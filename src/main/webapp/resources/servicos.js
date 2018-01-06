/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module("Servico", []).value('urlBase',
		'http://localhost:8080/AnguLaJs/rest/').controller(
		"ServicoControlle",
		function($http,$scope, urlBase) {
			var $scope = this;

			$scope.servicos = [];
			$scope.servico = undefined;

			$scope.novo = function() {
				$scope.servico = {};
			};

			$scope.salvar = function() {
				var metodo = 'POST';
				if ($scope.servico.id) {
					metodo = 'PUT';
				}

				$http({
					method : metodo,
					url : urlBase + 'servico/',
					data : $scope.servico
				}).then(function successCallback(response) {
					$scope.lista();
				}, function errorCallback(response) {
					$scope.ocorreuErro();
				});
			};

			$scope.alterar = function(servico) {
				$scope.servico = servico;
			};

			$scope.deletar = function(servico) {
				$scope.servico = servico;

				$http({
					method : 'DELETE',
					url : urlBase + 'servico/' + $scope.servico.id + '/'
				}).then(function successCallback(response) {
					$scope.lista();
					$scope.novo();
				}, function errorCallback(response) {
					$scope.ocorreuErro();
				});
			};

			$scope.concluir = function(servico) {
				$scope.servico = servico;

				$http({
					method : 'PUT',
					url : urlBase + 'servico/' + $scope.servico.id + '/'
				}).then(function successCallback(response) {
					$scope.lista();
				}, function errorCallback(response) {
					$scope.ocorreuErro();
				});
			};

			$scope.ocorreuErro = function() {
				alert("Ocorreu um erro inesperado!");
			};

			$scope.lista = function() {
				$http({
					method : 'GET',
					url : urlBase + 'servico/'
				}).then(function successCallback(response) {
					$scope.servicos = response.data;
					$scope.servico = undefined;
				}, function errorCallback(response) {
					$scope.ocorreuErro();
				});
			};

				$scope.lista();
			
		
		});