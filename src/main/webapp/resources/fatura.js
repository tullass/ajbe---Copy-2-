	angular.module("fatura",[]).controller(
			"control",
			function($scope,$http) {
	var urlBase = 'http://localhost:8080/AnguLaJs/rest/';

	$scope.addItem = function() {
		$scope.items.push({
			descricao : '',
			preco : 1
		});
	}, $scope.atualizarCombo = function() {
		$http.get(urlBase + 'fatura/servico').success(function(items) {
			$scope.items = items;
		}).error(function errorCallback(response) {
			$scope.ocorreuErro();
		});

	};
	$scope.atualizarCombo();
	$scope.removeItem = function(index) {
		
		$scope.items.splice(index, 1);
	},

	$scope.total = function() {
		var total = 0;
		angular.forEach($scope.items, function(item) {
			total += item.qty * item.preco;
		})

		return total;
	};

} );
