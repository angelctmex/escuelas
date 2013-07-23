package com.syc.persistence.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.orm.hibernate3.support.HibernateDaoSupport;
import org.springframework.stereotype.Repository;

import com.syc.persistence.dao.GenericPersistenceDao;



/**
 * @author angelctmex
 *
 * @param <T>
 * @param <PK>
 * La implementacion en clase asbtracta para todas las operaciones de los DAOs
 * Con esto permitimos a cualquier DAO que herede de esta clase a que tenga listos
 * los metodos del CRUD
 */
@SuppressWarnings("unchecked")
@Repository
public class GenericPersistenceDaoImpl<T, PK extends Serializable>
		extends HibernateDaoSupport implements GenericPersistenceDao<T, PK> {
	
	private Class<T> type = null;

	
	@Autowired
	public GenericPersistenceDaoImpl(HibernateTemplate hibernateTemplate){
		super.setHibernateTemplate(hibernateTemplate);
	}
	
	public GenericPersistenceDaoImpl(){
		
	}
	
	
	public void create(T newInstance) {
		this.getHibernateTemplate().save(newInstance);
	}
	
	public void createOrUpdate(T instance){
		this.getHibernateTemplate().saveOrUpdate(instance);
	}
	
	public void delete(T persistentObject) {
		this.getHibernateTemplate().delete(persistentObject);
	}

	@SuppressWarnings("rawtypes")
	public List findAll() {
		return this.getHibernateTemplate().loadAll(getType());
	}

	/**
	 * Obtiene por reflexion el tipo del DomainObject que usa este DAO
	 * 
	 * @return the type
	 */
	public Class<T> getType() {
		if (type == null) {
			@SuppressWarnings("rawtypes")
			Class clazz = getClass();

			while (!(clazz.getGenericSuperclass() instanceof ParameterizedType)) {
				clazz = clazz.getSuperclass();
			}

			type = (Class<T>) ((ParameterizedType) clazz.getGenericSuperclass())
					.getActualTypeArguments()[0];
		}

		return type;
	}

	public T read(PK id) {
		return (T) this.getHibernateTemplate().get(getType(), id);
	}

	public void update(T transientObject) {
		this.getHibernateTemplate().update(transientObject);
	}
		
}
