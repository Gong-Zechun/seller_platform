<%@ page language="java" import="java.util.*" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
  <head>
    <title>订单管理-传神决策分析系统</title>
	<%@ include file="../common/include.jsp"%>
	<%@ include file="../common/highcharts.jsp"%>
	<script type="text/javascript">
		$(function () {
		    Highcharts.chart('container', {
		        chart: {
		            type: 'pie',
		            options3d: {
		                enabled: true,
		                alpha: 45
		            }
		        },
		        title: {
		            text: 'Contents of Highsoft\'s weekly fruit delivery'
		        },
		        subtitle: {
		            text: '3D donut in Highcharts'
		        },
		        plotOptions: {
		            pie: {
		                innerSize: 100,
		                depth: 45
		            }
		        },
		        series: [{
		            name: 'Delivered amount',
		            data: [
		                ['Bananas', 8],
		                ['Kiwi', 3],
		                ['Mixed nuts', 1],
		                ['Oranges', 6],
		                ['Apples', 8],
		                ['Pears', 4],
		                ['Clementines', 4],
		                ['Reddish (bag)', 1],
		                ['Grapes (bunch)', 1]
		            ]
		        }]
		    });
		});
	</script>
  </head>
  <body>
  	<div id="container"></div>
  </body>
 </html>