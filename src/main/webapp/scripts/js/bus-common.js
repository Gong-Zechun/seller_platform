/** **********读取数据字典 Begin********** */
/**
 * 从数据字典中获取项目状态名称
 * @param val
 * @returns {String}
 */
function getProjectStatus(val){
	return findDictLabel(PRODUCT_STATUS,val);
}

/**
 * 从数据字典中获取行业类型名称
 * @param val
 * @returns {String}
 */
function getBusType(val){
	return findDictLabel(BUS_TYPE,val);
}

/**
 * 从数据字典中获取客户等级名称
 * @param val
 * @returns {String}
 */
function getCustLevel(val){
	return findDictLabel(CUST_LEVE,val);
}

/**
 * 从数据字典中获取客户区域名称
 * @param val
 * @returns {String}
 */
function getCustArea(val){
	return findDictLabel(CUST_AREA,val);
}

/**
 * 从数据字典中获取客户行业名称
 * @param val
 * @returns {String}
 */
function getCustIndustry(val){
	return findDictLabel(CUST_INDUSTRY,val);
}

/**
 * 从数据字典中获取销售员部门名称
 * @param val
 * @returns {String}
 */
function getSalespersonDept(val){
	return findDictLabel(SALESPERSON_DEPT,val);
}

/**
 * 从数据字典中获取处理类型名称
 * @param val
 * @returns {String}
 */
function getProcessType(val){
	return findDictLabel(PROCESS_TYPE,val);
}
/** **********读取数据字典 End********** */

/** **********从客户信息表获取对应客户属性 Begin********** */
/**
 * 获取Customer对象中客户名称
 * @param value
 * @param row
 * @param index
 * @returns
 */
function getCustName(value, row, index){
	if(!value){
		return null;
	}
	return tipView(value.name);
}

/**
 * 获取Customer对象中客户名称
 * @param value
 * @param row
 * @param index
 * @returns
 */
function getCustomerName(value, row, index){
	//合计
	if(value){
		return value;
	}
	if(!row){
		return null;
	}
	var customer = row.customer;
	if(!customer){
		return null;
	} else {
		return row.customer.name;
	}
}

/**
 * 获取Customer对象中客户行业
 * @param value
 * @param row
 * @param index
 * @returns
 */
function getIndustryFromCust(value, row, index){
	//合计
	if(value){
		return value;
	}
	if(!row){
		return null;
	}
	var customer = row.customer;
	if(!customer){
		return null;
	} else 
		return getCustIndustry(row.customer.industry);
}

/**
 * 获取Customer对象中所有者
 * @param value
 * @param row
 * @param index
 * @returns
 */
function getOwnerFromCust(value, row, index){
	//合计
	if(value){
		return value;
	}
	if(!row){
		return null;
	}
	var customer = row.customer;
	if(!customer){
		return null;
	} else 
		return row.customer.owner;
}

/**
 * 获取Customer对象中客户区域
 * @param value
 * @param row
 * @param index
 * @returns
 */
function getAreaFromCust(value, row, index){
	//合计
	if(value){
		return value;
	}
	if(!row){
		return null;
	}
	var customer = row.customer;
	if(!customer){
		return null;
	} else 
		return getCustArea(row.customer.area);
}

/**
 * 获取Customer对象中销售员部门
 * @param value
 * @param row
 * @param index
 * @returns
 */
function getSalespersonDeptFromCust(value, row, index){
	//合计
	if(value){
		return value;
	}
	if(!row){
		return null;
	}
	var customer = row.customer;
	if(!customer){
		return null;
	} else 
		return getSalespersonDept(row.customer.dept);
}

/**
 * 获取Customer对象中客户级别
 * @param value
 * @param row
 * @param index
 * @returns
 */
function getLeveFromCust(value, row, index){
	//合计
	if(value){
		return value;
	}
	if(!row){
		return null;
	}
	var customer = row.customer;
	if(!customer){
		return null;
	} else 
		return getCustLevel(row.customer.level);
}
/** **********从客户信息表获取对应客户属性 End********** */

/**
 * 根据数据字典列表获取Easy UI动态列
 */
function getDynamicCols(firstColName, colsDict, valFormatter, rowFormatter, rowAlign){
	var columns = [];
	var inductryArray = eval(colsDict);
	columns.push({field:'rowName', title:firstColName, width:160, resizable:true, halign:'center',align:rowAlign,formatter:rowFormatter});
	for(var i in inductryArray){//遍历json数组时，这么写p为索引，0,1
		var field = inductryArray[i].value;
		var title = inductryArray[i].label;
		if(field){
			columns.push({field:field, title:title, width:100, resizable:true, halign:'center',align:'right',formatter:valFormatter});
		}
	}
	var outCols = [];
	outCols.push(columns);
	return {columns:outCols}
}