package com.util.sql;

import java.util.*;
import java.util.Map.Entry;

import javax.annotation.Resource;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.StringUtils;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.RowBounds;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import com.seller.constants.Constants;
import com.util.sql.page.Page;
import com.util.sql.page.PaginationHelper;

/**
 * 类功能描述:MyBatis 查询工具类
 * 
 * @history 2012-12-21 Allen Gong 创建QueryExecutor.java
 * 
 * @author Allen Gong
 * @version 0.1.0
* [1.0] 2016-12-22 Allen Gong add MyBatis查询工具类<br>
 */
@Repository
public class QueryExecutor {
    /**
     * 日志记录器
     */
	private static final Logger logger = LoggerFactory.getLogger(QueryExecutor.class);
	/**
	 * Easy UI grid 页面列表数据Json key值
	 */
	public static final String EASY_UI_ROWS_KEY = "rows";
	/**
	 * Easy UI grid 页面列表行数Json key值
	 */
	public static final String EASY_UI_TOTAL_KEY = "total";
	/**
	 * Easy UI grid 页面汇总数据Json key值
	 */
	public static final String EASY_UI_FOOTER_KEY = "footer";

	@Resource
    private SqlSessionFactory sessionFactory;

	@Resource
    private PaginationHelper paginationHelper;

    /**
     * 根据MyBatis Mapper id获得查询结果
     * 
     * @param mapperId
     * @return
     */
    public <T> List<T> selectList(String mapperId) {
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            return sqlSession.selectList(mapperId);
        } catch (Exception e) {
            logger.error("执行SQL查询时发生错误.MapperId == " + mapperId, e);
        } finally {
            sqlSession.close();
        }
        return null;
    }

    /**
     * 
     * 根据MyBatis Mapper id和参数获得查询结果
     * 
     * @param mapperId
     * @param params
     * @return
     */
    public <T> List<T> selectList(String mapperId, Object params) {
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            return sqlSession.selectList(mapperId, params);
        } catch (Exception e) {
            logger.error("执行SQL查询时发生错误.MapperId == " + mapperId, e);
        } finally {
            sqlSession.close();
        }
        return null;
    }

    /**
     * 
     * 根据MyBatis Mapper id获得查询结果
     * 
     * @param mapperId
     * @param offset
     *            从第几行开始取数据
     * @param limit
     *            返回的记录数
     * @return
     */
    public List<?> selectList(String mapperId, int offset, int limit) {
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            return sqlSession.selectList(mapperId, new RowBounds(offset, limit));
        } catch (Exception e) {
            logger.error("执行SQL查询时发生错误.MapperId == " + mapperId, e);
        } finally {
            sqlSession.close();
        }
        return null;
    }

    /**
     * @param mapperId
     * @param
     * @param offset
     * @param limit
     * @return
     */
    public List<?> selectList(String mapperId, Object objectVo, int offset, int limit) {
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            return sqlSession.selectList(mapperId, objectVo, new RowBounds(offset, limit));
        } catch (Exception e) {
            logger.error("执行SQL查询时发生错误.MapperId == " + mapperId, e);
        } finally {
            sqlSession.close();
        }
        return null;
    }

    /**
     * 根据MyBatis Mapper id获得分页查询结果
     * @param mapperId MyBatis Mapper id
     *                 当前页(从第1页开始)
     *                 每页显示记录条数
     * @return
     */
    public Page getPageByMapperId(String mapperId) {
        return getPageByMapperId(mapperId, null);
    }
    
    /**
     * 根据MyBatis Mapper id获得分页查询结果
     * @param mapperId
     *            MyBatis Mapper id
     * @param objectVo
     *            SQL参数, 继承自AbstractPageEntity
     * @return 分页对象
     */
    public Page getPageByMapperId(String mapperId, BaseEntity objectVo) {
       return this.getPageByMapperId(mapperId, null, objectVo);
    }
    
    /**
     * 根据MyBatis Mapper id获得分页查询结果
     * @param pageMapperId
     *             分页查询
     * @param footerMapperId
     *             统计分析查询
     * @param objectVo
     *            SQL参数, 继承自AbstractPageEntity
     * @return 分页对象
     */
    public Page getPageByMapperId(String pageMapperId, String footerMapperId, BaseEntity objectVo) {
    	 // 当前为第几页
        Integer pageNumber = objectVo.getPageNum();
        // 每页记录条数
        Integer pageSize = objectVo.getPageSize();
        return this.getPageByMapperId(pageMapperId, footerMapperId, objectVo, pageNumber, pageSize);
    }
    
    /**
     * 根据MyBatis Mapper id获得分页查询结果(不包含统计分析查询)
     * @param mapperId
     *            MyBatis Mapper id
     * @param objectVo
     *            SQL参数
     * @param pageNumber
     *            当前页(从第1页开始)
     * @param pageSize
     *            每页显示记录条数
     * @return 分页对象
     */
    public Page getPageByMapperId(String mapperId, Object objectVo, Integer pageNumber, Integer pageSize) {
    	return this.getPageByMapperId(mapperId, null, objectVo, pageNumber, pageSize);
    }
    
    /**
     * 带统计汇总的分页查询
     * @param pageMapperId
     *            分页查询
     * @param footerMapperId
     * 			     汇总分析查询
     * @param objectVo
     *            SQL参数
     * @param pageNumber
     *            当前页(从第1页开始)
     * @param pageSize
     *            每页显示记录条数
     * @return 分页对象
     * @return
     */
    public Page getPageByMapperId(String pageMapperId, String footerMapperId, Object objectVo, Integer pageNumber, Integer pageSize) {
    	Page pager = new Page();
    	//如果没设置，默认为第一页
        if (pageNumber == null || pageNumber.intValue() <= 0) {
            pageNumber = 1;
        }
        //如果没设置，默认每页显示5条记录
        if(pageSize == null || pageSize.intValue() <= 0){
        	pageSize = 15;
        }
        pager.setPageNumber(pageNumber); // 当前页数
        pager.setPageSize(pageSize); // 每页记录条数
        pager.setStartLine((pageNumber - 1) * pageSize); // 开始记录条数(从0开始)
        // 记录集合
        pager.setResultList(selectList(pageMapperId, objectVo, pager.getStartLine(), pager.getPageSize()));
        SqlSession sqlSession = sessionFactory.openSession();
        // 总记录条数
        pager.setRowCount(paginationHelper.getRowCount(sqlSession, pageMapperId, objectVo));
        
        // 针对DATAGRID组件设置的MAP对象,到前台转换成JSON格式
        // 里面有两个KEY,分别用来存放 总资料笔数 和 每页数据对象(list格式)
        // 根据不同的开源框架，KEY值不同
        // easyui: total、rows
        // liger ui:Total、Rows
        if (pager.getJsonMap() == null) {
            Map<String, Object> jsonMap = new HashMap<String, Object>();
            pager.setJsonMap(jsonMap);
        }
        //统计分析查询
        if(StringUtils.isNotBlank(footerMapperId)){
        	pager.getJsonMap().put(EASY_UI_FOOTER_KEY, selectList(footerMapperId, objectVo));
        }
        pager.getJsonMap().put(EASY_UI_TOTAL_KEY, pager.getRowCount());
        pager.getJsonMap().put(EASY_UI_ROWS_KEY, pager.getResultList());
        return pager;
    }
    
    /**
     * 查询不带汇总的列表数据
     * @param listMapperId 列表查询SQL MapperId
     * @param objectVo 查询条件对象
     * @return
     */
    public Map<String, Object> getListByMapperId(String listMapperId, Object objectVo){
    	return this.getListByMapperId(listMapperId, null, objectVo);
    }
    
    /**
     * 查询带汇总的列表数据
     * @param listMapperId 列表查询SQL MapperId
     * @param footerMapperId 汇总查询SQL MapperId
     * @param objectVo 查询条件对象
     * @return
     */
    public Map<String, Object> getListByMapperId(String listMapperId, String footerMapperId, Object objectVo){
    	Map<String, Object> jsonMap = new HashMap<String, Object>();
    	//列表查询结果
    	jsonMap.put(EASY_UI_ROWS_KEY, selectList(listMapperId, objectVo));
    	//汇总查询结果
        if(StringUtils.isNotBlank(footerMapperId)){
        	jsonMap.put(EASY_UI_FOOTER_KEY, selectList(footerMapperId, objectVo));
        }
    	return jsonMap;
    }
    
    /**
     * 执行 Raw SQL
     * 
     * @param sql
     * @return
     */
    @SuppressWarnings("rawtypes")
    public List<Map> genericQuery(String sql) {
        if (StringUtils.isEmpty(sql) || !sql.toLowerCase().trim().startsWith("select")) {
            return null;
        }
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            GenericQueryMapper query = sqlSession.getMapper(GenericQueryMapper.class);
            return query.query(sql);
        } catch (Exception e) {
            logger.error("执行SQL查询时发生错误.sql == " + sql, e);
        } finally {
            sqlSession.close();
        }
        return null;
    }

    /**
     * 
     * 执行 SQL， SQL 参数的格式参照 MyBatis, 即用 #{param_name}
     * 
     * @param sql
     * @param params
     * @return
     */
    @SuppressWarnings("rawtypes")
    public List<Map> genericQuery(String sql, Object params) {
        if (StringUtils.isEmpty(sql) || !sql.toLowerCase().trim().startsWith("select")){
            return null;
        }
        SqlSession sqlSession = sessionFactory.openSession();
        try {
            GenericQueryMapper query = sqlSession.getMapper(GenericQueryMapper.class);
            return query.queryWithParams(sql, params);
        } catch (Exception e) {
            logger.error("执行SQL查询时发生错误.sql == " + sql, e);
        } finally {
            sqlSession.close();
        }
        return null;
    }
    
    /**
     * 根据动态数据生成动态列表格数据
     * @param groupMapperId 获取聚合数据SQL
     * @param objectVo 查询条件
     * @param dynamicCols 动态列
     * @return
     */
    public Map<String, Object>  getDynamicColsGridData(String groupMapperId, Object objectVo, List<DynamicColsField> dynamicCols){
    	Map<String, Object> returnMap = new HashMap<String, Object>();
    	if(CollectionUtils.isEmpty(dynamicCols)){
    		return returnMap;
    	}
    	List<DynamicColsData> groupData = selectList(groupMapperId, objectVo);
    	if(CollectionUtils.isEmpty(groupData)){
    		return returnMap;
    	}
    	Map<String, LinkedHashMap<String, String>> rowsData = new LinkedHashMap<String, LinkedHashMap<String, String>>();
    	for(DynamicColsData dynamicColsData : groupData){
    		String rowName = dynamicColsData.getRowName() == null ? "" : dynamicColsData.getRowName();
    		LinkedHashMap<String, String> oneRowData = rowsData.get(rowName);
    		if(oneRowData == null){
    			oneRowData = new LinkedHashMap<String, String>();
    			for(DynamicColsField dynamicColsField : dynamicCols){
    				oneRowData.put(dynamicColsField.getField(), "");
    			}
    			rowsData.put(rowName, oneRowData);
    		}
    		String colName = dynamicColsData.getColName() == null ? "" : dynamicColsData.getColName();
    		oneRowData.put(colName, dynamicColsData.getContent());
    	}
    	List<Map<String, String>> colDataList = new ArrayList<Map<String, String>>();
    	Iterator<Entry<String,LinkedHashMap<String,String>>> iter = rowsData.entrySet().iterator();
    	while(iter.hasNext()){
    		Entry<String,LinkedHashMap<String,String>> entry = iter.next();
    		colDataList.add(entry.getValue());
    		entry.getValue().put(Constants.DYNAMIC_COLS_DATA_ROW_NAME, entry.getKey());
    	}
    	//设置所有行数据
    	returnMap.put(EASY_UI_ROWS_KEY, colDataList);
    	return returnMap;
    }
}
