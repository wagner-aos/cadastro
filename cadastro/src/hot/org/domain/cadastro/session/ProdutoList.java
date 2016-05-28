package org.domain.cadastro.session;

import java.util.Arrays;

import org.domain.cadastro.entity.Produto;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

@Name("produtoList")
public class ProdutoList extends EntityQuery<Produto> {

	private static final long serialVersionUID = 1L;

	private static final String EJBQL = "select produto from Produto produto";

	private static final String[] RESTRICTIONS = {
			"lower(produto.codigo) like lower(concat(#{produtoList.produto.codigo},'%'))",
			"lower(produto.descricao) like lower(concat(#{produtoList.produto.descricao},'%'))",
			"lower(produto.nome) like lower(concat(#{produtoList.produto.nome},'%'))",
			"lower(produto.tags) like lower(concat(#{produtoList.produto.tags},'%'))",
			"lower(produto.tipo) like lower(concat(#{produtoList.produto.tipo},'%'))", };

	private Produto produto = new Produto();

	public ProdutoList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Produto getProduto() {
		return produto;
	}
	
	
}
