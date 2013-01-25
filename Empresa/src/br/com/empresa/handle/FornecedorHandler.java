package br.com.empresa.handle;

import java.util.ArrayList;
import java.util.List;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

import br.com.empresa.bean.Fornecedor;
import br.com.empresa.negocio.FornecedorNegocio;


@ManagedBean(name="fornecedor")
@RequestScoped
public class FornecedorHandler {
	
	private Fornecedor fornecedor = new Fornecedor();
	private FornecedorNegocio negocio = new FornecedorNegocio();
	
	private static final String SUCESSO = "Funcionário cadastrado com sucesso.";
	private static final String FALHA = "Falha ao cadastrar o funcionário, tente outra vez";
	
	List<String> listaErros = new ArrayList<String>();
	
	
	
	public String salvaFornecedor(){
		
		
		negocio.salvaFornecedor(fornecedor);
		
		return SUCESSO;
		
	}

	
	
	public boolean validaFornecedor(){
		
		
		return false;
		
		
	}

	public Fornecedor getFornecedor() {
		return fornecedor;
	}



	

}
