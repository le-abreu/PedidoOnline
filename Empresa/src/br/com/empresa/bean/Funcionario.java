package br.com.empresa.bean;

import java.sql.Blob;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
public class Funcionario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)  
	private Long id = new Long(0);
	
	private String nome;
	
	private String rg;
	
	private String cpf;
	
	private String carteiraTrabalho;
	
	
	@Temporal(TemporalType.DATE)
	private Date dataAniversario;
	
	@Temporal(TemporalType.DATE)
	private Date dataContratacao;

	@Temporal(TemporalType.DATE)
	private Date dataDemisao;
	
	private Integer genero;
	
	@OneToOne
	private Endereco endereco;
	
	private Integer status;
	
	
	private String nomeDoPai;
	
	private String nomeDaMae;
	
	private String telefone;
	
	private String celular;
	
	private String Salario;
	
	
	
	private String horarioInicio;
	
	private String horarioFim;
	
	private String cargo;
	
	private String setor;
	
	@Lob
	private Blob photos;


	public Long getId() {
		return id;
	}


	public void setId(Long id) {
		this.id = id;
	}



	public Blob getPhotos() {
		return photos;
	}


	public void setPhotos(Blob photos) {
		this.photos = photos;
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

	
	@OneToOne
	private Funcionario gestor;


	public Integer getGenero() {
		return genero;
	}

	public void setGenero(Integer genero) {
		this.genero = genero;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
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

	public String getSalario() {
		return Salario;
	}

	public void setSalario(String salario) {
		Salario = salario;
	}


	public Date getDataAniversario() {
		return dataAniversario;
	}


	public void setDataAniversario(Date dataAniversario) {
		this.dataAniversario = dataAniversario;
	}


	public Date getDataContratacao() {
		return dataContratacao;
	}


	public void setDataContratacao(Date dataContratacao) {
		this.dataContratacao = dataContratacao;
	}


	public Date getDataDemisao() {
		return dataDemisao;
	}


	public void setDataDemisao(Date dataDemisao) {
		this.dataDemisao = dataDemisao;
	}


	public String getHorarioInicio() {
		return horarioInicio;
	}

	public void setHorarioInicio(String horarioInicio) {
		this.horarioInicio = horarioInicio;
	}

	public String getHorarioFim() {
		return horarioFim;
	}

	public void setHorarioFim(String horarioFim) {
		this.horarioFim = horarioFim;
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

}
