package com.scd.model;

import java.util.List;

public class Termo {
	
	private String descricao;
	
	private Suporte suporte = new Suporte();
	private Nucleo nucleo = new Nucleo();
	
	// só tem se for referente a variavel objetivo
	private List<Condicao> condicoes;

	private double valorFuzzificado;
	
	public List<Condicao> getCondicoes() {
		return condicoes;
	}
	public void setCondicoes(List<Condicao> condicoes) {
		this.condicoes = condicoes;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Suporte getSuporte() {
		return suporte;
	}
	public void setSuporte(Suporte suporte) {
		this.suporte = suporte;
	}
	public Nucleo getNucleo() {
		return nucleo;
	}
	public void setNucleo(Nucleo nucleo) {
		this.nucleo = nucleo;
	}
	public void setValorFuzzificado(double valorFuzzificado) {
		this.valorFuzzificado = valorFuzzificado;
	}
	public double getValorFuzzificado() {
		return valorFuzzificado;
	}
}
