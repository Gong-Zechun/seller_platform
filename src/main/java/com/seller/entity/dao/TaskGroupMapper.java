package com.seller.entity.dao;

import com.seller.entity.model.TaskGroup;
import com.seller.entity.model.TaskGroupExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;

public interface TaskGroupMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(TaskGroupExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(TaskGroupExample example);

    /**
     *
     * @mbg.generated
     */
    @Insert({
        "insert into TASK_GROUP (USER_ID, TASK_TYPE, ",
        "TASK_ENTRANCE, GOODS_URL, ",
        "GOODS_TITLE, SELLER_SHOP_ID, ",
        "SEARCH_KEYWORD, CONDITION_IMG_URL, ",
        "SEARCH_IMG_URL, STAY_TIME, ",
        "CUSTOM_SERVICE_CHAT_FLAG, SPECIAL_CONDITION, ",
        "CONDITION_SEXUAL, CONDITION_AGE, ",
        "ADDITIONAL_CHOOSE, PUBLISH_DATE, ",
        "PUBLISH_AMOUNT, PUBLISH_TIME_PERIOD, ",
        "CHECK_FLAG, TASK_GROUP_STATUS, ",
        "CREATE_BY, CREATE_TIME, ",
        "UPDATE_BY, UPDATE_TIME, ",
        "REMARKS, DEL_FLAG)",
        "values (#{userId,jdbcType=INTEGER}, #{taskType,jdbcType=CHAR}, ",
        "#{taskEntrance,jdbcType=CHAR}, #{goodsUrl,jdbcType=VARCHAR}, ",
        "#{goodsTitle,jdbcType=VARCHAR}, #{sellerShopId,jdbcType=VARCHAR}, ",
        "#{searchKeyword,jdbcType=VARCHAR}, #{conditionImgUrl,jdbcType=VARCHAR}, ",
        "#{searchImgUrl,jdbcType=VARCHAR}, #{stayTime,jdbcType=CHAR}, ",
        "#{customServiceChatFlag,jdbcType=CHAR}, #{specialCondition,jdbcType=VARCHAR}, ",
        "#{conditionSexual,jdbcType=CHAR}, #{conditionAge,jdbcType=CHAR}, ",
        "#{additionalChoose,jdbcType=VARCHAR}, #{publishDate,jdbcType=TIMESTAMP}, ",
        "#{publishAmount,jdbcType=INTEGER}, #{publishTimePeriod,jdbcType=VARCHAR}, ",
        "#{checkFlag,jdbcType=CHAR}, #{taskGroupStatus,jdbcType=CHAR}, ",
        "#{createBy,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=INTEGER}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{remarks,jdbcType=VARCHAR}, #{delFlag,jdbcType=CHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(TaskGroup record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(TaskGroup record);

    /**
     *
     * @mbg.generated
     */
    List<TaskGroup> selectByExample(TaskGroupExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") TaskGroup record, @Param("example") TaskGroupExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") TaskGroup record, @Param("example") TaskGroupExample example);
}