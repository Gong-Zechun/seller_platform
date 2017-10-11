/**
 * 创建于: 2012-12-22 下午1:50:28<br>
 * 所属项目:Transn SG
 * 文件名称:PaginationHelper.java
 * 作者:Allen Gong
 * 版权信息:Copyright (c) 2016~2016,  All Rights Reserved.
 */
package com.seller.page;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.beanutils.PropertyUtils;
import org.apache.ibatis.executor.ErrorContext;
import org.apache.ibatis.executor.ExecutorException;
import org.apache.ibatis.mapping.BoundSql;
import org.apache.ibatis.mapping.MappedStatement;
import org.apache.ibatis.mapping.ParameterMapping;
import org.apache.ibatis.mapping.ParameterMode;
import org.apache.ibatis.reflection.MetaObject;
import org.apache.ibatis.reflection.property.PropertyTokenizer;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.type.TypeHandler;
import org.apache.ibatis.type.TypeHandlerRegistry;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

/**
 * 类功能描述:分页查询帮助类
 * 
 * @history 2012-12-21 Allen Gong 创建PaginationHelper.java
 * 
 * @author Allen Gong
 * @version 0.1.0
* [1.0] 2016-12-22 Allen Gong add 分页查询帮助类<br>
 */
@Repository
public class PaginationHelper {
	private static final Logger logger = LoggerFactory.getLogger(PaginationHelper.class);
	/**
	 * 根据查询SQL查出所有条数
	 * @param sqlSession
	 * @param mapperId
	 * @param params
	 * @return
	 */
	public int getRowCount(SqlSession sqlSession, String mapperId, Object params) {
		int count = 0;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		try {
			MappedStatement mst = sqlSession.getConfiguration().getMappedStatement(mapperId);
			BoundSql boundSql = mst.getBoundSql(params);

			String countSql = boundSql.getSql();
			String loweredString = boundSql.getSql().toLowerCase();
			int orderByIndex = loweredString.lastIndexOf("order by");
			if (orderByIndex != -1) {
				countSql = countSql.substring(0, orderByIndex);
			}
			String sql = " select count(1) row_count from (" + countSql + ") temp ";
			pstmt = sqlSession.getConnection().prepareStatement(sql);
			setParameters(pstmt, mst, boundSql, params);
			rs = pstmt.executeQuery();
			if (rs.next())
				count = rs.getInt("row_count");
		} catch (Exception e) {
			count = 0;
			logger.error("公共处理查询资料总笔数时发生错误.", e);
			throw new RuntimeException(e);
		} finally {
			try {
				if (rs != null) {
					rs.close();
				}
				if (pstmt != null)
					pstmt.close();
			} catch (Exception e) {
				logger.error("关闭数据库连接时发生错误.", e);
			}
			sqlSession.close();
		}
		return count;
	}

	private void setParameters(PreparedStatement ps, MappedStatement mappedStatement, BoundSql boundSql,
			Object parameterObject) throws SQLException {
		ErrorContext.instance().activity("setting parameters").object(mappedStatement.getParameterMap().getId());
		List<?> parameterMappings = boundSql.getParameterMappings();
		if (parameterMappings != null) {
			Configuration configuration = mappedStatement.getConfiguration();
			TypeHandlerRegistry typeHandlerRegistry = configuration.getTypeHandlerRegistry();
			MetaObject metaObject = parameterObject == null ? null : configuration.newMetaObject(parameterObject);
			for (int i = 0; i < parameterMappings.size(); i++) {
				ParameterMapping parameterMapping = (ParameterMapping) parameterMappings.get(i);
				if (parameterMapping.getMode() == ParameterMode.OUT)
					continue;
				String propertyName = parameterMapping.getProperty();
				PropertyTokenizer prop = new PropertyTokenizer(propertyName);
				Object value;
				if (parameterObject == null) {
					value = null;
				} else {
					if (typeHandlerRegistry.hasTypeHandler(parameterObject.getClass())) {
						value = parameterObject;
					} else {
						if (boundSql.hasAdditionalParameter(propertyName)) {
							value = boundSql.getAdditionalParameter(propertyName);
						} else if ((propertyName.startsWith("__frch_"))
								&& (boundSql.hasAdditionalParameter(prop.getName()))) {
							value = boundSql.getAdditionalParameter(prop.getName());
							if (value != null)
								value = configuration.newMetaObject(value)
										.getValue(propertyName.substring(prop.getName().length()));
						} else {
							value = metaObject == null ? null : metaObject.getValue(propertyName);
						}
					}
				}
				@SuppressWarnings("unchecked")
				TypeHandler<Object> typeHandler = (TypeHandler<Object>) parameterMapping.getTypeHandler();
				if (typeHandler == null) {
					throw new ExecutorException("There was no TypeHandler found for parameter " + propertyName
							+ " of statement " + mappedStatement.getId());
				}
				typeHandler.setParameter(ps, i + 1, value, parameterMapping.getJdbcType());
			}
		}
	}

	@SuppressWarnings("rawtypes")
	protected Map<?, ?> toParameterMap(Object parameter) {
		if (parameter == null) {
			return new HashMap();
		}
		if ((parameter instanceof Map))
			return (Map<?, ?>) parameter;
		try {
			return PropertyUtils.describe(parameter);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}