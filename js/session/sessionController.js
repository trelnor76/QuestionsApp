angular.module('questionApp').controller('sessionController', ['$state',
    function ($state) {

	this.doTest2 = () => {
		$state.go("viewquestion") 
	}
	
	}
])