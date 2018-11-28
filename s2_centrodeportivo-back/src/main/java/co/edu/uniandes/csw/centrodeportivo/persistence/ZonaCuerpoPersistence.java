/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.uniandes.csw.centrodeportivo.persistence;

import co.edu.uniandes.csw.centrodeportivo.entities.ZonaCuerpoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Clase que maneja la persistencia para ZonaCuerpo. Se conecta a través del Entity
 * Manager de javax.persistance con la base de datos SQL.
 *
 * @author Daniel Pardo
 */
@Stateless
public class ZonaCuerpoPersistence {
    
    private static final Logger LOGGER = Logger.getLogger(ZonaCuerpoPersistence.class.getName());
    
    @PersistenceContext(unitName = "LudisPU")
    protected EntityManager em;
    
    /**
     * Crea una zona del cuerpo en la base de datos
     *
     * @param zonaCuerpoEntity objeto zonaCuerpo que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    
    public ZonaCuerpoEntity create(ZonaCuerpoEntity zonaCuerpoEntity) {
        LOGGER.log(Level.INFO, "Creando una zona del cuerpo nueva");
        em.persist(zonaCuerpoEntity);
        LOGGER.log(Level.INFO, "Saliendo de crear una zona del cuerpo nueva");
        return zonaCuerpoEntity;
    }
    
    /**
     * Devuelve todas las zonasCuerpo de la base de datos.
     *
     * @return una lista con todas las zonasCuerpo que encuentre en la base de
     * datos, "select u from ZonaCuerpoEntity u" es como un "select * from
     * ZonaCuerpoEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<ZonaCuerpoEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todas las zonas del cuerpo");
        TypedQuery query = em.createQuery("select u from ZonaCuerpoEntity u", ZonaCuerpoEntity.class);
        return query.getResultList();
    }
    
    /**
     * Busca si hay alguna zonaCuerpo con el id que se envía de argumento
     *
     * @param zonaCuerpoId: id correspondiente a la zonaCuerpo buscada.
     * @return un zonaCuerpo.
     */
    
    public ZonaCuerpoEntity find(Long zonaCuerpoId) {
        LOGGER.log(Level.INFO, "Consultando la zona del cuerpo con id={0}", zonaCuerpoId);
        return em.find(ZonaCuerpoEntity.class, zonaCuerpoId);
    }
    
    /**
     * Actualiza una zonaCuerpo.
     *
     * @param zonaCuerpoEntity: la zonaCuerpo que viene con los nuevos cambios. Por
     * ejemplo el nombre pudo cambiar. En ese caso, se haria uso del método
     * update.
     * @return una zonaCuerpo con los cambios aplicados.
     */
    public ZonaCuerpoEntity update(ZonaCuerpoEntity zonaCuerpoEntity) {
        LOGGER.log(Level.INFO, "Actualizando la zona del cuerpo con id = {0}", zonaCuerpoEntity.getId());
        LOGGER.log(Level.INFO, "Saliendo de actualizarla zonaCuerpo con id = {0}", zonaCuerpoEntity.getId());
        return em.merge(zonaCuerpoEntity);
    }
    
    /**
     * Borra una zonaCuerpo de la base de datos recibiendo como argumento el id de
     * la zonaCuerpo
     *
     * @param zonaCuerpoId: id correspondiente a la zonaCuerpo a borrar.
     */
    public void delete(Long zonaCuerpoId) {
        LOGGER.log(Level.INFO, "Borrando la zonaCuerpo con id = {0}", zonaCuerpoId);
        ZonaCuerpoEntity entity = em.find(ZonaCuerpoEntity.class, zonaCuerpoId);
        em.remove(entity);
        LOGGER.log(Level.INFO, "Saliendo de borrar la zonaCuerpo con id = {0}", zonaCuerpoId);
    }
}