/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.persistence;

import co.edu.uniandes.csw.centrodeportivo.entities.RutinaEntity;
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
public class RutinaPersistence {
    private static final Logger LOGGER = Logger.getLogger(ObjetivoPersistence.class.getName());

    @PersistenceContext(unitName = "LudisPU")
    protected EntityManager em;
    
    /**
     * Método para persisitir la entidad en la base de datos.
     *
     * @param rutinaEntity
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public RutinaEntity create(RutinaEntity rutinaEntity) {
        LOGGER.log(Level.INFO, "Creando una nueva rutina");
        /* Note que hacemos uso de un método propio de EntityManager para persistir al deportista en la base de datos.
        Es similar a "INSERT INTO table_name (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);" en SQL.
         */
        em.persist(rutinaEntity);
        LOGGER.log(Level.INFO, "Saliendo de crear una nueva rutina");
        return rutinaEntity;
    }
    
    /**
     * Devuelve todos los objetivos de la base de datos.
     *
     * @return una lista con todos los objetivos que encuentre en la base de
     * datos, "select u from ObjetivoEntity u" es como un "select * from
     * ObjetivoEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<RutinaEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todas las rutinas");
        // Se crea un query para buscar todos los objetivos en la base de datos.
        TypedQuery query = em.createQuery("select u from ObjetivoEntity u", RutinaEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de objetivos.
        return query.getResultList();
    }
    
     /**
     * Busca si hay algun objetivo con el id que se envía de argumento
     *
     * @param rutinaId
     * @return un objetivo.
     */
    public RutinaEntity find(Long rutinaId) {
        LOGGER.log(Level.INFO, "Consultando el objetivo con id={0}", rutinaId);
        /* Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from ObjetivoEntity where id=id;" - "SELECT * FROM table_name WHERE condition;" en SQL.
         */
        return em.find(RutinaEntity.class, rutinaId);
    }
     /**
     * Actualiza la informacion de un objetivo.
     *
     * @param rutinaEntity
     * @return un objetivo con los cambios aplicados.
     */
    public RutinaEntity update(RutinaEntity rutinaEntity) {
        LOGGER.log(Level.INFO, "Actualizando el objetivo con id = {0}", rutinaEntity.getId());
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        el deportista con los cambios, esto es similar a 
        "UPDATE table_name SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        LOGGER.log(Level.INFO, "Saliendo de actualizar el objetivo con id = {0}", rutinaEntity.getId());
        return em.merge(rutinaEntity);
    }

public void delete(Long rutinaId) {
        LOGGER.log(Level.INFO, "Borrando la rutina con id = {0}", rutinaId);
        // Se hace uso de mismo método que esta explicado en public EditorialEntity find(Long id) para obtener la editorial a borrar.
        RutinaEntity entity = em.find(RutinaEntity.class, rutinaId);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
         EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
         Es similar a "delete from EditorialEntity where id=id;" - "DELETE FROM table_name WHERE condition;" en SQL.*/
        em.remove(entity);
        LOGGER.log(Level.INFO, "Saliendo de borrar la rutina con id = {0}", rutinaId);
    }
}
