app.factory('UserService',function($http){
	var userService=this;
	//var BASE_URL="http://localhost:1010/toygroup1"
	var BASE_URL="http://localhost:2020/group1"
	userService.authenticate=function(user){
		return $http.post(BASE_URL + "/logincheck",user);
	};
	
	userService.registerUser=function(user){
		return $http.post(BASE_URL+"/register",user);
	};
	
	userService.logout=function(){
		console.log('entering logout in userservice')		
		return $http.put(BASE_URL+"/logout");
	};
	
	userService.getUsers=function(){
		console.log('entering get users in userservice')		
		return $http.get(BASE_URL+"/getUserDetails");
	};
		
	return userService;
})