package com.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;

/**
 * @author Allen Gong
 * @version V1.0
 * @date 2016-12-19 10:06
 */
public class PaypalUtil {
    private static final Logger log = LoggerFactory.getLogger(PaypalUtil.class);
    /**
     * paypal提供给商户的服务接入网关URL
     */
    public static final String PAYPAL_GATEWAY_NEW_URL = "www.paypal.com/cgi-bin/webscr?locale.x=en_GB";
    //private static final String PAYPAL_GATEWAY_NEW_URL = "www.sandbox.paypal.com/cgi-bin/webscr";
    public static final String PAYPAL_GATEWAY_NEW_HTTPS = "https://" + PAYPAL_GATEWAY_NEW_URL;
    public static final String PAYPAL_GATEWAY_NEW_HTTP = "http://" + PAYPAL_GATEWAY_NEW_URL;

    //paypal收款账户
    public static final String paypal_business = "global-business@transn.com";

    /**
     * 组装参数，并跳转到支付页面
     * @param price
     * @param orderNo
     * @param userId
     * @param request
     * @param model
     * @return
     */
    public static String gotoPayPal(double price, String orderNo, String userId, HttpServletRequest request, Model model){
    	/**
         * paypal参数：
         * cmd(必填参数); _xclick: 在paypal中订单提交按钮类型中表示"立即购买"
         * item_name: 商品描述（显示在paypal收银台里的商品名称），orderno应当与sg网站订单系统中的唯一订单号匹配
         * amount: 商品金额或订单总价(显示在paypal收银台里的支付金额);
         * currency_code: 货币单位(USD美元、SGD新加坡元)
         * notify_url: 交易后paypal返回网站地址(用于接收PayPal发送的即时付款通知)
         * return_url: 客户交易返回地址(付完款后返回系统地址)
         */
        String cmd = "_xclick";
        String item_name = "[Transnsg]Information translation Order No: " + orderNo;
        String amount = price + "";
        String currency_code = "USD";
        String notify_url = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath() + "/order/notify";
        //String return_url = request.getScheme() +"://" + request.getServerName()  + ":" +request.getServerPort() +request.getContextPath() + "/order/paypal_return.html";
        String return_url = "order/paySuccess?orderNo=" + orderNo;

        //拼装paypal请求参数
        Map<String, String> paramMap = new HashMap<>();
        paramMap.put("cmd", cmd);
        paramMap.put("custom", orderNo + "|" + userId);//自定义字段
        paramMap.put("item_name", item_name);
        paramMap.put("amount", amount);
        paramMap.put("currency_code", currency_code);
        paramMap.put("return", return_url);
        paramMap.put("notify_url", notify_url);

        log.info("---------------Paypel参数: custom："+orderNo + "|" + userId+",amount:"+amount);
        String paypalHtml = PaypalUtil.createDirectPayByUser(paramMap);
        model.addAttribute("paypalHtml", paypalHtml);
        return "order/paypal";
    }
    
    /**
     * 构造即时到账接口
     * @param paramMap 请求参数集合
     * @return 表单提交HTML信息
     */
    public static String createDirectPayByUser(Map<String, String> paramMap) {
        //增加基本配置
        paramMap.put("business", paypal_business);
        String payReturn = PaypalUtil.buildForm(paramMap, PAYPAL_GATEWAY_NEW_HTTPS, "post");
        log.info(payReturn);
        return payReturn;
    }

    /**
     * 构造提交表单HTML数据
     * @param sParaTemp 请求参数数组
     * @param gateway 网关地址
     * @param strMethod 提交方式。两个值可选：post、get
     * @return 提交表单HTML文本
     */
    public static String buildForm(Map<String, String> sParaTemp, String gateway, String strMethod) {
        //待请求参数数组
        List<String> keys = new ArrayList<String>(sParaTemp.keySet());

        StringBuffer sbHtml = new StringBuffer();
        sbHtml.append("<form id=\"paypalsubmit\" action=\"" + gateway + "\" method=\"" + strMethod+ "\">");

        for (int i = 0; i < keys.size(); i++) {
            String name = (String) keys.get(i);
            String value = (String) sParaTemp.get(name);

            sbHtml.append("<input type=\"hidden\" name=\"" + name + "\" value=\"" + value + "\"/>");
        }

        sbHtml.append("<input type=\"submit\" style=\"display:none;\"></form>");
        sbHtml.append("<script>document.forms['paypalsubmit'].submit();</script>");

        return sbHtml.toString();
    }
}
