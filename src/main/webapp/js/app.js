var todoApp = angular.module('todoApp', [
    'ngRoute',
    'todoControllers'
]);

todoApp.config(['$routeProvider',
    function($routeProvider) {
        $routeProvider.

            // quando a url bater em /, chama home.html
            when('/', {
                templateUrl: 'partials/home.html',
                controller: 'TodoController'
            }).

            // se a url não corresponder a nada, é redirecionado para /
            otherwise({
                redirectTo: '/'
            });
    }]);