//package com.seller.interceptor;
//
//import com.seller.constants.FieldConst;
//import com.util.StringUtils;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//import org.springframework.web.util.WebUtils;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//
///**
// * 登录拦截
// * @author Allen Gong
// * @version V1.0
// * @date 2016-12-30 14:06
// */
//public class LoginInterceptor implements HandlerInterceptor {
//    private static final Logger log = LoggerFactory.getLogger(LoginInterceptor.class);
//
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
////        if ("GET".equalsIgnoreCase(request.getMethod())) {
////            RequestUtil.saveRequest();
////        }
//        if("GET".equalsIgnoreCase(request.getMethod())) {
//            log.info("==============执行顺序: 1、preHandle================");
//            String requestUri = request.getRequestURI();
//            String contextPath = request.getContextPath();
//            String url = requestUri.substring(contextPath.length());
//            if ("/index".equals(url)) {
//                return true;
//            } else {
//                String username = (String) WebUtils.getSessionAttribute(request, FieldConst.SYS_USER_EMAIL);
//                if (StringUtils.isEmpty(username)) {
//                    log.info("Interceptor：跳转到login页面！");
//                    //request.getRequestDispatcher("/petro/login").forward(request, response);
//                    response.sendRedirect(request.getContextPath() + "/index");
//                    return false;
//                } else {
//                    return true;
//                }
//            }
//        }else if("POST".equalsIgnoreCase(request.getMethod())){
//            return true;
//        }
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {
//
//    }
//}
