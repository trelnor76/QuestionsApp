angular.module('questionApp').component('questionComponent', {

    templateUrl: './js/question/questionTemplate.html',
    controller: 'questionController',
    bindings: {
        submission: '='
    }

})