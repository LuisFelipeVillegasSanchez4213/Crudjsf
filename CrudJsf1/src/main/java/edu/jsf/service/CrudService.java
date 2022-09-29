package edu.jsf.service;

import java.io.Serializable;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import edu.jsf.util.ReflectionUtil;


@Service
@Transactional(readOnly = true)
public class CrudService  implements Serializable{

	private static final long serialVersionUID = 1L;
	public static final String OBJ_ALIAS = "o";
	
	@PersistenceContext
	private EntityManager em;
	
	@Transactional(readOnly = false)
	public <T> T save(T t) {
		if(ReflectionUtil.isNewObject(t))
			em.persist(t);
		else
			t = em.merge(t);
		em.flush();
		
		return t;
	}
	
	public <T> List<T> findAll(Class<T> persistentClass, String... orderFields){
		String orderByClause = buildOrderByClause(orderFields);
		String jpql = String.format("select %s from %s as %s %s",OBJ_ALIAS,persistentClass.getSimpleName(),OBJ_ALIAS,orderByClause);
		System.out.println(" /////La query que lanza es :" + jpql);
		return em.createQuery(jpql).getResultList();
	}
	
	@Transactional(readOnly= false)
	public void delete(Object obj) {
		obj = em.getReference(obj.getClass(), ReflectionUtil.getPKValue(obj));
		em.remove(obj);
		em.flush();
	}
	
	public <T> T find(Class persistenceClass, Object id) {
		return (T) em.find(persistenceClass, id);
	}
	
	public String buildOrderByClause(String ...orderFields) {
		String orderByClause = "";
		if(orderFields.length > 0) {
			for (int i = 0; i < orderFields.length; i++) {
				orderFields[i] = OBJ_ALIAS + "." + orderFields[i];
			}
			orderByClause = "order by " + StringUtils.join(orderFields, ", ");
		}
		return orderByClause;
	}
}
