var app = angular.module('myGestionApp');

app.controller('ticket_de_pesage', function($scope, $state, sessionService, $rootScope, $http){

			
			
								$scope.newTicket_de_pesage = {};
								$scope.clickedTicket_de_pesages = [];
								
								$scope.ticket_de_pesages = [];
								
								
												
								
								
								
								$scope.saveTicket_de_pesage = function(){
									console.log(JSON.stringify($scope.newTicket_de_pesage)) ;
									$scope.newTicket_de_pesage.client.type = "AV" ;
									$http({
								          method  : 'POST',
								          url     : 'ticket_de_pesage',
								          data    : $scope.newTicket_de_pesage, //forms user object
								          headers : {'Content-Type': 'application/json'} 
								         }).then(
								                 function(data){
								                	 
								                	 window.location.reload()
								                		});
								};	
								
								
								
								$scope.selectTicket_de_pesage =  function(ticket_de_pesage){
									$scope.selectedTicket_de_pesage = ticket_de_pesage;
									console.log(JSON.stringify($scope.selectedTicket_de_pesage)) ;
								};
								
								$scope.newClient = {};
								
								$scope.selectClient =  function(client){
									$scope.selectedClient = client;
									console.log(JSON.stringify($scope.selectedClient)) ;
								};
								
								$scope.newChauffeur = {};
								
								$scope.selectChauffeur =  function(chauffeur){
									$scope.selectedChauffeur = chauffeur;
									console.log(JSON.stringify($scope.selectedChauffeur)) ;
								};
								
								$scope.newVehicule = {};
								
								$scope.selectVehicule =  function(vehicule){
									$scope.selectedVehicule = vehicule;
									console.log(JSON.stringify($scope.selectedVehicule)) ;
								};
								
		
								
								
								$scope.newClient = {};
								$scope.clickedClients = [];
								
								$scope.clients = [];
								
								
								$http.get('/usine/client/'+$rootScope.user.usine.code_usine , {
								     
								    }).then(function(data){
								    	angular.forEach(data.data , function(value){
								    		$scope.clients.push({
								    			
								    			type : value.type ,
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
												cosoc : value.cosoc 
												
								    		}) ;
								    		
								    	}) ; 
								      });
								
						
								
								
								
								$scope.newVehicule = {};
								$scope.clickedVehicules = [];
								
								$scope.vehicules = [];
								
								
								$http.get('/vehicule', {
								     
								    }).then(function(data){
								    	angular.forEach(data.data , function(value){
								    		$scope.vehicules.push({
								    			
								    			matricule : value.matricule ,
								    			identite_interne : value.identite_interne, 
								    			libelle : value.libelle , 
												poids : value.poids 
												
								    		}) ;
								    		
								    	}) ; 
								      });
								
								
								$scope.newChauffeur = {};
								$scope.clickedChauffeurs = [];
								
								$scope.chauffeurs = [];
								
								
								$http.get('/chauffeur', {
								     
								    }).then(function(data){
								    	angular.forEach(data.data , function(value){
								    		$scope.chauffeurs.push({
								    			
								    			code_chauffeur : value.code_chauffeur ,
								    			nom_chauffeur : value.nom_chauffeur, 
								    			libelle : value.libelle , 
								    			prenom_chauffeur : value.prenom_chauffeur ,
								    			tel : value.tel 
												
								    		}) ;
								    		
								    	}) ; 
								      });
								
								$http.get('/usine/ticket/'+$rootScope.user.usine.code_usine, {
								     
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
											vehicule : value.vehicule ,
											etat : value.etat
											
							    		}) ;
							    		
							    	}) ; 
							      });	
								
								
								$scope.updateTicket = function(){
									console.log(JSON.stringify($scope.selectedTicket_de_pesage)) ;
								        	 
								        	 $http({
										          method  : 'PUT',
										          url     : 'ticket_de_pesage',
										          data    : "codeT="+$scope.selectedTicket_de_pesage.code_ticket+"&choix="+$scope.selectedTicket_de_pesage.choix_coton+"&distance="+$scope.selectedTicket_de_pesage.distance_parcourue+"&libelle="+$scope.selectedTicket_de_pesage.libelle+"&poids="+$scope.selectedTicket_de_pesage.poids+"&codeC"+$scope.newChauffeur.code_chauffeur+"&codeClt="+$scope.newClient.code_client+"&matricule="+$scope.newVehicule.matricule ,
										          headers : {'Content-Type': 'application/x-www-form-urlencoded'} 
										         }).then(
								                 function(data){
								                	 
								                	 window.location.reload()
								                		});
								};	
								
								
								
						});