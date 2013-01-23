package br.com.empresa.handle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.empresa.bean.FuncionarioBean;


@ManagedBean(name="rh_list")
public class RecursoHumanosListHandle {
	
	public String pesquisa;

	public List<FuncionarioBean> getListaFuncionario() {
		return listaFuncionario;
	}

	public void setListaFuncionario(List<FuncionarioBean> listaFuncionario) {
		this.listaFuncionario = listaFuncionario;
	}

	public FuncionarioBean getFuncionarioSelecionado() {
		return funcionarioSelecionado;
	}

	public void setFuncionarioSelecionado(FuncionarioBean funcionarioSelecionado) {
		this.funcionarioSelecionado = funcionarioSelecionado;
	}

	public String status;
	
	public List<FuncionarioBean> listaFuncionario = new ArrayList<>(); 
	
	public  FuncionarioBean funcionarioSelecionado = new FuncionarioBean();
	
	
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
	
	
	public void listaFuncionarios(){
		
		
		
		
	}
	
	
	
	public void novoFuncionario(){
		
		
		
	}
	
	
	public void exportaExcel(){
		
		
		
		
	}
	
public void exportaPdf(){
		
		
		
		
	}

}
