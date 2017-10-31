app.controller('BlogController',function($scope,$rootScope,$location,BlogService){
	$scope.blog={blogID:'',blogTitle:'',blogContent:'',blogCreatedUser:'',blogCreationDate:'',blogStatus:''};	
	$scope.message;
	$scope.addBlog=function(){
		console.log('submit function in usercontroller');
		BlogService.addBlog($scope.blog)
		.then(function(response){			
				console.log('Blog added...');
				$scope.message="Blog Added Successfully";
				$location.path("/reqDisplayBlogs");							
			},
			function(response){
				console.log('Blog failed...');
				$scope.message="Failed to add Blog";
				$location.path("/reqDisplayBlogs");		
		})
	}
	
	
	function getAllBlogs(){
		console.log('entering get All blogs')
		BlogService.getAllBlogs()
		.then(function(response){
			console.log(response.status); //200
			$scope.blogs=response.data;  //List<Job>			
		},function(response){
			console.log('failed to get blogs' + response.status)
		})
	}
	getAllBlogs();
	/*

	$scope.registerUser=function(){
		console.log('entering register user')
        UserService.registerUser($scope.user)		
		.then(function(response){
			$scope.message="Successfully Registered";
			console.log("registration success" + response.status)
			$location.path("/login");
			
		}, function(response){
			console.log("registration failed" +  response.status)
			$scope.errmsg="Registration failed";
			$location.path("/register");
			
		})
	}
	
	$rootScope.logout=function(){
		console.log('logout function')	
		delete $rootScope.presentUser;
		UserService.logout()
		.then(function(response){
			console.log('logout successfully')
			$scope.message="Logged out - OK";
			$location.path('/default')
		},
		function(response){
			console.log(response.status)
		})
	}*/

	
})













