app.factory('JobService',function($http){
	var jobService=this;
	var BASE_URL="http://localhost:2020/group1"
	//var BASE_URL="http://172.23.170.91:1010/toygroup1"
	jobService.saveJob=function(job){
		console.log("successfully reached jobservice");
		return $http.post(BASE_URL + "/reqpostjob" , job);
	}
	
	jobService.getAllJobs=function(){
		console.log('job service');
		return $http.get(BASE_URL + "/getalljobs");		
	}
	
	return jobService;
})