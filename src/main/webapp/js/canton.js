var app = angular.module('myGestionApp');

app.controller('canton', function($scope, $state, sessionService, $rootScope, $http){
			
			
								$scope.newCanton = {};
								$scope.clickedCantons = [];
								
								$scope.cantons = [];
								
								
								$http.get('/canton', {
								     
								    }).then(function(data){
								    	angular.forEach(data.data , function(value){
								    		$scope.cantons.push({
								    			
								    			code_canton : value.code_canton, 
								    			nom_canton : value.nom_canton , 
								    			libelle : value.libelle , 
								    			sous_prefecture : value.sous_prefecture
								    		}) ;
								    		
								    	}) ; 
								      });
								
								
								
								
								
								
								$scope.saveCanton = function(){
									console.log(JSON.stringify($scope.newCanton)) ;
									
									$http({
								          method  : 'POST',
								          url     : '/canton',
								          data    : $scope.newCanton, //forms user object
								          headers : {'Content-Type': 'application/json'} 
								         }).then(
								                 function(data){
								                	 
								                	 window.location.reload()
								                		});
								};	
								
								
								
								$scope.selectCanton =  function(canton){
									$scope.selectedCanton = canton;
									console.log(JSON.stringify($scope.selectedCanton)) ;
								};
								
								$scope.updateCanton = function(){
									console.log(JSON.stringify($scope.selectedCanton)) ;
									$http({
								          method  : 'PUT',
								          url     : 'canton/libelle',
								          data    : "code="+$scope.selectedCanton.code_canton+"&libelle="+$scope.selectedCanton.libelle+"&nom="+$scope.selectedCanton.nom_canton+"&codeSous_prefecture="+$scope.selectedCanton.sous_prefecture.code_sous_prefecture ,
								          headers : {'Content-Type': 'application/x-www-form-urlencoded'} 
								         }).then(
								                 function(data){
								                	 
								                	 window.location.reload()
								                		});
								};			
								
								$scope.sous_prefectures = [];
								
								
								$http.get('/sous_prefecture', {
								     
								    }).then(function(data){
								    	angular.forEach(data.data , function(value){
								    		$scope.sous_prefectures.push({
								    			
								    			code_sous_prefecture : value.code_sous_prefecture, 
								    			nom_sous_prefecture : value.nom_sous_prefecture , 
								    			libelle : value.libelle , 
								    			prefecture : value.prefecture
								    		}) ;
								    		
								    	}) ; 
								      });
								
								
								
								
							
						});