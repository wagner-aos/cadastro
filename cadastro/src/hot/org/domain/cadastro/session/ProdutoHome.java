package org.domain.cadastro.session;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.faces.model.SelectItem;

import org.domain.cadastro.entity.Categoria;
import org.domain.cadastro.entity.Fabricante;
import org.domain.cadastro.entity.Produto;
import org.domain.cadastro.entity.ProdutoCategoria;
import org.domain.cadastro.enumeration.TipoProduto;
import org.domain.cadastro.to.TagTO;
import org.jboss.seam.annotations.Factory;
import org.jboss.seam.annotations.In;
import org.jboss.seam.annotations.Name;
import org.jboss.seam.framework.EntityHome;

@Name("produtoHome")
public class ProdutoHome extends EntityHome<Produto> {

	private static final long serialVersionUID = 1L;
	@In(create = true)
	FabricanteHome fabricanteHome;
	
	@In(create = true)
	CategoriaHome categoriaHome;
	
	
	private List<SelectItem> listaDeTags;
	private List<String> tagsSelecionadas;
		
	private List<SelectItem> listaDeCategorias;
	private List<String> categoriasSelecionadas;
	

	public void setProdutoId(Long id) {
		setId(id);
	}

	public Long getProdutoId() {
		return (Long) getId();
	}

	@Override
	protected Produto createInstance() {
		Produto produto = new Produto();
		return produto;
	}

	public void load() {
		if (isIdDefined()) {
			wire();
		}
	}

	public void wire() {
		getInstance();
		Fabricante fabricante = fabricanteHome.getDefinedInstance();
		if (fabricante != null) {
			getInstance().setFabricante(fabricante);
		}
	}
	
	private static Map<String, TagTO> tagList;
	static{
		tagList = new LinkedHashMap<String, TagTO>();
		tagList.put("Telefone", new TagTO("Telefone", "Telefone"));
		tagList.put("SSD", new TagTO("SSD","SSD"));
		tagList.put("Chip", new TagTO("Chip","Chip"));
		tagList.put("Preto", new TagTO("Preto","Preto"));
		tagList.put("Plástico", new TagTO("Plástico","Plástico"));
		tagList.put("Metal", new TagTO("Metal","Metal"));
		tagList.put("Bateria durável", new TagTO("Bateria durável","Bateria durável"));
		tagList.put("Performance", new TagTO("Performance","Performance"));
	}
		
	public Map<String, TagTO> tagList(){
		return tagList;
	}
	
	public List<SelectItem> getListaDeTags() {
		fillSelectItemsTags();
		return listaDeTags;
	}

	public void setListaDeTags(List<SelectItem> listaDeTags) {
		this.listaDeTags = listaDeTags;
	}

	private void fillSelectItemsTags() {
        listaDeTags = new ArrayList<SelectItem>();
        for (TagTO t: tagList.values()) {
            listaDeTags.add(new SelectItem(t.getLabel(), t.getValue()));
        }
    }
		
	public List<String> getTagsSelecionadas() {
		return tagsSelecionadas;
	}

	public void setTagsSelecionadas(List<String> tagsSelecionadas) {
		this.tagsSelecionadas = tagsSelecionadas;
		if(tagsSelecionadas.size() > 0){
			StringBuilder stringResult = new StringBuilder();
			for(String s: tagsSelecionadas){
				stringResult.append(s);
				stringResult.append("     ");
			}
			getInstance().setTags(stringResult.toString());
	
		}
	}
	
	public List<String> tipos(){
		List<String> tipos = new ArrayList<String>();
		for(TipoProduto t: TipoProduto.values()){
			tipos.add(t.getNome().toUpperCase());
		}
		return tipos;
	}


	public boolean isWired() {
		return true;
	}

	public Produto getDefinedInstance() {
		return isIdDefined() ? getInstance() : null;
	}

	@SuppressWarnings("unused")
	private Map<String, ProdutoCategoria> getProdutoCategorias() {
		if(getInstance() != null){
			Map<String, ProdutoCategoria> categoriaList = new LinkedHashMap<String, ProdutoCategoria>();
			
			List<ProdutoCategoria> categorias = new ArrayList<ProdutoCategoria>(getInstance().getProdutoCategorias());
			for(ProdutoCategoria pc: categorias){
				categoriaList.put(pc.getCategoria().getDescricao(),pc);
			}
			return categoriaList;
		}
		return null;
	}
	
	/*Categorias*/
	@Factory("categorias")
	@SuppressWarnings("unchecked")
	public Map<String, Categoria> listarCategorias() {
		Map<String, Categoria> categoriaList = new LinkedHashMap<String, Categoria>();
		
		String query = "select categoria from Categoria categoria";
		
		List<Categoria> categorias = getEntityManager().createQuery(query).getResultList();
		for(Categoria c: categorias){
			categoriaList.put(c.getDescricao(),c);
		}
		return categoriaList;
	}
	
	private void fillSelectItemsCategoria() {
        listaDeCategorias = new ArrayList<SelectItem>();
        for (Categoria c: listarCategorias().values()) {
            listaDeCategorias.add(new SelectItem(c.getId().toString(), c.getDescricao()));
        }
    }

	public List<SelectItem> listaDeCategoriasDB() {
		fillSelectItemsCategoria();
		return listaDeCategorias;
	}

	public void setListaDeCategorias(List<SelectItem> listaDeCategorias) {
		this.listaDeCategorias = listaDeCategorias;
	}

	public List<String> getCategoriasSelecionadas() {
		return categoriasSelecionadas;
	}
	
	public void setCategoriasSelecionadas(List<String> categoriasSelecionadas) {
		this.categoriasSelecionadas = categoriasSelecionadas;
		if(categoriasSelecionadas.size() > 0){
			Set<ProdutoCategoria> produtoCategorias = new HashSet<ProdutoCategoria>();
			Produto produto = getInstance();
			for(String c: categoriasSelecionadas){
				ProdutoCategoria pc = new ProdutoCategoria();
				pc.setProduto(produto);
				Categoria categoria = (Categoria) getEntityManager()
									 .createQuery("select c from Categoria c where c.id = :id")
									 .setParameter("id", Long.valueOf(c))
									 .getSingleResult();
				pc.setCategoria(categoria);
				produtoCategorias.add(pc);
			}
			
			getInstance().getProdutoCategorias().clear();
			getInstance().getProdutoCategorias().addAll(produtoCategorias);
			
		}
	}
	
	public List<ProdutoCategoria> listaDeCategorias(){
		return (getInstance() == null ? null : new ArrayList<ProdutoCategoria>(getInstance().getProdutoCategorias()));
	}
	
	/*rendered*/
	public boolean exibePainelTags(){
	   if(null != getInstance() && null != getInstance().getTipo() && getInstance().getTipo().equals(TipoProduto.APARELHO)){
		   return false;
	   }
	   return true;
	}

	/*calcular o valor Total de um Produto acrescentando 
	 * 10% do valor unitário se o tipo for 	SIMCARD e 
	 * 20 % se for CARTAO. Criar um teste unitário testando essas situações. */
	
	public BigDecimal calcularValorTotal(Produto produto){
		
	   BigDecimal valor = produto.getValorUnitario();
	
	   if(produto.getTipo().equals(TipoProduto.SIMCARD)){
		   return valor.multiply(new BigDecimal("1.1")); //10%
	   }
	   else if(produto.getTipo().equals(TipoProduto.CARTAO)){
		   return valor.multiply(new BigDecimal("1.2")); //20%
	   }
	   return null;
	 }

}
