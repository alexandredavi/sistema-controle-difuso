package com.scd.model;

import java.util.ArrayList;
import java.util.List;

public class Variavel {
	
	private String descricao;
	private String objetivo;
	
	private List<Termo> termos = new ArrayList<>();

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public String getObjetivo() {
		return objetivo;
	}

	public void setObjetivo(String objetivo) {
		this.objetivo = objetivo;
	}

	public List<Termo> getTermos() {
		return termos;
	}

	public void setTermos(List<Termo> termos) {
		this.termos = termos;
	}
	
}