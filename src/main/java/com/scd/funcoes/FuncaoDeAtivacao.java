package com.scd.funcoes;

import java.util.ArrayList;
import java.util.List;

import com.scd.model.Condicao;
import com.scd.model.Termo;
import com.scd.model.Variavel;

public class FuncaoDeAtivacao {

	public static void calculaValorDeAtivacao(Variavel variavel, List<Variavel> variaveis) {
		
		for(Termo termo : variavel.getTermos()) {
				double menorValor = 0;
				System.out.println(termo.getDescricao());
				
				List<Double> menoresValores = new ArrayList<>();
				
				for(Condicao condicao : termo.getCondicoes()) {
					int indexOfVariavel = variaveis.indexOf(condicao.getVariavel());
					Variavel variavelCondicao = variaveis.get(indexOfVariavel);
					
					int indexOfTermo = variavelCondicao.getTermos().indexOf(condicao.getTermo());
					Termo termoCondicao = variavelCondicao.getTermos().get(indexOfTermo);
					
					System.out.println(variavelCondicao.getDescricao() + " = " + termoCondicao.getDescricao() + "(" + termoCondicao.getValorFuzzificado() + ")");
					
					double valorFuzzificado = termoCondicao.getValorFuzzificado();
					double teste = Double.min(menorValor, valorFuzzificado);
					menoresValores.add(teste);
					
					menorValor = valorFuzzificado;
				}
				
				for (Double menor : menoresValores) {
					System.out.println(menor);
				}
				
				System.out.println();
				termo.setValorAtivacao(menorValor);
		}
	}
}