package org.domain.cadastro.session;

import org.domain.cadastro.entity.*;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityQuery;
import java.util.Arrays;

@Name("fabricanteList")
public class FabricanteList extends EntityQuery<Fabricante> {

	private static final long serialVersionUID = 1L;

	private static final String EJBQL = "select fabricante from Fabricante fabricante";

	private static final String[] RESTRICTIONS = {
			"lower(fabricante.codigo) like lower(concat(#{fabricanteList.fabricante.codigo},'%'))",
			"lower(fabricante.descricao) like lower(concat(#{fabricanteList.fabricante.descricao},'%'))", };

	private Fabricante fabricante = new Fabricante();

	public FabricanteList() {
		setEjbql(EJBQL);
		setRestrictionExpressionStrings(Arrays.asList(RESTRICTIONS));
		setMaxResults(25);
	}

	public Fabricante getFabricante() {
		return fabricante;
	}
}
