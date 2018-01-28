angular.module('questionApp').controller('viewquestionController', ['viewquestionService', '$state',
    function (viewquestionService, $state) {
		this.questions = []
 
        this.getQuestion = () => {
            viewquestionService.getQuestions().then((succeedResponse) => {
                //we can do something here
				this.questions = succeedResponse.data
            }, (errorResponse) => {
				alert('error')
            })
        }					
	    
		this.getQuestion()
			
    }
])
