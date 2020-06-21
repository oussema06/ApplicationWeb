
var app = angular.module('myGestionApp');

app.controller('LoginCtrl', function($scope, $state, sessionService, $rootScope, $http){

    $scope.login ='';
    $scope.password ='';
    $scope.type='admin' ; 
    
    
    
    
   $scope.conx = function (code) {
	   $scope.paramsNoCorrect = false ; 
		 $http.get('/utilisateur/'+code, {
			 cache : false, 
			 params: {}
		}).then(function (data) {
		
		    $scope.user= data.data ; 
		    $rootScope.user= $scope.user ; 
		
		 
		 if (angular.isUndefined ($scope.user) )  {
			 $scope.paramsNoCorrect = true ; 
			 
		 }
	  
	  
		 console.log(JSON.stringify($scope.user)) ;
		 
		 if ($scope.user.mdp ==  $scope.password) {
			 $scope.mdpok = true ; 
		 } else {
         $scope.paramsNoCorrect=true ; 
		 }
		 
		 if ($scope.user.type ==  $scope.type) {
			 $scope.typeok = true ; 
		 }else {
         $scope.paramsNoCorrect=true ; 
		 }
		
		 
		 if ($scope.typeok && $scope.mdpok && $scope.paramsNoCorrect == false ) {
			 if($scope.user.type == "GPB"){
		          $state.go('homeGPB',null,{reload:false})
		          }else if($scope.user.type == "admin"){
		          $state.go('homeAdmin',null,{reload:false});
		          }else if($scope.user.type == "superviseur_financier"){
		          $state.go('homeSuperviseur_financier',null,{reload:false});
		          }else if($scope.user.type == "agent_CGI"){
		          $state.go('homeResponsable_CGI',null,{reload:false});
		          }
		 }
		}); 
   }
   
   
  
  
})