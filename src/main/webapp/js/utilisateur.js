var app = angular.module('myGestionApp');

app.controller('utilisateur', function($scope, $state, sessionService, $rootScope, $http){
			
			
								$scope.newUtilisateur = {};
								$scope.clickedCantons = [];
								
								$scope.utilisateurs = [];
								
								
								$http.get('/utilisateur', {
								     
								    }).then(function(data){
								    	angular.forEach(data.data , function(value){
								    		$scope.utilisateurs.push({
								    			
								    			type : value.type,
								    			code_utilisateur : value.code_utilisateur, 
								    			nom : value.nom , 
								    			email : value.email , 
								    			prenom : value.prenom,
								    			tel : value.tel,
								    			mdp : value.mdp,
								    			usine : value.usine,
								    			cgi : value.cgi
								    		}) ;
								    		
								    	}) ; 
								      });
								
								
								
								
								
								
								$scope.saveCanton = function(){
									console.log(JSON.stringify($scope.newUtilisateur)) ;
									
									$http({
								          method  : 'POST',
								          url     : '/utilisateur',
								          data    : $scope.newUtilisateur, //forms user object
								          headers : {'Content-Type': 'application/json'} 
								         }).then(
								                 function(data){
								                	 
								                	 window.location.reload()
								                		});
								};	
								
								
								
								$scope.selectUtilisateur =  function(utilisateur){
									$scope.selectedUtilisateur = utilisateur;
									console.log(JSON.stringify($scope.selectedUtilisateur)) ;
								};
								
								$scope.updateCanton = function(){
									console.log(JSON.stringify($scope.selectedUtilisateur)) ;
									$http({
								          method  : 'PUT',
								          url     : 'utilisateur',
								          data    : "code="+$scope.selectedUtilisateur.code_utilisateur+"&type="+$scope.selectedUtilisateur.type+"&mail="+$scope.selectedUtilisateur.mail+"&nom="+$scope.selectedUtilisateur.nom+"&prenom="+$scope.selectedUtilisateur.prenom+"&tel="+$scope.selectedUtilisateur.tel+"&mdp="+$scope.selectedUtilisateur.mdp+"&codeCgi="+$scope.selectedUtilisateur.cgi.codeCgi+"&codeUsine="+$scope.selectedUtilisateur.usine.code_usine  ,
								          headers : {'Content-Type': 'application/x-www-form-urlencoded'} 
								         }).then(
								                 function(data){
								                	 
								                	 window.location.reload()
								                		});
								};			
								
								$scope.usines = [];
								
								
								$http.get('/usine', {
								     
								    }).then(function(data){
								    	angular.forEach(data.data , function(value){
								    		$scope.usines.push({
								    			
								    			code_usine : value.code_usine, 
								    			nom_usine : value.nom_usine , 
								    			libelle : value.libelle 
								    			
								    		}) ;
								    		
								    	}) ; 
								      });
								
	                           $scope.cgis = [];
								
								
								$http.get('/CGI', {
								     
								    }).then(function(data){
								    	angular.forEach(data.data , function(value){
								    		$scope.cgis.push({
								    			
								    			code_CGI : value.code_CGI, 
								    			nom_CGI : value.nom_CGI , 
								    			libelle : value.libelle 
								    			
								    		}) ;
								    		
								    	}) ; 
								      });
								
								
								
								
							
						});