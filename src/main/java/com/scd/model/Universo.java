package com.scd.model;

public class Universo {
	
	private Integer inicio;
	private Integer fim;
	
	public Universo() {}
	
	public Universo(int inicio, int fim) {
		this.inicio = inicio;
		this.fim = fim;
		
	}
	public Integer getInicio() {
		return inicio;
	}
	public void setInicio(Integer inicio) {
		this.inicio = inicio;
	}
	public Integer getFim() {
		return fim;
	}
	public void setFim(Integer fim) {
		this.fim = fim;
	}

}
