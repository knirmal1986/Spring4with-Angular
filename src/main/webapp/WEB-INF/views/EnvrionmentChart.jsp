<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Environment Chart</title>
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
     <link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"></link>
     <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.js"></script>
       <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-route.js"></script>
      <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
	  <script type="text/javascript" src="resources/js/angular-fusioncharts.min.js"></script>
	  <script type="text/javascript" src="resources/js/fusioncharts.js"></script>
	 
	  <script type="text/javascript" src="resources/js/controller/user_chart_controller.js"></script>
</head>
<center>
<body ng-app="myApp2" ng-controller ="chartController" class="ng-cloak">
<div class="generic-containerr">
          <div class="panel panel-default">
          <ul class="navoption nav navbar-nav navbar-right">
               	<li><a href="list">Details</a></li>
              	 <li><a href="charts">Chart</a></li>
              	
              </ul>
              <div class="panel-heading"><span class="lead">Environment Chart Date Wise</span></div>
</br>
      <fusioncharts 
    width="600" 
    height="300"
    type="column2d"
    datasource="{{myDataSource}}"
></fusioncharts>

</body>
</center>
</html>