package com.syc.persistence.dao;

import java.util.List;

import com.syc.persistence.domain.EscuelaDomain;

public interface EscuelaDao extends GenericPersistenceDao<EscuelaDomain, Long>{

	
	public List<EscuelaDomain> obtenListaPorEscuela( String nombreEscuela );
	
}
