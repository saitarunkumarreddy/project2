app.controller('UserController',function($scope,$rootScope,$cookieStore,$location,UserService){
	$scope.user={userid:'',username:'',password:'',isonlie:'',role:'',fullname:'',emailid:'',mobileno:'',address:'',city:'',state:'',country:''};	
	$scope.message;
	$scope.submit=function(){
		console.log('submit function in usercontroller');
		UserService.authenticate($scope.user)
		.then(function(response){			
				console.log('login success');
				console.log($scope.user.role);
				$scope.user=response.data;
				$rootScope.presentUser=$scope.user;
				//console.log($rootScope.presentUser.userid);
				//$scope.message="Successfully Registered";
				$cookieStore.put('presentUser',$rootScope.presentUser)
				$location.path("/home");							
			},
			function(response){
				console.log('login failed');
				$scope.message="Invalid Username or Password";
				$location.path("/login");	
		})
	}

	$scope.registerUser=function(){
		console.log('entering register user')
        UserService.registerUser($scope.user)		
		.then(function(response){
			$scope.message="Successfully Registered";
			console.log("registration success" + response.status)
			alert('Registration success. User id : ' + response.data.userid);
			$location.path("/login");
			
		}, function(response){
			console.log("registration failed" +  response.status)
			$scope.errmsg="Registration failed";
			$location.path("/register");
			
		})
	}
		
	function getUsers(){
		console.log('getusers function in usercontroller');
		UserService.getUsers()
		.then(function(response){			
				console.log('getusers success');
				//console.log($scope.user.role);
				$scope.users=response.data;
				//$rootScope.presentUser=$scope.user;
				//console.log($rootScope.presentUser.userid);
				//$scope.message="Successfully Registered";
				//$location.path("/displayUsers");							
			},
			function(response){
				console.log('failed to get users' + response.status)
		})
	}
	//getUsers();
	
	
	$rootScope.hasRole=function(role){
		if($rootScope.presentUser.role==undefined)
			return false;
		return $rootScope.role==role;			
	}
})













