package com.sdc.funcoes;

import java.util.Arrays;

import org.junit.Test;

import com.scd.Algoritmo;
import com.scd.model.Condicao;
import com.scd.model.Termo;
import com.scd.model.Universo;
import com.scd.model.Variavel;

public class LojaOnlineTest {

	@Test
	public void test1() {
		Variavel valor = variavelValor();
		Variavel tempoEntrega = variavelTempoEntrega();
		Variavel qualidadeServico = new Variavel();
		qualidadeServico.setObjetivo("Sim");

		qualidadeServico.setDescricao("Qualidade do Serviço");
		qualidadeServico.setUniverso(new Universo(0, 100));

		Termo ruim = new Termo();
		ruim.setDescricao("Ruim");
		ruim.getSuporte().setInicio(0);
		ruim.getSuporte().setFim(50);
		ruim.getNucleo().setInicio(0);
		ruim.getNucleo().setFim(25);

		Termo medio = new Termo();
		medio.setDescricao("Médio");
		medio.getSuporte().setInicio(25);
		medio.getSuporte().setFim(75);
		medio.getNucleo().setInicio(50);
		medio.getNucleo().setFim(50);

		Termo bom = new Termo();
		bom.setDescricao("Bom");
		bom.getSuporte().setInicio(50);
		bom.getSuporte().setFim(100);
		bom.getNucleo().setInicio(75);
		bom.getNucleo().setFim(100);

		Condicao condicaoValorBarato = new Condicao();
		condicaoValorBarato.setVariavel(valor);
		condicaoValorBarato.setTermo(valor.getTermos().get(0));

		Condicao condicaoValorMedio = new Condicao();
		condicaoValorMedio.setVariavel(valor);
		condicaoValorMedio.setTermo(valor.getTermos().get(1));

		Condicao condicaoValorCaro = new Condicao();
		condicaoValorCaro.setVariavel(valor);
		condicaoValorCaro.setTermo(valor.getTermos().get(2));

		Condicao condicaoTempoEntregaRapido = new Condicao();
		condicaoTempoEntregaRapido.setVariavel(tempoEntrega);
		condicaoTempoEntregaRapido.setTermo(tempoEntrega.getTermos().get(0));

		Condicao condicaoTempoEntregaMedio = new Condicao();
		condicaoTempoEntregaMedio.setVariavel(tempoEntrega);
		condicaoTempoEntregaMedio.setTermo(tempoEntrega.getTermos().get(1));

		Condicao condicaoTempoEntregaDemorado = new Condicao();
		condicaoTempoEntregaDemorado.setVariavel(tempoEntrega);
		condicaoTempoEntregaDemorado.setTermo(tempoEntrega.getTermos().get(2));

		ruim.setCondicoes(Arrays.asList(condicaoValorMedio, condicaoTempoEntregaDemorado, condicaoValorCaro,
				condicaoTempoEntregaDemorado, condicaoValorCaro, condicaoTempoEntregaMedio));
		qualidadeServico.getTermos().add(ruim);

		medio.setCondicoes(Arrays.asList(condicaoValorBarato, condicaoTempoEntregaDemorado, condicaoValorMedio,
				condicaoTempoEntregaMedio, condicaoValorCaro, condicaoTempoEntregaRapido));
		qualidadeServico.getTermos().add(medio);
		
		bom.setCondicoes(Arrays.asList(condicaoValorBarato, condicaoTempoEntregaRapido, condicaoValorBarato,
				condicaoTempoEntregaMedio, condicaoValorMedio, condicaoTempoEntregaRapido));
		qualidadeServico.getTermos().add(bom);
		
		Algoritmo algoritmo = new Algoritmo(Arrays.asList(valor, tempoEntrega, qualidadeServico));
		algoritmo.processar();

	}

	private Variavel variavelValor() {
		Variavel valor = new Variavel();
		valor.setDescricao("Valor");
		valor.setUniverso(new Universo(0, 100));
		valor.setValorCrisp(60);

		Termo barato = new Termo();
		barato.setDescricao("Barato");
		barato.getSuporte().setInicio(0);
		barato.getSuporte().setFim(50);
		barato.getNucleo().setInicio(0);
		barato.getNucleo().setFim(25);

		Termo medio = new Termo();
		medio.setDescricao("Médio");
		medio.getSuporte().setInicio(25);
		medio.getSuporte().setFim(75);
		medio.getNucleo().setInicio(50);
		medio.getNucleo().setFim(50);

		Termo caro = new Termo();
		caro.setDescricao("Caro");
		caro.getSuporte().setInicio(50);
		caro.getSuporte().setFim(100);
		caro.getNucleo().setInicio(75);
		caro.getNucleo().setFim(100);

		valor.getTermos().add(barato);
		valor.getTermos().add(medio);
		valor.getTermos().add(caro);

		return valor;
	}

	private Variavel variavelTempoEntrega() {
		Variavel tempoEntrega = new Variavel();
		tempoEntrega.setDescricao("Tempo de Entrega");
		tempoEntrega.setUniverso(new Universo(1, 12));
		tempoEntrega.setValorCrisp(7);

		Termo rapido = new Termo();
		rapido.setDescricao("Rápido");
		rapido.getSuporte().setInicio(1);
		rapido.getSuporte().setFim(6);
		rapido.getNucleo().setInicio(1);
		rapido.getNucleo().setFim(3);

		Termo medio = new Termo();
		medio.setDescricao("Moderado");
		medio.getSuporte().setInicio(3);
		medio.getSuporte().setFim(9);
		medio.getNucleo().setInicio(6);
		medio.getNucleo().setFim(6);

		Termo demorado = new Termo();
		demorado.setDescricao("Demorado");
		demorado.getSuporte().setInicio(6);
		demorado.getSuporte().setFim(12);
		demorado.getNucleo().setInicio(9);
		demorado.getNucleo().setFim(12);

		tempoEntrega.getTermos().add(rapido);
		tempoEntrega.getTermos().add(medio);
		tempoEntrega.getTermos().add(demorado);

		return tempoEntrega;
	}
}