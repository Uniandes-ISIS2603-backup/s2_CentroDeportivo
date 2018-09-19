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
public class DeportistaObjetivosLogic {
   private static final Logger LOGGER = Logger.getLogger(DeportistaObjetivosLogic.class.getName());

    @Inject
    private ObjetivoPersistence objetivoPersistence;

    @Inject
    private DeportistaPersistenc deportistaPersistence;
    
        /**
     * Agregar un objetivo a la deportista
     *
     * @param objetivosId El id del objetivo a guardar
     * @param deportistasId El id de la deportista en la cual se va a guardar el
     * objetivo.
     * @return El objetivo creado.
     */
    public ObjetivoEntity addObjetivo(Long objetivosId, Long deportistasId) {
        LOGGER.log(Level.INFO, "Inicia proceso de agregarle un objetivo a una deportista con id = {0}", deportistasId);
        DeportistaEntity deportistaEntity = deportistaPersistence.find(deportistasId);
        ObjetivoEntity objetivoEntity = objetivoPersistence.find(objetivosId);
        objetivoEntity.setDeportista(deportistaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de agregarle un objetivo a una deportista con id = {0}", deportistasId);
        return objetivoEntity;
    }
    
    /**
     * Retorna todos los objetivos asociados a una deportista
     *
     * @param deportistasId El ID de la deportista buscada
     * @return La lista de objetivos de la deportista
     */
    public List<ObjetivoEntity> getObjetivos(Long deportistasId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar los objetivos asociados a la deportista con id = {0}", deportistasId);
        return deportistaPersistence.find(deportistasId).getObjetivos();
    }
    
    /**
     * Retorna un objetivo asociado a una deportista
     *
     * @param deportistasId El id de la deportista a buscar.
     * @param objetivosId El id del libro a buscar
     * @return El objetivo encontrado dentro de la deportista.
     * @throws BusinessLogicException Si la deportista no se encuentra en la
     * deportista
     */
    public ObjetivoEntity getObjetivo(Long deportistasId, Long objetivosId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el objetivo con id = {0} de la deportista con id = " + deportistasId, objetivosId);
        List<ObjetivoEntity> objetivos = deportistaPersistence.find(deportistasId).getObjetivos();
        ObjetivoEntity objetivoEntity = objetivoPersistence.find(objetivosId);
        int index = objetivos.indexOf(objetivoEntity);
        LOGGER.log(Level.INFO, "Termina proceso de consultar el objetivo con id = {0} de la deportista con id = " + deportistasId, objetivosId);
        if (index >= 0) {
            return objetivos.get(index);
        }
        throw new BusinessLogicException("El objetivo no está asociado a la deportista");
    }
    
    /**
     * Remplazar objetivos de una deportista
     *
     * @param objetivos Lista de libros que serán los de la deportista.
     * @param deportistasId El id de la deportista que se quiere actualizar.
     * @return La lista de objetivos actualizada.
     */
    public List<ObjetivoEntity> replaceObjetivos(Long deportistasId, List<ObjetivoEntity> objetivos) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar la deportista con id = {0}", deportistasId);
        DeportistaEntity deportistaEntity = deportistaPersistence.find(deportistasId);
        List<ObjetivoEntity> objetivoList = objetivoPersistence.findAll();
        for (ObjetivoEntity objetivo : objetivoList) {
            if (objetivos.contains(objetivo)) {
                objetivo.setDeportista(deportistaEntity);
            } else if (objetivo.getDeportista()!= null && objetivo.getDeportista().equals(deportistaEntity)) {
                objetivo.setDeportista(null);
            }
        }
        LOGGER.log(Level.INFO, "Termina proceso de actualizar la deportista con id = {0}", deportistasId);
        return objetivos;
    } 
}
