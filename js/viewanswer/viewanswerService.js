angular.module('questionApp').service('viewanswerService', ['$http', function ($http) {

	this.getAnswers = function(title){
		return $http.post('http://localhost:8888/api/answers/', title)
	}
	
}])