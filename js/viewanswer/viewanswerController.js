angular.module('questionApp').controller('viewanswerController', ['viewanswerService', '$state',
    function (viewanswerService, $state) {
		this.title = []
		this.answers = []
     
        this.getAnswer = () => {
            viewanswerService.getAnswers(this.title).then((succeedResponse) => {
                //we can do something here
				this.questions = succeedResponse.data
            }, (errorResponse) => {
				alert('error')
            })
        }					
	    
		this.getAnswer()
			
    }
])
