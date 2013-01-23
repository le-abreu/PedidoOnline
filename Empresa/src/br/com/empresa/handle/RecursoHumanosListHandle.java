package br.com.empresa.handle;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.faces.bean.ManagedBean;

import br.com.empresa.bean.FuncionarioBean;


@ManagedBean(name="rh_list")
public class RecursoHumanosListHandle {
	
	public String pesquisa;

	public FuncionarioBean novoFuncionario;
	
	public FuncionarioBean getNovoFuncionario() {
		return novoFuncionario;
	}

	public void setNovoFuncionario(FuncionarioBean novoFuncionario) {
		this.novoFuncionario = novoFuncionario;
	}

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
		
		FuncionarioBean a = new FuncionarioBean();
		a.setCarteiraTrabalho("fff");
		a.setCelular("2443");
		a.setDataAniversario(new Date());
		a.setDataContratacao(new Date());
		a.setGenero("");
		a.setNome("Rodrigo");
		a.setNomeDoPai("Vicente");
		a.setNomeDaMae("Cleusa");
		listaFuncionario.add(a);
		
		
	}
	
	
	
	public void novoFuncionario(){
		
		
		
	}
	
	
	public void exportaExcel(){
		
		
		
		
	}
	
public void exportaPdf(){
		
		
		
		
	}

public void editar(){
}

}
