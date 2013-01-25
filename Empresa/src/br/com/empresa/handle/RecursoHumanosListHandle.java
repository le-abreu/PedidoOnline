package br.com.empresa.handle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.empresa.bean.Funcionario;

@ManagedBean(name = "rh_list")
public class RecursoHumanosListHandle {

	public Funcionario getNovoFuncionario() {
		return novoFuncionario;
	}

	public void setNovoFuncionario(Funcionario novoFuncionario) {
		this.novoFuncionario = novoFuncionario;
	}

	public String pesquisa;

	public Funcionario novoFuncionario = new Funcionario();

	public Boolean inserirFuncionario = true;

	public String status;

	public List<Funcionario> listaFuncionario = new ArrayList<>();

	public Funcionario funcionarioSelecionado = new Funcionario();

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getPesquisa() {
		return pesquisa;
	}

	public void setPesquisa(String pesquisa) {
		this.pesquisa = pesquisa;
	}

	public void listaFuncionarios() {

		Funcionario a = new Funcionario();
		a.setCarteiraTrabalho("fff");
		a.setCelular("2443");
		a.setDataAniversario(new Date());
		a.setDataContratacao(new Date());
		// a.setGenero("");
		a.setNome("Rodrigo");
		a.setNomeDoPai("Vicente");
		a.setNomeDaMae("Cleusa");
		listaFuncionario.add(a);

	}

	public void exportaExcel() {

	}

	public void exportaPdf() {

	}

	public void editar() {
	}

	public Boolean getInserirFuncionario() {
		return inserirFuncionario;
	}

	public List<Funcionario> getListaFuncionario() {
		return listaFuncionario;
	}

	public void setListaFuncionario(List<Funcionario> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}

	public Funcionario getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(Funcionario funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

	public void setInserirFuncionario(Boolean inserirFuncionario) {
		this.inserirFuncionario = inserirFuncionario;
	}

	public void inserirNovoFunc() {

		novoFuncionario.getCargo();

	}

}
