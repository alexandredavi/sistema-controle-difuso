package com.sdc.funcoes;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import com.scd.funcoes.FuncaoDePertinencia;
import com.scd.model.Termo;
import com.scd.model.Variavel;

public class FuncaoDePertinenciaTest {
	
	private FuncaoDePertinencia funcaoDePertinencia;
	private Variavel idade;
	
	@Before
	public void iniciaTeste() {
		funcaoDePertinencia = new FuncaoDePertinencia();
		idade = new Variavel();
	}
	
	@Test
	public void test1() {
		
		Termo jovem = new Termo();
		jovem.setDescricao("Jovem");
		jovem.getSuporte().setInicio(0);
		jovem.getSuporte().setFim(30);
		jovem.getNucleo().setInicio(0);
		jovem.getNucleo().setFim(20);
		idade.getTermos().add(jovem);
		
		funcaoDePertinencia.fuzzifica(idade, 22);
		double valorFuzzificado = idade.getTermos().get(0).getValorFuzzificado();
		Assert.assertEquals(0.8D, valorFuzzificado, 0.001);
	}
	
	@Test
	public void test2() {
		
		Termo adulto = new Termo();
		adulto.setDescricao("Adulto");
		adulto.getSuporte().setInicio(20);
		adulto.getSuporte().setFim(60);
		adulto.getNucleo().setInicio(30);
		adulto.getNucleo().setFim(50);
		idade.getTermos().add(adulto);
		
		funcaoDePertinencia.fuzzifica(idade, 22);
		double valorFuzzificado = idade.getTermos().get(0).getValorFuzzificado();
		Assert.assertEquals(0.2D, valorFuzzificado, 0.001);
	}
	
	@Test
	public void test3() {
		
		Termo idoso = new Termo();
		idoso.setDescricao("Idoso");
		idoso.getSuporte().setInicio(50);
		idoso.getSuporte().setFim(90);
		idoso.getNucleo().setInicio(60);
		idoso.getNucleo().setFim(90);
		idade.getTermos().add(idoso);
		
		funcaoDePertinencia.fuzzifica(idade, 22);
		double valorFuzzificado = idade.getTermos().get(0).getValorFuzzificado();
		Assert.assertEquals(0.0D, valorFuzzificado, 0.001);
	}

}
