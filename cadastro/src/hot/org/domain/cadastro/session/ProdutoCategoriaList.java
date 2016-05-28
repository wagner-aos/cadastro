package org.domain.cadastro.session;

import org.domain.cadastro.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("produtoCategoriaList")
public class ProdutoCategoriaList extends EntityQuery<ProdutoCategoria> {

	private static final long serialVersionUID = 1L;

	private static final String EJBQL = "select produtoCategoria from ProdutoCategoria produtoCategoria";

	private static final String[] RESTRICTIONS = {};

	private ProdutoCategoria produtoCategoria;

	public ProdutoCategoriaList() {
		produtoCategoria = new ProdutoCategoria();
		produtoCategoria.setId(new ProdutoCategoriaId());
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public ProdutoCategoria getProdutoCategoria() {
		return produtoCategoria;
	}
}
