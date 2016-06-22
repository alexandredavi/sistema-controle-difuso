package com.scd.model;

import java.util.ArrayList;
import java.util.List;

public class Termo {
	
	private String descricao;
	private Suporte suporte = new Suporte();
	private Nucleo nucleo = new Nucleo();
	
	// só tem se for referente a variavel objetivo
	private List<Condicao> condicoes = new ArrayList<>();

	private double valorFuzzificado;
	private double valorAtivacao;
	private int quantidadeDeValoresDoUniverso;
	
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
	public double getValorAtivacao() {
		return valorAtivacao;
	}
	public void setValorAtivacao(double valorAtivação) {
		this.valorAtivacao = valorAtivação;
	}
	public int getQuantidadeDeValoresDoUniverso() {
		return quantidadeDeValoresDoUniverso;
	}
	public void setQuantidadeDeValoresDoUniverso(int quantidadeDeValoresDoUniverso) {
		this.quantidadeDeValoresDoUniverso = quantidadeDeValoresDoUniverso;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		return result;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Termo other = (Termo) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		return true;
	}
	
}
