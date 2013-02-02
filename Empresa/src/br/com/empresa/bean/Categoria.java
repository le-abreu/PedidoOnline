package br.com.empresa.bean;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;


@Entity
public class Categoria {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false)
	private int id;
	
	@Column()
	private String nome;
	
	@Column(length= 1000)
	private String descricao;

	@OneToMany(cascade= CascadeType.ALL)
	private List<Produto> produtos; 
	
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
	

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Produto> getProdutos() {
		return produtos;
	}

	public void setProdutos(List<Produto> produtos) {
		this.produtos = produtos;
	}

	public String getFoto() {
		String path = "../..";
		return path+"/imagens/categoria/"+getId()+".jpg";
	}

}
