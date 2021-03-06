package br.com.empresa.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

import br.com.empresa.dao.EstoqueDAO;


@Entity
public class Produto {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private int id;
	
	@Column()
	private String nome;
	
	@Column()
	private String codigoBarra;
	
	@ManyToOne(cascade = CascadeType.ALL)
	private Categoria categoria;
	
	@Column()
	private double preco;

	@Column(length= 1000)
	private String descricao;

	@OneToMany(mappedBy = "produto", cascade= CascadeType.ALL)
	private List<Estoque> listaEstoque;
	
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	public String getCodigoBarra() {
		return codigoBarra;
	}

	public void setCodigoBarra(String codigoBarra) {
		this.codigoBarra = codigoBarra;
	}

	public Categoria getCategoria() {
		return categoria;
	}

	public void setCategoria(Categoria categoria) {
		this.categoria = categoria;
	}

	public double getPreco() {
		return preco;
	}

	public void setPreco(double preco) {
		this.preco = preco;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Estoque> getListaEstoque() {
		return new EstoqueDAO().buscaListaPorProdutoFornecedor(this, null);
	}

	public void setListaEstoque(List<Estoque> listaEstoque) {
		this.listaEstoque = listaEstoque;
	}

	public String getFoto() {
		String path = "../..";
		return path+"/imagens/produto/"+getId()+".jpg";
	}

}
