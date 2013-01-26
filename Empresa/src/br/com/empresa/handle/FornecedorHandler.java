package br.com.empresa.handle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.component.UIParameter;
import javax.faces.event.ActionEvent;

import br.com.empresa.bean.Fornecedor;
import br.com.empresa.dao.FornecedorDAO;
import br.com.empresa.negocio.FornecedorNegocio;


@ManagedBean(name="fornecedorHandler")
@RequestScoped
public class FornecedorHandler {
	
	private Fornecedor fornecedor = new Fornecedor();
	private Fornecedor fornecedorSelecionado = new Fornecedor();
	
	private FornecedorNegocio negocio = new FornecedorNegocio();
	
	private static final String SUCESSO = "Funcionário cadastrado com sucesso.";
	private static final String FALHA = "Falha ao cadastrar o funcionário, tente outra vez";
	private String resultado;
	
	List<String> listaErros = new ArrayList<String>();
	private List<Fornecedor> listaFornecedores = new FornecedorDAO().listaFornecedores();;
	private String campoPesquisa;
	
	
	public void salvaFornecedor(){
		
		
		try {
			negocio.salvaFornecedor(getFornecedor());
			
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			resultado = FALHA;
		}
		
		resultado = SUCESSO;
		
	}

	public void deletaFornecedor(ActionEvent action){
		
		UIParameter val = (UIParameter) action.getComponent().findComponent("codigoFornecedor");
		
		long codigo = Long.valueOf(val.getValue().toString()); 
		
		try {
			negocio.deleteFornecedor(codigo);
			
			resultado = SUCESSO;
			
		} catch (Exception e) {
			
			resultado = FALHA;
		
		}
		
	}
	
	public void pesquisaFornecedorPorId(ActionEvent event){
		
		UIParameter val = (UIParameter) event.getComponent().findComponent("codigoFornecedorEditar");
		
		long codigo = Long.valueOf(val.getValue().toString()); 
		
		fornecedor = negocio.pesquisaFornecedor(codigo);
		
	}
	
	public void pesquisaEditarFornecedor(){

		fornecedor = fornecedorSelecionado;
		
		
	}
	
	
	public boolean validaFornecedor(){
		
		
		return false;
		
		
	}

	
	public void pesquisaFornecedor(){
		
		if(campoPesquisa==null || campoPesquisa.equals("")){
			
			listaFornecedores = negocio.listaFornecedor();
			
		}else{
			
			listaFornecedores = negocio.listaFornecedorPorNome(campoPesquisa);
			
		}
		
	}
	
	

	public Fornecedor getFornecedor() {
		return fornecedor;
	}



	public String getCampoPesquisa() {
		return campoPesquisa;
	}



	public void setCampoPesquisa(String campoPesquisa) {
		this.campoPesquisa = campoPesquisa;
	}



	public List<Fornecedor> getListaFornecedores() {
		return listaFornecedores;
	}



	public void setListaFornecedores(List<Fornecedor> listaFornecedores) {
		this.listaFornecedores = listaFornecedores;
	}



	public Fornecedor getFornecedorSelecionado() {
		return fornecedorSelecionado;
	}



	public void setFornecedorSelecionado(Fornecedor fornecedorSelecionado) {
		this.fornecedorSelecionado = fornecedorSelecionado;
	}



	public void setFornecedor(Fornecedor fornecedor) {
		this.fornecedor = fornecedor;
	}

	public String getResultado() {
		return resultado;
	}

	


	

}
