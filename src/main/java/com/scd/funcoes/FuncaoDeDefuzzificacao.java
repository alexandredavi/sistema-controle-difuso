package com.scd.funcoes;

import java.util.List;

import com.scd.model.Termo;
import com.scd.model.Universo;
import com.scd.model.Variavel;

public class FuncaoDeDefuzzificacao {
	
	public static void deffuzifica(Variavel variavel) {
		double dividendo = encontraDividendo(variavel);
		double divisor = encontraDivisor(variavel);
		System.out.println(dividendo);
		System.out.println(divisor);
		double valorDeffuzificado = dividendo / divisor;
		System.out.println("deffuzification " + valorDeffuzificado);
		System.out.println();
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
			System.out.println("i " + i);
			for (Termo termo : variavel.getTermos()) {
				System.out.println("nome termo " + termo.getDescricao());
				if (termo.getNucleo().getInicio() <= i && termo.getNucleo().getFim() >= i) {
					System.out.println("termo " + termo.getValorAtivacao());					
					dividendo += i * termo.getValorAtivacao();
					if(i != 0) {
						termo.setQuantidadeDeValoresDoUniverso(termo.getQuantidadeDeValoresDoUniverso() + 1);
					}
					encontrouTermo = true;
				}				
			}
			System.out.println();
			if (!encontrouTermo) {
				Termo termo = encontraTermoAdequadoParaOValor(i, variavel.getTermos());
				System.out.println("termoEncontrado =>" + termo.getDescricao());
				System.out.println(termo.getValorAtivacao());
				System.out.println();
				dividendo += i * termo.getValorAtivacao();
				if(i != 0) {
					termo.setQuantidadeDeValoresDoUniverso(termo.getQuantidadeDeValoresDoUniverso() + 1);
				}
			}
		}
		return dividendo;
	}

	private static Termo(int valor, List<Termo> termos) {
		Termo termoEncontrado = new Termo();
		int menorDistancia = Integer.MAX_VALUE;
		for (Termo termo : termos) {
			System.out.println("termo suporte " + termo.getDescricao());
			System.out.println(termo.getSuporte().getInicio() + " <= " + valor + " && " + termo.getSuporte().getFim() + " >= " + valor);
			if (termo.getSuporte().getInicio() <= valor && termo.getSuporte().getFim() >= valor) {
				int distanciaParaOTermo = 0;
				System.out.println(valor + " <= " + termo.getNucleo().getInicio());
				if (valor <= termo.getNucleo().getInicio()) {
					distanciaParaOTermo = valor - termo.getSuporte().getInicio(); 
				} else {
					distanciaParaOTermo = termo.getSuporte().getFim() - valor;
				}
				
				System.out.println("distanciaParaOTermo => " + distanciaParaOTermo);
				if (distanciaParaOTermo <= menorDistancia) {
					termoEncontrado = termo;
					menorDistancia = distanciaParaOTermo;
				}
			}
			System.out.println("menorDistancia => " + menorDistancia);
			System.out.println();
		}
			
		return termoEncontrado;
	}
}
