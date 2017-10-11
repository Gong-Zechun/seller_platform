package com.seller.entity.dao;

import com.seller.entity.model.RechargeRecord;
import com.seller.entity.model.RechargeRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;

public interface RechargeRecordMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(RechargeRecordExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(RechargeRecordExample example);

    /**
     *
     * @mbg.generated
     */
    @Insert({
        "insert into RECHARGE_RECORD (RECEIPT_ACCOUNT_NAME, TRANSFER_PERSON_PHONE, ",
        "TRANSFER_AMOUNT, TRANSFER_IMG_URL, ",
        "FINISH_FLAG, CREATE_BY, ",
        "CREATE_TIME, UPDATE_BY, ",
        "UPDATE_TIME, REMARKS, ",
        "DEL_FLAG)",
        "values (#{receiptAccountName,jdbcType=VARCHAR}, #{transferPersonPhone,jdbcType=VARCHAR}, ",
        "#{transferAmount,jdbcType=DECIMAL}, #{transferImgUrl,jdbcType=VARCHAR}, ",
        "#{finishFlag,jdbcType=CHAR}, #{createBy,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=INTEGER}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{remarks,jdbcType=VARCHAR}, ",
        "#{delFlag,jdbcType=CHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(RechargeRecord record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(RechargeRecord record);

    /**
     *
     * @mbg.generated
     */
    List<RechargeRecord> selectByExample(RechargeRecordExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") RechargeRecord record, @Param("example") RechargeRecordExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") RechargeRecord record, @Param("example") RechargeRecordExample example);
}