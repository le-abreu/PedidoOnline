package br.com.empresa.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.empresa.bean.Produto;
import br.com.empresa.util.JPAUtil;

public class ProdutoDAO extends DAO<Produto>{

	public ProdutoDAO() {
		super(JPAUtil.getEntityManager(), Produto.class);
	}
	
	public Produto buscaPorParametro(String nome) {
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		if(nome != null)
			parametros.put("nome", nome);

		return super.buscaPorParametro(parametros);
	}

	public List<Produto> buscaListaPorParametro(String nome) {
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		if(nome != null)
			parametros.put("nome", nome);

		return super.buscaListaPorParametro(parametros);

	}
}
