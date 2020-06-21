
var app = angular.module('myGestionApp');

app.controller('HomeCtrl', function($scope, $state, sessionService, $location, $rootScope, $http){
    $('#tabs')
        .tabs()
        .addClass('ui-tabs-vertical ui-helper-clearfix');

    $scope.userCourrant = {};
    
   $scope.loanding = function(){
        if(sessionService.isLoggedIn() == true){
            $location.path('home');
        }else{
            $location.path('login');
        }
    };
    $scope.loanding();

    $scope.logout = function(){
        sessionService.logout();
    };

    $scope.demandes = [{"idDemande":59,"statut":1,"dateCreation":1492507274000,"nature":1,"quantite":null,"cahierText":"hhhhhhh","cahierFich":null,"commentaires":null,"demandeur":{"type_u":"demandeur","idUtilisateur":1,"nom":"grindi","prenom":"hamza","role":"demandeur","service":null,"tel":null,"histoVieSerie":[],"nbrDemandes":null,"sender":[],"receiver":[]},"outillage":null,"gestionnaire":null},{"idDemande":58,"statut":0,"dateCreation":1492507220000,"nature":1,"quantite":null,"cahierText":"hhhhhhh","cahierFich":null,"commentaires":null,"demandeur":{"type_u":"demandeur","idUtilisateur":1,"nom":"grindi","prenom":"hamza","role":"demandeur","service":null,"tel":null,"histoVieSerie":[],"nbrDemandes":null,"sender":[],"receiver":[]},"outillage":null,"gestionnaire":null},];
    
 //   $scope.gridOptions = { data : $scope.demandes };

  /*  $scope.gridOptions = {};
    $scope.gridOptions = {
        saveFocus: false,
        saveScroll: true,
        enableGridMenu: true,
        onRegisterApi: function(gridApi){
            $scope.gridApi = gridApi;
        }
    };
    $scope.gridOptions.enableFiltering = true;
    $scope.gridOptions.data = $scope.demandes;

    console.log("DEFFFFFFFFFFF");
    console.log($scope.gridOptions);*/



    $scope.gridOptions = {
        columnDefs: [{
            name: 'date',
            width: '16%'
        }, {
            name: 'nature',
            width: '10%'
        }, {
            name: 'quantite',
            width: '10%'
        }, {
            name: 'texte',
            width: '20%'
        }, {
            name: 'fiche',
            width: '20%'
        }
            ,{
            name: 'commentaire',
            width: '24%',
            cellTooltip: function(row) {
                return row.entity.commentaire;
            },
            cellTemplate: '<div class="ui-grid-cell-contents wrap" white-space: normal title="TOOLTIP">{{COL_FIELD CUSTOM_FILTERS}}</div>'
        }
        ],
        data: $scope.demandes
    };
    $scope.gridOptions.enableFiltering = true;
    $scope.gridOptions.enableGridMenu = true;



   




});