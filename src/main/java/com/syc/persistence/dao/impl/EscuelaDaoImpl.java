package com.syc.persistence.dao.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate3.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.syc.persistence.dao.EscuelaDao;
import com.syc.persistence.domain.EscuelaDomain;


@SuppressWarnings("unchecked")
@Repository("escuelaDao")
public class EscuelaDaoImpl extends GenericPersistenceDaoImpl<EscuelaDomain, Long> implements EscuelaDao{

	@Autowired
	public EscuelaDaoImpl(HibernateTemplate hibernateTemplate) {
		super(hibernateTemplate);
	}
	
	public List<EscuelaDomain> obtenListaPorEscuela( String nombreEscuela ){
		
		return getSession().getNamedQuery("escuelaDomain.buscarPorEscuela").setString("escuela", nombreEscuela).list();
		
	}

}
