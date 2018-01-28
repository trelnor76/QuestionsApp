angular.module('questionApp').component('viewanswerComponent', {

    templateUrl: './js/viewanswer/viewanswerTemplate.html',
    controller: 'viewanswerController'

	bindings: {
        submission: '='
    }

})
