/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.ejb;

import co.edu.uniandes.csw.centrodeportivo.entities.ObjetivoEntity;
import co.edu.uniandes.csw.centrodeportivo.entities.RutinaEntity;
import co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.centrodeportivo.persistence.RutinaPersistence;
import co.edu.uniandes.csw.centrodeportivo.persistence.ObjetivoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 * Clase que implementa la conexion con la persistencia para la relación entre
 * la entidad de Rutina y Objetivo.
 *
 * @author Francisco Jose MacAllister
 */
@Stateless
public class RutinaObjetivosLogic {

     private static final Logger LOGGER = Logger.getLogger(RutinaObjetivosLogic.class.getName());

    @Inject
    private ObjetivoPersistence objetivoPersistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    @Inject
    private RutinaPersistence rutinaPersistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     * Agregar un objetivo a la rutina
     *
     * @param objetivosId El id objetivo a guardar
     * @param rutinasId El id de la rutina en la cual se va a guardar el
     * objetivo.
     * @return El objetivo creado.
     */
    public ObjetivoEntity addObjetivo(Long objetivosId, Long rutinasId) {
        LOGGER.log(Level.INFO, "Inicia proceso de agregarle un objetivo a la rutina con id = {0}", rutinasId);
        ObjetivoEntity objetivoEntity = objetivoPersistence.find(objetivosId);
        RutinaEntity rutinaEntity = rutinaPersistence.find(rutinasId);
       objetivoEntity.setRutina(rutinaEntity);
       
        LOGGER.log(Level.INFO, "Termina proceso de agregarle un objetivo a la rutina con id = {0}", rutinasId);
        return objetivoEntity;
    }

    /**
     * Retorna todos los objetivos asociados a una rutina
     *
     * @param rutinasId El ID de la rutina buscada
     * @return La lista de objetivos de la rutina
     */
    public List<ObjetivoEntity> getObjetivos(Long rutinasId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar los objetivos asociados a la rutina con id = {0}", rutinasId);
        return rutinaPersistence.find(rutinasId).getObjetivos();
    }

    /**
     * Retorna un objetivo asociado a una rutina
     *
     * @param rutinasId El id de la rutina a buscar.
     * @param objetivosId El id del objetivo a buscar
     * @return El objetivo encontrado dentro de la rutina.
     * @throws BusinessLogicException Si el objetivo no se encuentra en la
     * rutina
     */
    public ObjetivoEntity getObjetivo(Long rutinasId, Long objetivosId) throws BusinessLogicException {
        Long[] array = {objetivosId,rutinasId};
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el objetivo con id = {0} de la rutina con id ={1} ", array);
        List<ObjetivoEntity> objetivos = rutinaPersistence.find(rutinasId).getObjetivos();
        ObjetivoEntity objetivoEntity = objetivoPersistence.find(objetivosId);
        int index = objetivos.indexOf(objetivoEntity);
        Long[] array2 = {objetivosId,rutinasId};
        LOGGER.log(Level.INFO, "Termina proceso de consultar el objetivo con id = {0} de la rutina con id = {1}",array2);
        if (index >= 0) {
            return objetivos.get(index);
        }
        throw new BusinessLogicException("El objetivo no está asociado a la rutina");
    }

    /**
     * Remplazar objetivos de una rutina
     *
     * @param objetivos Lista de objetivos que serán los de la rutina.
     * @param rutinasId El id de la rutina que se quiere actualizar.
     * @return La lista de objetivos actualizada.
     */
    public List<ObjetivoEntity> replaceObjetivos(Long rutinasId, List<ObjetivoEntity> objetivos) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar la rutina con id = {0}", rutinasId);

        List<ObjetivoEntity> objetivoList = objetivoPersistence.findAll();
        RutinaEntity rutinaEntity = rutinaPersistence.find(rutinasId);
        for (ObjetivoEntity objetivo : objetivoList) {
            if (objetivos.contains(objetivo)) {
                objetivo.setRutina(rutinaEntity);
                
            } else if (objetivo.getRutina() != null && objetivo.getRutina().equals(rutinaEntity)) {
                objetivo.setRutina(null);
            }
        }
        LOGGER.log(Level.INFO, "Termina proceso de actualizar la rutina con id = {0}", rutinasId);
        return objetivos;
    }
    
}
