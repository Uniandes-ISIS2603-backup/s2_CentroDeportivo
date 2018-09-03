/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.persistence;

import co.edu.uniandes.csw.centrodeportivo.entities.EspecialistaEntity;
import co.edu.uniandes.csw.centrodeportivo.entities.ObjetivoEntity;
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
    
     public EspecialistaEntity create(EspecialistaEntity especialistaEntity) {
        LOGGER.log(Level.INFO, "Creando un objetivo nuevo");
        /* Note que hacemos uso de un método propio de EntityManager para persistir al deportista en la base de datos.
        Es similar a "INSERT INTO table_name (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);" en SQL.
         */
        em.persist(especialistaEntity);
        LOGGER.log(Level.INFO, "Saliendo de crear un objetivo nuevo");
        return especialistaEntity;
    }
     
      public List<EspecialistaEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todos los especialistas");
        // Se crea un query para buscar todos los objetivos en la base de datos.
        TypedQuery query = em.createQuery("select u from ObjetivoEntity u", EspecialistaEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de objetivos.
        return query.getResultList();
    }
       public EspecialistaEntity find(Long especialistaId) {
        LOGGER.log(Level.INFO, "Consultando el objetivo con id={0}", especialistaId);
        /* Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from ObjetivoEntity where id=id;" - "SELECT * FROM table_name WHERE condition;" en SQL.
         */
        return em.find(EspecialistaEntity.class, especialistaId);
    }
       public EspecialistaEntity update(EspecialistaEntity especialistaEntity) {
        LOGGER.log(Level.INFO, "Actualizando el especialista con id = {0}", especialistaEntity.getId());
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        el deportista con los cambios, esto es similar a 
        "UPDATE table_name SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        LOGGER.log(Level.INFO, "Saliendo de actualizar el objetivo con id = {0}", especialistaEntity.getId());
        return em.merge(especialistaEntity);
    }
}
