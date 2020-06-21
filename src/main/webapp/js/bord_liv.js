var app = angular.module('myGestionApp');

app.controller('bord_liv', function($scope, $state, sessionService, $rootScope, $http){
			
			
								$scope.newBordereau_de_livraison = {};
								$scope.clickedBordereau_de_livraisons = [];
								
								$scope.bordereau_de_livraisons = [];
								
								$scope.newLigne_bordereau = {};
								$scope.clickedLigne_bordereaus = [];
								
								$scope.ligne_bordereaus = [];
								
								
								$scope.newLiqne_bordereau1 = {};
								$scope.clickedLiqne_bordereau1s = [];
								
								$scope.liqne_bordereau1s = [];
								
								//$scope.bordereau = null;
											
								
								
								$scope.saveBordereau_de_livraison = function(){
									console.log(JSON.stringify($scope.newBordereau_de_livraison)) ;
									$scope.newBordereau_de_livraison.client.type = "AV" ;
									$http({
								          method  : 'POST',
								          url     : 'bordereau_de_livraison',
								          data    : $scope.newBordereau_de_livraison, //forms user object
								          headers : {'Content-Type': 'application/json'} 
								         }).then(function(result) {
								             console.log(result.data);
								             $scope.bordereau = result.data;
								             return result.data;
								         }).then(function() {
	
									            
									
									
									
									
				            	
				    
									$scope.$watchCollection('ligne_bordereaus', function(newVal) {
									    for (var i = 0; i < newVal.length; i++) {

									    	 //ligne_bordereaus[i].bordereau_de_livraison.num = 105;
									    	newVal[i].bordereau_de_livraison =  $scope.bordereau;
									      console.log(newVal[i].bordereau_de_livraison);
									      console.log(newVal[i]);
								    			$http({
											          method  : 'POST',
											          url     : 'ligne_bordereau',
											          data    : newVal[i], //forms user object
											          headers : {'Content-Type': 'application/json'} 
												     
												    })
												    
									    }
									   
								                	
								                		
									  })
								         }).then(
								                 function(data1){
								                	 
								                	 window.location.reload()
								                		});
				            
				             
								
								};
								
								
								
								$scope.selectBordereau_de_livraison =  function(bordereau_de_livraison){
									$scope.selectedBordereau_de_livraison = bordereau_de_livraison;
									console.log(JSON.stringify($scope.selectedBordereau_de_livraison)) ;
									
									$http.get('/bordereau_de_livraison/ligne_bordereau/'+$scope.selectedBordereau_de_livraison.num , {
									      
					         	    }).then(function(data){
							    	    angular.forEach(data.data , function(value){
							    		$scope.liqne_bordereau1s.push({
							    			
							    			num : value.num ,
							    			qauntite : value.qauntite ,
											article : value.article ,
											bordereau_de_livraison : value.bordereau_de_livraison
											
											
							    		}) ;
							    		
							    	}) ; 
							      });
							
								};
							
								
								$scope.newClient = {};
								$scope.clickedClients = [];
								
								$scope.clients = [];
								
								
								$http.get('/CGI/client/'+$rootScope.user.cgi.code_CGI, {
								     
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
												cosoc : value.cosoc 
												
								    		}) ;
								    		
								    	}) ; 
								      });
								
								
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
												TVA : value.TVA ,
												quantite_disponible : value.quantite_disponible ,
												unite_de_vente : value.unite_de_vente
												
								    		}) ;
								    		
								    	}) ; 
								      });
								
								
								
								$http.get('/CGI/bordereau/'+$rootScope.user.cgi.code_CGI, {
								      
				         	    }).then(function(data){
						    	    angular.forEach(data.data , function(value){
						    		$scope.bordereau_de_livraisons.push({
						    			
						    			num : value.num ,
						    			date : value.date ,
										client : value.client 
										
										
						    		}) ;
						    		
						    	}) ; 
						      });
						
								$scope.selectLiqne_bordereau =  function(liqne_bordereau){
									$scope.selectedLiqne_bordereau = liqne_bordereau;
									console.log(JSON.stringify($scope.selectedLiqne_bordereau)) ;
								};		
							
								
								$scope.updateLiqne_bordereau = function(){
									console.log(JSON.stringify($scope.selectedLiqne_bordereau)) ;
									$http({
								          method  : 'PUT',
								          url     : 'ligne_bordereau',
								          data    : "codeLigne="+$scope.selectedLiqne_bordereau.num+"&quantite="+$scope.selectedLiqne_bordereau.qauntite ,
								          headers : {'Content-Type': 'application/x-www-form-urlencoded'} 
								         }).then(
								                 function(data){
								                	 
								                	 window.location.reload()
								                		});
								};				
								
								$scope.updateLiqne_bordereau1 = function(){
									console.log(JSON.stringify($scope.selectedLiqne_bordereau)) ;
									$http({
								          method  : 'PUT',
								          url     : 'ligne_bordereau',
								          data    : "codeLigne="+$scope.selectedLiqne_bordereau.num+"&quantite=0" ,
								          headers : {'Content-Type': 'application/x-www-form-urlencoded'} 
								         }).then(
								                 function(data){
								                	 
								                	 window.location.reload()
								                		});
								};	
								
								
								
								
								
								
								$scope.saveBordereau_de_livraison1 = function(){
									console.log(JSON.stringify($scope.newBordereau_de_livraison)) ;
									
									$scope.$watchCollection('ligne_bordereaus', function(newVal) {
									    for (var i = 0; i < newVal.length; i++) {

									    	 //ligne_bordereaus[i].bordereau_de_livraison.num = 105;
									    	newVal[i].bordereau_de_livraison =  $scope.selectedBordereau_de_livraison;
									      console.log(newVal[i].bordereau_de_livraison);
									      console.log(newVal[i]);
								    			$http({
											          method  : 'POST',
											          url     : 'ligne_bordereau',
											          data    : newVal[i], //forms user object
											          headers : {'Content-Type': 'application/json'} 
												     
												    })
												    
									    }
									   
								                	
								                		
									  }).then(
								                 function(data1){
								                	 
								                	 window.location.reload()
								                		});
				            
				             
								
								};
								
						});