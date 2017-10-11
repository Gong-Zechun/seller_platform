/**   
* @Title: SysConstant.java
* @Package com.iol.ppy.utilities.common
* @Description: TODO
* @author Clark.Liu(superman)
* @date 2014年10月29日 下午3:12:39
* @version V1.0   
*/

package com.seller.constants;

import java.util.HashMap;
import java.util.Map;

/**
 * 类功能描述：API错误代码定义
 * 
 * @author Allen Gong
 * @version 1.0.0
 * @history 2017-03-31 Allen Gong 创建
 */
public class ErrorCode {
    public static final Integer ERROR = 0;
    public static final Integer SUCCESS = 1;
    public static final String DEFAULT_PASSWORD = "123456";

    public static final Integer ERROR_CODE_1001 = 1001;// 没有找到对应数据
    public static final Integer ERROR_CODE_1002 = 1002;// 数据版本不一致
    public static final Integer ERROR_CODE_1003 = 1003;// Json格式错误
    public static final Integer ERROR_CODE_1004 = 1004;// 系统错误
    public static final Integer ERROR_CODE_1005 = 1005;// 参数为空
    public static final Integer ERROR_CODE_1006 = 1006;// 依赖系统服务中断
    public static final Integer ERROR_CODE_1007 = 1007;// 调用超时
    public static final Integer ERROR_CODE_2001 = 2001;// 一般性失败，不给出具体原因
    public static final Integer ERROR_CODE_2002 = 2002;// 不具备该权限，无法访问数据
    public static final Integer ERROR_CODE_2003 = 2003;// 网络故障
    public static final Integer ERROR_CODE_2004 = 2004;// 图片上传失败
    public static final Integer ERROR_CODE_3001 = 3001;// 用户不存在
    public static final Integer ERROR_CODE_3002 = 3002;// 用户名或密码错误
    public static final Integer ERROR_CODE_3003 = 3003;// 用户已存在
    public static final Integer ERROR_CODE_3004 = 3004;// 用户余额不足
    public static final Integer ERROR_CODE_3005 = 3005;// 用户被禁用
    public static final Integer ERROR_CODE_3006 = 3006;// 用户编号（sellerNo）不存在
    public static final Integer ERROR_CODE_3007 = 3007;// 注册失败
    public static final Integer ERROR_CODE_3008 = 3008;// 用户不存在

    public static final Integer ERROR_CODE_3009 = 3009;// 您的邮箱已被使用，使用找回密码试试
    public static final Integer ERROR_CODE_3010 = 3010;// 你的邮箱已被使用。
    public static final Integer ERROR_CODE_3011 = 3011;// 你的手机号已被使用。
    public static final Integer ERROR_CODE_3012 = 3012;// 验证码输入有误
    public static final Integer ERROR_CODE_3013 = 3013;// 验证码已过期
    public static final Integer ERROR_CODE_3014 = 3014;// 接口调用失败
    public static final Integer ERROR_CODE_3015 = 3015;// 昵称已被注册
    public static final Integer ERROR_CODE_3016 = 3016;// 用户注册失败
    public static final Integer ERROR_CODE_3017 = 3017;// 用户修改密码失败
    public static final Integer ERROR_CODE_3018 = 3018;// 修改用户信息失败
    public static final Integer ERROR_CODE_3019 = 3019;// 修改用户信息失败
    public static final Integer ERROR_CODE_3020 = 3020;// 没有找到对应用户
    public static final Integer ERROR_CODE_3021 = 3021;// 请重新登录那啥议员端
    public static final Integer ERROR_CODE_3022 = 3022;// 验证码生成失败
    public static final Integer ERROR_CODE_3023 = 3023;// 用户名不能为空
    public static final Integer ERROR_CODE_3024 = 3024;// 密码不能为空
    public static final Integer ERROR_CODE_3025 = 3025;// 原密码错误
    public static final Integer ERROR_CODE_3026 = 3026;// 请重新登录
    public static final Integer ERROR_CODE_3027 = 3027;// 新旧密码不能相同
    public static final Integer ERROR_CODE_3028 = 3028;// 两次输入密码不同
    public static final Integer ERROR_CODE_3029 = 3029;// 您输入的手机号码格式错误
    public static final Integer ERROR_CODE_3030 = 3030;// 手机或邮箱不存在
    public static final Integer ERROR_CODE_3031 = 3031;// 数据保存失败
    public static final Integer ERROR_CODE_3032 = 3032;// 没有找到该评论
    public static final Integer ERROR_CODE_3033 = 3033;// 已有推荐字幕
    public static final Integer ERROR_CODE_3034 = 3034;// 已有推荐配音
    public static final Integer ERROR_CODE_3035 = 3035;// 未找到要删除数据
    public static final Integer ERROR_CODE_3036 = 3036;// 非法的字幕文件格式（非srt）
    public static final Integer ERROR_CODE_3037 = 3037;// 已发布配音不能修改
    public static final Integer ERROR_CODE_3038 = 3038;// 昵称不能为空
    public static final Integer ERROR_CODE_3039 = 3039;// 非法的视频文件格式
    public static final Integer ERROR_CODE_3040 = 3040;// 字幕文件格式非UTF-8
    public static final Integer ERROR_CODE_3041 = 3041;// 字幕格式错误

    // token 验证失败 Illegal token
    public static final Integer ERROR_CODE_7001 = 7001;
    // sessionId 验证失败
    public static final Integer ERROR_CODE_7002 = 7002;
    // 资源已经被占用，无法操作
    public static final Integer ERROR_CODE_7003 = 7003;
    // 存在重复数据
    public static final Integer ERROR_CODE_7004 = 7004;
    // 数据库操作失败
    public static final Integer ERROR_CODE_7005 = 7005;
    // 用户重复操作
    public static final Integer ERROR_CODE_7006 = 7006;
    // 语种与提交的文字不一致
    public static final Integer ERROR_CODE_7007 = 7007;
    // 该资源已被放弃或完成，请刷新最新数据
    public static final Integer ERROR_CODE_7008 = 7008;
    // 摘要翻译的译文只能是中文
    public static final Integer ERROR_CODE_7009 = 7009;
    // 提交过快
    public static final Integer ERROR_CODE_7010 = 7010;
    // 重复提交
    public static final Integer ERROR_CODE_7011 = 7011;
    // 违反文章的翻译规则 不允许翻译成该语种
    public static final Integer ERROR_CODE_7012 = 7012;
    // 违反文章的翻译规则 该语种的翻译次数超限
    public static final Integer ERROR_CODE_7013 = 7013;
    // 当前数据下不支持该操作
    public static final Integer ERROR_CODE_7014 = 7014;
    // 您已经赞过这条啦
    public static final Integer ERROR_CODE_7015 = 7015;
    // 给别人一点赞扬吧
    public static final Integer ERROR_CODE_7016 = 7016;
    // 喜欢这篇文章先把踩取消吧
    public static final Integer ERROR_CODE_7017 = 7017;
    // 赞过怎么舍得踩
    public static final Integer ERROR_CODE_7018 = 7018;
    // 参照译文被举报查实已被删除，请刷新最新数据
    public static final Integer ERROR_CODE_7019 = 7019;

    // 手机错误码errcode 定义
    public static final Integer RESULT_ERR_LIMIT = -2; //请求过于频繁
    public static final Integer RESULT_ERR_ACCESS_TOKEN = -1; //Token验证失败
    public static final Integer RESULT_ERR_SYS = 00; // 系统错误
    public static final Integer RESULT_ERR_DATA = 01; // 数据错误
    public static final Integer RESULT_DUP_DATA = 02; // 重复提交
    public static final Integer RESULT_ERR_VALID = 10; // 用户名密码错误
    public static final Integer RESULT_USER_DEL = 11; // 用户被删除
    public static final Integer RESULT_EDIT_PASSWORD_PWD_ERROR = 12; // 原始密码输入错误
    public static final Integer RESULT_ERR_NOEXISTS = 13; // 失败
    public static final Integer RESULT_ERR_EMAILNOEXISTS = 14; // 注册邮箱不存在 找回密码
    public static final Integer RESULT_IS_BIND = 15; // 账号已绑定

    // 错误提示内容
    public final static Map<Integer, String> ERROR_MSG_MAP = new HashMap<Integer, String>();
    static {
        ERROR_MSG_MAP.put(ERROR_CODE_1001, "没有找到对应数据");
        ERROR_MSG_MAP.put(ERROR_CODE_1002, "请刷新最新数据");
        ERROR_MSG_MAP.put(ERROR_CODE_1003, "数据格式错误");
        ERROR_MSG_MAP.put(ERROR_CODE_1004, "系统错误");
        ERROR_MSG_MAP.put(ERROR_CODE_1005, "参数为空");
        ERROR_MSG_MAP.put(ERROR_CODE_1006, "服务中断");
        ERROR_MSG_MAP.put(ERROR_CODE_1007, "调用超时");
        ERROR_MSG_MAP.put(ERROR_CODE_2001, "一般性失败");
        ERROR_MSG_MAP.put(ERROR_CODE_2002, "不具备该权限，无法访问数据");
        ERROR_MSG_MAP.put(ERROR_CODE_2003, "网络故障");
        ERROR_MSG_MAP.put(ERROR_CODE_2004, "图片上传失败");
        ERROR_MSG_MAP.put(ERROR_CODE_3001, "用户不存在");
        ERROR_MSG_MAP.put(ERROR_CODE_3002, "用户名或密码错误");
        ERROR_MSG_MAP.put(ERROR_CODE_3003, "用户已存在");
        ERROR_MSG_MAP.put(ERROR_CODE_3004, "用户余额不足");
        ERROR_MSG_MAP.put(ERROR_CODE_3005, "用户被禁用");
        ERROR_MSG_MAP.put(ERROR_CODE_3006, "商家编号不存在");
        ERROR_MSG_MAP.put(ERROR_CODE_3007, "注册失败");
        ERROR_MSG_MAP.put(ERROR_CODE_3008, "用户不存在");

        ERROR_MSG_MAP.put(ERROR_CODE_3009, "您的邮箱已被使用，使用找回密码试试");
        ERROR_MSG_MAP.put(ERROR_CODE_3010, "你的邮箱已被使用。");
        ERROR_MSG_MAP.put(ERROR_CODE_3011, "你的手机号已被使用。");
        ERROR_MSG_MAP.put(ERROR_CODE_3012, "验证码输入有误");
        ERROR_MSG_MAP.put(ERROR_CODE_3013, "验证码已过期");
        ERROR_MSG_MAP.put(ERROR_CODE_3015, "昵称已被注册");
        ERROR_MSG_MAP.put(ERROR_CODE_3019, "您当天已有安排了哦，再看看其他时间的活动吧~");
        ERROR_MSG_MAP.put(ERROR_CODE_3020, "那啥译员中没有找到您的信息，请确保认证那啥译员再登录！");
        ERROR_MSG_MAP.put(ERROR_CODE_3021, "请重新登录那啥议员端！");
        ERROR_MSG_MAP.put(ERROR_CODE_3022, "验证码生成失败");
        ERROR_MSG_MAP.put(ERROR_CODE_3023, "用户名不能为空");
        ERROR_MSG_MAP.put(ERROR_CODE_3024, "密码不能为空");
        ERROR_MSG_MAP.put(ERROR_CODE_3025, "原密码错误");
        ERROR_MSG_MAP.put(ERROR_CODE_3026, "请重新登录");
        ERROR_MSG_MAP.put(ERROR_CODE_3027, "新旧密码不能相同");
        ERROR_MSG_MAP.put(ERROR_CODE_3028, "两次输入密码不同");
        ERROR_MSG_MAP.put(ERROR_CODE_3029, "您输入的手机号码格式错误");
        ERROR_MSG_MAP.put(ERROR_CODE_3030, "手机或邮箱不存在");
        ERROR_MSG_MAP.put(ERROR_CODE_3031, "数据保存失败");
        ERROR_MSG_MAP.put(ERROR_CODE_3032, "没有找到该评论");
        ERROR_MSG_MAP.put(ERROR_CODE_3033, "已有推荐字幕，无法继续推荐");
        ERROR_MSG_MAP.put(ERROR_CODE_3034, "已有推荐配音，无法继续推荐");
        ERROR_MSG_MAP.put(ERROR_CODE_3035, "未找到要删除数据");
        ERROR_MSG_MAP.put(ERROR_CODE_3036, "请上传str格式的字幕文件");
        ERROR_MSG_MAP.put(ERROR_CODE_3037, "已发布配音不能修改");
        ERROR_MSG_MAP.put(ERROR_CODE_3038, "昵称不能为空");
        ERROR_MSG_MAP.put(ERROR_CODE_3039, "非法的视频文件格式");
        ERROR_MSG_MAP.put(ERROR_CODE_3040, "上传字幕文件字符集不是UTF-8");
        ERROR_MSG_MAP.put(ERROR_CODE_3041, "字幕格式错误，请检查");

        ERROR_MSG_MAP.put(RESULT_ERR_VALID, "用户名密码错误");
        ERROR_MSG_MAP.put(ERROR_CODE_7001, "非法的token");
        ERROR_MSG_MAP.put(ERROR_CODE_7002, "sessionId验证错误");
        ERROR_MSG_MAP.put(ERROR_CODE_7003, "资源已经被占用，无法操作");
        ERROR_MSG_MAP.put(ERROR_CODE_7004, "存在重复数据");
        ERROR_MSG_MAP.put(ERROR_CODE_7005, "数据库操作失败");
        ERROR_MSG_MAP.put(ERROR_CODE_7006, "用户重复操作");
        ERROR_MSG_MAP.put(ERROR_CODE_7007, "亲，提交语种与所选语种不一致");
        ERROR_MSG_MAP.put(ERROR_CODE_7008, "资源已被放弃或完成,请刷新最新数据");
        ERROR_MSG_MAP.put(ERROR_CODE_7009, "标题和摘要译文必须以中文提交");
        ERROR_MSG_MAP.put(ERROR_CODE_7010, "先喝杯茶休息下哦，1分钟后再提交吧");
        ERROR_MSG_MAP.put(ERROR_CODE_7011, "嗯？确定不是复制后粘贴吗？再想想吧");
        ERROR_MSG_MAP.put(ERROR_CODE_7012, "不允许翻译成该语种");
        ERROR_MSG_MAP.put(ERROR_CODE_7013, "该语种的翻译次数超限");
        ERROR_MSG_MAP.put(ERROR_CODE_7014, "当前不支持该操作");
        ERROR_MSG_MAP.put(ERROR_CODE_7015, "您已经赞过这条啦");
        ERROR_MSG_MAP.put(ERROR_CODE_7016, "给别人一点赞扬吧");
        ERROR_MSG_MAP.put(ERROR_CODE_7017, "喜欢这篇文章先把踩取消吧");
        ERROR_MSG_MAP.put(ERROR_CODE_7018, "赞过怎么舍得踩");
        ERROR_MSG_MAP.put(ERROR_CODE_7019, "参照译文被举报查实已被删除，请刷新最新数据");

    }

    // 1:ios,2:android,3,windowPhone
    public static final String SYSTEM_IOS = "1";
    public static final String SYSTEM_ANDROID = "2";
    public static final String SYSTEM_WINPHONE = "3";

}
