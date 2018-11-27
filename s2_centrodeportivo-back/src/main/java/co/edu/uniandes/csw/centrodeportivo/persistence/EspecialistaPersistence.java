/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.persistence;

import co.edu.uniandes.csw.centrodeportivo.entities.EspecialistaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Francisco Jose MacAllister
 */
@Stateless
public class EspecialistaPersistence {
    private static final Logger LOGGER = Logger.getLogger(EspecialistaPersistence.class.getName());
    
    @PersistenceContext(unitName = "LudisPU")
    protected EntityManager em;
    /**
     * Método para persisitir la entidad en la base de datos.
     *
     * @param especialistaEntity objeto especialista que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
     public EspecialistaEntity create(EspecialistaEntity especialistaEntity) {
        LOGGER.log(Level.INFO, "Creando un nuevo especialista");
        
        em.persist(especialistaEntity);
        LOGGER.log(Level.INFO, "Saliendo de crear un nuevo especialista");
        return especialistaEntity;
    }
     /**
     * Devuelve todas las especialistaes de la base de datos.
     *
     * @return una lista con todas las especialistaes que encuentre en la base de
     * datos, "select u from EspecialistaEntity u" es como un "select * from
     * EspecialistaEntity;" - "SELECT * FROM table_name" en SQL.
     */
      public List<EspecialistaEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todos los especialistas");
        // Se crea un query para buscar todos los especialistas en la base de datos.
        TypedQuery query = em.createQuery("select u from EspecialistaEntity u", EspecialistaEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de especialistas.
        return query.getResultList();
    }
      /**
     * Busca si hay alguna especialista con el id que se envía de argumento
     *
     * @param especialistasId: id correspondiente a la especialista buscada.
     * @return una especialista.
     */
       public EspecialistaEntity find(Long especialistaId) {
        LOGGER.log(Level.INFO, "Consultando el especialista con id={0}", especialistaId);
        /* Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from EspecialistaEntity where id=id;" - "SELECT * FROM table_name WHERE condition;" en SQL.
         */
        return em.find(EspecialistaEntity.class, especialistaId);
    }
        /**
     * Actualiza una especialista.
     *
     * @param especialistaEntity: la especialista que viene con los nuevos cambios.
     * Por ejemplo el nombre pudo cambiar. En ese caso, se haria uso del método
     * update.
     * @return una especialista con los cambios aplicados.
     */
       public EspecialistaEntity update(EspecialistaEntity especialistaEntity) {
        LOGGER.log(Level.INFO, "Actualizando el especialista con id = {0}", especialistaEntity.getId());
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        el especialista con los cambios, esto es similar a 
        "UPDATE table_name SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        LOGGER.log(Level.INFO, "Saliendo de actualizar el especialista con id = {0}", especialistaEntity.getId());
        return em.merge(especialistaEntity);
    }
/**
     *
     * Borra una especialista de la base de datos recibiendo como argumento el id
     * de la especialista
     *
     * @param especialistasId: id correspondiente a la especialista a borrar.
     */
     public void delete(Long especialistaId) {
        LOGGER.log(Level.INFO, "Borrando especialista con id = {0}", especialistaId);
        // Se hace uso de mismo método que esta explicado en public EspecialistaEntity find(Long id) para obtener la especialista a borrar.
        EspecialistaEntity entity = em.find(EspecialistaEntity.class, especialistaId);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
         EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
         Es similar a "delete from EspecialistaEntity where id=id;" - "DELETE FROM table_name WHERE condition;" en SQL.*/
        em.remove(entity);
        LOGGER.log(Level.INFO, "Saliendo de borrar el especialista con id = {0}", especialistaId);
    }

   public EspecialistaEntity findByName(String name) {
        LOGGER.log(Level.INFO, "Consultando especialista por nombre ", name);
        // Se crea un query para buscar especialistaes con el nombre que recibe el método como argumento. ":name" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From EspecialistaEntity e where e.nombre = :nombre", EspecialistaEntity.class);
        // Se remplaza el placeholder ":name" con el valor del argumento 
        query = query.setParameter("nombre", name);
        // Se invoca el query se obtiene la lista resultado
        List<EspecialistaEntity> sameName = query.getResultList();
        EspecialistaEntity result;
        if (sameName == null) {
            result = null;
        } else if (sameName.isEmpty()) {
            result = null;
        } else {
            result = sameName.get(0);
        }
        LOGGER.log(Level.INFO, "Saliendo de consultar especialista por nombre ", name);
        return result;
    }
}
