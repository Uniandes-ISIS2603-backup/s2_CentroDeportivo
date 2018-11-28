/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.uniandes.csw.centrodeportivo.persistence;

import co.edu.uniandes.csw.centrodeportivo.entities.EjercicioEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Clase que maneja la persistencia para Ejercicio. Se conecta a través Entity
 * Manager de javax.persistance con la base de datos SQL.
 *
 * @author Daniel Pardo
 */
@Stateless
public class EjercicioPersistence
{
    private static final Logger LOGGER = Logger.getLogger(EjercicioPersistence.class.getName());
    
    @PersistenceContext(unitName = "LudisPU")
    protected EntityManager em;
    
    /**
     * Crea un ejercicio en la base de datos
     *
     * @param ejercicioEntity objeto ejercicio que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public EjercicioEntity create(EjercicioEntity ejercicioEntity) {
        LOGGER.log(Level.INFO, "Creando un ejercicio nuevo");
        em.persist(ejercicioEntity);
        LOGGER.log(Level.INFO, "Saliendo de crear un ejercicio nuevo");
        return ejercicioEntity;
    }
    
    /**
     * Devuelve todos los ejercicios de la base de datos.
     *
     * @return una lista con todas las ejercicios que encuentre en la base de
     * datos, "select u from EjercicioEntity u" es como un "select * from
     * EjercicioEntity;o - "SELECT * FROM table_name" en SQL.
     */
    public List<EjercicioEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todos los ejercicios");
        TypedQuery query = em.createQuery("select u from EjercicioEntity u", EjercicioEntity.class);
        return query.getResultList();
    }
    
    /**
     * Busca si hay alguna ejercicio con el id que se envía de argumento
     *
     * @param ejercicioId: id correspondiente a la ejercicio buscada.
     * @return un ejercicio.
     */
    public EjercicioEntity find(Long ejercicioId) {
        LOGGER.log(Level.INFO, "Consultando el ejercicio con id={0}", ejercicioId);
        return em.find(EjercicioEntity.class, ejercicioId);
    }
    
    /**
     * Actualiza una ejercicio.
     *
     * @param ejercicioEntity: la ejercicio que viene con los nuevos cambios. Por
     * ejemplo el nombre pudo cambiar. En ese caso, se haria uso del método
     * update.
     * @return una ejercicio con los cambios aplicados.
     */
    public EjercicioEntity update(EjercicioEntity ejercicioEntity) {
        LOGGER.log(Level.INFO, "Actualizando el ejercicio con id = {0}", ejercicioEntity.getId());
        LOGGER.log(Level.INFO, "Saliendo de actualizar el ejercicio con id = {0}", ejercicioEntity.getId());
        return em.merge(ejercicioEntity);
    }
    
    /**
     * Borra una ejercicio de la base de datos recibiendo como argumento el id de
     * la ejercicio
     *
     * @param ejerciciosId: id correspondiente a la ejercicio a borrar.
     */
    public void delete(Long ejerciciosId) {
        LOGGER.log(Level.INFO, "Borrando el ejercicio con id = {0}", ejerciciosId);
        EjercicioEntity entity = em.find(EjercicioEntity.class, ejerciciosId);
        em.remove(entity);
        LOGGER.log(Level.INFO, "Saliendo de borrar el ejercicio con id = {0}", ejerciciosId);
    }
    
}