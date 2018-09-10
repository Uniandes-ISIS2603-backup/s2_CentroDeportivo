/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.ejb;

import co.edu.uniandes.csw.centrodeportivo.entities.DeportistaEntity;
import co.edu.uniandes.csw.centrodeportivo.persistence.DeportistaPersistenc;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Leidy Romero
 */
@Stateless
public class DeportistaLogic {
    
    private static final Logger LOGGER = Logger.getLogger(DeportistaLogic.class.getName());

    @Inject
    private DeportistaPersistenc persistencia;

    /**
     * Metodo que se encarga de crear un deportista en la base de datos.
     * 
     * @param deportistaEntity Objeto de DeportistaEntity con los datos nuevos
     * @return Objeto de DeportistaEntity con los datos nuevos y su ID.
     */
    public DeportistaEntity createDeportista(DeportistaEntity deportistaEntity)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de creación de un deportista");
        DeportistaEntity nuevoDeportista = persistencia.create(deportistaEntity);
        LOGGER.log(Level.INFO,"Termina proceso de creación de un deportista");
        return nuevoDeportista;
    }
    
    /**
     * Obtiene la lista de los registros de los deportistas.
     * @return Coleccion de objetos tipo DeportistaEntity
     */
    public List<DeportistaEntity> getDeportistas()
    {
        LOGGER.log(Level.INFO,"Inicia proceso de consultar todos los deportistas almacenados en la base de datos");
        List<DeportistaEntity> lista = persistencia.findAll();
        LOGGER.log(Level.INFO,"Termina proceso de consultar todos los deportistas");
        return lista;
    }
    
    /**
     * Obtiene los datos de una instancia de Deportista a partir de su ID.
     * @param deportistasId Identificador de la instancia a consultar.
     * @return Instancia de DeportistaEntity con los datos del deportista encontrado.
     */
    public DeportistaEntity getDeportista(Long deportistasId)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar id = {0}",deportistasId);
        DeportistaEntity deportistaEntity = persistencia.find(deportistasId);
        if(deportistaEntity == null)
            LOGGER.log(Level.SEVERE, "No se encontró al identificado con X = {0}");
        
        LOGGER.log(Level.INFO, "Termina proceso de consultar un deportista identificado con id = {0}");
        return deportistaEntity;
    }
    /**
     * Actualiza la informacion de una instancia de deportista de la base de datos.
     * 
     * @param deportistasId identificador de la instancia a actualizar.
     * @param deportistaEntity instancia de Entity con los nuevos datos.
     * @return Instancia de DeportistaEntity con los datos actualizados.
     */
    public DeportistaEntity updateDeportista(Long deportistasId, DeportistaEntity deportistaEntity)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar al deportista identificado con el id = {0}",deportistasId);
        DeportistaEntity deportistaActualizado = persistencia.update(deportistaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar al deportista identificado con el id = {0}",deportistasId);
        return deportistaActualizado;
    }
    
     /**
     * Elimina una instancia de un deportista de la base de datos.
     *
     * @param deportistasId Identificador de la instancia a eliminar.
     */
    public void deleteDeportista(Long deportistasId)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el deportista con id = {0}", deportistasId);
        persistencia.delete(deportistasId);
        LOGGER.log(Level.INFO, "Termina proceso de borrar el deportista con id = {0}", deportistasId);
    }
}
