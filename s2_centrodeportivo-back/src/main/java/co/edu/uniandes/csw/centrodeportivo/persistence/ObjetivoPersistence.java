/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.persistence;

import co.edu.uniandes.csw.centrodeportivo.entities.ObjetivoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 * Clase que maneja la persistencia para Objetivo. Se conecta a través Entity
 * Manager de javax.persistance con la base de datos SQL.
 * @author Leidy Romero
 */
@Stateless
public class ObjetivoPersistence {
    private static final Logger LOGGER = Logger.getLogger(ObjetivoEntity.class.getName());

    @PersistenceContext(unitName = "LudisPU")
    protected EntityManager em;
    
    /**
     * Método para persisitir la entidad en la base de datos.
     *
     * @param objetivoEntity objeto objetivo que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public ObjetivoEntity create(ObjetivoEntity objetivoEntity) {
        LOGGER.log(Level.INFO, "Creando un objetivo nuevo");
        /* Note que hacemos uso de un método propio de EntityManager para persistir al deportista en la base de datos.
        Es similar a "INSERT INTO table_name (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);" en SQL.
         */
        em.persist(objetivoEntity);
        LOGGER.log(Level.INFO, "Saliendo de crear un objetivo nuevo");
        return objetivoEntity;
    }
    
    /**
     * Devuelve todos los objetivos de la base de datos.
     *
     * @return una lista con todos los objetivos que encuentre en la base de
     * datos, "select u from ObjetivoEntity u" es como un "select * from
     * ObjetivoEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<ObjetivoEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todos los objetivos");
        // Se crea un query para buscar todos los objetivos en la base de datos.
        TypedQuery query = em.createQuery("select u from ObjetivoEntity u", ObjetivoEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de objetivos.
        return query.getResultList();
    }
    
     /**
     * Busca si hay algun objetivo con el id que se envía de argumento
     *
     * @param objetivosId: id correspondiente al objetivo buscado.
     * @return un objetivo.
     */
    public ObjetivoEntity find(Long objetivosId) {
        LOGGER.log(Level.INFO, "Consultando el objetivo con id={0}", objetivosId);
        /* Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from ObjetivoEntity where id=id;" - "SELECT * FROM table_name WHERE condition;" en SQL.
         */
        return em.find(ObjetivoEntity.class, objetivosId);
    }
     /**
     * Actualiza la informacion de un objetivo.
     *
     * @param objetivoEntity: el objetivo que viene con los nuevos cambios.
     * Por ejemplo el estado pudo cambiar. En ese caso, se haria uso del método
     * update.
     * @return un objetivo con los cambios aplicados.
     */
    public ObjetivoEntity update(ObjetivoEntity objetivoEntity) {
        LOGGER.log(Level.INFO, "Actualizando el objetivo con id = {0}", objetivoEntity.getId());
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        el deportista con los cambios, esto es similar a 
        "UPDATE table_name SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        LOGGER.log(Level.INFO, "Saliendo de actualizar el objetivo con id = {0}", objetivoEntity.getId());
        return em.merge(objetivoEntity);
    }

}
