/**
 * 创建于: 2012-12-22 下午1:50:28<br>
 * 所属项目:Transn SG
 * 文件名称:GenericQueryMapper.java
 * 作者:Allen Gong
 * 版权信息:Copyright (c) 2016~2016,  All Rights Reserved.
 */
package com.seller.sql;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

/**
 * 类功能描述:MyBatis动态执行sql语句
 */
@Repository
public interface GenericQueryMapper {

    /**
     * 带条件查询
     * @param sql
     * @param params
     * @return
     */
    @SuppressWarnings("rawtypes")
	@Select("${sql}")
    List<Map> queryWithParams(@Param("sql") String sql, @Param("params") Object params);

    /**
     * 不带条件查询
     * @param sql
     * @return
     */
    @SuppressWarnings("rawtypes")
	@Select("${sql}")
    List<Map> query(@Param("sql") String sql);
}