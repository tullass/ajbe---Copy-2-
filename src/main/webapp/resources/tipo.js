/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module("tipoServico", []).value('urlBase',
		'http://localhost:8080/AnguLaJs/rest/').controller("tipoControlle",
		function($http, $scope, urlBase) {
			var $scope = this;

			$scope.tipos = [];
			$scope.tipo = undefined;

			$scope.novo = function() {
				$scope.tipo = {};
			};

			$scope.salvar = function() {
				var metodo = 'POST';
				if ($scope.tipo.id) {
					metodo = 'PUT';
				}

				$http({
					method : metodo,
					url : urlBase + 'tipo/',
					data : $scope.tipo
				}).then(function successCallback(response) {
					$scope.listaTipo();
				}, function errorCallback(response) {
					$scope.ocorreuErro();
				});
			};

			$scope.alterar = function(tipo) {
				$scope.tipo = tipo;
			};

			$scope.deletar = function(tipo) {
				$scope.tipo = tipo;

				$http({
					method : 'DELETE',
					url : urlBase + 'tipo/' + $scope.tipo.id + '/'
				}).then(function successCallback(response) {
					$scope.listaTipo();
					$scope.novo();
				}, function errorCallback(response) {
					$scope.ocorreuErro();
				});
			};

			$scope.ocorreuErro = function() {
				alert("Ocorreu um erro inesperado!");
			};

			$scope.listaTipo = function() {
				$http({
					method : 'GET',
					url : urlBase + 'tipo/'
				}).then(function successCallback(response) {
					$scope.tipos = response.data;
					$scope.tipo = undefined;
				}, function errorCallback(response) {
					$scope.ocorreuErro();
				});
			};

			$scope.listaTipo();

		});