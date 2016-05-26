angular.module("scd").controller("scdCtrl", function ($scope) {

    $scope.variaveis = [];

    $scope.adicionarVariavel = function (variavel) {
        $scope.variaveis.push(variavel);
        delete $scope.variavel;
    };

    $scope.editarVariavel = function (variavel) {
        $scope.editandoVariavel = true;
        $scope.variavel = variavel;
    };

    $scope.removerVariavel = function (variaveis, variavel) {
        $scope.variaveis = variaveis.filter(function (i) {
            return i != variavel;
        });
    }

    $scope.salvarVariavel = function () {
        $scope.editandoVariavel = false;
        delete $scope.variavel;
    }
    
    $scope.adicionarTermo = function (variavel, termo) {
        if (variavel.termos === undefined) {
            variavel.termos = [];
        }
        variavel.termos.push(termo);
        delete $scope.termo;
    }
    
    $scope.editarTermo = function (termo) {
        $scope.editandoTermo = true;
        $scope.termo = termo;
    }
    
    $scope.removerTermo = function (variavel, termo) {
        variavel.termos = variavel.termos.filter(function (i) {
            return i != termo;      
        });
    };
    
    $scope.salvarTermo = function () {
        $scope.editandoTermo = false;
        delete $scope.termo;
    }
});