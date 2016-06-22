package com.sdc.funcoes;

import java.util.Arrays;

import org.junit.Assert;
import org.junit.Test;

import com.scd.funcoes.FuncaoDeAtivacao;
import com.scd.funcoes.FuncaoDeDefuzzificacao;
import com.scd.funcoes.FuncaoDePertinencia;
import com.scd.model.Condicao;
import com.scd.model.Termo;
import com.scd.model.Universo;
import com.scd.model.Variavel;

public class FuncaoAtivacaoTest {
	
	@Test
	public void test1() {
		Variavel idade = variavelIdade();
		Variavel frequencia = variavelFrequencia();
		Variavel potencia = new Variavel();

		potencia.setDescricao("Potencia");
		potencia.setUniverso(new Universo(0, 100));

		
		Termo minima = new Termo();
		minima.setDescricao("Minima");
		minima.getSuporte().setInicio(0);
		minima.getSuporte().setFim(30);
		minima.getNucleo().setInicio(0);
		minima.getNucleo().setFim(10);
		
		Termo medio = new Termo();
		medio.setDescricao("Medio");
		medio.getSuporte().setInicio(10);
		medio.getSuporte().setFim(70);
		medio.getNucleo().setInicio(30);
		medio.getNucleo().setFim(50);
		
		Termo maxima = new Termo();
		maxima.setDescricao("Maxima");
		maxima.getSuporte().setInicio(50);
		maxima.getSuporte().setFim(100);
		maxima.getNucleo().setInicio(70);
		maxima.getNucleo().setFim(100);
		
		Condicao condicaoIdadeAdulta = new Condicao();
		condicaoIdadeAdulta.setVariavel(idade);
		condicaoIdadeAdulta.setTermo(idade.getTermos().get(1));
		
		Condicao condicaoFCModerada = new Condicao();
		condicaoFCModerada.setVariavel(frequencia);
		condicaoFCModerada.setTermo(frequencia.getTermos().get(1));
		
		Condicao condicaoIdadeJovem = new Condicao();
		condicaoIdadeJovem.setVariavel(idade);
		condicaoIdadeJovem.setTermo(idade.getTermos().get(0));
		
		Condicao condicaoFCAlta = new Condicao();
		condicaoFCAlta.setVariavel(frequencia);
		condicaoFCAlta.setTermo(frequencia.getTermos().get(2));
		
		maxima.setCondicoes(Arrays.asList(condicaoIdadeAdulta, condicaoFCModerada));
		medio.setCondicoes(Arrays.asList(condicaoIdadeJovem, condicaoFCAlta));
		
		potencia.getTermos().add(minima);
		potencia.getTermos().add(medio);
		potencia.getTermos().add(maxima);
		
		FuncaoDePertinencia.fuzzifica(idade, 22);
		FuncaoDePertinencia.fuzzifica(frequencia, 135);
		
		FuncaoDeAtivacao.calculaValorDeAtivacao(potencia, Arrays.asList(idade, frequencia));
		
		Assert.assertEquals(0.2, maxima.getValorAtivacao(), 0.0001);
		Assert.assertEquals(0.75, medio.getValorAtivacao(), 0.0001);
		
		FuncaoDeDefuzzificacao.deffuzifica(potencia);
		
		System.out.println(potencia.getValorDeffuzificado());
		
	}
	
	private Variavel variavelIdade() {
		Variavel idade = new Variavel();
		idade.setDescricao("Idade");
		idade.setUniverso(new Universo(0, 90));

		Termo jovem = new Termo();
		jovem.setDescricao("Jovem");
		jovem.getSuporte().setInicio(0);
		jovem.getSuporte().setFim(30);
		jovem.getNucleo().setInicio(0);
		jovem.getNucleo().setFim(20);
		
		Termo adulto = new Termo();
		adulto.setDescricao("Adulto");
		adulto.getSuporte().setInicio(20);
		adulto.getSuporte().setFim(60);
		adulto.getNucleo().setInicio(30);
		adulto.getNucleo().setFim(50);
		
		Termo idoso = new Termo();
		idoso.setDescricao("Idoso");
		idoso.getSuporte().setInicio(50);
		idoso.getSuporte().setFim(90);
		idoso.getNucleo().setInicio(60);
		idoso.getNucleo().setFim(90);

		
		idade.getTermos().add(jovem);
		idade.getTermos().add(adulto);
		idade.getTermos().add(idoso);
		
		return idade;
	}
	
	private Variavel variavelFrequencia() {
		Variavel frequencia = new Variavel();
		frequencia.setDescricao("Frequencia");
		frequencia.setUniverso(new Universo(50, 200));

		Termo baixa = new Termo();
		baixa.setDescricao("Baixa");
		baixa.getSuporte().setInicio(50);
		baixa.getSuporte().setFim(90);
		baixa.getNucleo().setInicio(50);
		baixa.getNucleo().setFim(70);
		
		Termo moderada = new Termo();
		moderada.setDescricao("Moderada");
		moderada.getSuporte().setInicio(70);
		moderada.getSuporte().setFim(140);
		moderada.getNucleo().setInicio(90);
		moderada.getNucleo().setFim(120);
		
		Termo alta = new Termo();
		alta.setDescricao("Alta");
		alta.getSuporte().setInicio(120);
		alta.getSuporte().setFim(200);
		alta.getNucleo().setInicio(140);
		alta.getNucleo().setFim(200);

		
		frequencia.getTermos().add(baixa);
		frequencia.getTermos().add(moderada);
		frequencia.getTermos().add(alta);
		
		return frequencia;
	}

}
