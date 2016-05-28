package org.domain.cadastro.entity;


import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;

import static javax.persistence.GenerationType.IDENTITY;

import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

@Entity
@Table(name = "Categoria", catalog = "ventron")
public class Categoria implements java.io.Serializable {

	private static final long serialVersionUID = 1L;
	
	private Long id;
	private String codigo;
	private String descricao;
	private Set<ProdutoCategoria> produtoCategorias = new HashSet<ProdutoCategoria>(
			0);

	public Categoria() {
	}

	public Categoria(Long id){
		this.id = id;
	}
	
	public Categoria(String codigo) {
		this.codigo = codigo;
	}
	
	public Categoria(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Categoria(String codigo, String descricao,
			Set<ProdutoCategoria> produtoCategorias) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.produtoCategorias = produtoCategorias;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	public Long getId() {
		return this.id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "codigo", nullable = false, length = 30)
	@NotNull
	@Length(max = 30)
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Column(name = "descricao", nullable = false, length = 150)
	@NotNull
	@Length(max = 150)
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "categoria")
	public Set<ProdutoCategoria> getProdutoCategorias() {
		return this.produtoCategorias;
	}
	
	public void setProdutoCategorias(Set<ProdutoCategoria> produtoCategorias) {
		this.produtoCategorias = produtoCategorias;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
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
		Categoria other = (Categoria) obj;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

	
	
	
	
	

}
