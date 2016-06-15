package com.scd.funcoes;

import com.scd.model.Termo;
import com.scd.model.Variavel;

public class FuncaoDePertinencia {
	
	public static void fuzzifica(Variavel variavel, double valor) {
		for (Termo termo : variavel.getTermos()) {
			double valorFuzzificado = aplicaFincaoDePertinencia(termo, valor);
			termo.setValorFuzzificado(valorFuzzificado);
		}
	}

	private static double aplicaFincaoDePertinencia(Termo termo, double valor) {
		Integer inicioNucleo = termo.getNucleo().getInicio();
		Integer inicioSuporte = termo.getSuporte().getInicio();
		Integer fimNucleo = termo.getNucleo().getFim();
		Integer fimSuporte = termo.getSuporte().getFim();
		
		if (valor >= inicioNucleo && valor <= fimNucleo) {
			return 1D;
		} else if (valor >= inicioSuporte && valor < inicioNucleo) {
			return (valor - inicioSuporte) / (inicioNucleo - inicioSuporte);
		} else if (valor > fimNucleo && valor <= fimSuporte) {
			return (fimSuporte - valor) / (fimSuporte - fimNucleo);
		} else {
			return 0D;
		}
	}
}
