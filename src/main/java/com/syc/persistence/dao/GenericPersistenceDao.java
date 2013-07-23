package com.syc.persistence.dao;

import java.io.Serializable;
import java.util.List;

/**
 * @author angelctmex
 *
 * @param <T>
 * @param <PK>
 * Una interface generica para los DAO's
 */
public interface GenericPersistenceDao<T, PK extends Serializable> {
    /**
     * Persiste newInstance en la base de datos.
     *
     * @param newInstance
     * @return
     */
    void create(T newInstance);
    
    /**
     * Crea una nueva instancia en caso de no existir, de lo contrario Actualiza 
     *
     * @param newInstance
     * @return
     */
    void createOrUpdate(T newInstance);

    /**
     * Recupera un objeto usando el id indicado como llave primaria.
     *
     * @param id
     * @return
     */
    T read(PK id);

    /**
     * Guarda los cambios hechos al objeto persistente.
     *
     * @param transientObject
     */
    void update(T transientObject);

    /**
     * Remueve el objeto de la base de datos.
     *
     * @param persistentObject
     */
    void delete(T persistentObject);

    /**
     * @return
     */
    List<T> findAll();
        
}

