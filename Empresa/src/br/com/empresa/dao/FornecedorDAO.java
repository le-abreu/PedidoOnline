package br.com.empresa.dao;


import java.util.List;

import javax.persistence.Query;

import br.com.empresa.bean.Fornecedor;
import br.com.empresa.util.JPAUtil;

public class FornecedorDAO  extends DAO<Fornecedor>{

	public FornecedorDAO() {
		super(JPAUtil.getEntityManager(), Fornecedor.class);
	}

	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> listaFornecedoresPorNome(String nomeFuncionario) {

		try {

			Query query = getEm()
					.createQuery(
							"select f from Fornecedor f where nomeFantasia =:nomeFantasia");
			query.setParameter("nomeFantasia", nomeFuncionario);

			return (List<Fornecedor>) query.getResultList();

		} catch (Exception e) {
			return null;
		}

	}
	
	public Fornecedor pesquisaFornecedorPorID(long codigo) {

		try {

			Query query = getEm()
					.createQuery(
							"select fornecedor from Fornecedor fornecedor where codigo =:codigo");
			query.setParameter("codigo", codigo);

			return (Fornecedor) query.getSingleResult();

		} catch (Exception e) {
			return null;
		}

	}
	
	
	@SuppressWarnings("unchecked")
	public List<Fornecedor> listaFornecedores() {

		try {

			Query query = getEm().createQuery("select f from Fornecedor f");

			return (List<Fornecedor>) query.getResultList();

		} catch (Exception e) {
			return null;
		}

	}
	
	
	
	
}
