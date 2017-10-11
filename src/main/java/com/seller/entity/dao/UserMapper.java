package com.seller.entity.dao;

import com.seller.entity.model.User;
import com.seller.entity.model.UserExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;

public interface UserMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(UserExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(UserExample example);

    /**
     *
     * @mbg.generated
     */
    @Insert({
        "insert into USER (SELLER_NO, PASSWORD, ",
        "REAL_NAME, PHONE, ",
        "QQ_NUM, WECHAT_NUM, ",
        "SELLER_SHOP_ID1, SELLER_SHOP_ID2, ",
        "SELLER_SHOP_ID3, USER_TYPE, ",
        "VIP_FLAG, VIP_GRADE, LAST_LOGIN_IP, ",
        "LAST_LOGIN_DATE, REGISTER_FLAG, ",
        "CREATE_BY, CREATE_TIME, ",
        "UPDATE_BY, UPDATE_TIME, ",
        "REMARKS, DEL_FLAG)",
        "values (#{sellerNo,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, ",
        "#{realName,jdbcType=VARCHAR}, #{phone,jdbcType=VARCHAR}, ",
        "#{qqNum,jdbcType=VARCHAR}, #{wechatNum,jdbcType=VARCHAR}, ",
        "#{sellerShopId1,jdbcType=VARCHAR}, #{sellerShopId2,jdbcType=VARCHAR}, ",
        "#{sellerShopId3,jdbcType=VARCHAR}, #{userType,jdbcType=CHAR}, ",
        "#{vipFlag,jdbcType=CHAR}, #{vipGrade,jdbcType=CHAR}, #{lastLoginIp,jdbcType=VARCHAR}, ",
        "#{lastLoginDate,jdbcType=TIMESTAMP}, #{registerFlag,jdbcType=CHAR}, ",
        "#{createBy,jdbcType=INTEGER}, #{createTime,jdbcType=TIMESTAMP}, ",
        "#{updateBy,jdbcType=INTEGER}, #{updateTime,jdbcType=TIMESTAMP}, ",
        "#{remarks,jdbcType=VARCHAR}, #{delFlag,jdbcType=CHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(User record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(User record);

    /**
     *
     * @mbg.generated
     */
    List<User> selectByExample(UserExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") User record, @Param("example") UserExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") User record, @Param("example") UserExample example);
}