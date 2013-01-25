package br.com.empresa.negocio;

import br.com.empresa.bean.Fornecedor;
import br.com.empresa.dao.FornecedorDAO;

public class FornecedorNegocio {
	
	private Fornecedor fornecedor;
	
	
	public void salvaFornecedor(Fornecedor fornecedor){
		
		this.fornecedor = fornecedor;
		
		new FornecedorDAO().persist(fornecedor);
		
		
	}


	public Fornecedor getFornecedor() {
		return fornecedor;
	}

	

}
