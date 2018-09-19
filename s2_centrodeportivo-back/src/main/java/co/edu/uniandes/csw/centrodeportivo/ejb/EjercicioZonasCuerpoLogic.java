/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.ejb;

import co.edu.uniandes.csw.centrodeportivo.entities.EjercicioEntity;
import co.edu.uniandes.csw.centrodeportivo.entities.ZonaCuerpoEntity;
import co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.centrodeportivo.persistence.EjercicioPersistence;
import co.edu.uniandes.csw.centrodeportivo.persistence.ZonaCuerpoPersistence;
import java.util.List;
import java.util.logging.Level;
import javax.inject.Inject;
import java.util.logging.Logger;

/**
 *
 * @author estudiante
 */
public class EjercicioZonasCuerpoLogic 
{
    
    private static final Logger LOGGER = Logger.getLogger(EjercicioZonasCuerpoLogic.class.getName());

    @Inject
    private ZonaCuerpoPersistence zonaCuerpoPersistence;

    @Inject
    private EjercicioPersistence ejercicioPersistence;

    /**
     * Agregar un zonaCuerpo a la ejercicio
     *
     * @param zonasCuerpoId El id libro a guardar
     * @param ejerciciosId El id de la ejercicio en la cual se va a guardar el
     * libro.
     * @return El libro creado.
     */
    public ZonaCuerpoEntity addZonaCuerpo(Long zonasCuerpoId, Long ejerciciosId) {
        LOGGER.log(Level.INFO, "Inicia proceso de agregarle un libro a la ejercicio con id = {0}", ejerciciosId);
        EjercicioEntity ejercicioEntity = ejercicioPersistence.find(ejerciciosId);
        ZonaCuerpoEntity zonaCuerpoEntity = zonaCuerpoPersistence.find(zonasCuerpoId);
        zonaCuerpoEntity.setEjercicio(ejercicioEntity);
        LOGGER.log(Level.INFO, "Termina proceso de agregarle un libro a la ejercicio con id = {0}", ejerciciosId);
        return zonaCuerpoEntity;
    }

    /**
     * Retorna todos los zonasCuerpo asociados a una ejercicio
     *
     * @param ejerciciosId El ID de la ejercicio buscada
     * @return La lista de libros de la ejercicio
     */
    public List<ZonaCuerpoEntity> getZonasCuerpo(Long ejerciciosId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar los libros asociados a la ejercicio con id = {0}", ejerciciosId);
        return ejercicioPersistence.find(ejerciciosId).getZonasCuerpo();
    }

    /**
     * Retorna un zonaCuerpo asociado a una ejercicio
     *
     * @param ejerciciosId El id de la ejercicio a buscar.
     * @param zonasCuerpoId El id del libro a buscar
     * @return El libro encontrado dentro de la ejercicio.
     * @throws BusinessLogicException Si el libro no se encuentra en la
     * ejercicio
     */
    public ZonaCuerpoEntity getZonaCuerpo(Long ejerciciosId, Long zonasCuerpoId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el libro con id = {0} de la ejercicio con id = " + ejerciciosId, zonasCuerpoId);
        List<ZonaCuerpoEntity> zonasCuerpo = ejercicioPersistence.find(ejerciciosId).getZonasCuerpo();
        ZonaCuerpoEntity zonaCuerpoEntity = zonaCuerpoPersistence.find(zonasCuerpoId);
        int index = zonasCuerpo.indexOf(zonaCuerpoEntity);
        LOGGER.log(Level.INFO, "Termina proceso de consultar el libro con id = {0} de la ejercicio con id = " + ejerciciosId, zonasCuerpoId);
        if (index >= 0) {
            return zonasCuerpo.get(index);
        }
        throw new BusinessLogicException("El libro no está asociado a la ejercicio");
    }

    /**
     * Remplazar zonasCuerpo de una ejercicio
     *
     * @param zonasCuerpo Lista de libros que serán los de la ejercicio.
     * @param ejerciciosId El id de la ejercicio que se quiere actualizar.
     * @return La lista de libros actualizada.
     */
    public List<ZonaCuerpoEntity> replaceZonasCuerpo(Long ejerciciosId, List<ZonaCuerpoEntity> zonasCuerpo) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el ejercicio con id = {0}", ejerciciosId);
        EjercicioEntity ejercicioEntity = ejercicioPersistence.find(ejerciciosId);
        List<ZonaCuerpoEntity> zonaCuerpoList = zonaCuerpoPersistence.findAll();
        
        for (ZonaCuerpoEntity zonaCuerpo : zonaCuerpoList) {
            if (zonasCuerpo.contains(zonaCuerpo)) {
                zonaCuerpo.setEjercicio(ejercicioEntity);
            } else if (zonaCuerpo.getEjercicio() != null && zonaCuerpo.getEjercicio().equals(ejercicioEntity)) {
                zonaCuerpo.setEjercicio(null);
            }
        }
        LOGGER.log(Level.INFO, "Termina proceso de actualizar la ejercicio con id = {0}", ejerciciosId);
        return zonasCuerpo;
    }
}
