package com.seller.exception;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

/**
 * 类功能描述:异常处理类
 * 
 * @author Allen Gong
 * @version 2.0.0
 * 
 * @history 2017-04-19 Allen Gong 创建
 */
public class ExceptionHandler implements HandlerExceptionResolver {
//    private static final Logger logger = LoggerFactory.getLogger(ExceptionHandler.class);
    
    /**
     * 处理Exception
     */
    public ModelAndView resolveException(HttpServletRequest request,
                                         HttpServletResponse response, Object object, Exception exception) { // 如果不是ajax，JSP格式返回
        /*BaseEntity rs = new BaseEntity();
        rs.setResult(ErrorCode.ERROR);
        // 判断是否Ajax请求
        if (!(request.getHeader("accept").indexOf("application/json") > -1 || 
             (request.getHeader("X-Requested-With") != null 
               && request.getHeader("X-Requested-With").indexOf("XMLHttpRequest") > -1))) {
            // 为安全起见，只有业务异常我们对前端可见，否则否则统一归为系统异常
            if (exception instanceof MeException) {
                MeException e = (MeException)exception;
                logger.error("["+e.getMessageKey()+"]"+e.getMessage(), e);
                rs.setCode(e.getMessageKey());
                rs.setMsg("["+e.getMessageKey()+"]"+e.getMessage());
            } else {
                exception.printStackTrace();
                logger.error("系统异常", exception);
                rs.setMsg("系统异常！");
            }
            //对于非ajax请求，我们都统一跳转到error.jsp页面
            return new ModelAndView("/error", "fgresponseResult", rs);
        } else {// 如果是ajax请求，JSON格式返回
            try {
                response.setContentType("application/json;charset=UTF-8");
                PrintWriter writer = response.getWriter();
                // 为安全起见，只有业务异常我们对前端可见，否则统一归为系统异常
                if (exception instanceof MeException) {
                    MeException e = (MeException)exception;
                    logger.error("["+e.getMessageKey()+"]"+e.getMessage(), e);
                    rs.setCode(e.getMessageKey());
                    rs.setMsg("["+e.getMessageKey()+"]"+e.getMessage());
                } else {
                    exception.printStackTrace();
                    logger.error("系统异常", exception);
                    rs.setMsg("系统异常！");
                }
                writer.write(JSON.toJSONString(rs));
                writer.flush();
                writer.close();
            } catch (IOException e) {
                logger.error("系统异常", e);
            }
        }*/
        return null;
    }
}