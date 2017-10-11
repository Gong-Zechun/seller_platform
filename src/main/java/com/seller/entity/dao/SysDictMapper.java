package com.seller.entity.dao;

import com.seller.entity.model.SysDict;
import com.seller.entity.model.SysDictExample;
import java.util.List;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.SelectKey;

public interface SysDictMapper {
    /**
     *
     * @mbg.generated
     */
    long countByExample(SysDictExample example);

    /**
     *
     * @mbg.generated
     */
    int deleteByExample(SysDictExample example);

    /**
     *
     * @mbg.generated
     */
    @Insert({
        "insert into SYS_DICT (VALUE, LABEL, ",
        "TYPE, DESCRIPTION, ",
        "PARENT_ID, CREATE_BY, ",
        "CREATE_TIME, UPDATE_BY, ",
        "UPDATE_TIME, REMARKS, ",
        "DEL_FLAG)",
        "values (#{value,jdbcType=VARCHAR}, #{label,jdbcType=VARCHAR}, ",
        "#{type,jdbcType=VARCHAR}, #{description,jdbcType=VARCHAR}, ",
        "#{parentId,jdbcType=INTEGER}, #{createBy,jdbcType=VARCHAR}, ",
        "#{createTime,jdbcType=TIMESTAMP}, #{updateBy,jdbcType=VARCHAR}, ",
        "#{updateTime,jdbcType=TIMESTAMP}, #{remarks,jdbcType=VARCHAR}, ",
        "#{delFlag,jdbcType=CHAR})"
    })
    @SelectKey(statement="SELECT LAST_INSERT_ID()", keyProperty="id", before=false, resultType=Integer.class)
    int insert(SysDict record);

    /**
     *
     * @mbg.generated
     */
    int insertSelective(SysDict record);

    /**
     *
     * @mbg.generated
     */
    List<SysDict> selectByExample(SysDictExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") SysDict record, @Param("example") SysDictExample example);

    /**
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") SysDict record, @Param("example") SysDictExample example);
}