angular.module('questionApp').service('viewquestionService', ['$http', function ($http) {

	this.getQuestions = function(){
		return $http.get('http://localhost:8888/api/questions/')
	}
	
}])