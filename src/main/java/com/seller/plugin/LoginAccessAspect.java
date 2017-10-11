package com.seller.plugin;

import javax.servlet.http.HttpServletRequest;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;
import org.springframework.web.util.WebUtils;

import com.seller.constants.ErrorCode;
import com.seller.constants.FieldConst;
import com.seller.entity.model.User;
import com.util.JsonUtil;
import com.util.sql.BaseEntity;

/**
 * 类功能描述：spring AOP 授权token登陆验证
 * 
 * @author barry.wang
 * @version 5.0.0
 * @history 2017-06-13 barry.wang 创建
 */
@Aspect
@Component
public class LoginAccessAspect {

    /**
     * 授权验证
     * @param pjp
     * @return
     * @throws Throwable
     */
    @Around("@annotation(com.seller.plugin.LoginAccess)")
    public Object doAccessCheck(ProceedingJoinPoint pjp) throws Throwable {
        /**
         * 1.获取request信息 2.根据request获取session 3.从session中取出登录用户信息
         */
        RequestAttributes ra = RequestContextHolder.getRequestAttributes();
        ServletRequestAttributes sra = (ServletRequestAttributes) ra;
        HttpServletRequest request = sra.getRequest();
//        HttpSession session = request.getSession();
        // 从session中获取用户信息
        User user = (User) WebUtils.getSessionAttribute(request, FieldConst.USER);
        
        if(user != null){
            return pjp.proceed();//执行连接点方法;
        } else {
            BaseEntity baseEntity = new BaseEntity();
            baseEntity.setResult(ErrorCode.ERROR);
            baseEntity.setCode(ErrorCode.RESULT_ERR_ACCESS_TOKEN);
            baseEntity.setMsg("登录异常，请重新登录");
            return JsonUtil.toJsonStr(baseEntity);
        }
    }
}
