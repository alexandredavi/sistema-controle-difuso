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
		
		Universo universo = new Universo();
		universo.setInicio(0);
		universo.setFim(100);
		
		potencia.setUniverso(universo);
		
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
		
		Condicao condicaoIdadeJovem = new Condicao();
		condicaoIdadeJovem.setVariavel(idade);
		condicaoIdadeJovem.setTermo(idade.getTermos().get(0));
		
		Condicao condicaoIdadeAdulta = new Condicao();
		condicaoIdadeAdulta.setVariavel(idade);
		condicaoIdadeAdulta.setTermo(idade.getTermos().get(1));
		
		Condicao condicaoIdadeIdoso = new Condicao();
		condicaoIdadeIdoso.setVariavel(idade);
		condicaoIdadeIdoso.setTermo(idade.getTermos().get(2));
		
		Condicao condicaoFCBaixa = new Condicao();
		condicaoFCBaixa.setVariavel(frequencia);
		condicaoFCBaixa.setTermo(frequencia.getTermos().get(0));
		
		Condicao condicaoFCModerada = new Condicao();
		condicaoFCModerada.setVariavel(frequencia);
		condicaoFCModerada.setTermo(frequencia.getTermos().get(1));
		
		Condicao condicaoFCAlta = new Condicao();
		condicaoFCAlta.setVariavel(frequencia);
		condicaoFCAlta.setTermo(frequencia.getTermos().get(2));
		
		minima.setCondicoes(Arrays.asList(condicaoFCAlta));
		medio.setCondicoes(Arrays.asList(condicaoIdadeAdulta, condicaoFCModerada));
		maxima.setCondicoes(Arrays.asList(condicaoIdadeJovem, condicaoFCAlta));
		
		potencia.getTermos().add(minima);
		potencia.getTermos().add(medio);
		potencia.getTermos().add(maxima);
		
		FuncaoDePertinencia.fuzzifica(idade, 52);
		FuncaoDePertinencia.fuzzifica(frequencia, 170);
		
		FuncaoDeAtivacao.calculaValorDeAtivacao(potencia, Arrays.asList(idade, frequencia));
		
//		Assert.assertEquals(0.2, maxima.getValorAtivacao(), 0.0001);
//		Assert.assertEquals(0.75, medio.getValorAtivacao(), 0.0001);
		
		FuncaoDeDefuzzificacao.deffuzifica(potencia);
		
	}
	
	private Variavel variavelIdade() {
		Variavel idade = new Variavel();
		idade.setDescricao("Idade");
		
		Universo universo = new Universo();
		universo.setInicio(0);
		universo.setFim(90);
		
		idade.setUniverso(universo);

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
		
		Universo universo = new Universo();
		universo.setInicio(50);
		universo.setFim(200);
		
		frequencia.setUniverso(universo);

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
	
	@Test
	public void test2() {
		Variavel temperatura = variavelTemperatura();
		Variavel umidade = variavelUmidade();
		Variavel irrigacao = new Variavel();

		irrigacao.setDescricao("Irrigação");

		Universo universo = new Universo();
		universo.setInicio(0);
		universo.setFim(90);

		irrigacao.setUniverso(universo);

		Termo pequeno = new Termo();
		pequeno.setDescricao("Pequeno");
		pequeno.getSuporte().setInicio(0);
		pequeno.getSuporte().setFim(60);
		pequeno.getNucleo().setInicio(0);
		pequeno.getNucleo().setFim(30);

		Termo medio = new Termo();
		medio.setDescricao("Medio");
		medio.getSuporte().setInicio(30);
		medio.getSuporte().setFim(90);
		medio.getNucleo().setInicio(60);
		medio.getNucleo().setFim(60);

		Termo grande = new Termo();
		grande.setDescricao("Grande");
		grande.getSuporte().setInicio(60);
		grande.getSuporte().setFim(90);
		grande.getNucleo().setInicio(90);
		grande.getNucleo().setFim(90);

		Condicao condicaoTemperaturaFria = new Condicao();
		condicaoTemperaturaFria.setVariavel(temperatura);
		condicaoTemperaturaFria.setTermo(temperatura.getTermos().get(0));

		Condicao condicaoTemperaturaMedia = new Condicao();
		condicaoTemperaturaMedia.setVariavel(temperatura);
		condicaoTemperaturaMedia.setTermo(temperatura.getTermos().get(1));

		Condicao condicaoTemperaturaQuente = new Condicao();
		condicaoTemperaturaQuente.setVariavel(temperatura);
		condicaoTemperaturaQuente.setTermo(temperatura.getTermos().get(2));

		Condicao condicaoUmidadeBaixa = new Condicao();
		condicaoUmidadeBaixa.setVariavel(umidade);
		condicaoUmidadeBaixa.setTermo(umidade.getTermos().get(1));

		Condicao condicaoUmidadeMedia = new Condicao();
		condicaoUmidadeMedia.setVariavel(umidade);
		condicaoUmidadeMedia.setTermo(umidade.getTermos().get(2));
		
		Condicao condicaoUmidadeAlta = new Condicao();
		condicaoUmidadeAlta.setVariavel(umidade);
		condicaoUmidadeAlta.setTermo(umidade.getTermos().get(2));

		pequeno.setCondicoes(Arrays.asList(condicaoTemperaturaFria, condicaoUmidadeAlta));
		medio.setCondicoes(Arrays.asList(condicaoTemperaturaMedia, condicaoTemperaturaMedia));
		medio.setCondicoes(Arrays.asList(condicaoTemperaturaFria, condicaoTemperaturaMedia));
		grande.setCondicoes(Arrays.asList(condicaoTemperaturaQuente, condicaoUmidadeBaixa));

		irrigacao.getTermos().add(pequeno);
		irrigacao.getTermos().add(medio);
		irrigacao.getTermos().add(grande);

//		FuncaoDePertinencia.fuzzifica(temperatura, 16);
//		FuncaoDePertinencia.fuzzifica(umidade, 58.5);
//
//		FuncaoDeAtivacao.calculaValorDeAtivacao(irrigacao, Arrays.asList(temperatura, umidade));

		// Assert.assertEquals(0.2, maxima.getValorAtivacao(), 0.0001);
		// Assert.assertEquals(0.75, medio.getValorAtivacao(), 0.0001);

//		FuncaoDeDefuzzificacao.deffuzifica(irrigacao);

	}

	private Variavel variavelTemperatura() {
		Variavel temperatura = new Variavel();
		temperatura.setDescricao("Temperatura");

		Universo universo = new Universo();
		universo.setInicio(0);
		universo.setFim(30);

		temperatura.setUniverso(universo);

		Termo fria = new Termo();
		fria.setDescricao("Fria");
		fria.getSuporte().setInicio(0);
		fria.getSuporte().setFim(20);
		fria.getNucleo().setInicio(0);
		fria.getNucleo().setFim(10);

		Termo media = new Termo();
		media.setDescricao("media");
		media.getSuporte().setInicio(10);
		media.getSuporte().setFim(30);
		media.getNucleo().setInicio(20);
		media.getNucleo().setFim(20);

		Termo quente = new Termo();
		quente.setDescricao("Quente");
		quente.getSuporte().setInicio(20);
		quente.getSuporte().setFim(30);
		quente.getNucleo().setInicio(30);
		quente.getNucleo().setFim(30);

		temperatura.getTermos().add(fria);
		temperatura.getTermos().add(media);
		temperatura.getTermos().add(quente);

		return temperatura;
	}

	private Variavel variavelUmidade() {
		Variavel umidade = new Variavel();
		umidade.setDescricao("Umidade");

		Universo universo = new Universo();
		universo.setInicio(0);
		universo.setFim(100);

		umidade.setUniverso(universo);

		Termo baixa = new Termo();
		baixa.setDescricao("Baixa");
		baixa.getSuporte().setInicio(0);
		baixa.getSuporte().setFim(50);
		baixa.getNucleo().setInicio(0);
		baixa.getNucleo().setFim(25);

		Termo media = new Termo();
		media.setDescricao("Media");
		media.getSuporte().setInicio(25);
		media.getSuporte().setFim(75);
		media.getNucleo().setInicio(50);
		media.getNucleo().setFim(50);

		Termo alta = new Termo();
		alta.setDescricao("Alta");
		alta.getSuporte().setInicio(50);
		alta.getSuporte().setFim(75);
		alta.getNucleo().setInicio(75);
		alta.getNucleo().setFim(75);

		umidade.getTermos().add(baixa);
		umidade.getTermos().add(media);
		umidade.getTermos().add(alta);

		return umidade;
	}
}