package org.domain.cadastro.session;

import org.domain.cadastro.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("categoriaHome")
public class CategoriaHome extends EntityHome<Categoria> {

	private static final long serialVersionUID = 1L;

	public void setCategoriaId(Long id) {
		setId(id);
	}

	public Long getCategoriaId() {
		return (Long) getId();
	}

	@Override
	protected Categoria createInstance() {
		Categoria categoria = new Categoria();
		return categoria;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
	}

	public boolean isWired() {
		return true;
	}

	public Categoria getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<ProdutoCategoria> getProdutoCategorias() {
		return getInstance() == null ? null : new ArrayList<ProdutoCategoria>(
				getInstance().getProdutoCategorias());
	}

}
