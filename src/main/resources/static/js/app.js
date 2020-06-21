var app = angular.module("myModule", [])
							   .controller("myController", function($scope,$http){
			
								$scope.newPrefecture = {};
								$scope.clickedPrefectures = [];
								
								$scope.prefectures = [];
								
								
								
								
								
								$scope.savePrefecture = function(){
									$scope.newPrefecture.client = $scope.selectedClient;
									console.log(JSON.stringify($scope.newPrefecture)) ;
									
									$http({
								          method  : 'POST',
								          url     : 'facture',
								          data    : $scope.newPrefecture , 
								          headers : {'Content-Type': 'application/json'} 
								         }).then(function(result) {
								             console.log(result.data);
								             $scope.bordereau = result.data;
								             return result.data;
								         }).then(function() {
								        	 
								        	 $http({
										          method  : 'PUT',
										          url     : 'facture',
										          data    : "code="+$scope.bordereau.num ,
										          headers : {'Content-Type': 'application/x-www-form-urlencoded'} 
										         })
												    
									    
								         }).then(
								                 function(data){
								                	 
								                	 window.location.reload()
								                		});
								};	
								
								
								
								$scope.selectClient =  function(client){
									$scope.selectedClient = client;
				                	// window.location.reload();
									console.log(JSON.stringify($scope.selectedClient)) ;
									console.log(JSON.stringify($scope.selectedClient.code_client)) ;
									
									$http.get('/client/bordereau_de_livraison/'+$scope.selectedClient.code_client, {
									      
					         	    }).then(function(data){
							    	    angular.forEach(data.data , function(value){
							    		$scope.bordereau_de_livraisons.push({
							    			
							    			num : value.num ,
							    			date : value.date ,
											client : value.client 
											
											
							    		}) ;
							    		
							    	}) ; 
							      });
							
									
									$http.get('/client/ticket_de_pesage/'+$scope.selectedClient.code_client, {
									      
					         	    }).then(function(data){
							    	    angular.forEach(data.data , function(value){
							    		$scope.ticket_de_pesages.push({
							    			
							    			code_tichet : value.code_tichet, 
							    			choix_coton : value.choix_coton , 
											date : value.date ,
											distance_parcourue : value.distance_parcourue ,
											libelle : value.libelle ,
											poids : value.poids ,
											chauffeur : value.chauffeur ,
											client : value.client ,
											vehicule : value.vehicule
											
							    		}) ;
							    		
							    	}) ; 
							      });
							
									
								};
								
								$scope.selectBordereau_de_livraison =  function(bordereau_de_livraison){
									$scope.selectedBordereau_de_livraison = bordereau_de_livraison;
									console.log(JSON.stringify($scope.selectedBordereau_de_livraison)) ;
									
									$http.get('/bordereau_de_livraison/ligne_bordereau/'+$scope.selectedBordereau_de_livraison.num , {
									      
					         	    }).then(function(data){
							    	    angular.forEach(data.data , function(value){
							    		$scope.liqne_bordereaus.push({
							    			
							    			num : value.num ,
							    			qauntite : value.qauntite ,
											article : value.article ,
											bordereau_de_livraison : value.bordereau_de_livraison
											
											
							    		}) ;
							    		
							    	}) ; 
							      });
							
								};
								
								$scope.selectTicket_de_pesage =  function(ticket_de_pesage){
									$scope.selectedTicket_de_pesage = ticket_de_pesage;
									console.log(JSON.stringify($scope.selectedTicket_de_pesage)) ;
								};
								
											
							
								
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
												cosoc : value.cosoc 
												
								    		}) ;
								    		
								    	}) ; 
								      });
								
								
								
								$scope.newTicket_de_pesage = {};
								$scope.clickedTicket_de_pesages = [];
								
								$scope.ticket_de_pesages = [];
								
								
								
								
								$scope.newBordereau_de_livraison = {};
								$scope.clickedBordereau_de_livraisons = [];
								
								$scope.bordereau_de_livraisons = [];
								
								
								
								
								
								
								$scope.newLiqne_bordereau = {};
								$scope.clickedLiqne_bordereaus = [];
								
								$scope.liqne_bordereaus = [];
								
								
								
						});