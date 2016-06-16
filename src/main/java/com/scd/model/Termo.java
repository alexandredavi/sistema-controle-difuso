package com.scd.model;

import java.util.ArrayList;
import java.util.List;

public class Termo {
	
	private String descricao;
	private Universo universo = new Universo();
	private Suporte suporte = new Suporte();
	private Nucleo nucleo = new Nucleo();
	
	// só tem se for referente a variavel objetivo
	private List<Condicao> condicoes = new ArrayList<>();

	private double valorFuzzificado;
	private double valorAtivacao;
	
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
	public void setValorFuzzificado(double valorFuzzificado) {
		this.valorFuzzificado = valorFuzzificado;
	}
	public double getValorFuzzificado() {
		return valorFuzzificado;
	}
	public double getValorAtivação() {
		return valorAtivacao;
	}
	public void setValorAtivação(double valorAtivação) {
		this.valorAtivacao = valorAtivação;
	}
}
