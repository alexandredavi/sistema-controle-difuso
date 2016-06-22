angular.module("scd").controller("scdCtrl", function ($scope, $http) {

    $scope.variaveis = [];
    $scope.variavelObjetivo;
    $scope.resultado = [];

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

    $scope.visualizarCondicoes = function(variavelObjetivo) {
        $scope.regras = [];
        for (var i = 0; i < variavelObjetivo.termos.length; i++) {            
            var valorConsequente = variavelObjetivo.termos[i].descricao,
                condicoes        = variavelObjetivo.termos[i].condicoes,
                regra            = {},                            
                linha            = {};

                regra.linhas     = [];
                regra.descricao  = "Regra " + (i + 1);

            for(var j = 0; j < condicoes.length; j++) {
                var variavel = condicoes[j].variavel.descricao,
                    termo    = condicoes[j].termo.descricao;                

                if(j > 0 && j < condicoes.length) {
                    linha.condicao = "E ";
                } else {
                    linha.condicao = "SE ";
                }

                linha.valor = variavel + " = " + termo;

                regra.linhas.push(angular.copy(linha));
                delete linha;
            }

            linha.condicao = "ENTÃO ";
            linha.valor =  variavelObjetivo.descricao + " = " + valorConsequente;
            regra.linhas.push(angular.copy(linha));
            delete linha;

            $scope.regras.push(angular.copy(regra));
            delete regra;
        }        
    }

    $scope.visualizarCondicoesFuzzificadas = function(variaveis) {
        $scope.regras = [],
        variaveisFuzzificadas = [],
        condicoes = [],
        variaveisAtivacao = [];

        for (var i = 0; i < variaveis.length; i++) {
            var variavel = variaveis[i],
                variavelObjetivo = "",
                valorConsequente = "";

            for (var j = 0; j < variavel.termos.length; j++) {  

                var regra = {},                            
                    linha = {};

                if(variavel.objetivo !== "Sim") {
                    var variavelFuzzificado = variavel.termos[j];
                    variaveisFuzzificadas.push(variavelFuzzificado);

                } else {
                    var variavelAtivacao = variavel.termos[j];
                    variaveisAtivacao.push(variavelAtivacao);

                    valorConsequente = variavel.termos[j].descricao;
                    condicoes        = variavel.termos[j].condicoes;
                    variavelObjetivo = variavel; 
                }                 

                if(condicoes.length > 0) {

                    regra.linhas     = [];
                    regra.descricao  = "Regra " + (j + 1);    

                    for(var k = 0; k < condicoes.length; k++) {
                        var v        = condicoes[k].variavel.descricao,
                            termo    = condicoes[k].termo.descricao,                            
                            valorFuzzy = variaveisFuzzificadas.filter(function( obj ) {
                                return obj.descricao == termo;
                            });

                        if(k > 0 && k < condicoes.length) {
                            linha.condicao = "E ";
                        } else {
                            linha.condicao = "SE ";
                        }

                        linha.valor = v + " = " + termo + " (" + valorFuzzy[0].valorFuzzificado + ")";

                        regra.linhas.push(angular.copy(linha));
                        delete linha;
                    }    

                    linha.condicao = "ENTÃO ";
                    linha.valor =  variavelObjetivo.descricao + " = " + valorConsequente + " (" + variaveisAtivacao[j].valorAtivacao + ")";
                    regra.linhas.push(angular.copy(linha));
                    delete linha;

                    $scope.regras.push(angular.copy(regra));
                    delete regra;     
                }                 
            }    
        } 
    }    
    
    $scope.adicionarCondicao = function() {
        $scope.termoObjetivo.condicoes.push({});
    }

    $scope.processar = function(variaveis) {
        // $http.get("/sistema-controle-difuso/rest/algoritmoREST", variaveis).success(function(data) {
        //     $scope.resultado = json;         
        //     $scope.visualizarCondicoesFuzzificadas($scope.resultado);
        // });

        $http.get("teste.json").success(function(json) {
                $scope.resultado = json;         
                $scope.visualizarCondicoesFuzzificadas($scope.resultado);
        });
    }
});