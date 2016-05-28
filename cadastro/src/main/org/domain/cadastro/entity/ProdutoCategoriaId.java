package org.domain.cadastro.entity;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class ProdutoCategoriaId implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private long produtoId;
	private long categoriaId;

	public ProdutoCategoriaId() {
	}

	public ProdutoCategoriaId(long produtoId, long categoriaId) {
		this.produtoId = produtoId;
		this.categoriaId = categoriaId;
	}

	@Column(name = "produto_id", nullable = false)
	public long getProdutoId() {
		return this.produtoId;
	}

	public void setProdutoId(long produtoId) {
		this.produtoId = produtoId;
	}

	@Column(name = "categoria_id", nullable = false)
	public long getCategoriaId() {
		return this.categoriaId;
	}

	public void setCategoriaId(long categoriaId) {
		this.categoriaId = categoriaId;
	}

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof ProdutoCategoriaId))
			return false;
		ProdutoCategoriaId castOther = (ProdutoCategoriaId) other;

		return (this.getProdutoId() == castOther.getProdutoId())
				&& (this.getCategoriaId() == castOther.getCategoriaId());
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result + (int) this.getProdutoId();
		result = 37 * result + (int) this.getCategoriaId();
		return result;
	}

}
