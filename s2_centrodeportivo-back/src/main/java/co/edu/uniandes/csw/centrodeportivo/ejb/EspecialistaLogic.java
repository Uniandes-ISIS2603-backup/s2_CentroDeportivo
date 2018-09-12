/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.ejb;

import co.edu.uniandes.csw.centrodeportivo.entities.EspecialistaEntity;
import co.edu.uniandes.csw.centrodeportivo.persistence.EspecialistaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Francisco Jose MacAllister
 */
public class EspecialistaLogic {

 private static final Logger LOGGER = Logger.getLogger(EspecialistaLogic.class.getName());
    
    @Inject 
    private EspecialistaPersistence persistencia;
    
     /**
     * Metodo que se encarga de crear un especialista en la base de datos.
     * 
     * @param especialistaEntity Objeto de EspecialistaEntity con los datos nuevos
     * @return Objeto de EspecialistaEntity con los datos nuevos y su ID.
     */
    public EspecialistaEntity createEspecialista(EspecialistaEntity especialistaEntity)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de creación de un especialista");
        EspecialistaEntity nuevoEspecialista = persistencia.create(especialistaEntity);
        LOGGER.log(Level.INFO,"Termina proceso de creación de un especialista");
        return nuevoEspecialista;
    }
     /**
     * Obtiene la lista de los registros de los especialistas.
     * @return Coleccion de objetos tipo EspecialistaEntity
     */
    public List<EspecialistaEntity> getEspecialistas()
    {
        LOGGER.log(Level.INFO,"Inicia proceso de consultar todos los especialistas almacenado en la base de datos");
        List<EspecialistaEntity> lista = persistencia.findAll();
        LOGGER.log(Level.INFO,"Termina proceso de consultar todos los especialistas");
        return lista;
    }
    
        /**
     * Obtiene los datos de una instancia de Especialista a partir de su ID.
     * @param especialistasId Identificador de la instancia a consultar.
     * @return Instancia de EspecialistaEntity con los datos del especialista encontrado.
     */
    public EspecialistaEntity getEspecialista(Long especialistasId)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar un especialista identificado con el id = {0}",especialistasId);
        EspecialistaEntity especialistaEntity = persistencia.find(especialistasId);
        if(especialistaEntity == null)
            LOGGER.log(Level.SEVERE, "No se encontró el especialista identificado con el id = {0}");
        
        LOGGER.log(Level.INFO, "Termina proceso de consultar un especialista identificado con el id = {0}");
        return especialistaEntity;
    }
    
    /**
     * Actualiza la informacion de una instancia de especialista de la base de datos.
     * 
     * @param especialistasId identificador de la instancia a actualizar.
     * @param especialistaEntity instancia de Entity con los nuevos datos.
     * @return Instancia de EspecialistaEntity con los datos actualizados.
     */
    public EspecialistaEntity updateEspecialista(Long especialistasId, EspecialistaEntity especialistaEntity)
    {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el especialista identificado con el id = {0}",especialistasId);
        EspecialistaEntity especialistaActualizado = persistencia.update(especialistaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar el especialista identificado con el id = {0}",especialistasId);
        return especialistaActualizado;
    }
    
}
