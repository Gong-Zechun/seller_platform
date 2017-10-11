package com.seller.entity.dao;

import com.seller.entity.model.Wallet;
import com.seller.entity.model.WalletExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;

public interface WalletMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(WalletExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(WalletExample example);

    /**
     *
     * @mbg.generated
     */
    @Insert({
        "insert into WALLET (USER_ID, BALANCE, ",
        "BLOCK_FUND, ACTIVE_FUND, ",
        "DEPOSIT, CREATE_BY, ",
        "CREATE_TIME, UPDATE_BY, ",
        "UPDATE_TIME, REMARKS, ",
        "DEL_FLAG)",
        "values (#{userId,jdbcType=INTEGER}, #{balance,jdbcType=DECIMAL}, ",
        "#{blockFund,jdbcType=DECIMAL}, #{activeFund,jdbcType=DECIMAL}, ",
        "#{deposit,jdbcType=DECIMAL}, #{createBy,jdbcType=INTEGER}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=INTEGER}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{remarks,jdbcType=VARCHAR}, ",
        "#{delFlag,jdbcType=CHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(Wallet record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(Wallet record);

    /**
     *
     * @mbg.generated
     */
    List<Wallet> selectByExample(WalletExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") Wallet record, @Param("example") WalletExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") Wallet record, @Param("example") WalletExample example);
}