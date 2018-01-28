angular.module('questionApp').controller('viewanswerController', ['viewanswerService', '$state',
    function (viewanswerService, $state) {
		this.submission = {}
		this.answers = []
     
        this.getAnswer = () => {
            viewanswerService.getAnswers(this.submission.title).then((succeedResponse) => {
                //we can do something here
				this.answers = succeedResponse.data
            }, (errorResponse) => {
				alert('error')
            })
        }					
			
    }
])
