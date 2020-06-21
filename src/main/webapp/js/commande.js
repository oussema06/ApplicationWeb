var app = angular.module('myGestionApp');

app.controller('CommandeCtrl', function($scope, $state, sessionService, $location, $rootScope, $http ){
	$scope.selectedFR = {} ; 
	$scope.delais ; 
	$scope.pu ; 
	$scope.histos ; 
	 $scope.date3= new Date(); 

	$scope.logout = function(){
        sessionService.logout();
    };
    $scope.commandes =[] ; 
    
   
    
    
    $scope.refrech = function() {
    	 $scope.commandes=[] ;
	 $http.get('/commandes', {
		 cache : false, 
		 params: {}
	}).then(function (data) {
	
		      angular.forEach(data.data , function(value){
		    	 
		    	 $scope.commandes.push({
		    		  idCommande : value.idCommande ,
		    		  codeCommande : value.codeCommande ,
		    		  statut : value.statut	 ,
		    		  dateCreation : value.dateCreation ,
		    		  fichierBonCommande : value.fichierBonCommande ,
		    		  delaiReception : value.delaiReception ,
		    		  validDt	 : value.validDt	 , 
		    		  validGest: value.validGest , 
		    		  validAchat :  value.validAchat , 
		    		  commentaires : value.commentaires , 
		    		  gestionnaire : value.gestionnaire ,
		    		  bonCommande : value.bonCommande , 
		    		  demande : value.demande,
		    		  pu : value.pu , 
		    		  delais : value.delais
				 
			     }) ;
		   
		    	  console.log("dddd00") ;
		 });
	
	}); }
    
    
    
	 $scope.selectedCommande = {} ; 
	 $scope.bonCommande = function(commande){
		 $scope.selectedCommande = commande ;
		 console.log(JSON.stringify($scope.selectedCommande)) ;
		 console.log("ddd333333") ;
		 
	 } ; 
	 
	 
	 $scope.showdemande = function (commande) {
		 
		 $scope.selectedDemande = commande.demande ; 
	 }
	 
	 $scope.selectCommande = function(commande){
		 $scope.histos=[] ; 
		 $scope.selectedCommande = commande ;
		 console.log(JSON.stringify($scope.selectedCommande)) ;
		 
		 
		 $http.get('commandes/histos/' + $scope.selectedCommande.idCommande , {
			 cache : false, 
			 params: {}
		}).then(function (data) {
			 angular.forEach(data.data , function(value){
				 $scope.histos.push({
					 idHistoCommande : value.idHistoCommande , 
					 comment : value.comment 
					 
				 })
				 
				 
				 
			 });
			
			
		});
	 }
	 
	 
	 $scope.Fournisseurs =[] ;
	 $http.get('/fournisseur', {
	      params: {
	    	  cache : false, 
				 params: {}
	      }
	    }).then(function(data){
	    	angular.forEach(data.data , function(value){
	    		$scope.Fournisseurs.push({
	    			
	    			id : value.idFournisseur, 
	    			nom : value.nom , 
	    			prenom : value.prenom , 
	    			adresse : value.adresse , 
	    			tel : value.tel  , 
	    			email : value.email
	    		}) ;
	    		
	    	}) ; 
	      });

   
    
   
    	
   
    
    
    $scope.createBonCommande = function() {
    	$scope.commentBon = $rootScope.curentUser.nom + ' ' +$rootScope.curentUser.nom +' : ADD BonCommande to #'+ $scope.selectedCommande.codeCommande + ' at ' + $scope.date3 ; 
    	
    	$http({
	          method  : 'PUT',
	          url     : 'updateCommande',
	          data    : "id="+$scope.selectedCommande.idCommande+"&id_F="+$scope.selectedFR.id+"&pu="+$scope.selectedCommande.pu+"&delais="+$scope.delais+"&qu="+ $scope.selectedCommande.demande.quantite +"&histo=" + $scope.commentBon,
	          headers : {'Content-Type': 'application/x-www-form-urlencoded'} 
	         }).then(
	                 function(data){
	                	 
	                	 $scope.refrech() ;
	                		});
    };
    
    
    
    
    
    ///// 

    $scope.selectTableRow = function (index, storeId) {
        if ($scope.dayDataCollapse === 'undefined') {
            $scope.dayDataCollapse = $scope.dayDataCollapseFn();
        } else {

            if ($scope.tableRowExpanded === false && $scope.tableRowIndexCurrExpanded === "" && $scope.storeIdExpanded === "") {
                $scope.tableRowIndexPrevExpanded = "";
                $scope.tableRowExpanded = true;
                $scope.tableRowIndexCurrExpanded = index;
                $scope.storeIdExpanded = storeId;
                $scope.dayDataCollapse[index] = false;
            } else if ($scope.tableRowExpanded === true) {
                if ($scope.tableRowIndexCurrExpanded === index && $scope.storeIdExpanded === storeId) {
                    $scope.tableRowExpanded = false;
                    $scope.tableRowIndexCurrExpanded = "";
                    $scope.storeIdExpanded = "";
                    $scope.dayDataCollapse[index] = true;
                } else {
                    $scope.tableRowIndexPrevExpanded = $scope.tableRowIndexCurrExpanded;
                    $scope.tableRowIndexCurrExpanded = index;
                    $scope.storeIdExpanded = storeId;
                    $scope.dayDataCollapse[$scope.tableRowIndexPrevExpanded] = true;
                    $scope.dayDataCollapse[$scope.tableRowIndexCurrExpanded] = false;
                }
            }
        }
    };

    ////
    
    
    $scope.changevalidDt = function(){
    	
    	
    	$http({
	          method  : 'PUT',
	          url     : '/commandes/statut',
	          data    : "id="+$scope.selectedCommande.idCommande + "&stat=2" + "&id_u=2" ,
	          headers : {'Content-Type': 'application/x-www-form-urlencoded'} 
	         }).then(
	                 function(data){
	                	
	                	 $scope.refrech() ;
	                		});
    	
    }
    
    $scope.changevalidA = function(){
    	if($scope.selectedCommande.validAchat == 1){
    		$scope.selectedCommande.validAchat = 0  ; 
    		 
    	}
    	
    	else{
    		$scope.selectedCommande.validAchat = 1 ; 
    		 
    	}
    	$http({
	          method  : 'PUT',
	          url     : '/commandes/ValidationAchat',
	          data    : "id="+$scope.selectedCommande.idCommande +"&id_u=2",
	          headers : {'Content-Type': 'application/x-www-form-urlencoded'} 
	         }).then(
	                 function(data){
	                	 $scope.refrech() ;
	                	
	                		});
    	
    	
    }
    
    $scope.changevalidG = function(){
    	if($scope.selectedCommande.validGest == 1){
    		$scope.selectedCommande.validGest = 0  ; 
    		 
    	}
    	
    	else{
    		$scope.selectedCommande.validGest = 1 ; 
    		 
    	}
    	
    	$http({
	          method  : 'PUT',
	          url     : '/commandes/ValidationGest',
	          data    : "id="+$scope.selectedCommande.idCommande ,
	          headers : {'Content-Type': 'application/x-www-form-urlencoded'} 
	         }).then(
	                 function(data){
	                	
	                	 $scope.refrech() ;
	                		});
    	
    	
    }
    
    
    $scope.setCode = function (commande){
    	
    	
    	console.log(commande.idCommande) ; 
    	console.log(commande.codeCommande) ; 
    	$scope.commentCode = $rootScope.curentUser.nom + ' ' +$rootScope.curentUser.nom +' : ADD codeComment ( '+ commande.codeCommande + ' ) at ' + $scope.date3 ; 
    	
    	$http({
	          method  : 'PUT',
	          url     : '/codeCommande',
	          data    : "id="+ commande.idCommande +"&code=" + commande.codeCommande +"&histo=" +$scope.commentCode   ,
	          headers : {'Content-Type': 'application/x-www-form-urlencoded'} 
	         }).then(
	                 function(data){
	                	
	                	 $scope.refrech() ;
	                		});
    	
    }
    
    
    $scope.refrech() ; 
    
    $scope.AddComment = function(){
		 
		 console.log(JSON.stringify($scope.selectedCommande)) ;
		
		 
$scope.comment = $rootScope.curentUser.nom + ' ' +$rootScope.curentUser.nom +' : Add '+ $scope.comment  + ' at ' + $scope.date3 ; 
		 console.log($scope.comment); 
		 
		 $http({
	          method  : 'PUT',
	          url     : '/commandes/AddComment',
	          data    : "id="+$scope.selectedCommande.idCommande+"&comment="+$scope.comment+"&id_u="+$rootScope.curentUser.idUtilisateur  ,
	          headers : {'Content-Type': 'application/x-www-form-urlencoded'} 
	         }).then(
	                 function(data){
	                	 $scope.comment="" ; 
	                	 $scope.refrech() ;
	                		});
		
	 } ; 
	 
	 
	 
	 
	 
	 
	 
	 $scope.archivier = function () {
		
		
		$http({
	          method  : 'PUT',
	          url     : '/commandes/statut',
	          data    : "id="+ $scope.selectedCommande.idCommande + "&stat=-1&id_u=2" ,
	          headers : {'Content-Type': 'application/x-www-form-urlencoded'} 
	         }).then(
	                 function(data){
	                	 
	                	 $scope.refrech() ;
	                		}); 
		 
	 }
	 

})