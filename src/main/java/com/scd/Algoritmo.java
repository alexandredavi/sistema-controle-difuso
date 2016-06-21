package com.scd;

import java.util.List;

import com.scd.funcoes.FuncaoDeAtivacao;
import com.scd.funcoes.FuncaoDePertinencia;
import com.scd.model.Variavel;
import com.scd.utils.AlgoritmoUtils;

public class Algoritmo {
	
	private List<Variavel> variaveis;

	public List<Variavel> processar() {		
		for (Variavel variavel : variaveis) {
			if(!variavel.isObjetivo()) {
				FuncaoDePertinencia.fuzzifica(variavel, variavel.getValorCrisp());				
			}					
		}
		
		Variavel objetivo = AlgoritmoUtils.getVariavelObjetivo(variaveis);
		FuncaoDeAtivacao.calculaValorDeAtivacao(objetivo, variaveis);
		
		return variaveis;
	}
	
	public Algoritmo(List<Variavel> variaveis) {
		this.variaveis = variaveis;
	}

	public List<Variavel> getVariaveis() {
		return variaveis;
	}

	public void setVariaveis(List<Variavel> variaveis) {
		this.variaveis = variaveis;
	}
}