/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.persistence;


import co.edu.uniandes.csw.centrodeportivo.entities.MaquinaEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author dy.quintero
 */
public class MaquinaPersistence 
{
    private static final Logger LOGGER = Logger.getLogger(ObjetivoPersistence.class.getName());
        
    @PersistenceContext(unitName = "LudisPU")
    protected EntityManager em;
    
    /**
     * Método para persisitir la entidad en la base de datos.
     * @param maquinaEntity
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public MaquinaEntity create(MaquinaEntity maquinaEntity) {
    LOGGER.log(Level.INFO, "Creando un objetivo nuevo");
    /* Note que hacemos uso de un método propio de EntityManager para persistir al deportista en la base de datos.
    Es similar a "INSERT INTO table_name (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);" en SQL.
     */
    em.persist(maquinaEntity);
    LOGGER.log(Level.INFO, "Saliendo de crear un objetivo nuevo");
    return maquinaEntity;
    }
    
    
    /**
     * Devuelve todos las maquinas de la base de datos.
     *
     * @return una lista con todos lla maquinas que encuentre en la base de
     * datos, "select u from ObjetivoEntity u" es como un "select * from
     * MaquinaEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<MaquinaEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todos los objetivos");
        // Se crea un query para buscar todos los objetivos en la base de datos.
        TypedQuery query = em.createQuery("select u from ObjetivoEntity u", MaquinaEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de objetivos.
        return query.getResultList();
    }
    
    
     /**
     * Busca si hay alguna maquina con el id que se envía de argumento
     * @param maquinasId
     * @return maquina con el id buscado.
     */
    public MaquinaEntity find(Long maquinasId) {
        LOGGER.log(Level.INFO, "Consultando la maquina con id={0}", maquinasId);
        /* Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from ObjetivoEntity where id=id;" - "SELECT * FROM table_name WHERE condition;" en SQL.
         */
        return em.find(MaquinaEntity.class, maquinasId);
    }
    
         /**
     * Actualiza la informacion de un objetivo.
     * @param maquinaEntity
     * Por ejemplo el estado pudo cambiar. En ese caso, se haria uso del método
     * update.
     * @return una maquina con los cambios aplicados.
     */
    public MaquinaEntity update(MaquinaEntity maquinaEntity) {
        LOGGER.log(Level.INFO, "Actualizando el objetivo con id = {0}", maquinaEntity.getId());
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        el deportista con los cambios, esto es similar a 
        "UPDATE table_name SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        LOGGER.log(Level.INFO, "Saliendo de actualizar el objetivo con id = {0}", maquinaEntity.getId());
        return em.merge(maquinaEntity);
    }
    
    
    /**
     * Borra una maquina de la base de datos recibiendo como argumento el id
     * de la editorial
     * 
     * @param maquinasId
     */
    public void delete(Long maquinasId) {
        LOGGER.log(Level.INFO, "Borrando editorial con id = {0}", maquinasId);
        // Se hace uso de mismo método que esta explicado en public EditorialEntity find(Long id) para obtener la editorial a borrar.
        MaquinaEntity entity = em.find(MaquinaEntity.class, maquinasId);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
         EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
         Es similar a "delete from EditorialEntity where id=id;" - "DELETE FROM table_name WHERE condition;" en SQL.*/
        em.remove(entity);
        LOGGER.log(Level.INFO, "Saliendo de borrar la maquina con id = {0}", maquinasId);
    }
    
}
