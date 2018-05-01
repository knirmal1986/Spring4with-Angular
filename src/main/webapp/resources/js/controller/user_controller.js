'use strict';

App.controller('UserController', ['$scope', '$http','User', function($scope,$http, User) {
          var self = this;
          self.user= new User();
         // self.env = new Environment();
          
          self.users=[];
              
          self.fetchAllUsers = function(){
        	  //self.users = User.query();
        	  $http({
        	        method : "GET",
        	        url : "Environment"
        	    }).then(function mySuccess(response) {
        	    	 console.log("got the users");
        	    	self.users = response.data;
               	  console.log( self.users);
        	    }, function myError(response) {
        	        console.log(response.statusText);
        	    });
        	 
          };
           
          self.createUser = function(){
        	  self.user.$save(function(){
        		  self.fetchAllUsers();
        	  });
          };

          self.updateUser = function(){
        	  /*self.user.$update(function(){
    			  self.fetchAllUsers();
    		  });*/
        	  
        	  $http({
      	        method : "PUT",
      	        url : "Environment/"+self.user.id,
      	        data: self.user,
        	    headers : {
        	        'Content-Type' : 'application/json'
        	    }
      	    }).then(function mySuccess(response) {
      	    	 console.log("updated the env");
      	    	//self.users = response.data;
             	//  console.log( self.users);
      	    	 self.fetchAllUsers(); 
      	    }, function myError(response) {
      	        console.log(response.statusText);
      	    });
        	  
          };

         self.deleteUser = function(identity){
        	 /*var user = User.get({id:identity}, function() {
        		  user.$delete(function(){
        			  console.log('Deleting user with id ', identity);
        			  self.fetchAllUsers();
        		  });
        	 });*/
        	 $http({
       	        method : "DELETE",
       	        url : "Environment/"+identity
       	      
       	    }).then(function mySuccess(response) {
       	    	 console.log("deleted from env");
       	    	//self.users = response.data;
              	//  console.log( self.users);
       	    	 self.fetchAllUsers(); 
       	    }, function myError(response) {
       	        console.log(response.statusText);
       	    });
          };

          self.fetchAllUsers();

          self.submit = function() {
              if(self.user.id==null){
                  console.log('Saving New User', self.user);    
                  self.createUser();
              }else{
    			  console.log('Upddating user with id ', self.user.id);
                  self.updateUser();
                  console.log('User updated with id ', self.user.id);
              }
              self.reset();
          };
              
          self.edit = function(id){
              console.log('id to be edited', id);
              for(var i = 0; i < self.users.length; i++){
                  if(self.users[i].id === id) {
                     self.user = angular.copy(self.users[i]);
                     break;
                  }
              }
          };
              
          self.remove = function(id){
              console.log('id to be deleted', id);
              if(self.user.id === id) {//If it is the one shown on screen, reset screen
                 self.reset();
              }
              self.deleteUser(id);
          };

          
          self.reset = function(){
              self.user= new User();
              $scope.myForm.$setPristine(); //reset Form
          };

      }]);
