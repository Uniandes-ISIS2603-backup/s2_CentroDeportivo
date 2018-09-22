/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.ejb;

import co.edu.uniandes.csw.centrodeportivo.entities.DeportistaEntity;
import co.edu.uniandes.csw.centrodeportivo.entities.ObjetivoEntity;
import co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.centrodeportivo.persistence.DeportistaPersistenc;
import co.edu.uniandes.csw.centrodeportivo.persistence.ObjetivoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Leidy Romero
 */
public class ObjetivoDeportistasLogic {
    private static final Logger LOGGER = Logger.getLogger(ObjetivoDeportistasLogic.class.getName());

    @Inject
    private DeportistaPersistenc deportistaPersistence;

    @Inject
    private ObjetivoPersistence objetivoPersistence;
    
        /**
     * Agregar un deportista a la objetivo
     *
     * @param deportistasId El id del deportista a guardar
     * @param objetivosId El id de la objetivo en la cual se va a guardar el
     * deportista.
     * @return El deportista creado.
     */
    public DeportistaEntity addDeportista(Long deportistasId, Long objetivosId) {
        LOGGER.log(Level.INFO, "Inicia proceso de agregarle un deportista a una objetivo con id = {0}", objetivosId);
        ObjetivoEntity objetivoEntity = objetivoPersistence.find(objetivosId);
        DeportistaEntity deportistaEntity = deportistaPersistence.find(deportistasId);
        deportistaEntity.setObjetivo(objetivoEntity);
        LOGGER.log(Level.INFO, "Termina proceso de agregarle un deportista a una objetivo con id = {0}", objetivosId);
        return deportistaEntity;
    }
    
    /**
     * Retorna todos los deportistas asociados a una objetivo
     *
     * @param objetivosId El ID de la objetivo buscada
     * @return La lista de deportistas de la objetivo
     */
    public List<DeportistaEntity> getDeportistas(Long objetivosId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar los deportistas asociados a la objetivo con id = {0}", objetivosId);
        return objetivoPersistence.find(objetivosId).getCasosExitosos();
    }
    
    /**
     * Retorna un deportista asociado a una objetivo
     *
     * @param objetivosId El id de la objetivo a buscar.
     * @param deportistasId El id del libro a buscar
     * @return El deportista encontrado dentro de la objetivo.
     * @throws BusinessLogicException Si la objetivo no se encuentra en la
     * objetivo
     */
    public DeportistaEntity getDeportista(Long objetivosId, Long deportistasId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el deportista con id = {0} de la objetivo con id = " + objetivosId, deportistasId);
        List<DeportistaEntity> deportistas = objetivoPersistence.find(objetivosId).getCasosExitosos();
        DeportistaEntity deportistaEntity = deportistaPersistence.find(deportistasId);
        int index = deportistas.indexOf(deportistaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de consultar el deportista con id = {0} de la objetivo con id = " + objetivosId, deportistasId);
        if (index >= 0) {
            return deportistas.get(index);
        }
        throw new BusinessLogicException("El deportista no está asociado a la objetivo");
    }
 /**
     * Remplazar deportistas de una objetivo
     *
     * @param deportistas Lista de libros que serán los de la objetivo.
     * @param objetivosId El id de la objetivo que se quiere actualizar.
     * @return La lista de libros actualizada.
     */
    public List<DeportistaEntity> replaceDeportistas(Long objetivosId, List<DeportistaEntity> deportistas) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el objetivo con id = {0}", objetivosId);
        ObjetivoEntity objetivoEntity = objetivoPersistence.find(objetivosId);
        List<DeportistaEntity> deportistaList = deportistaPersistence.findAll();
        
        for (DeportistaEntity deportista : deportistaList) {
            if (deportistas.contains(deportista)) {
                deportista.setObjetivo(objetivoEntity);
            } else if (deportista.getObjetivo() != null && deportista.getObjetivo().equals(objetivoEntity)) {
                deportista.setObjetivo(null);
            }
        }
        LOGGER.log(Level.INFO, "Termina proceso de actualizar la objetivo con id = {0}", objetivosId);
        return deportistas;
    }
}
