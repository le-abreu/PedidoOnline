package br.com.empresa.dao;

import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.Query;

import br.com.empresa.util.JPAUtil;

public class DAO<T> {

	private EntityManager em;
	private Class<?> persistentClass;
	
	public DAO(EntityManager em, Class<?> persistenClass) {
		this.em = em;
		this.persistentClass = persistenClass;
	}

	@SuppressWarnings("unchecked")
	public List<T> lista() {
		String nome = this.persistentClass.getName();
		String sql = "SELECT c FROM  "
				+ nome.replace("br.com.empresa.bean.", "") + " c";
		Query q = getEm().createQuery(sql);
		List<T> lista = q.getResultList();
		return lista;
	}

	@SuppressWarnings("unchecked")
	public T find(long id) {
		return (T) getEm().find(persistentClass, id);
	}

	@SuppressWarnings("unchecked")
	public T find(int id) {
		return (T) getEm().find(persistentClass, id);
	}

	public void persist(T t) throws Exception {
		EntityTransaction trans = getEm().getTransaction();
		try {
			trans.begin();
			getEm().merge(t);
			trans.commit();
		} catch (Exception e) {
			if (trans.isActive())
				trans.rollback();
		
			throw new Exception();
		
		}
	}

	public void update(T t) throws Exception {
		EntityTransaction trans = getEm().getTransaction();
		try {
			trans.begin();
			getEm().merge(t);
			trans.commit();
		} catch (Exception e) {
			if (trans.isActive())
				trans.rollback();
			
			throw new Exception();
		
		}

	}

	public void delete(T t) throws Exception {
		try {
			EntityTransaction trans = getEm().getTransaction();
			trans.begin();
			getEm().remove(t);
			trans.commit();
		} catch (Exception e) {
		
			throw new Exception();
		}

	}

	
	public EntityManager getEm() {
		return em;
	}

	@SuppressWarnings("unchecked")
	public T buscaPorParametro(Map<String, Object> parameters) {
		String nome = this.persistentClass.getName();
		StringBuilder sql = new StringBuilder();
		sql.append("from ").append( nome.replace("br.com.empresa.bean.", "") + " c").append(" where ");
		for (String string: parameters.keySet()) {
			sql.append(string+ "= :"+ string);
		}
		
		Query q = JPAUtil.getEntityManager().createQuery(sql.toString());
		for (String string: parameters.keySet()) {
			q.setParameter(string, parameters.get(string));
		}

		return (T) q.getResultList().get(0);
	}

	@SuppressWarnings("unchecked")
	public List<T> buscaListaPorParametro(Map<String, Object> parameters) {
		String nome = this.persistentClass.getName();
		StringBuilder sql = new StringBuilder();
		sql.append("from ").append( nome.replace("br.com.empresa.bean.", "") + " c").append(" where ");
		for (String string: parameters.keySet()) {
			sql.append(string+ "= :"+ string);
		}
		
		Query q = JPAUtil.getEntityManager().createQuery(sql.toString());
		for (String string: parameters.keySet()) {
			q.setParameter(string, parameters.get(string));
		}
		
		return (List<T>) q.getResultList();
	}
}
