package br.com.empresa.dao;


import br.com.empresa.bean.Fornecedor;
import br.com.empresa.util.JPAUtil;

public class FornecedorDAO  extends DAO<Fornecedor>{

	public FornecedorDAO() {
		super(JPAUtil.getEntityManager(), Fornecedor.class);
	}

}
