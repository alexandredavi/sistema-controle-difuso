angular.module("scd").controller("scdCtrl", function ($scope, $http) {

    $scope.variaveis = [];
    $scope.variavelObjetivo;

    $scope.adicionarVariavel = function (variavel) {
        defineVariavelObjetivo(variavel);
        $scope.variaveis.push(variavel);
        delete $scope.variavel;
    };

    $scope.editarVariavel = function (variavel) {
        $scope.editandoVariavel = true;
        $scope.variavel = variavel;
    };

    $scope.removerVariavel = function (variaveis, variavel) {
        if($scope.variavelObjetivo === variavel) {
            $scope.variavelObjetivo = [];
        }
        $scope.variaveis = variaveis.filter(function (i) {
            return i != variavel;
        });
    };

    $scope.salvarVariavel = function (variavel) {
        defineVariavelObjetivo(variavel);
        $scope.editandoVariavel = false;
        delete $scope.variavel;
    };
    
    $scope.adicionarTermo = function (variavel, termo) {
        if (variavel.termos === undefined) {
            variavel.termos = [];
        }
        variavel.termos.push(termo);
        delete $scope.termo;
    };
    
    $scope.editarTermo = function (termo) {
        $scope.editandoTermo = true;
        $scope.termo = termo;
    };
    
    $scope.removerTermo = function (variavel, termo) {
        variavel.termos = variavel.termos.filter(function (i) {
            return i != termo;      
        });
    };
    
    $scope.salvarTermo = function () {
        $scope.editandoTermo = false;
        delete $scope.termo;
    }
    
    var defineVariavelObjetivo = function (variavel) {
        if (variavel.objetivo === 'Sim') {
            if ($scope.variavelObjetivo != undefined && $scope.variavelObjetivo != variavel) {
                $scope.variavelObjetivo.objetivo = undefined;
            }
            $scope.variavelObjetivo = variavel;
        } else if (variavel.objetivo === undefined && $scope.variavelObjetivo === variavel) {
            $scope.variavelObjetivo = [];
        }
    };
    
    $scope.editarCondicoes = function (termoObjetivo) {
        if(termoObjetivo.condicoes === undefined) {
            termoObjetivo.condicoes = [];
            termoObjetivo.condicoes.push({});
        }
        $scope.termoObjetivo = termoObjetivo;
    }

    $scope.visualizarCondicoes = function(termoObjetivo) {
        console.log(termoObjetivo.condicoes);
    }
    
    $scope.adicionarCondicao = function() {
        $scope.termoObjetivo.condicoes.push({});
    }
    
    $scope.processar = function(variaveis) {
        $http.post("localhost:8080/rest/algoritmoREST", variaveis).success(function (data) {
            console.log("oook");
        });
    }
    
});