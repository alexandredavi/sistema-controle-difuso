package com.scd.funcoes;

import java.util.List;

import com.scd.model.Termo;
import com.scd.model.Universo;
import com.scd.model.Variavel;

public class FuncaoDeDefuzzificacao {
	
	public static void deffuzifica(Variavel variavel) {
		double dividendo = encontraDividendo(variavel);
		double divisor = encontraDivisor(variavel);
		double valorDeffuzificado = dividendo / divisor;
		variavel.setValorDeffuzificado(valorDeffuzificado);
	}

	private static double encontraDivisor(Variavel variavel) {
		double divisor = 0;
		for (Termo termo : variavel.getTermos()) {
			divisor += termo.getQuantidadeDeValoresDoUniverso() * termo.getValorAtivacao();
		}
		return divisor;
	}

	private static double encontraDividendo(Variavel variavel) {
		double dividendo = 0;
		Universo universo = variavel.getUniverso();
		for (int i = universo.getInicio(); i <= universo.getFim(); i += 10) {
			boolean encontrouTermo = false;
			for (Termo termo : variavel.getTermos()) {
				if (termo.getNucleo().getInicio() <= i && termo.getNucleo().getFim() >= i) {
					dividendo += i * termo.getValorAtivacao();
					termo.setQuantidadeDeValoresDoUniverso(termo.getQuantidadeDeValoresDoUniverso() + 1);
					encontrouTermo = true;
				}
			}
			if (!encontrouTermo) {
				Termo termo = encontraTermoAdequadoParaOValor(i, variavel.getTermos());
				dividendo += i * termo.getValorAtivacao();
				termo.setQuantidadeDeValoresDoUniverso(termo.getQuantidadeDeValoresDoUniverso() + 1);
			}
		}
		return dividendo;
	}

	private static Termo encontraTermoAdequadoParaOValor(int valor, List<Termo> termos) {
		Termo termoEncontrado = new Termo();
		int menorDistancia = Integer.MAX_VALUE;
		for (Termo termo : termos) {
			int distanciaParaOTermo = 0;
			if (termo.getSuporte().getInicio() <= valor && termo.getSuporte().getFim() >= valor) {
				if (valor <= termo.getNucleo().getInicio()) {
					distanciaParaOTermo = valor - termo.getSuporte().getInicio(); 
				} else {
					distanciaParaOTermo = termo.getSuporte().getFim() - valor;
				}
			}
			if (distanciaParaOTermo <= menorDistancia) {
				termoEncontrado = termo;
				menorDistancia = distanciaParaOTermo;
			}
		}
			
		return termoEncontrado;
	}
}
