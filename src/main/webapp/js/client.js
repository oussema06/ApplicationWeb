var app = angular.module('myGestionApp');

app.controller('client', function($scope, $state, sessionService, $rootScope, $http){
			
			
								$scope.newClient = {};
								$scope.clickedClients = [];
								
								$scope.clients = [];
								
								
								$http.get('/client', {
								     
								    }).then(function(data){
								    	angular.forEach(data.data , function(value){
								    		$scope.clients.push({
								    			
								    			code_client : value.code_client, 
								    			nom_client : value.nom_client , 
												representant : value.representant ,
												cgi : value.cgi ,
												tel : value.tel ,
												fax : value.fax ,
												mail : value.mail ,
												adresse_de_facturation : value.adresse_de_facturation ,
												adresse_de_livraison : value.adresse_de_livraison ,
								    			libelle : value.libelle ,												
								    			canton : value.canton ,
												type : value.type ,
												
												
								    		}) ;
								    		
								    	}) ; 
								      });
								
								
								
								
								
								
								$scope.saveClient = function(){
									console.log(JSON.stringify($scope.newClient)) ;
									
									$http({
								          method  : 'POST',
								          url     : '/client',
								          data    : $scope.newClient, //forms user object
								          headers : {'Content-Type': 'application/json'} 
								         }).then(
								                 function(data){
								                	 
								                	 window.location.reload()
								                		});
								};	
								
								
								
								$scope.selectClient =  function(client){
									$scope.selectedClient = client;
									console.log(JSON.stringify($scope.selectedClient)) ;
								};
								
								$scope.updateCanton = function(){
									console.log(JSON.stringify($scope.selectedClient)) ;
									$http({
								          method  : 'PUT',
								          url     : 'client',
								          data    : "code="+$scope.selectedClient.code_client+"&adrFac="+$scope.selectedClient.adresse_de_facturation+"&adrLiv="+$scope.selectedClient.adresse_de_livraison+"&fax="+$scope.selectedClient.fax+"&libelle="+$scope.selectedClient.libelle+"&mail="+$scope.selectedClient.mail+"&nom="+$scope.selectedClient.nom+"&tel="+$scope.selectedClient.tel+"&codeCGI="+$scope.selectedClient.cgi.code_CGI+"&codeCanton="+$scope.selectedClient.canton.code_canton ,
								          headers : {'Content-Type': 'application/x-www-form-urlencoded'} 
								         }).then(
								                 function(data){
								                	 
								                	 window.location.reload()
								                		});
								};			
								
								
								
					   $scope.newCanton = {};
					   $scope.clickedCantons = [];		
                       $scope.cantons = [];
								
								
								$http.get('/canton', {
								     
								    }).then(function(data){
								    	angular.forEach(data.data , function(value){
								    		$scope.cantons.push({
								    			
								    			code_canton : value.code_canton,
								    			libelle : value.libelle ,												
								    			nom_canton : value.nom_canton ,
												sous_prefecture : value.sous_prefecture 
												
								    		}) ;
								    		
								    	}) ; 
								      });	
						
								
								$scope.newCGI = {};
								$scope.clickedCGIs = [];
								 $scope.CGIs = [];
									
									
									$http.get('/CGI', {
									     
									    }).then(function(data){
									    	angular.forEach(data.data , function(value){
									    		$scope.CGIs.push({
									    			
									    			code_CGI : value.code_CGI,
									    			libelle : value.libelle ,												
									    			nom_CGI : value.nom_CGI ,
													usine : value.usine 
													
									    		}) ;
									    		
									    	}) ; 
									      });			
								
								
							
						});