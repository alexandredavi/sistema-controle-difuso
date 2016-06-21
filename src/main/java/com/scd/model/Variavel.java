package com.scd.model;

import java.util.ArrayList;
import java.util.List;

public class Variavel {
	
	private String descricao;
	private String objetivo;
	private double valorCrisp;
	private Universo universo = new Universo();
	private double valorDeffuzificado;
	
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
	
	public double getValorCrisp() {
		return valorCrisp;
	}

	public void setValorCrisp(double valorCrisp) {
		this.valorCrisp = valorCrisp;
	}

	public boolean isObjetivo() {
		return objetivo != null;
	}

	public Universo getUniverso() {
		return universo;
	}

	public void setUniverso(Universo universo) {
		this.universo = universo;
	}

	public double getValorDeffuzificado() {
		return valorDeffuzificado;
	}

	public void setValorDeffuzificado(double valorDeffuzificado) {
		this.valorDeffuzificado = valorDeffuzificado;
	}

}