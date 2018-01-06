/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

angular.module("Helpaluno", []).value('urlBase',
		'http://localhost:8080/AnguLaJs/rest/').controller("alunoControlle",
		function($http,$scope, urlBase) {
			var $scope = this;

			$scope.alunos = [];
			$scope.aluno = undefined;

			$scope.novo = function() {
				$scope.aluno = {};
			};

			$scope.salvar = function() {
				var metodo = 'POST';
				if ($scope.aluno.id) {
					metodo = 'PUT';
				}

				$http({
					method : metodo,
					url : urlBase + 'aluno/',
					data : $scope.aluno
				}).then(function successCallback(response) {
					$scope.atualizarTabela();
				}, function errorCallback(response) {
					$scope.ocorreuErro();
				});
			};

			$scope.alterar = function(aluno) {
				$scope.aluno = aluno;

			};

			$scope.ocorreuErro = function() {
				alert("Ocorreu um erro inesperado!");
			};

			$scope.atualizarTabela = function() {
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

				$scope.atualizarTabela();
		

		});