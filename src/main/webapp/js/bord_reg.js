var app = angular.module('myGestionApp');

app.controller('bord_reg', function($scope, $state, sessionService, $rootScope, $http){
			
			
								$scope.newFactureN = {};
								$scope.clickedFactureNs = [];
								
								
								$scope.factureNs = [];
								
								
								$http.get('/factureN', {
								     
								    }).then(function(data){
								    	angular.forEach(data.data , function(value){
								    		$scope.factureNs.push({
								    			
								    			num_facture : value.num_facture, 
								    			client : value.client , 
								    			date : value.date , 
								    			net : value.net ,
								    			etat : value.etat ,
								    			total : value.total ,
								    			totalFac : value.totalFac ,
								    			totalBord : value.totalBord ,
								    			totalTicket : value.totalTicket
								    		}) ;
								    		
								    	}) ; 
								      });
								
								
								
								
								$scope.newFactureP = {};
								$scope.clickedFacturePs = [];
								
								$scope.facturePs = [];
								
								
								$http.get('/factureP', {
								     
								    }).then(function(data){
								    	angular.forEach(data.data , function(value){
								    		$scope.facturePs.push({
								    			
								    			num_facture : value.num_facture, 
								    			client : value.client , 
								    			date : value.date , 
								    			net : value.net ,
								    			etat : value.etat ,
								    			total : value.total ,
								    			totalFac : value.totalFac ,
								    			totalBord : value.totalBord ,
								    			totalTicket : value.totalTicket
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
								
								
								
								$scope.selectFactureN =  function(factureN){
									$scope.selectedFactureN = factureN;
									console.log(JSON.stringify($scope.selectedFactureN)) ;
									
									$http.get("/facture/bordereau_de_livraison/"+$scope.selectedFactureN.num_facture, {
									     
								    }).then(function(data){
								    	angular.forEach(data.data , function(value){
								    		$scope.bordereau_de_livraisons.push({
								    			
								    			num : value.num, 
								    			client : value.client , 
								    			date : value.date , 
								    			facture : value.facture ,
								    			etat : value.etat
								    		}) ;
								    		
								    	}) ; 
								      });
									
									
									$http.get("/facture/ticket_de_pesage/"+$scope.selectedFactureN.num_facture, {
									     
								    }).then(function(data){
								    	angular.forEach(data.data , function(value){
								    		$scope.ticket_de_pesages.push({
								    			
								    			code_tichet : value.code_tichet, 
								    			client : value.client , 
								    			date : value.date , 
								    			facture : value.facture ,
								    			etat : value.etat ,
								    			choix_coton : value.choix_coton ,
								    			distance_parcourue : value.distance_parcourue ,
								    			libelle : value.libelle ,
								    			poids : value.poids ,
								    			chauffeur : value.chauffeur
								    		}) ;
								    		
								    	}) ; 
								      });
									
									
								};
								
								$scope.selectFactureP =  function(factureP){
									$scope.selectedFactureP = factureP;
									$scope.codeclt = $scope.selectedFactureP.client.code_client;
									console.log(JSON.stringify($scope.selectedFactureP)) ;
									console.log(JSON.stringify($scope.codeclt)) ;
									
									$http.get("/facture/bordereau_de_livraison/"+$scope.selectedFactureP.num_facture, {
									     
								    }).then(function(data){
								    	angular.forEach(data.data , function(value){
								    		$scope.bordereau_de_livraisons.push({
								    			
								    			num : value.num, 
								    			client : value.client , 
								    			date : value.date , 
								    			facture : value.facture ,
								    			etat : value.etat
								    		}) ;
								    		
								    	}) ; 
								      });
									
									$http.get("/facture/ticket_de_pesage/"+$scope.selectedFactureP.num_facture, {
									     
								    }).then(function(data){
								    	angular.forEach(data.data , function(value){
								    		$scope.ticket_de_pesages.push({
								    			
								    			code_ticket : value.code_ticket, 
								    			client : value.client , 
								    			date : value.date , 
								    			facture : value.facture ,
								    			etat : value.etat ,
								    			choix_coton : value.choix_coton ,
								    			distance_parcourue : value.distance_parcourue ,
								    			libelle : value.libelle ,
								    			poids : value.poids ,
								    			chauffeur : value.chauffeur
								    		}) ;
								    		
								    	}) ; 
								      });
									
								};
								
								$scope.updateFacture = function(){
									
									console.log(JSON.stringify($scope.selectedFacture)) ;
									$http({
								          method  : 'PUT',
								          url     : 'facture/net',
								          data    : "net="+$scope.selectedFactureN.net+"&num="+$scope.selectedFactureN.num_facture ,
								          headers : {'Content-Type': 'application/x-www-form-urlencoded'} 
								         }).then(
								                 function(data){
								                	 
								                	 window.location.reload()
								                		});
								};			
							
								
								$scope.newBordereau_de_livraison = {};
								$scope.clickedBordereau_de_livraisons = [];
								
								$scope.bordereau_de_livraisons = [];
								
								
								$scope.newTicket_de_pesage = {};
								$scope.clickedTicket_de_pesages = [];
								
								$scope.ticket_de_pesages = [];
								
								
								$scope.newLiqne_bordereau = {};
								$scope.clickedLiqne_bordereaus = [];
								
								$scope.liqne_bordereaus = [];
								//$scope.code = +$scope.selectedFactureP.client.code_client;
								
								
								$scope.selectBordereau_de_livraison =  function(bordereau_de_livraison){
									$scope.selectedBordereau_de_livraison = bordereau_de_livraison;
									console.log(JSON.stringify($scope.selectedBordereau_de_livraison)) ;
									$http.get("bordereau_de_livraison/ligne_bordereau/"+$scope.selectedBordereau_de_livraison.num, {
									     
								    }).then(function(data){
								    	angular.forEach(data.data , function(value){
								    		$scope.liqne_bordereaus.push({
								    			
								    			num : value.num, 
								    			article : value.article , 
								    			qauntite : value.qauntite ,
								    			bordereau_de_livraison : value.bordereau_de_livraison
								    		}) ;
								    		
								    	}) ; 
								      });
									
									
								};
								
								
								
								
								
								$scope.deletePrefecture = function(){
									$scope.prefectures.splice($scope.prefectures.indexOf($scope.selectPrefecture), 1);
								};
						});