package br.com.empresa.bean;

import java.util.Date;
import java.util.List;

import javax.persistence.Id;


public class Funcionario {
	
	@Id
	public Long id = new Long(0);
	
	public String nome;
	
	public String rg;
	
	public String cpf;
	
	public String carteiraTrabalho;
	
	public Date dataAniversario;
	
	public Integer genero;
	
	public Endereco endereco;
	
	public Integer status;
	
	public Date dataContratacao;
	
	public String nomeDoPai;
	
	public String nomeDaMae;
	
	public String telefone;
	
	public String celular;
	
	public String Salario;
	
	public Date dataDemisao;
	
	public String horarioInicio;
	
	public String horarioFim;
	
	public String cargo;
	
	public String setor;
	
	public Funcionario gestor;
	
	public List<Funcionario> subordinado;
	
	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public String getSalario() {
		return Salario;
	}

	public void setSalario(String salario) {
		Salario = salario;
	}


	public String getCargo() {
		return cargo;
	}

	public void setCargo(String cargo) {
		this.cargo = cargo;
	}

	public String getSetor() {
		return setor;
	}

	public void setSetor(String setor) {
		this.setor = setor;
	}

	public Funcionario getGestor() {
		return gestor;
	}

	public void setGestor(Funcionario gestor) {
		this.gestor = gestor;
	}

	public List<Funcionario> getSubordinado() {
		return subordinado;
	}

	public void setSubordinado(List<Funcionario> subordinado) {
		this.subordinado = subordinado;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getCarteiraTrabalho() {
		return carteiraTrabalho;
	}

	public void setCarteiraTrabalho(String carteiraTrabalho) {
		this.carteiraTrabalho = carteiraTrabalho;
	}

	public Date getDataAniversario() {
		return dataAniversario;
	}

	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}


	public Integer getGenero() {
		return genero;
	}

	public void setGenero(Integer genero) {
		this.genero = genero;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public Endereco getEnderco() {
		return endereco;
	}

	public void setEnderco(Endereco enderco) {
		this.endereco = enderco;
	}


	public Date getDataContratacao() {
		return dataContratacao;
	}

	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}

	public String getNomeDoPai() {
		return nomeDoPai;
	}

	public void setNomeDoPai(String nomeDoPai) {
		this.nomeDoPai = nomeDoPai;
	}

	public String getNomeDaMae() {
		return nomeDaMae;
	}

	public void setNomeDaMae(String nomeDaMae) {
		this.nomeDaMae = nomeDaMae;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public String getCelular() {
		return celular;
	}

	public void setCelular(String celular) {
		this.celular = celular;
	}


	
	
	
	

}
