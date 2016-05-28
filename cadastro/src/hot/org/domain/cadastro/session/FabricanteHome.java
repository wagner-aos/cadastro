package org.domain.cadastro.session;

import org.domain.cadastro.entity.*;
import java.util.ArrayList;
import java.util.List;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("fabricanteHome")
public class FabricanteHome extends EntityHome<Fabricante> {

	private static final long serialVersionUID = 1L;

	public void setFabricanteId(Long id) {
		setId(id);
	}

	public Long getFabricanteId() {
		return (Long) getId();
	}

	@Override
	protected Fabricante createInstance() {
		Fabricante fabricante = new Fabricante();
		return fabricante;
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

	public Fabricante getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	public List<Produto> getProdutos() {
		return getInstance() == null ? null : new ArrayList<Produto>(
				getInstance().getProdutos());
	}

}
