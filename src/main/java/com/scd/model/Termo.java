package com.scd.model;

import java.util.List;

public class Termo {
	
	private String descricao;
	private Universo universo;
	private Suporte suporte;
	private Nucleo nucleo;
	
	// só tem se for referente a variavel objetivo
	private List<Condicao> condicoes;
	
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
	public Universo getUniverso() {
		return universo;
	}
	public void setUniverso(Universo universo) {
		this.universo = universo;
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
}
