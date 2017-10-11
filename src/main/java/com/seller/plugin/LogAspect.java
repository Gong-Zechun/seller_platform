package com.seller.plugin;

import java.lang.reflect.Field;
import java.text.SimpleDateFormat;

import org.apache.ibatis.javassist.*;
import org.apache.ibatis.javassist.bytecode.CodeAttribute;
import org.apache.ibatis.javassist.bytecode.LocalVariableAttribute;
import org.apache.ibatis.javassist.bytecode.MethodInfo;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 类功能描述：日志记录AOP实现  
 * @author Allen Gong
 * @version 5.0.0
 * @history 2017-05-04 Allen Gong 创建
 */
@Aspect
public class LogAspect {
    private static final Logger logger = LoggerFactory.getLogger(LogAspect.class);
    
    private static String[] types = { "java.lang.Integer", "java.lang.Double",  
            "java.lang.Float", "java.lang.Long", "java.lang.Short",  
            "java.lang.Byte", "java.lang.Boolean", "java.lang.Char",  
            "java.lang.String", "net.sf.json.JSONObject", "java.util.Map",
            "int", "double", "long", "short", "byte", "boolean", "char", "float" };
    /**
     * 不需要处理的方法
     */
    public static final String NOT_NEED_HANDLE_METHOD = "setReqAndRes"; 
  
    private String requestPath; // 请求地址  
    private String controllerName;//访问类名
    private String userName; // 用户名  
    private String iPAddress;//访问IP
    private String inputParams; // 传入参数  
    private long startTimeMillis = 0; // 开始时间  
    private long endTimeMillis = 0; // 结束时间  
    private String methodName = null;
  
    /** 
     *  
     * @Title：doBeforeInServiceLayer 
     * @Description: 方法调用前触发  
     *  记录开始时间  
     * @author Allen Gong
     * @param joinPoint 
     */  
    @Before("execution(* com.seller.controller..*.*(..))")
    public void doBeforeInServiceLayer(JoinPoint joinPoint) {
        startTimeMillis = System.currentTimeMillis(); // 记录方法开始执行的时间  
        controllerName = joinPoint.getTarget().getClass().getSimpleName()+".java";
        String classType = joinPoint.getTarget().getClass().getName();  
        Class<?> clazz;
        try {
            clazz = Class.forName(classType);
            String clazzName = clazz.getName();
            methodName = joinPoint.getSignature().getName();
            if(!NOT_NEED_HANDLE_METHOD.equals(methodName)){
                String[] paramNames = getFieldsName(this.getClass(), clazzName, methodName);  
                inputParams = getParamsValue(paramNames, joinPoint);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NotFoundException e) {
            e.printStackTrace();
        }
    }
  
    /** 
     *  
     * @Title：doAfterInServiceLayer 
     * @Description: 方法调用后触发  
     *  记录结束时间 
     * @author Allen Gong
     * @param joinPoint 
     */  
    @After("execution(* com.seller.controller..*.*(..))")
    public void doAfterInServiceLayer(JoinPoint joinPoint) {
        endTimeMillis = System.currentTimeMillis(); // 记录方法执行完成的时间  
        this.printOptLog();
    }
  
    /** 
     *  
     * @Title：doAround 
     * @Description: 环绕触发  
     * @author Allen Gong
     * @param pjp 
     * @return 
     * @throws Throwable 
     */
//    @Around("execution(* com.seller.controller..*.*(..))")
//    public Object doAround(ProceedingJoinPoint pjp) throws Throwable {
//        /**
//         * 1.获取request信息 2.根据request获取session 3.从session中取出登录用户信息
//         */
//        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
//        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
//        HttpServletRequest request = sra.getRequest();
//        HttpSession session = request.getSession();
//        // 从session中获取用户信息
//        AdminUser user = (AdminUser) session.getAttribute(FieldConst.SESSION_USER_ID_KEY);
//        if (user == null) {
//            userName = "User hasn't login!";
//        } else {
//            userName = user.getLoginName();
//        }
//        logger.info("User info:"+userName);
//        // 获取输入参数
////        inputParamMap = request.getParameterMap();
//        // 获取请求地址
//        requestPath = request.getRequestURI();
//        //获取问IP
//        iPAddress = IpAccessUtil.getIpAddress(request);
//        // 执行完方法的返回值：调用proceed()方法，就会触发切入点方法执行
////        outputParamMap = new HashMap<String, Object>();
//        return pjp.proceed();// result的值就是被拦截方法的返回值
//    }
    
    /*
     * 获取参数值
     */
    private static String getParamsValue(String[] paramNames, JoinPoint joinPoint) {
        Object[] args = joinPoint.getArgs();
        StringBuilder sb = new StringBuilder();
        boolean clazzFlag = true;
        for (int k = 0; k < args.length; k++) {
            Object arg = args[k];
            sb.append(paramNames[k] + " ");
            // 获取对象类型
            if (arg == null) {
                continue;
            }
            String typeName = arg.getClass().getTypeName();
            for (String t : types) {
                if (t.equals(typeName)) {
                    sb.append("=" + arg + "; ");
                }
            }
            if (clazzFlag) {
                sb.append(getFieldsValue(arg));
            }
        }
        return sb.toString();
    }
    
    /** 
     * 得到方法参数的名称 
     * @param cls 
     * @param clazzName 
     * @param methodName 
     * @return 
     * @throws NotFoundException 
     */  
    private static String[] getFieldsName(Class<?> cls, String clazzName, String methodName) throws NotFoundException {
        ClassPool pool = ClassPool.getDefault();
        //ClassClassPath classPath = new ClassClassPath(this.getClass());  
        ClassClassPath classPath = new ClassClassPath(cls);
        pool.insertClassPath(classPath);  
          
        CtClass cc = pool.get(clazzName);
        CtMethod cm = cc.getDeclaredMethod(methodName);
        MethodInfo methodInfo = cm.getMethodInfo();
        CodeAttribute codeAttribute = methodInfo.getCodeAttribute();
        LocalVariableAttribute attr = (LocalVariableAttribute) codeAttribute.getAttribute(LocalVariableAttribute.tag);
        if (attr == null) {  
            // exception  
        }  
        String[] paramNames = new String[cm.getParameterTypes().length];  
        int pos = Modifier.isStatic(cm.getModifiers()) ? 0 : 1;  
        for (int i = 0; i < paramNames.length; i++){  
            paramNames[i] = attr.variableName(i + pos); //paramNames即参数名  
        }  
        return paramNames;  
    }  
    
    /** 
     * 得到参数的值 
     * @param obj 
     */  
    public static String getFieldsValue(Object obj) {
        Field[] fields = obj.getClass().getDeclaredFields();
        String typeName = obj.getClass().getTypeName();
        for (String t : types) {
            if (t.equals(typeName))
                return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (Field f : fields) {
            f.setAccessible(true);
            try {
                for (String str : types) {
                    if (f.getType().getName().equals(str)) {
                        sb.append(f.getName() + " = " + f.get(obj) + "; ");
                    }
                }
            } catch (IllegalArgumentException e) {
                e.printStackTrace();
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
        sb.append("]");
        return sb.toString();
    }
      
  
    /** 
     *  
     * @Title：printOptLog 
     * @Description: 输出日志  
     * @author Allen Gong
     */  
    private void printOptLog() {
        String optTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(startTimeMillis);
        StringBuilder stringBuilder = new StringBuilder(128);
        stringBuilder.append("\n-------------------").append(optTime).append("-------------------------");
        stringBuilder.append("\n\tURL       :").append(requestPath);
        stringBuilder.append("\n\tFrom IP   :").append(iPAddress);
        stringBuilder.append("\n\tUser ID   :").append(userName);
        stringBuilder.append("\n\tController:").append(controllerName);
        stringBuilder.append("\n\tParameters:").append(inputParams);
        //stringBuilder.append("\n\tReturn    :").append(gson.toJson(outputParam));
        stringBuilder.append("\n-------------------End Cost:").append((endTimeMillis - startTimeMillis)).append("ms-------------------------");
        logger.info(stringBuilder.toString());
    }
}  
