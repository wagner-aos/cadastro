package org.domain.cadastro.test;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import org.domain.cadastro.entity.Produto;
import org.domain.cadastro.enumeration.TipoProduto;
import org.domain.cadastro.session.ProdutoHome;
import org.junit.Test;

public class ProdutoHomeTest{
	 
	@Test
	public void testCalculaTotalPorTipo(){
		
		Produto produto1 = new Produto();
		produto1.setTipo(TipoProduto.SIMCARD);
		produto1.setValorUnitario(new BigDecimal("100.00"));
		/** 10% do valor unitário se o tipo for SIMCARD */
		BigDecimal valor1 = new ProdutoHome().calcularValorTotal(produto1);
		assertEquals(valor1, new BigDecimal("110.000"));
				
		Produto produto2 = new Produto();
		produto2.setTipo(TipoProduto.CARTAO);
		produto2.setValorUnitario(new BigDecimal("100.00"));
		/** 20% do valor unitário se o tipo for CARTAO*/
		BigDecimal valor2 = new ProdutoHome().calcularValorTotal(produto2);
		assertEquals(valor2, new BigDecimal("120.000"));
	}

}
