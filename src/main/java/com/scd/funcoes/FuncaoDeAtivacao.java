package com.scd.funcoes;

import java.util.List;

import com.scd.model.Condicao;
import com.scd.model.Termo;
import com.scd.model.Variavel;

public class FuncaoDeAtivacao {

	public static void calculaValorDeAtivacao(Variavel variavel, List<Variavel> variaveis) {
		for(Termo termo : variavel.getTermos()) {
			double menorValor = Double.MAX_VALUE;
			for(Condicao condicao : termo.getCondicoes()) {
				int indexOfVariavel = variaveis.indexOf(condicao.getVariavel());
				Variavel variavelCondicao = variaveis.get(indexOfVariavel);
				
				int indexOfTermo = variavelCondicao.getTermos().indexOf(condicao.getTermo());
				Termo termoCondicao = variavelCondicao.getTermos().get(indexOfTermo);
			
				double valorFuzzificado = termoCondicao.getValorFuzzificado();
				menorValor = Double.min(menorValor, valorFuzzificado);
			}
			termo.setValorAtivação(menorValor);
		}
	}
	
}
