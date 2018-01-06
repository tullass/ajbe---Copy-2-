angular.module("factura", []);
angular.module("factura").controller(
		"facturaController",
		function($scope, $http, $interval, dateFilter) {
			$scope.servicos = [];
			$scope.aluno = undefined;
			$scope.servico = {};
			$scope.fatura = {};
			var urlBase = 'http://localhost:8080/AnguLaJs/rest/';
			
			
			$scope.servicos = [];
			$scope.subtotal = 0;
			$scope.iva = 0.17;

			var servico = {
				ref : '',
				designacao : '',
				qty : 1,
				preco : 0,
				total : 0
			};

			$scope.typeOfService = [ {

			} ];

			$scope.add = function() {
				var metodo = 'POST';
				if ($scope.fatura.id != null) {
					metodo = 'PUT';
					alert($scope.fatura.id);
				}

				$http({
					method : metodo,
					url : urlBase + 'fatura/',
					data : $scope.fatura

				}).then(function successCallback(response) {
					alert("sucesso" + response);

				}, function errorCallback(response) {
					console.log(response);
					alert("OcorreuErro" + response);

				});
			};


			$scope.atualizarCombo = function() {
				$http.get(urlBase + 'fatura/tipo').success(function(tipos) {
					$scope.tipos = tipos;
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
alert(response);				});
			};
			$scope.alterar = function(aluno) {
				$scope.fatura.aluno = aluno;
				alert(aluno.nome);
			};

			$scope.listaAluno();
			$scope.atualizarCombo();
			
			
			//Tabela Servicos
				$scope.typeOfService = [ {

				} ];

				$scope.servicos.push(servico);

				function getServicesServer() {
					$http.get(urlBase + 'fatura/servico').success(
							function(servicos) {
								servicos.forEach(function(servico) {
									var ser = {
										id : servico.id,
										abreviatura : servico.abreviatura,
										descricao : servico.descricao,
										preco : servico.preco
									}
									$scope.typeOfService.push(ser);
								});
							}).error(function errorCallback(response) {
						$scope.ocorreuErro();
					});
				}
				getServicesServer();
				$scope.newService = function() {
					$scope.servicos.push({
						id : '',
						designacao : '',
						qty : 1,
						preco : 0,
						total : 0
					});
				}

				$scope.alterData = function(index, value) {
					$scope.servicos[index].id = value.id;
					$scope.servicos[index].abreviatura = value.abreviatura;
					
					$scope.servicos[index].descricao = value.descricao;
					$scope.servicos[index].preco = value.preco;
					$scope.calculateTotal(index, value.preco);
				}

				$scope.calculateTotal = function(index, preco) {
					$scope.servicos[index].total = preco
							* $scope.servicos[index].qty;
					$scope.facturaSubTotal();
				}

				$scope.facturaSubTotal = function() {
					var innerTotal = 0;

					$scope.servicos.forEach(function(servico) {
						innerTotal += servico.total;
					});
					$scope.subtotal = innerTotal;
				}


		});