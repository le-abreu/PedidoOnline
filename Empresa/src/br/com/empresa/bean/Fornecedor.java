package br.com.empresa.bean;

import java.util.Calendar;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity(name = "Fornecedor")
public class Fornecedor {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(nullable = false, name = "codigo")
	private long codigo;
	@Column(name = "nome_fantasia")
	private String nomeFantasia;
	@Column(name = "razao_social")
	private String razaoSocial;
	@Column(name = "cnpj")
	private String cnpj;
	@Column(name = "insc_estadual")
	private String inscEstadual;
	@Column(name = "insc_municipal")
	private String inscMunicipal;
	@Column(name = "ramo_negocio")
	private String ramoNegocio;
	@Column(name = "natureza_juridica")
	private String naturezaJuridica;
	@Column(name = "endereco")
	private String endereco;
	@Column(name = "bairro")
	private String bairro;
	@Column(name = "codigo_municipio")
	private long codigoMunicipio;
	@Column(name = "cep")
	private int cep;
	@Column(name = "caixa_postal")
	private String caixaPostal;
	@Column(name = "telefone_a")
	private long telefoneA;
	@Column(name = "telefone_b")
	private long telefoneB;
	@Temporal(TemporalType.DATE)
	@Column(name = "data_cadastro")
	private Calendar dataCadastro;

	public long getCodigo() {
		return codigo;
	}

	public void setCodigo(long codigo) {
		this.codigo = codigo;
	}

	public String getNomeFantasia() {
		return nomeFantasia;
	}

	public void setNomeFantasia(String nomeFantasia) {
		this.nomeFantasia = nomeFantasia;
	}

	public String getRazaoSocial() {
		return razaoSocial;
	}

	public void setRazaoSocial(String razaoSocial) {
		this.razaoSocial = razaoSocial;
	}

	public String getCnpj() {
		return cnpj;
	}

	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}

	public String getInscEstadual() {
		return inscEstadual;
	}

	public void setInscEstadual(String inscEstadual) {
		this.inscEstadual = inscEstadual;
	}

	public String getInscMunicipal() {
		return inscMunicipal;
	}

	public void setInscMunicipal(String inscMunicipal) {
		this.inscMunicipal = inscMunicipal;
	}

	public String getRamoNegocio() {
		return ramoNegocio;
	}

	public void setRamoNegocio(String ramoNegocio) {
		this.ramoNegocio = ramoNegocio;
	}

	public String getNaturezaJuridica() {
		return naturezaJuridica;
	}

	public void setNaturezaJuridica(String naturezaJuridica) {
		this.naturezaJuridica = naturezaJuridica;
	}

	public String getEndereco() {
		return endereco;
	}

	public void setEndereco(String endereco) {
		this.endereco = endereco;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public long getCodigoMunicipio() {
		return codigoMunicipio;
	}

	public void setCodigoMunicipio(long codigoMunicipio) {
		this.codigoMunicipio = codigoMunicipio;
	}

	public int getCep() {
		return cep;
	}

	public void setCep(int cep) {
		this.cep = cep;
	}

	public String getCaixaPostal() {
		return caixaPostal;
	}

	public void setCaixaPostal(String caixaPostal) {
		this.caixaPostal = caixaPostal;
	}

	public long getTelefoneA() {
		return telefoneA;
	}

	public void setTelefoneA(long telefoneA) {
		this.telefoneA = telefoneA;
	}

	public long getTelefoneB() {
		return telefoneB;
	}

	public void setTelefoneB(long telefoneB) {
		this.telefoneB = telefoneB;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public long getFax() {
		return fax;
	}

	public void setFax(long fax) {
		this.fax = fax;
	}

	public Calendar getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Calendar dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	private String email;
	private long fax;

}
