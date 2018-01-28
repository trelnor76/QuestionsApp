angular.module('questionApp').controller('questionController', ['questionService', '$state',
    function (questionService, $state) {
        this.submission = {}
		$state.questions = []
        $state.Tags = []
 
            $state.Add = function () {
                //Add the new item to the Array.
                var q = {}
                q.Tag = $state.Tag
                $state.Tags.push(q)
 
                //Clear the TextBoxes.
                $state.Tag = ""
            };
 
            $state.Remove = function (index) {
                //Find the record using Index from Array.
                var name = $state.Tags[index].Tag
                if ($window.confirm("Do you want to delete: " + name)) {
                    //Remove the item from Array using Index.
                    $state.Tags.splice(index, 1)
                }
            }
        

        this.postQuestion = () => {
            questionService.postQuestion(this.submission).then((succeedResponse) => {
                //we can do something here
				alert('success')
            }, (errorResponse) => {
				alert('error')
            })
        }			
		
		questionService.getQuestions().then(function(data) {
			$state.questions = data
		})
		
				
    }
])