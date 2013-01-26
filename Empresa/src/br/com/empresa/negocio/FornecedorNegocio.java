package br.com.empresa.negocio;

import java.util.List;

import br.com.empresa.bean.Fornecedor;
import br.com.empresa.dao.FornecedorDAO;

public class FornecedorNegocio {
	
	private Fornecedor fornecedor;
	
	
	public void salvaFornecedor(Fornecedor fornecedor) throws Exception{
		
		this.fornecedor = fornecedor;
		
		new FornecedorDAO().update(fornecedor);
		
		
	}
	
	public void deleteFornecedor(long codigoFornecedor) throws Exception{ 
		
		FornecedorDAO dao = new FornecedorDAO();
		
		Fornecedor fornecedor = dao.find(codigoFornecedor);
	
		new FornecedorDAO().delete(fornecedor);
	
	}
	
	
	public Fornecedor pesquisaFornecedor(long codigoFornecedor){
		
		return new FornecedorDAO().find(codigoFornecedor);
		
	}
	

	public List<Fornecedor> listaFornecedorPorNome(String nome){
		
		return new FornecedorDAO().listaFornecedoresPorNome(nome);
		
	}
	
	public List<Fornecedor> listaFornecedor(){
		
		return new FornecedorDAO().listaFornecedores();
		
	}
	
	
	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	

}
