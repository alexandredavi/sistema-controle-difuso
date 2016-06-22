package com.scd.funcoes;

import java.util.ArrayList;
import java.util.List;

import com.scd.model.Condicao;
import com.scd.model.Termo;
import com.scd.model.Variavel;

public class FuncaoDeAtivacao {

	public static void calculaValorDeAtivacao(Variavel variavel, List<Variavel> variaveis) {
		
		for(Termo termo : variavel.getTermos()) {
				double menorValor = 0, menor = 0;

				List<Double> menoresValores = new ArrayList<>();
				
				for(Condicao condicao : termo.getCondicoes()) {
					int indexOfVariavel = variaveis.indexOf(condicao.getVariavel());
					Variavel variavelCondicao = variaveis.get(indexOfVariavel);
					
					int indexOfTermo = variavelCondicao.getTermos().indexOf(condicao.getTermo());
					Termo termoCondicao = variavelCondicao.getTermos().get(indexOfTermo);
					
					double valorFuzzificado = termoCondicao.getValorFuzzificado();
					menor = Double.min(menorValor, valorFuzzificado);
					menoresValores.add(menor);
					
					menorValor = valorFuzzificado;
				}
				
				double ativacao = 0;
				for (Double m : menoresValores) {
					ativacao = Double.max(ativacao, m);
				}
				termo.setValorAtivacao(ativacao);
		}
	}
}