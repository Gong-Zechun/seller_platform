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
        	            { dname: '2013-01', dgroup: 'olive', dvalue: 116 },
        	            { dname: '2013-04', dgroup: 'olive', dvalue: 115 },
        	            { dname: '2013-05', dgroup: 'olive', dvalue: 222 },
        	            { dname: '2013-06', dgroup: 'olive', dvalue: 324 },
        	            { dname: '2013-02', dgroup: 'olive', dvalue: 156 },
        	            { dname: '2013-07', dgroup: 'olive', dvalue: 185 },
        	            { dname: '2013-08', dgroup: 'olive', dvalue: 202 },
        	            { dname: '2013-09', dgroup: 'olive', dvalue: 34 },
        	            { dname: '2013-10', dgroup: 'olive', dvalue: 16 },
        	            { dname: '2013-11', dgroup: 'olive', dvalue: 51 },
        	            { dname: '2013-12', dgroup: 'olive', dvalue: 22 },
        	            { dname: '2013-03', dgroup: 'olive', dvalue: 84 }
        	            ];
            var opt = HighChart.ChartOptionTemplates.SPLine(data, 'Love-Rate', "折线图示例");
            var container = $("#container");
            HighChart.RenderChart(opt, container);
        });
    </script>
  </head>
  <body>
  	<div id="container" style="min-width:400px;height:400px"></div>
  </body>
 </html>