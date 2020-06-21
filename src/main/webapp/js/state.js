

var app = angular.module('myGestionApp',['ui.router', 'ui.grid' ,'ui.bootstrap','smart-table']);

app.config(function($stateProvider, $urlRouterProvider){
  
  $urlRouterProvider.otherwise('/login');
    
  $stateProvider.state('login',
  {
	  url: '/login',
	  templateUrl:'pages/login.html',
	  controller:'LoginCtrl'
  })
  $stateProvider.state('home',
  {
	  url: '/home',
	  templateUrl:'pages/home.html',
	  controller:'HomeCtrl'
  })
  
  $stateProvider.state('ajout_bord_reg',
  {
	  url: '/ajout_bord_reg',
	  templateUrl:'pages/ajout_bord_reg.html',
	  controller:'ajout_bord_reg'
  })
  
  $stateProvider.state('article',
  {
	  url: '/article',
	  templateUrl:'pages/article.html',
	  controller:'article'
  })
  
  
  $stateProvider.state('bord_liv',
  {
	  url: '/bord_liv',
	  templateUrl:'pages/bord_liv.html',
	  controller:'bord_liv'
  })
  $stateProvider.state('bord_reg',
  {
	  url: '/bord_reg',
	  templateUrl:'pages/bord_reg.html',
	  controller:'bord_reg'
  })
   $stateProvider.state('canton',
  {
	  url: '/canton',
	  templateUrl:'pages/canton.html',
	  controller:'canton'
  })
  $stateProvider.state('client',
  {
	  url: '/client',
	  templateUrl:'pages/client.html',
	  controller:'client'
  })
  $stateProvider.state('famille_article',
  {
	  url: '/famille_article',
	  templateUrl:'pages/famille article.html',
	  controller:'famille_article'
  })
  
  $stateProvider.state('prefecture',
  {
	  url: '/prefecture',
	  templateUrl:'pages/prefecture.html',
	  controller:'prefecture'
  })
   $stateProvider.state('sous_famille',
  {
	  url: '/sous_famille',
	  templateUrl:'pages/sous famille.html',
	  controller:'sous_famille'
  })
  $stateProvider.state('commande',
  {
	  url: '/commande',
	  templateUrl:'pages/commande.html',
	  controller:'CommandeCtrl'
  })
    $stateProvider.state('sous_prefecture',
  {
	  url: '/sous_prefecture',
	  templateUrl:'pages/sous_prefecture.html',
	  controller:'sous_prefecture'
  })
  
  $stateProvider.state('ticket_de_pesage',
  {
	  url: '/ticket_de_pesage',
	  templateUrl:'pages/ticketdepesage.html',
	  controller:'ticket_de_pesage'
  })
  $stateProvider.state('utilisateur',
  {
	  url: '/utilisateur',
	  templateUrl:'pages/utilisateur.html',
	  controller:'utilisateur'
  })
   $stateProvider.state('homeGPB',
  {
	  url: '/homeGPB',
	  templateUrl:'pages/homeGPB.html',
	  controller:'homeGPB'
  })
   $stateProvider.state('homeAdmin',
  {
	  url: '/homeAdmin',
	  templateUrl:'pages/homeAdmin.html',
	  controller:'homeAdmin'
  })
   $stateProvider.state('homeSuperviseur_financier',
  {
	  url: '/homeSuperviseur_financier',
	  templateUrl:'pages/homeSuperviseur_financier.html',
	  controller:'homeSuperviseur_financier'
  })
   $stateProvider.state('homeResponsable_CGI',
  {
	  url: '/homeResponsable_CGI',
	  templateUrl:'pages/homeResponsable_CGI.html',
	  controller:'homeResponsable_CGI'
  })
 
  
  
 
  ;
})
/*.run(function($state, sessionService) {
	console.log("Is Logging !!!!!!!!!!!");
	console.log(sessionService.isLoggedIn());
	if(sessionService.isLoggedIn()){
		$state.go('home',null,{reload:true});
	}else{
		$state.go('login',null,{reload:true});
	}
})*/
.factory('sessionService', function($http, $state, $rootScope, $location){
	var session = {};
	session.login = function(data){
		return $http.post("/login", "username=" +
			data.matricule + ":" + data.login + ":" + data.password + "&password=" + data.matricule, {
			headers: {'Content-Type': 'application/x-www-form-urlencoded'}
		}).then(function(data){
			//	alert("login successful");
			localStorage.setItem("session", {});
			$rootScope.error = false;
		}, function(data){
			//	alert("Error lors de la connexion, vérifiez vos paramètres !");
			$rootScope.error = true;
		});
	};
	session.logout = function(){
		return $http.get("/logout")
			.success(function(data){
				localStorage.removeItem("session");
				$location.path(data);
			})
			.error(function(reason){
				console.log(reason);
			});
	};
	session.isLoggedIn = function(){
		return localStorage.getItem("session") != null;
	};
	session.curentUser = function(){
		return $http.get("/utilisateurCourant")
			.success(function(data){
				$rootScope.curentUser = data;
				return data;
			})
			.error(function(reason){
				console.log(reason);
				localStorage.removeItem("session");
				return reason;
			});
	};
	session.curentUser();
	return session;
});