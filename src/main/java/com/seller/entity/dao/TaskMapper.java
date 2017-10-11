package com.seller.entity.dao;

import com.seller.entity.model.Task;
import com.seller.entity.model.TaskExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;

public interface TaskMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(TaskExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(TaskExample example);

    /**
     *
     * @mbg.generated
     */
    @Insert({
        "insert into TASK (TASK_GROUP_ID, PUBLISH_TIME_ID, ",
        "PUBLISH_AMOUNT, BUYER_ID, ",
        "STATUS, TAOBAO_ORDER_NO, ",
        "ACCEPT_ORDER_TIME, CREATE_BY, ",
        "CREATE_TIME, UPDATE_BY, ",
        "UPDATE_TIME, REMARKS, ",
        "DEL_FLAG)",
        "values (#{taskGroupId,jdbcType=INTEGER}, #{publishTimeId,jdbcType=INTEGER}, ",
        "#{publishAmount,jdbcType=INTEGER}, #{buyerId,jdbcType=INTEGER}, ",
        "#{status,jdbcType=CHAR}, #{taobaoOrderNo,jdbcType=VARCHAR}, ",
        "#{acceptOrderTime,jdbcType=TIMESTAMP}, #{createBy,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=INTEGER}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{remarks,jdbcType=VARCHAR}, ",
        "#{delFlag,jdbcType=CHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Task record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(Task record);

    /**
     *
     * @mbg.generated
     */
    List<Task> selectByExample(TaskExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Task record, @Param("example") TaskExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Task record, @Param("example") TaskExample example);
}