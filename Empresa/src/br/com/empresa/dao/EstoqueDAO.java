package br.com.empresa.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.empresa.bean.Estoque;
import br.com.empresa.bean.Fornecedor;
import br.com.empresa.bean.Produto;
import br.com.empresa.util.JPAUtil;

public class EstoqueDAO extends DAO<Estoque>{

	public EstoqueDAO() {
		super(JPAUtil.getEntityManager(), Estoque.class);
	}
	
	public Estoque buscaPorParametro(String produto, String fornecedor) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		if(produto != null)
			parametros.put("produto.nome", produto);
		if(fornecedor != null)
			parametros.put("fornecedor.nomeFantasia", fornecedor);

		return super.buscaPorParametro(parametros);
	}

	public List<Estoque> buscaListaPorParametro(String produto, String fornecedor) {
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		if(produto != null)
			parametros.put("produto.nome", produto);
		if(fornecedor != null)
			parametros.put("fornecedor.nomeFantasia", fornecedor);

		return super.buscaListaPorParametro(parametros);

	}

	public List<Estoque> buscaListaPorProdutoFornecedor(Produto produto, Fornecedor fornecedor) {
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		if(produto != null)
			parametros.put("produto", produto);
		
		if(fornecedor != null)
			parametros.put("fornecedor", fornecedor);
		
		return super.buscaListaPorParametro(parametros);
		
	}
}
