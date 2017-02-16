package com.ejb.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaQuery;

import com.ejb.exception.CarroNaoEncontradoException;
import com.ejb.model.AbstractEntity;


public abstract class CarroRepository<T extends AbstractEntity, PK extends Number> {

	private Class<T> entityClass;
	
	public CarroRepository(Class<T> entityClass) {
		this.entityClass = entityClass;
	}

	public T save(T e) {
		if (e.getId() != null)
			return getEntityManager().merge(e);
		else {
			getEntityManager().persist(e);
			return e;
		}
	}

	public void remove(T entity) {
		getEntityManager().remove(getEntityManager().merge(entity));
	}

	public T find(PK id) {
		return getEntityManager().find(entityClass, id);
	}

	public List<T> findAll() {
		CriteriaQuery cq = getEntityManager().getCriteriaBuilder().createQuery();
		cq.select(cq.from(entityClass));
		return getEntityManager().createQuery(cq).getResultList();
	}

	
	public T findMarcaAndModeloAndPlaca(String marca, String modelo ,String placa) {
	    try {
			TypedQuery<T> query = getEntityManager().createQuery(
			    "SELECT c FROM Carro c inner join fetch c.modelo m WHERE  c.marca =:marca and m.descricao =:modelo  and c.placa =:placa", entityClass);
			     query.setParameter("marca", marca);
			     query.setParameter("modelo", modelo);
			     query.setParameter("placa", placa);
			     T objeto = (T) query.getSingleResult();
			     return objeto;
		} catch (Exception e) {
			throw new CarroNaoEncontradoException("carro nao existente na base "+e.getMessage());
		}  
	} 

	protected abstract EntityManager getEntityManager();
}
