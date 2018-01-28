angular.module('questionApp', ['ui.router', 'xeditable']).run(function (editableOptions) {
    editableOptions.theme = 'bs3';
}).config(['$stateProvider', '$urlRouterProvider',
    function ($stateProvider, $urlRouterProvider) {

        const questionState = {
            // abstract: true,
            name: 'question',
            url: '/question',
            component: 'questionComponent'
        }
        
        const viewQuestionState = {
            // abstract: true,
            name: 'viewquestion',
            url: '/viewquestion',
            component: 'viewquestionComponent'
        }

        const viewAnswerState = {
            // abstract: true,
            name: 'viewanswer',
            url: '/viewanswer',
            component: 'viewanswerComponent'
        }

        $stateProvider.state(questionState)
      	.state(viewQuestionState)
      	.state(viewAnswerState)

        $urlRouterProvider.otherwise('/viewanswer')
		
    }

])
