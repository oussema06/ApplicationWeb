var app = angular.module('myApp' , ['ui.calendar' , 'ui.bootstrap' , ]); 
app.controller('myNgController',['$scope','$http','uiCalendarConfig','$uibModal','$location',function($scope,$http,uiCalendarConfig,$uibModal,$location){
	
	$scope.SelectedEvent = null ; 
	 var isFirstTime = true ;
	 $scope.events=[] ; 
	 $scope.eventSources = [$scope.events] ; 
	 $scope.NewEvent =[] ; 
	 
	 
	 function clearCalendar(){
		 if(uiCalendarConfig.calendars.myCalendar != null) {
			 uiCalendarConfig.calendars.myCalendar.fullCalendar('removeEvents')
			 uiCalendarConfig.calendars.myCalendar.fullCalendar('unselect')
		 }
	 }
	$scope.tdate = moment();
	 //Load from REST
	 function loadfromRest() {
		 clearCalendar() ; 
	 $http.get('/e', {
		 cache : false, 
		 params: {}
	}).then(function (data) {
		 $scope.events.slice(0,$scope.events.length);
		 angular.forEach(data.data , function(value){
			
			 $scope.events.push({
				 id : value.idVieSerie ,
				 title : value.title ,
				 freq : value.maintenance_prev , 
				 description : value.descp ,
				 outillage : value.outillage,
				 start : value.startAt ,
				 end : value.endAt ,
				 cm : value.nbrRepar ,
				 nc : value.nbrMaint,
				 stick : true , 
				 allDay: false
				 
			 });
			 
			 $scope.mytestDate = new Date();
			 $scope.myDate3 = new Date(value.startAt);
			 var newDate1 = new Date($scope.mytestDate.setDate($scope.mytestDate.getDate() + 10));
			 
			
			 
			 
		 });
	});
	 }
	 loadfromRest();
	 //config calendar
	 $scope.uiConfig = {
			 calendar : {
				 height : 450 , 
				 editable :true , 
				 displayEventTime: false , 
				 header : {
					 left : 'month , agendaWeek  ,agendaDay',
					 center: 'title' , 
					 right:'today prev,next'
				   },
				   timeFormat : {
				   	month: '' , 
				   	agenda : 'h:m t'
				   } , 
				   selectable : true , 
				   selectHelper:true, 
				   select : function(start,end){
                         var fromDate = moment(start).format('YYYY/MM/DD LT');
                         var endDate = moment(end).format('YYYY/MM/DD LT');

                         $scope.NewEvent = {
                               EventID : 0 , 
                               outillage : {} , 
                               StartAt : fromDate , 
                               EndAt : endDate , 
                               IsFullDay : false , 
                               Title : '' , 
                               freq :'' ,
                               nc :'' , 
                               cm :'',
                               Description  :''                        
				                           }
				  $scope.ShowModal() ; 
				},

				 eventClick: function(event) {
					 $scope.SelectedEvent=event ; 
					 var fromDate = moment(event.start).format('YYYY/MM/DD LT');
                         var endDate = moment(event.end).format('YYYY/MM/DD LT');
                            //var idOutillage = event.outillage.idOutillage ; 
                                 
                         $scope.NewEvent = {
                               EventID : event.id , 
                               StartAt : fromDate , 
                               EndAt : endDate , 
                               outillage :event.outillage, 
                               IsFullDay : false , 
                               Title :event.title , 
                               freq : event.freq ,
                               nc: event.nc , 
                               cm : event.cm , 
                               Description  : event.description                         
				                           }
                         
                         
                         if($scope.NewEvent.freq == 90) {
                        	 $scope.test = true ; 
                         }
                         
                         
                         
                         
                     $scope.ShowModal() ; 
				 },
				 eventAfterAllRender : function() {
					 if ($scope.events.length > 0 && isFirstTime) {
						 uiCalendarConfig.calendars.myCalendar.fullCalendar('gotoDate', $scope.events[0].start);
						 isFirstTime = false;
					 }
				 }
				 
			 }
			 
	 };
             //This function for show modal dialog 
	 $scope.ShowModal = function() {
	 	$scope.option = {
                templateUrl: 'modalContent.html' , 
                controller: 'modalController' , 
                backdrop: 'static' , 
                resolve:{
                	NewEvent : function() {
                		return $scope.NewEvent ; 
                	}
                }

	 	};
	 	var modal = $uibModal.open($scope.option ) ; 
	 	modal.result.then(function(data){
            $scope.NewEvent = data.event ; 
            switch (data.operation) {
                  case 'Save' : 
                      //Save Here 
                	  var url = window.location.href ; 
                	  var arr = url.split("/");
                	  var result = arr[0] + "//" + arr[2] ; 
                	   
                	  $scope.padNumber = function (number) {
                          var string  = '' + number;
                          string      = string.length < 2 ? '0' + string : string;
                          return string;
                      }
                      
                	  
                	  
                     var date      = new Date($scope.NewEvent.EndAt);
                    var  next_date = new Date(date.setDate(date.getDate() + $scope.NewEvent.freq));
                     var  formatted = next_date.getUTCFullYear() + '/' + $scope.padNumber(next_date.getUTCMonth() + 1) + '/' + $scope.padNumber(next_date.getUTCDate())
                	  ///
                      var date2   = new Date($scope.NewEvent.StartAt);
                    var  next_date2 = new Date(date2.setDate(date2.getDate() + $scope.NewEvent.freq));
                     var  formatted2= next_date2.getUTCFullYear() + '/' + $scope.padNumber(next_date2.getUTCMonth() + 1) + '/' + $scope.padNumber(next_date2.getUTCDate())
                	  ///
                     
                     

             		if($scope.NewEvent.nc==true){
             			$scope.NewEvent.nc=1 ; 
             		}else{
             			$scope.NewEvent.nc=0 ; 
             		} ; 
             		
             		if($scope.NewEvent.cm==true){
             			$scope.NewEvent.cm=1 ; 
             		}else{
             			$scope.NewEvent.cm=0 ; 
             		}
                     
                     ////
                	  $http({
              	          method  : 'PUT',
              	          url     : result+'/saveVieSerie/',
              	          data    : "title="+$scope.NewEvent.Title+"&desc="+$scope.NewEvent.Description+"&start="+formatted2+"&end="+formatted+"&ido="+$scope.NewEvent.outillage.idOutillage+"&freq="+$scope.NewEvent.freq+"&nc="+$scope.NewEvent.nc+"&cm="+$scope.NewEvent.cm ,
              	          headers : {'Content-Type': 'application/x-www-form-urlencoded'} 
              	         }).then(
              	                 function(data){
              	                	window.location.reload();	
              	                	
              	                		});
                      break ; 
                   case 'Delete' : 
                      break ; 
                    default : 
                       break ; 

            }


	 	})
	 	
	 }
	
}])

	 //create a new controller for modal  

	 app.controller('modalController',['$scope','$uibModalInstance', 'NewEvent' , function($scope,$uibModalInstance,NewEvent){

       $scope.NewEvent = NewEvent ; 
       $scope.Message ="" ; 
       $scope.ok = function () {
       	if($scope.NewEvent.Title.trim() != "")
       		{ $uibModalInstance.close({event : $scope.NewEvent, operation : 'Save'}); 
       		}
       		else {
       			$scope.Message = "Event title required !! / " ; 
       		}

       }
        $scope.delete = function () {
        	 $uibModalInstance.close({event : $scope.NewEvent, operation : 'Delete'}) ; 
       	
       }
        $scope.cancel = function () {
        	$uibModalInstance.dismiss('cancel') ;
       	
       }
        console.log(JSON.stringify( $scope.events)) ;
	 }])


