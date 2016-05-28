package org.domain.cadastro.session;

import java.util.Arrays;

import javax.persistence.EntityManager;

import org.domain.cadastro.entity.Categoria;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;

@Name("categoriaList")
public class CategoriaList extends EntityQuery<Categoria> {
	
	@In
	private EntityManager entityManager;

	private static final long serialVersionUID = 1L;

	private static final String EJBQL = "select categoria from Categoria categoria";

	private static final String[] RESTRICTIONS = {
			"lower(categoria.codigo) like lower(concat(#{categoriaList.categoria.codigo},'%'))",
			"lower(categoria.descricao) like lower(concat(#{categoriaList.categoria.descricao},'%'))", };


	private Categoria categoria = new Categoria();

	public CategoriaList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}
	
	
	public Categoria getCategoria() {
		return categoria;
	}


	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}
	
	
}
