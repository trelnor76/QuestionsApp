angular.module('questionApp').service('questionService', ['$http', function ($http) {

    this.postQuestion = (submission) => {
        return $http.post('http://localhost:8888/api/questions/', submission)
    }

	this.getQuestions = () => {
		$http.get('http://localhost:8888/api/questions/').then(function(response){
		    return response.data
		}, function(response){
			alert('error');
		})	
	}

	this.getQuestions = function(){
		var questions = $http.get('http://localhost:8888/api/questions/')
		.then(function(response){
			return response.data
		},function(response){
			alert('error')
		})
		return questions;
	}
	
}])