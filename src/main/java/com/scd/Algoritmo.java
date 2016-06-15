package com.scd;

import java.util.List;

import com.scd.funcoes.FuncaoDePertinencia;
import com.scd.model.Variavel;

public class Algoritmo {
	
	private List<Variavel> variaveis;

	public void processar() {
		for (Variavel variavel : variaveis) {
			FuncaoDePertinencia.fuzzifica(variavel, 85);
		}
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