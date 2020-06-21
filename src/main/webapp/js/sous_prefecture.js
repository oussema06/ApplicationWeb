var app = angular.module('myGestionApp');

app.controller('sous_prefecture', function($scope, $state, sessionService, $rootScope, $http){
			
			
								$scope.newSous_Prefecture = {};
								$scope.clickedSous_Prefectures = [];
								
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
								
								
								
								
								
								
								$scope.saveSous_Prefecture = function(){
									console.log(JSON.stringify($scope.newSous_Prefecture)) ;
									
									$http({
								          method  : 'POST',
								          url     : 'sous_prefecture',
								          data    : $scope.newSous_Prefecture, //forms user object
								          headers : {'Content-Type': 'application/json'} 
								         }).then(
								                 function(data){
								                	 
								                	 window.location.reload()
								                		});
								};	
								
								
								
								$scope.selectSous_Prefecture =  function(sous_prefecture){
									$scope.selectedSous_Prefecture = sous_prefecture;
									console.log(JSON.stringify($scope.selectedSous_Prefecture)) ;
								};
								
								$scope.updateSous_prefecture = function(){
									
									console.log(JSON.stringify($scope.selectedSous_Prefecture)) ;
									$http({
								          method  : 'PUT',
								          url     : 'sous_prefecture/libelle',
								          data    : "code="+$scope.selectedSous_Prefecture.code_sous_prefecture+"&libelle="+$scope.selectedSous_Prefecture.libelle+"&nom="+$scope.selectedSous_Prefecture.nom_sous_prefecture+"&codePrefecture="+$scope.selectedSous_Prefecture.prefecture.code_pefecture ,
								          headers : {'Content-Type': 'application/x-www-form-urlencoded'} 
								         }).then(
								                 function(data){
								                	 
								                	 window.location.reload()
								                		});
								};			
							
								
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
								
								
								
								
								
								$scope.deletePrefecture = function(){
									$scope.prefectures.splice($scope.prefectures.indexOf($scope.selectPrefecture), 1);
								};
						});