<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
  <head>  
    <title>AngularJS ngResource Example</title>  
    
     <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
     <link rel="stylesheet" href="//code.jquery.com/ui/1.12.1/themes/base/jquery-ui.css">
     <link href="<c:url value='/resources/css/app.css' />" rel="stylesheet"></link>
  </head>
  <script src="https://code.jquery.com/jquery-1.12.4.js"></script>
		<script src="https://code.jquery.com/ui/1.12.1/jquery-ui.js"></script>
  <body ng-app="myApp" class="ng-cloak">
      <div class="generic-containerr" ng-controller="UserController as ctrl">
          <div class="panel panel-default">
          <ul class="navoption nav navbar-nav navbar-right">
              	<li><a href="list">Details</a></li>
              	<li><a href="charts">Chart</a></li>
              </ul>
              <div class="panel-heading"><span class="lead">Allocate New Environment </span></div>
              
              <div class="formcontainer">
                  <form ng-submit="ctrl.submit()" name="myForm" class="form-horizontal">
                      <input type="hidden" ng-model="ctrl.user.id" />
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="url">URL</label>
                              <div class="col-md-7">
                                  <input type="text" ng-model="ctrl.user.url" id="url" class="url form-control input-sm" placeholder="Enter Environment URL" required ng-minlength="3"/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.url.$error.required">This is a required field</span>
                                      <!-- <span ng-show="myForm.url.$error.minlength">Minimum length required is 3</span> -->
                                      <span ng-show="myForm.url.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                        
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="env">ENV</label>
                              <div class="col-md-2">
                                  <input type="text" ng-model="ctrl.user.env" id="env" class="form-control input-sm" placeholder="Enter your Env. [This field is validation free]"/>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="schema">SCHEMA</label>
                              <div class="col-md-2">
                                  <input type="text" ng-model="ctrl.user.schema" id="schema" class="schema form-control input-sm" placeholder="Enter your DB Schema" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.schema.$error.required">This is a required field</span>
                                      <span ng-show="myForm.schema.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="startDate">START DATE</label>
                              <div class="col-md-2">
                                  <input type="text" ng-model="ctrl.user.startDate" id="startDate" class="startdate form-control input-sm" placeholder="Select Start Date" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.startDate.$error.required">This is a required field</span>
                                      <span ng-show="myForm.startDate.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
					 <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="endDate">END DATE</label>
                              <div class="col-md-2">
                                  <input type="text" ng-model="ctrl.user.endDate" id="endDate" class="enddate form-control input-sm" placeholder="Select End Date" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.endDate.$error.required">This is a required field</span>
                                      <span ng-show="myForm.endDate.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>
                      <div class="row">
                          <div class="form-group col-md-12">
                              <label class="col-md-2 control-lable" for="projectName">PROJECT NAME</label>
                              <div class="col-md-2">
                                  <input type="text" ng-model="ctrl.user.projectName" id="projectName" class="projectname form-control input-sm" placeholder="Enter your Project Name" required/>
                                  <div class="has-error" ng-show="myForm.$dirty">
                                      <span ng-show="myForm.projectName.$error.required">This is a required field</span>
                                      <span ng-show="myForm.projectName.$invalid">This field is invalid </span>
                                  </div>
                              </div>
                          </div>
                      </div>

                      <div class="row">
                          <div class="form-actions floatRight">
                              <input type="submit"  value="{{!ctrl.user.id ? 'Add' : 'Update'}}" class="btn btn-primary btn-sm" ng-disabled="myForm.$invalid">
                              <button type="button" ng-click="ctrl.reset()" class="btn btn-warning btn-sm" ng-disabled="myForm.$pristine">Reset Form</button>
                          </div>
                      </div>
                  </form>
              </div>
          </div>
          <div class="panel panel-default">
                <!-- Default panel contents -->
              <div class="panel-heading"><span class="lead">Currently Allocated Environment Details </span></div>
              <div class="tablecontainer">
                  <table class="table table-hover">
                      <thead>
                          <tr>
                              <th>ID.</th>
                              <th>URL</th>
                              <th>ENV</th>
                              <th>SCHEMA</th>
                              <th>START DATE</th>
                              <th>END DATE</th>
                              <th>PROECT NAME</th>
                              <th width="20%"></th>
                          </tr>
                      </thead>
                      <tbody style="font-family: 	Arial, Verdana, sans-serif;color:#000115;font-size:	13px;">
                          <tr ng-repeat="u in ctrl.users">
                              <td><span ng-bind="u.id"></span></td>
                              <td><span ng-bind="u.url"></span></td>
                              <td><span ng-bind="u.env"></span></td>
                              <td><span ng-bind="u.schema"></span></td>
                               <td><span ng-bind="u.startDate"></span></td>
                                <td><span ng-bind="u.endDate"></span></td>
                              <td><span ng-bind="u.projectName"></span></td>
                               
                              <td>
                              <button type="button" ng-click="ctrl.edit(u.id)" class="btn btn-success custom-width">Edit</button>  <button type="button" ng-click="ctrl.remove(u.id)" class="btn btn-danger custom-width">Remove</button>
                              </td>
                          </tr>
                      </tbody>
                  </table>
              </div>
          </div>
      </div>
      
  <script>
    
  $( function() {
    $( "#startDate").datepicker({ minDate: 0});
    $( "#endDate").datepicker({ minDate: 0});
  } );
  
  
  </script>
      
		
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
      <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-resource.js"></script>
       <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular-route.js"></script>
      <script src="<c:url value='/resources/js/app.js' />"></script>
      <script src="<c:url value='/resources/js/service/user_service.js' />"></script>
      <script src="<c:url value='/resources/js/controller/user_controller.js' />"></script>
  </body>
</html>