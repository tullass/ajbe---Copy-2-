angular.module("factura", []);
angular.module("factura").controller(
		"facturaController",
		function($scope, $http, $interval, dateFilter) {
			$scope.servicos = [];
			$scope.aluno = undefined;
			$scope.servico = {};
			$scope.chamado = {};
			var urlBase = 'http://localhost:8080/AnguLaJs/rest/';
			
			$scope.addItem = function() {
				$scope.items.push({
					descricao : '',
					preco : 1
				});
			}, $scope.serr = function() {
				$http.get(urlBase + 'fatura/servico').success(function(items) {
					$scope.items = items;
				}).error(function errorCallback(response) {
					$scope.ocorreuErro();
				});

			};
			$scope.serr();
			$scope.removeItem = function(index) {
				for(var i=0; i<index.size;i++){
					
				}
				$scope.items.splice(index, 1);
			},

			$scope.total = function() {
				var total = 0;
				angular.forEach($scope.items, function(item) {
					total += item.qty * item.preco;
				})

				return total;
			};

		
			

			$scope.add = function() {
				var metodo = 'POST';
				if ($scope.chamado.id != null) {
					metodo = 'PUT';
					alert($scope.chamado.id);
				}

				$http({
					method : metodo,
					url : urlBase + 'fatura/',
					data : $scope.chamado

				}).then(function successCallback(response) {
					alert("sucesso" + response);

				}, function errorCallback(response) {
					console.log(response);
					alert("OcorreuErro" + response);

				});
			};

			$scope.atualizarCombo = function() {
				$http.get(urlBase + 'fatura/tipo').success(function(combos) {
					$scope.combos = combos;
				}).error(function errorCallback(response) {
					$scope.ocorreuErro();
				});

			}
			$scope.listaAluno = function() {
				$http({
					method : 'GET',
					url : urlBase + 'aluno/'
				}).then(function successCallback(response) {
					$scope.alunos = response.data;
					$scope.aluno = undefined;
				}, function errorCallback(response) {
					$scope.ocorreuErro();
				});
			};
			$scope.lista = function() {
				$http({
					method : 'GET',
					url : urlBase + 'fatura/servico'
				}).then(function successCallback(response) {
					$scope.servicos = response.data;
					$scope.servico = undefined;
				}, function errorCallback(response) {
alert(response);				});
			};
			
			$scope.alterarservico = function(servico) {
				$scope.chamado.servico = servico;
				alert(servico.descricao);
			};
			
			$scope.lista();
			$scope.listaAluno();
			$scope.atualizarCombo();
		

		});