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


        $stateProvider.state(questionState)
      	.state(viewQuestionState)

        $urlRouterProvider.otherwise('/viewquestion')
    }

])
