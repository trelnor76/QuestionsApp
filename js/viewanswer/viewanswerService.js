angular.module('questionApp').service('viewanswerService', ['$http', function ($http) {

	this.getAnswers = function(title){
		return $http.get('http://localhost:8888/api/answers/' + title)
	}
	
}])