package com.seller.controller;

import java.util.List;

import javax.annotation.Resource;

import com.util.DateUtils;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.collections.MapUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.util.WebUtils;

import com.seller.constants.ErrorCode;
import com.seller.constants.FieldConst;
import com.seller.entity.model.TaskGroup;
import com.seller.entity.model.TaskGroupTemplate;
import com.seller.entity.model.User;
import com.seller.exception.MeException;
import com.seller.extendEntity.vo.TaskVo;
import com.seller.extendEntity.vo.UserVo;
import com.seller.service.TaskGroupService;
import com.seller.service.TaskGroupTemplateService;
import com.seller.service.TaskService;
import com.seller.service.UserService;
import com.util.StringUtils;
import com.util.sql.BaseEntity;

import net.sf.json.JSONObject;

/**
 * 类功能描述：商家登录Controller
 * @author Allen Gong
 * @version 5.1.1
 * @history 2017-8-28 Allen Gong 创建
 */
@RequestMapping("/seller")
@Controller
public class SellerLoginController extends BaseController{
    protected static final Logger logger = LoggerFactory.getLogger(SellerLoginController.class);

    @Resource
    private UserService userService;
    @Resource
    private TaskGroupTemplateService taskGroupTemplateService;
    @Resource
    private TaskGroupService taskGroupService;
    @Resource
    private TaskService taskService;

    /**
     * 商家注册
     * @param jsonObj
     * @return
     */
    @RequestMapping(value="/register", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String register(@RequestBody JSONObject jsonObj) {
        try {
            if(MapUtils.isEmpty(jsonObj)) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1005);
            }
            User user = (User)JSONObject.toBean(jsonObj, User.class);
            String phone = user.getPhone();
            if(StringUtils.isBlank(user.getPassword())
                    || StringUtils.isBlank(user.getRealName())
                    || StringUtils.isBlank(user.getPhone())
                    || StringUtils.isBlank(user.getQqNum())
                    || StringUtils.isBlank(user.getWechatNum())
                    || StringUtils.isBlank(user.getSellerShopId1())) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1005);
            }
            if(userService.isPhoneExist(phone)) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_3007, "该手机号" + phone + "已被注册");
            }
            int resultFlag = userService.register(user);
            if(resultFlag <= 0) {
                return returnErrorInfo(ErrorCode.ERROR, "注册失败");
            }
            return returnSuccessInfo(new BaseEntity());
        } catch (MeException e) {
            logger.error("SellerLoginController-register MeException: ",e);
            return returnErrorInfo(e.getMessageKey(), e.getMessage());
        } catch (Exception e) {
            logger.error("SellerLoginController-register Exception: ",e);
            return returnErrorInfo(ErrorCode.ERROR_CODE_1004);
        }
    }

    /**
     * 登录
     * @param jsonObj
     * @return
     */
    @RequestMapping(value="/login", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String login(@RequestBody JSONObject jsonObj) {
        try {
            if(MapUtils.isEmpty(jsonObj)) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1005);
            }
            User paramUser = (User)JSONObject.toBean(jsonObj, User.class);
            if(StringUtils.isBlank(paramUser.getPhone()) || StringUtils.isBlank(paramUser.getPassword())) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1005);
            }
            User user = userService.getUserByParam(paramUser);
            if(user == null) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_3008, "用户不存在或密码错误");
            }else {
                //用户信息存入session
                WebUtils.setSessionAttribute(request, FieldConst.USER, user);
                return returnSuccessInfo(new BaseEntity());
            }
        } catch (MeException e) {
            logger.error("SellerLoginController-login MeException: ",e);
            return returnErrorInfo(e.getMessageKey(), e.getMessage());
        } catch (Exception e) {
            logger.error("SellerLoginController-login Exception: ",e);
            return returnErrorInfo(ErrorCode.ERROR_CODE_1004);
        }
    }

    /**
     * 获取商家店铺ID
     * @param jsonObj
     * @return
     */
    @RequestMapping(value="/sellerShopId", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String getSellerShopId(@RequestBody JSONObject jsonObj) {
        try {
            if(MapUtils.isEmpty(jsonObj)) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1005);
            }
            String phone = jsonObj.getString("phone");
            if(StringUtils.isBlank(phone)) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1005);
            }
            User sessionUser = (User)WebUtils.getSessionAttribute(request, FieldConst.USER);
            User user = new User();
            if(sessionUser != null) {
                user.setSellerShopId1(sessionUser.getSellerShopId1());
                if(StringUtils.isNotBlank(sessionUser.getSellerShopId2())) {
                    user.setSellerShopId2(sessionUser.getSellerShopId2());
                }
                if(StringUtils.isNotBlank(sessionUser.getSellerShopId3())) {
                    user.setSellerShopId3(sessionUser.getSellerShopId3());
                }
            }else {
                return returnErrorInfo(ErrorCode.ERROR_CODE_3026);
//                User tempUser = userService.getUserByPhone(phone);
//                if(tempUser != null) {
//                    user.setSellerShopId1(tempUser.getSellerShopId1());
//                    if(StringUtils.isNotBlank(tempUser.getSellerShopId2())) {
//                        user.setSellerShopId2(tempUser.getSellerShopId2());
//                    }
//                    if(StringUtils.isNotBlank(tempUser.getSellerShopId3())) {
//                        user.setSellerShopId3(tempUser.getSellerShopId3());
//                    }
//                }else {
//                    return returnErrorInfo(ErrorCode.ERROR_CODE_3008);
//                }
            }
            BaseEntity baseEntity = new BaseEntity();
            baseEntity.setData(user);
            return returnSuccessInfo(baseEntity);
        } catch (MeException e) {
            logger.error("SellerLoginController-getSellerShopId MeException: ", e);
            return returnErrorInfo(e.getMessageKey(), e.getMessage());
        } catch (Exception e) {
            logger.error("SellerLoginController-getSellerShopId-未知错误: ", e);
            return returnErrorInfo(ErrorCode.ERROR_CODE_1004);
        }
    }

    /**
     * 获取模板名称
     * @param jsonObj
     * @return
     */
    @RequestMapping(value="/templateName", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String getTemplateName(@RequestBody JSONObject jsonObj) {
        try {
            if(MapUtils.isEmpty(jsonObj)) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1005);
            }
            String phone = jsonObj.getString("phone");
            if(StringUtils.isBlank(phone)) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1005);
            }
            User user = (User)WebUtils.getSessionAttribute(request, FieldConst.USER);
            if(user == null) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_3026);
            }
            List<TaskGroupTemplate> taskGroupTemplateList =  taskGroupTemplateService.getTemplateName(user.getId());
            if(CollectionUtils.isEmpty(taskGroupTemplateList)) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1001);
            }
            BaseEntity baseEntity = new BaseEntity();
            baseEntity.setData(taskGroupTemplateList);
            return returnSuccessInfo(baseEntity);
        }catch (MeException e) {
            logger.error("SellerLoginController-getTemplateName", e);
            return returnErrorInfo(e.getMessageKey(), e.getMessage());
        }catch (Exception e) {
            logger.error("SellerLoginController-getTemplateName-未知错误", e);
            return returnErrorInfo(ErrorCode.ERROR);
        }
    }

    /**
     * 获取模板详情
     * @param jsonObj
     * @return
     */
    @RequestMapping(value="/templateDetail", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String getTemplateDetail(@RequestBody JSONObject jsonObj) {
        try {
            if(MapUtils.isEmpty(jsonObj)) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1005);
            }
            String templateName = jsonObj.getString("templateName");
            if(StringUtils.isBlank(templateName)) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1005);
            }
            User tempUser = (User)WebUtils.getSessionAttribute(request, FieldConst.USER);
            if(tempUser == null) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_3026);
            }
            TaskGroupTemplate paramTemplate = new TaskGroupTemplate();
            paramTemplate.setUserId(tempUser.getId());
            paramTemplate.setTemplateName(templateName);
            TaskGroupTemplate taskGroupTemplate = taskGroupTemplateService.getTemplateDetail(paramTemplate);
            if(taskGroupTemplate == null) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1001);
            }
            BaseEntity baseEntity = new BaseEntity();
            baseEntity.setData(taskGroupTemplate);
            return returnSuccessInfo(baseEntity);
        }catch (MeException e) {
            logger.error("SellerLoginController-getTemplateDetail", e);
            return returnErrorInfo(e.getMessageKey(), e.getMessage());
        }catch (Exception e) {
            logger.error("SellerLoginController-getTemplateDetail-未知错误", e);
            return returnErrorInfo(ErrorCode.ERROR);
        }
    }

    /**
     *
     * @param jsonObj
     * @return
     */
    //todo
    @RequestMapping("/buyerCount")
    @ResponseBody
    public String buyerCount(@RequestBody JSONObject jsonObj) {
        try {



            return returnErrorInfo(ErrorCode.ERROR_CODE_1005);
        }catch (MeException e) {
            logger.error("SellerLoginController-getTemplateDetail", e);
            return returnErrorInfo(e.getMessageKey(), e.getMessage());
        }catch (Exception e) {
            logger.error("SellerLoginController-getTemplateDetail-未知错误", e);
            return returnErrorInfo(ErrorCode.ERROR);
        }
    }

    /**
     * 发布任务组
     * @param jsonObj
     * @return
     */
    @RequestMapping(value="/publishTaskGroup", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String publishTaskGroup(@RequestBody JSONObject jsonObj) {
        try {
            if(MapUtils.isEmpty(jsonObj)) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1005);
            }
            TaskGroup taskGroup = (TaskGroup)JSONObject.toBean(jsonObj, TaskGroup.class);
            if(StringUtils.isBlank(taskGroup.getTaskType())
                    || StringUtils.isBlank(taskGroup.getTaskEntrance())
                    || StringUtils.isBlank(taskGroup.getGoodsUrl())
                    || StringUtils.isBlank(taskGroup.getGoodsTitle())) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1005);
            }
            User tempUser = (User)WebUtils.getSessionAttribute(request, FieldConst.USER);
            if(tempUser == null) {
                return returnErrorInfo(ErrorCode.ERROR, "用户未登录");
            }
            taskGroup.setUserId(tempUser.getId());
            int insertFlag = taskGroupService.publishTaskGroup(taskGroup);
            if(insertFlag <= 0) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1004, "发布任务组失败");
            }
            return returnSuccessInfo(new BaseEntity());
        }catch (MeException e) {
            logger.error("SellerLoginController-publishTaskGroup", e);
            return returnErrorInfo(e.getMessageKey(), e.getMessage());
        }catch (Exception e) {
            logger.error("SellerLoginController-publishTaskGroup-未知错误", e);
            return returnErrorInfo(ErrorCode.ERROR);
        }
    }

    /**
     * 新增模板
     * @return
     */
    @RequestMapping(value="/newTemplate", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String newTemplate(@RequestBody JSONObject jsonObj) {
        try {
            if(MapUtils.isEmpty(jsonObj)) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1005);
            }
            TaskGroupTemplate taskGroupTemplate = (TaskGroupTemplate)JSONObject.toBean(jsonObj, TaskGroupTemplate.class);
            String templateName = taskGroupTemplate.getTemplateName();
            if(StringUtils.isBlank(templateName)) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1005);
            }

            User tempUser = (User)WebUtils.getSessionAttribute(request, FieldConst.USER);
            if(tempUser == null) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_3026);
            }

            //模板名称不能重复
            TaskGroupTemplate paramTemplate = new TaskGroupTemplate();
            paramTemplate.setUserId(tempUser.getId());
            paramTemplate.setTemplateName(templateName);
            if(taskGroupTemplateService.getTemplateDetail(paramTemplate) != null) {
                return returnErrorInfo(ErrorCode.ERROR, "模板名称重复，请重新输入模板名称");
            }

            taskGroupTemplate.setUserId(tempUser.getId());
            int insertFlag = taskGroupTemplateService.addNewTemplate(taskGroupTemplate);
            if(insertFlag <= 0) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1004, "新增模板失败");
            }
            return returnSuccessInfo(new BaseEntity());
        }catch (MeException e) {
            logger.error("SellerLoginController-newTemplate", e);
            return returnErrorInfo(e.getMessageKey(), e.getMessage());
        }catch (Exception e) {
            logger.error("SellerLoginController-newTemplate-未知错误", e);
            return returnErrorInfo(ErrorCode.ERROR);
        }
    }

    /**
     * 获取商家信息概要
     * @return
     */
    @RequestMapping(value="/sellerInfoBrief", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String sellerInfoBrief() {
        try {
            User tempUser = (User)WebUtils.getSessionAttribute(request, FieldConst.USER);
            if(tempUser == null) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_3026);
            }

            User user = new User();
            user.setPhone(tempUser.getPhone());
            UserVo userVo = userService.getSellerInfoBrief(user);
            if(userVo == null) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1001);
            }
            BaseEntity baseEntity = new BaseEntity();
            baseEntity.setData(userVo);
            return returnSuccessInfo(baseEntity);
        }catch (MeException e) {
            logger.error("SellerLoginController-sellerInfoBrief", e);
            return returnErrorInfo(e.getMessageKey(), e.getMessage());
        }catch (Exception e) {
            logger.error("SellerLoginController-sellerInfoBrief-未知错误", e);
            return returnErrorInfo(ErrorCode.ERROR);
        }
    }

    /**
     * 获取商家信息详情
     * @return
     */
    @RequestMapping(value="/sellerInfoDetail", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String sellerInfoDetail() {
        try {
            User tempUser = (User)WebUtils.getSessionAttribute(request, FieldConst.USER);
            if(tempUser == null) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_3026);
            }

            BaseEntity baseEntity = new BaseEntity();
            baseEntity.setData(tempUser);
            return returnSuccessInfo(baseEntity);
        }catch (MeException e) {
            logger.error("SellerLoginController-sellerInfoDetail", e);
            return returnErrorInfo(e.getMessageKey(), e.getMessage());
        }catch (Exception e) {
            logger.error("SellerLoginController-sellerInfoDetail-未知错误", e);
            return returnErrorInfo(ErrorCode.ERROR);
        }
    }

    /**
     * 新增店铺
     * @return
     */
    @RequestMapping(value="/addSellerShopId", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String addSellerShopId(@RequestBody JSONObject jsonObj) {
        try {
            if(MapUtils.isEmpty(jsonObj)) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1005);
            }
            String sellerShopId = jsonObj.getString("sellerShopId");
            if(StringUtils.isBlank(sellerShopId)) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1005);
            }

            User tempUser = (User)WebUtils.getSessionAttribute(request, FieldConst.USER);
            if(tempUser == null) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_3026);
            }

            if(StringUtils.isNotBlank(tempUser.getSellerShopId2()) && StringUtils.isNotBlank(tempUser.getSellerShopId3())) {
                return returnErrorInfo(ErrorCode.ERROR, "店铺最多可设置三个，无法继续添加");
            }

            if(StringUtils.isBlank(tempUser.getSellerShopId2())) {
                tempUser.setSellerShopId2(sellerShopId);
            }
            if(StringUtils.isBlank(tempUser.getSellerShopId3())) {
                tempUser.setSellerShopId3(sellerShopId);
            }
            int updateFlag = userService.updateSellerShopId(tempUser);
            if(updateFlag <= 0) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1004, "新增店铺失败");
            }
            return returnSuccessInfo(new BaseEntity());
        }catch (MeException e) {
            logger.error("SellerLoginController-addSellerShopId", e);
            return returnErrorInfo(e.getMessageKey(), e.getMessage());
        }catch (Exception e) {
            logger.error("SellerLoginController-addSellerShopId-未知错误", e);
            return returnErrorInfo(ErrorCode.ERROR);
        }
    }

    /**
     * 获取待处理任务
     * @param jsonObj
     * @return
     */
    @RequestMapping(value="/unProcessTask", method = RequestMethod.POST, consumes = "application/json")
    @ResponseBody
    public String unProcessTask(@RequestBody JSONObject jsonObj) {
        try {
            /**
             * 登录校验
             */
            User tempUser = (User)WebUtils.getSessionAttribute(request, FieldConst.USER);
            if(tempUser == null) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_3026);
            }

            if(MapUtils.isEmpty(jsonObj)) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1005);
            }

            TaskVo taskVo = (TaskVo)JSONObject.toBean(jsonObj, TaskVo.class);
            String acceptOrderTimeStart = jsonObj.getString("acceptOrderTimeStart");
            String acceptOrderTimeEnd = jsonObj.getString("acceptOrderTimeEnd");
            taskVo.setAcceptOrderTimeStart(DateUtils.changeStringToDateTime(acceptOrderTimeStart));
            taskVo.setAcceptOrderTimeEnd(DateUtils.changeStringToDateTime(acceptOrderTimeEnd));

            List<TaskVo> taskVoList = taskService.getUnProcessTask(taskVo);
            if(CollectionUtils.isEmpty(taskVoList)) {
                return returnErrorInfo(ErrorCode.ERROR_CODE_1001);
            }
            BaseEntity baseEntity = new BaseEntity();
            baseEntity.setData(taskVoList);
            return returnSuccessInfo(baseEntity);
        }catch (MeException e) {
            logger.error("SellerLoginController-unProcessTask", e);
            return returnErrorInfo(e.getMessageKey(), e.getMessage());
        }catch (Exception e) {
            logger.error("SellerLoginController-unProcessTask-未知错误", e);
            return returnErrorInfo(ErrorCode.ERROR);
        }
    }



}
