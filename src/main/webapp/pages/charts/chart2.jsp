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
            var opt = HighChart.ChartOptionTemplates.Line(data, 'Love-Rate', "折线图示例");
            var container = $("#container");
            HighChart.RenderChart(opt, container);
        });
    </script>
  </head>
  <body>
  	<div id="container"></div>
  </body>
 </html>