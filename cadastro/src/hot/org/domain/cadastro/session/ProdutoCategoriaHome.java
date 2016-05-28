package org.domain.cadastro.session;

import org.domain.cadastro.entity.*;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("produtoCategoriaHome")
public class ProdutoCategoriaHome extends EntityHome<ProdutoCategoria> {

	private static final long serialVersionUID = 1L;
	@In(create = true)
	CategoriaHome categoriaHome;
	@In(create = true)
	ProdutoHome produtoHome;

	public void setProdutoCategoriaId(ProdutoCategoriaId id) {
		setId(id);
	}

	public ProdutoCategoriaId getProdutoCategoriaId() {
		return (ProdutoCategoriaId) getId();
	}

	public ProdutoCategoriaHome() {
		setProdutoCategoriaId(new ProdutoCategoriaId());
	}

	@Override
	public boolean isIdDefined() {
		if (getProdutoCategoriaId().getProdutoId() == 0)
			return false;
		if (getProdutoCategoriaId().getCategoriaId() == 0)
			return false;
		return true;
	}

	@Override
	protected ProdutoCategoria createInstance() {
		ProdutoCategoria produtoCategoria = new ProdutoCategoria();
		produtoCategoria.setId(new ProdutoCategoriaId());
		return produtoCategoria;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Categoria categoria = categoriaHome.getDefinedInstance();
		if (categoria != null) {
			getInstance().setCategoria(categoria);
		}
		Produto produto = produtoHome.getDefinedInstance();
		if (produto != null) {
			getInstance().setProduto(produto);
		}
	}

	public boolean isWired() {
		if (getInstance().getCategoria() == null)
			return false;
		if (getInstance().getProduto() == null)
			return false;
		return true;
	}

	public ProdutoCategoria getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

}
