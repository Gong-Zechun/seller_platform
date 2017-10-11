package com.seller.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.seller.entity.dao.SysDictMapper;
import com.seller.constants.Constants;
import com.seller.entity.model.SysDict;
import com.seller.entity.model.SysDictExample;

/**
 * 类功能描述: 系统数据字典Service
 * @className SysDictService.java
 * 
 * @author Allen Gong
 * @version 2.0
 * 
 * @history 2017-01-01 Allen Gong 创建 SysDictService.java
 */
@Service
public class SysDictService {
	
	@Resource
	private SysDictMapper sysDictMapper;
	
	/**
	 * 获取所有系统数据字典数据
	 * @return
	 */
	public List<SysDict> getAllSysDictList(){
		SysDictExample example = new SysDictExample();
		SysDictExample.Criteria cirteria = example.createCriteria();
		cirteria.andDelFlagEqualTo(Constants.FLAG_FALSE);
//		return sysDictMapper.selectByExample(example);
		return null;
	}
}
