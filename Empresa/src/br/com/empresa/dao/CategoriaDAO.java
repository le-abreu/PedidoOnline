package br.com.empresa.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.empresa.bean.Categoria;
import br.com.empresa.util.JPAUtil;

public class CategoriaDAO extends DAO<Categoria>{

	public CategoriaDAO() {
		super(JPAUtil.getEntityManager(), Categoria.class);
	}
	
	public Categoria buscaPorParametro(String produto, String nome) {
		Map<String, Object> parametros = new HashMap<String, Object>();
		
		if(produto != null)
			parametros.put("produto.nome", produto);
		if(nome != null)
			parametros.put("nome", nome);

		
		return super.buscaPorParametro(parametros);
	}

	public List<Categoria> buscaListaPorParametro(String produto, String nome) {
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		if(produto != null)
			parametros.put("produto.nome", produto);
		if(nome != null)
			parametros.put("nome", nome);

		return super.buscaListaPorParametro(parametros);

	}
}
