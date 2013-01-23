package br.com.empresa.dao;

import java.util.HashMap;
import java.util.Map;

import br.com.empresa.bean.Produto;
import br.com.empresa.util.JPAUtil;

public class ProdutoDAO extends DAO<Produto>{

	public ProdutoDAO() {
		super(JPAUtil.getEntityManager(), Produto.class);
	}
	
	public Produto buscaPorParametro(String nome, String apelido) {
		
		Map<String, Object> parametros = new HashMap<String, Object>();
		if(nome != null)
			parametros.put("nome", nome);
		if(apelido != null)
			parametros.put("apelido", apelido);

		return super.buscaPorParametro(parametros);
	}

}
