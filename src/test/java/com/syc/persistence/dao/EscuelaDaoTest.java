package com.syc.persistence.dao;

import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.Assert;

import com.syc.persistence.domain.EscuelaDomain;

public class EscuelaDaoTest extends BaseTest{
	
	private static final transient Log log = LogFactory.getLog(EscuelaDaoTest.class);
	
	@Autowired
	EscuelaDao escuelaDao;
	
	@Test
	public void isEscuelaDaoNull(){
		Assert.notNull(escuelaDao);
	}
	
	@Ignore
	@Test
	public void crearNuevaEscuela(){
		
		EscuelaDomain escuela = new EscuelaDomain();
		
		escuela.setIdEscuela(2);
		escuela.setNombreEscuela("UPIICSA");
		escuela.setDireccion("AV. UPIICSA No 2.");
		escuela.setEspecialidad("SISTEMAS");
		escuela.setTelefono("565811");
		
		escuelaDao.create(escuela);
		
	}
	
	@Ignore
	@Test
	public void obtenListaDeElementos(){
		
		List<EscuelaDomain> listaEscuelas;
		
		listaEscuelas = escuelaDao.findAll();
		
		log.debug("===========================");
		log.debug("El total de elementos es: "+ listaEscuelas.size());
		
		for( EscuelaDomain escuela: listaEscuelas ){
			log.debug( escuela.toString() );
		}
		
		log.debug("===========================");
	}
	
	@Test
	public void obtenListaPorEscuea(){
		
		List<EscuelaDomain> listaEscuelas;
		
		listaEscuelas = escuelaDao.obtenListaPorEscuela("UPIICSA");
		
		log.debug("===========================");
		log.debug("El total de elementos es: "+ listaEscuelas.size());
		
		for( EscuelaDomain escuela: listaEscuelas ){
			log.debug( escuela.toString() );
		}
		
		log.debug("===========================");
	}
	

}
