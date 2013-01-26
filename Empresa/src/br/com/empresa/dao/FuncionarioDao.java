package br.com.empresa.dao;

import br.com.empresa.bean.Funcionario;
import br.com.empresa.util.JPAUtil;

public class FuncionarioDao extends DAO<Funcionario> {

	public FuncionarioDao() {
		super(JPAUtil.getEntityManager(), Funcionario.class);
	}
	
}
