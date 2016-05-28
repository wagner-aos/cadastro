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
@Table(name = "Fabricante", catalog = "ventron")
public class Fabricante implements java.io.Serializable {

	private static final long serialVersionUID = 8789814172231292145L;
	
	private Long id;
	private String codigo;
	private String descricao;
	private Set<Produto> produtos = new HashSet<Produto>(0);

	public Fabricante() {
	}

	public Fabricante(String codigo, String descricao) {
		this.codigo = codigo;
		this.descricao = descricao;
	}

	public Fabricante(String codigo, String descricao, Set<Produto> produtos) {
		this.codigo = codigo;
		this.descricao = descricao;
		this.produtos = produtos;
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

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "fabricante")
	public Set<Produto> getProdutos() {
		return this.produtos;
	}

	public void setProdutos(Set<Produto> produtos) {
		this.produtos = produtos;
	}

}
