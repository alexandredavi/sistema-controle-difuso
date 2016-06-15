package com.scd.funcoes;

import com.scd.model.Termo;
import com.scd.model.Variavel;

public class FuncaoDePertinencia {
	
	//TODO PASSAR PARA TESTE UNITARIO
	public static void main(String[] args) {
		Variavel idade = new Variavel();
		Termo jovem = new Termo();
		
		jovem.setDescricao("Jovem");
		jovem.getSuporte().setInicio(0);
		jovem.getSuporte().setFim(30);
		jovem.getNucleo().setInicio(0);
		jovem.getNucleo().setFim(20);
		idade.getTermos().add(jovem);
		
		Termo adulto = new Termo();
		adulto.setDescricao("Adulto");
		adulto.getSuporte().setInicio(20);
		adulto.getSuporte().setFim(60);
		adulto.getNucleo().setInicio(30);
		adulto.getNucleo().setFim(50);
		idade.getTermos().add(adulto);
		
		Termo idoso = new Termo();
		idoso.setDescricao("Idoso");
		idoso.getSuporte().setInicio(50);
		idoso.getSuporte().setFim(90);
		idoso.getNucleo().setInicio(60);
		idoso.getNucleo().setFim(90);
		idade.getTermos().add(idoso);
		
		new FuncaoDePertinencia().fuzzifica(idade, 22);
		
		for (Termo t : idade.getTermos()) {
			System.out.println(t.getDescricao() + " - " + t.getValorFuzzificado());
		}
	}

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
