var app = angular.module('myGestionApp');

app.controller('article', function($scope, $state, sessionService, $rootScope, $http){
			
			
								$scope.newPrefecture = {};
								$scope.clickedPrefectures = [];
								
								$scope.newArticle = {};
								$scope.clickedarticles = [];
								
								$scope.articles = [];
								
								
								$http.get('/article', {
								     
								    }).then(function(data){
								    	angular.forEach(data.data , function(value){
								    		$scope.articles.push({
								    			
								    			code_article : value.code_article, 
								    			nom : value.nom, 
												discription_technique : value.discription_technique ,
												prix_unitaire : value.prix_unitaire ,
												TVA : value.tva ,
												quantite_disponible : value.quantite_disponible ,
												unite_de_vente : value.unite_de_vente
												
								    		}) ;
								    		
								    	}) ; 
								      });
								
								
								
								
								
								
								$scope.savePrefecture = function(){
									console.log(JSON.stringify($scope.newPrefecture)) ;
									
									$http({
								          method  : 'POST',
								          url     : 'article',
								          data    : $scope.newPrefecture, //forms user object
								          headers : {'Content-Type': 'application/json'} 
								         }).then(
								                 function(data){
								                	 
								                	 window.location.reload()
								                		});
								};	
								
								
								
								$scope.selectPrefecture =  function(article){
									$scope.selectedPrefecture = article;
									console.log(JSON.stringify($scope.selectedPrefecture)) ;
								};
								
								$scope.update_prefecture = function(){
									console.log(JSON.stringify($scope.selectedPrefecture)) ;
									$http({
								          method  : 'PUT',
								          url     : 'article',
								          data    : "code="+$scope.selectedPrefecture.code_article+"&tva="+$scope.selectedPrefecture.TVA+"&dis="+$scope.selectedPrefecture.discription_technique+"&nom="+$scope.selectedPrefecture.nom+"&prix="+$scope.selectedPrefecture.prix_unitaire+"&quantite="+$scope.selectedPrefecture.quantite_disponible+"&unite="+$scope.selectedPrefecture.unite_de_vente ,
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