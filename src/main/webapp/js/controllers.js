var todoControllers = angular.module('todoControllers', ['ngGrid']);

todoControllers.controller('TodoController',
  	function ($scope, $http) {
    	$http.get('/rest/todo').success(function(data) {
			$scope.todos = data;
    	});

    	$scope.gridOptions = { data: 'todos' ,

			columnDefs: [
						{ field: 'ok', displayName: '',
          					cellTemplate: '<input class="ngSelectionHeader" type="checkbox" ng-show="multiSelect"/>	'
        				},
						{field: 'id', displayName: 'Id', width: '10%'},
                     	{field:'what', displayName:'O que tenho que fazer?', width: '50%', enableCellEdit: 'true'},
					 	{field:'toWhen', displayName:'Para Quando?', width: '20%',  cellFilter: 'date:\'dd/MM/yyyy\'',   enableCellEdit: 'true'},
					 	{field:'done', displayName:'Data de conclusao', width: '20%', cellFilter: 'date:\'dd/MM/yyyy\''},

        	]

    	};


  	}
);