app.factory('BlogService',function($http){
	var blogService=this;
	var BASE_URL="http://localhost:2020/group1"
	//var BASE_URL="http://172.23.170.91:1010/toygroup1"
	blogService.addBlog=function(blog){
		return $http.post(BASE_URL + "/reqAddBlog",blog);
	};
	blogService.getAllBlogs=function(){
		return $http.get(BASE_URL + "/reqGetAllBlogs");
	};	
/*	userService.registerUser=function(user){
		return $http.post(BASE_URL+"/register",user);
	};
	
	userService.logout=function(){
		console.log('entering logout in userservice')		
		return $http.put(BASE_URL+"/logout");
	};*/
	
	return blogService;
})