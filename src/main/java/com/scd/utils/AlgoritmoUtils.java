package com.scd.utils;

import java.util.List;

import com.scd.model.Variavel;

public class AlgoritmoUtils {

	
	public Variavel getVariavelObjetivo(List<Variavel> variaveis) {
		for (Variavel variavel : variaveis) {
			if (variavel.isObjetivo()) {
				return variavel;
			}
		}
		return null;
	}
}
