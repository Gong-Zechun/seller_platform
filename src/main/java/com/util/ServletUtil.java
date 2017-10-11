package com.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author Allen Gong
 * @version V1.0
 * @date 2017-1-24 13:45
 */
public class ServletUtil {
    /**
     * 获取主机url
     * @param request
     * @return
     */
    public static String getHostUrl(HttpServletRequest request) {
        return request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath();
    }
}
