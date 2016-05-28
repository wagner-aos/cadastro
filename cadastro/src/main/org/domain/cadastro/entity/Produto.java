package org.domain.cadastro.entity;

import static javax.persistence.GenerationType.IDENTITY;

import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.persistence.UniqueConstraint;

import org.domain.cadastro.enumeration.TipoProduto;
import org.hibernate.validator.Length;
import org.hibernate.validator.NotNull;

@Entity
@Table(name = "Produto", catalog = "ventron", uniqueConstraints = @UniqueConstraint(columnNames = "codigo"))
public class Produto implements java.io.Serializable {

	private static final long serialVersionUID = -289044754069116479L;
	
	private Long id;
	private Fabricante fabricante;
	private Boolean ativo;
	private String codigo;
	private Date data;
	private String descricao;
	private String nome;
	private String tags;
	private TipoProduto tipo;
	private BigDecimal valorUnitario;
	private Set<ProdutoCategoria> produtoCategorias = new HashSet<ProdutoCategoria>(
			0);

	public Produto() {
	}

	public Produto(String codigo, Date data, String nome,
			BigDecimal valorUnitario) {
		this.codigo = codigo;
		this.data = data;
		this.nome = nome;
		this.valorUnitario = valorUnitario;
	}

	public Produto(Fabricante fabricante, Boolean ativo, String codigo,
			Date data, String descricao, String nome, String tags, TipoProduto tipo,
			BigDecimal valorUnitario, Set<ProdutoCategoria> produtoCategorias) {
		this.fabricante = fabricante;
		this.ativo = ativo;
		this.codigo = codigo;
		this.data = data;
		this.descricao = descricao;
		this.nome = nome;
		this.tags = tags;
		this.tipo = tipo;
		this.valorUnitario = valorUnitario;
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

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_fabricante")
	public Fabricante getFabricante() {
		return this.fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}

	@Column(name = "ativo")
	public Boolean getAtivo() {
		return this.ativo;
	}

	public void setAtivo(Boolean ativo) {
		this.ativo = ativo;
	}

	@Column(name = "codigo", unique = true, nullable = false, length = 30)
	@NotNull
	@Length(max = 30)
	public String getCodigo() {
		return this.codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}

	@Temporal(TemporalType.DATE)
	@Column(name = "data", nullable = false, length = 10)
	@NotNull
	public Date getData() {
		return this.data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	@Column(name = "descricao", length = 150)
	@Length(max = 150)
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "nome", nullable = false, length = 50)
	@NotNull
	@Length(max = 50)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@Column(name = "tags")
	public String getTags() {
		return this.tags;
	}

	public void setTags(String tags){
		this.tags = tags;
	}
	
	@Enumerated(EnumType.STRING)
	@Column(name = "tipo")
	public TipoProduto getTipo() {
		return this.tipo;
	}

	public void setTipo(TipoProduto tipo) {
		this.tipo = tipo;
	}

	@Column(name = "valor_unitario", nullable = false)
	@NotNull
	public BigDecimal getValorUnitario() {
		return this.valorUnitario;
	}

	public void setValorUnitario(BigDecimal valorUnitario) {
		this.valorUnitario = valorUnitario;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "produto")
	public Set<ProdutoCategoria> getProdutoCategorias() {
		return this.produtoCategorias;
	}

	public void setProdutoCategorias(Set<ProdutoCategoria> produtoCategorias) {
		this.produtoCategorias = produtoCategorias;
	}

}
