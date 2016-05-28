package org.domain.cadastro.entity;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.validator.NotNull;

@Entity
@Table(name = "produto_categoria", catalog = "ventron")
public class ProdutoCategoria implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private ProdutoCategoriaId id;
	private Categoria categoria;
	private Produto produto;

	public ProdutoCategoria() {
	}

	public ProdutoCategoria(ProdutoCategoriaId id, Categoria categoria,
			Produto produto) {
		this.id = id;
		this.categoria = categoria;
		this.produto = produto;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "produtoId", column = @Column(name = "produto_id", nullable = false)),
			@AttributeOverride(name = "categoriaId", column = @Column(name = "categoria_id", nullable = false)) })
	
	
	@NotNull
	public ProdutoCategoriaId getId() {
		return this.id;
	}

	public void setId(ProdutoCategoriaId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "categoria_id", nullable = false, insertable = false, updatable = false)
	@NotNull
	public Categoria getCategoria() {
		return this.categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "produto_id", nullable = false, insertable = false, updatable = false)
	@NotNull
	public Produto getProduto() {
		return this.produto;
	}

	public void setProduto(Produto produto) {
		this.produto = produto;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((categoria == null) ? 0 : categoria.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		ProdutoCategoria other = (ProdutoCategoria) obj;
		if (categoria == null) {
			if (other.categoria != null)
				return false;
		} else if (!categoria.equals(other.categoria))
			return false;
		return true;
	}
	
	
	

}
