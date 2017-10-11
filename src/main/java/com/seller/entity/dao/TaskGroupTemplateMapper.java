package com.seller.entity.dao;

import com.seller.entity.model.TaskGroupTemplate;
import com.seller.entity.model.TaskGroupTemplateExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;

public interface TaskGroupTemplateMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(TaskGroupTemplateExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(TaskGroupTemplateExample example);

    /**
     *
     * @mbg.generated
     */
    @Insert({
        "insert into TASK_GROUP_TEMPLATE (USER_ID, TEMPLATE_NAME, ",
        "TASK_TYPE, TASK_ENTRANCE, ",
        "GOODS_URL, GOODS_TITLE, ",
        "SELLER_SHOP_ID, SEARCH_KEYWORD, ",
        "CONDITION_IMG_URL, SEARCH_IMG_URL, ",
        "STAY_TIME, CUSTOM_SERVICE_CHAT_FLAG, ",
        "CONDITION_SEXUAL, CONDITION_AGE, ",
        "ADDITIONAL_CHOOSE, PUBLISH_DATE, ",
        "PUBLISH_AMOUNT, PUBLISH_TIME_PERIOD, ",
        "CREATE_BY, CREATE_TIME, ",
        "UPDATE_BY, UPDATE_TIME, ",
        "REMARKS, DEL_FLAG)",
        "values (#{userId,jdbcType=INTEGER}, #{templateName,jdbcType=VARCHAR}, ",
        "#{taskType,jdbcType=CHAR}, #{taskEntrance,jdbcType=CHAR}, ",
        "#{goodsUrl,jdbcType=VARCHAR}, #{goodsTitle,jdbcType=VARCHAR}, ",
        "#{sellerShopId,jdbcType=VARCHAR}, #{searchKeyword,jdbcType=VARCHAR}, ",
        "#{conditionImgUrl,jdbcType=VARCHAR}, #{searchImgUrl,jdbcType=VARCHAR}, ",
        "#{stayTime,jdbcType=CHAR}, #{customServiceChatFlag,jdbcType=CHAR}, ",
        "#{conditionSexual,jdbcType=CHAR}, #{conditionAge,jdbcType=CHAR}, ",
        "#{additionalChoose,jdbcType=VARCHAR}, #{publishDate,jdbcType=TIMESTAMP}, ",
        "#{publishAmount,jdbcType=INTEGER}, #{publishTimePeriod,jdbcType=VARCHAR}, ",
        "#{createBy,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=INTEGER}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{remarks,jdbcType=VARCHAR}, #{delFlag,jdbcType=CHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(TaskGroupTemplate record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(TaskGroupTemplate record);

    /**
     *
     * @mbg.generated
     */
    List<TaskGroupTemplate> selectByExample(TaskGroupTemplateExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TaskGroupTemplate record, @Param("example") TaskGroupTemplateExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TaskGroupTemplate record, @Param("example") TaskGroupTemplateExample example);
}