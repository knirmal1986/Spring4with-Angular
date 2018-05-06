'use strict';

var App2 = angular.module('myApp2',['ngResource','ngRoute','ng-fusioncharts']);
App2.controller('chartController', [ '$scope', function($scope) {
    //chart definition
	$scope.myDataSource = {
		    chart: {
		        caption: "Harry's SuperMart",
		        subCaption: "Top 5 stores in last month by revenue",
		        numberPrefix: "$",
		        theme: "ocean"
		    },
		    data:[{
		        label: "Bakersfield Central",
		        value: "880000"
		    },
		    {
		        label: "Garden Groove harbour",
		        value: "730000"
		    },
		    {
		        label: "Los Angeles Topanga",
		        value: "590000"
		    },
		    {
		        label: "Compton-Rancho Dom",
		        value: "520000"
		    },
		    {
		        label: "Daly City Serramonte",
		        value: "330000"
		    }]
	};
}]);