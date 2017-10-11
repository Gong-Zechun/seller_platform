<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>订单管理-传神决策分析系统</title>
	<%@ include file="../common/include.jsp"%>
	<%@ include file="../common/highcharts.jsp"%>
	<script type="text/javascript">
        $(function () {
            var data = [
            { name: '2013-01', group: 'olive', value: 116 },
            { name: '2013-01', group: 'momo', value: 115 },
            { name: '2013-01', group: 'only', value: 222 },
            { name: '2013-01', group: 'for', value: 324 },
            { name: '2013-02', group: 'olive', value: 156 },
            { name: '2013-02', group: 'momo', value: 185 },
            { name: '2013-02', group: 'only', value: 202 },
            { name: '2013-02', group: 'for', value: 34 },
            { name: '2013-03', group: 'olive', value: 16 },
            { name: '2013-03', group: 'momo', value: 51 },
            { name: '2013-03', group: 'only', value: 22 },
            { name: '2013-03', group: 'for', value: 84 }
            ];
            var opt = HighChart.ChartOptionTemplates.Bars(data, '','','Love-Rate', "分组柱形图示例");
            var container = $("#container");
            HighChart.RenderChart(opt, container);
            var opt1 = HighChart.ChartOptionTemplates.Bars(data, true,'','Love-Rate', "堆积柱形图示例");
            var container1 = $("#container1");
            HighChart.RenderChart(opt1, container1);
            var opt2 = HighChart.ChartOptionTemplates.Bars(data, '',true ,'Love-Rate', "堆积百分比柱形图示例");
            var container2 = $("#container2");
            HighChart.RenderChart(opt2, container2);
        });
    </script>
  </head>
  <body>
  	<div id="container"></div>
  	<div id="container1"></div>
  	<div id="container2"></div>
  </body>
 </html>