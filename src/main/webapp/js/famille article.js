var app = angular.module('myGestionApp');

app.controller('famille_article', function($scope, $state, sessionService, $rootScope, $http){
			
			
								$scope.newPrefecture = {};
								$scope.clickedPrefectures = [];
								
								$scope.prefectures = [];
								
								
								$http.get('/prefecture', {
								     
								    }).then(function(data){
								    	angular.forEach(data.data , function(value){
								    		$scope.prefectures.push({
								    			
								    			code_pefecture : value.code_pefecture, 
								    			nom_prefecture : value.nom_prefecture , 
								    			libelle : value.libelle , 
								    			pays : value.pays
								    		}) ;
								    		
								    	}) ; 
								      });
								
								
								
								
								
								
								$scope.savePrefecture = function(){
									console.log(JSON.stringify($scope.newPrefecture)) ;
									
									$http({
								          method  : 'POST',
								          url     : 'prefecture',
								          data    : $scope.newPrefecture, //forms user object
								          headers : {'Content-Type': 'application/json'} 
								         }).then(
								                 function(data){
								                	 
								                	 window.location.reload()
								                		});
								};	
								
								
								
								$scope.selectPrefecture =  function(prefecture){
									$scope.selectedPrefecture = prefecture;
									console.log(JSON.stringify($scope.selectedPrefecture)) ;
								};
								
								$scope.update_prefecture = function(){
									console.log(JSON.stringify($scope.selectedPrefecture)) ;
									$http({
								          method  : 'PUT',
								          url     : 'prefecture/libelle',
								          data    : "code="+$scope.selectedPrefecture.code_pefecture+"&libelle="+$scope.selectedPrefecture.libelle+"&nom="+$scope.selectedPrefecture.nom_prefecture+"&codePays="+$scope.selectedPrefecture.pays.code_pays ,
								          headers : {'Content-Type': 'application/x-www-form-urlencoded'} 
								         }).then(
								                 function(data){
								                	 
								                	 window.location.reload()
								                		});
								};										
								
								
								$scope.deletePrefecture = function(){
									$scope.prefectures.splice($scope.prefectures.indexOf($scope.selectPrefecture), 1);
								};
						});