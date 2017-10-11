<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>订单管理-传神决策分析系统</title>
	<%@ include file="../common/include.jsp"%>
	<%@ include file="../common/highcharts.jsp"%>
	<script type="text/javascript">
    $(function () {
        var data = [{ name: 'olive', value: 116 }, { name: 'momo', value: 115 }, { name: 'only', value: 222 }, { name: 'for', value: 324}];
        var opt = HighChart.ChartOptionTemplates.Pie(data,'Love-Rate',"饼图示例");
        var container = $("#container");
        HighChart.RenderChart(opt, container);
    });
 
</script>
  </head>
  <body>
  	<div id="container"></div>
  </body>
 </html>