var app=angular.module("myApp",['ngRoute','ngCookies'])
app.config(function($routeProvider){
	console.log('entering configuration')		
	$routeProvider
	.when('/login',{		
		controller:'UserController',
		templateUrl:'_user/login.html'
	})	
	.when('/register',{ // $scope.user, $scope.register() -- local for this page
		controller:'UserController',
		templateUrl:'_user/register.html'
	})
	.when('/displayUsers',{
		controller:'UserController',
		templateUrl:'_user/displayusers.html'
	})	
	.when('/home',{
		controller:'UserController',
		templateUrl:'_home/home.html'
	})
	.when('/postjob',{
		controller:'JobController',
		templateUrl:'_job/createJob.html'
	})	
	.when('/getAllJobs',{		
		controller:'JobController',
		templateUrl:'_job/displayjobs1.html'
	})	
	.when('/reqAddBlog',{		
		controller:'BlogController',
		templateUrl:'_blog/addBlog.html'
	})	
	.when('/reqDisplayBlogs',{		
		controller:'BlogController',
		templateUrl:'_blog/displayBlogs.html'
	})	
	.when('/uploadPicture',{	
		templateUrl:'_user/uploadPicture.html'
	})		
	.when("/chat",
	{
		templateUrl:"_chat/chat.html",
	controller:'chatController'
	})
	.otherwise({
		templateUrl:'_default/default.html'
	})
	
})



app.run(function($cookieStore,$rootScope,$location,UserService){  //entry point
	
	if($rootScope.presentUser==undefined)
		$rootScope.presentUser=$cookieStore.get('presentUser')
		
	$rootScope.logoff=function(){
		console.log('logout function')
		delete $rootScope.presentUser;
		$cookieStore.remove('presentUser')
		UserService.logout()
		.then(function(response){
			console.log("logged out successfully..");
			$rootScope.message="Logged out Successfully";
			$location.path('/login')
		},
		function(response){
			console.log(response.status);
		})
		
	}	
})









/*

.when('/logout',{		
		controller:'UserController',
		templateUrl:'_user/login.html'
	})	*/