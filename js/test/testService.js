angular.module('questionApp').service('testService', ['$http', function ($http) {


	this.doTest3 = function(){
		alert('Hello')
	}
	
}])