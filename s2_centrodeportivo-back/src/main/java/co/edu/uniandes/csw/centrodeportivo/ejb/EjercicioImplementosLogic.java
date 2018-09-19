/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.ejb;

import co.edu.uniandes.csw.centrodeportivo.entities.EjercicioEntity;
import co.edu.uniandes.csw.centrodeportivo.entities.ImplementoEntity;
import co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.centrodeportivo.persistence.EjercicioPersistence;
import co.edu.uniandes.csw.centrodeportivo.persistence.ImplementoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author estudiante
 */
@Stateless
public class EjercicioImplementosLogic {
    
    
    private static final Logger LOGGER = Logger.getLogger(EjercicioImplementosLogic.class.getName());

    @Inject
    private ImplementoPersistence implementoPersistence;

    @Inject
    private EjercicioPersistence ejercicioPersistence;

    /**
     * Agregar un implemento a la ejercicio
     *
     * @param implementosId El id libro a guardar
     * @param ejerciciosId El id de la ejercicio en la cual se va a guardar el
     * libro.
     * @return El libro creado.
     */
    public ImplementoEntity addImplemento(Long implementosId, Long ejerciciosId) {
        LOGGER.log(Level.INFO, "Inicia proceso de agregarle un libro a la ejercicio con id = {0}", ejerciciosId);
        EjercicioEntity ejercicioEntity = ejercicioPersistence.find(ejerciciosId);
        ImplementoEntity implementoEntity = implementoPersistence.find(implementosId);
        implementoEntity.setEjercicio(ejercicioEntity);
        LOGGER.log(Level.INFO, "Termina proceso de agregarle un libro a la ejercicio con id = {0}", ejerciciosId);
        return implementoEntity;
    }

    /**
     * Retorna todos los implementos asociados a una ejercicio
     *
     * @param ejerciciosId El ID de la ejercicio buscada
     * @return La lista de libros de la ejercicio
     */
    public List<ImplementoEntity> getImplementos(Long ejerciciosId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar los libros asociados a la ejercicio con id = {0}", ejerciciosId);
        return ejercicioPersistence.find(ejerciciosId).getImplementos();
    }

    /**
     * Retorna un implemento asociado a una ejercicio
     *
     * @param ejerciciosId El id de la ejercicio a buscar.
     * @param implementosId El id del libro a buscar
     * @return El libro encontrado dentro de la ejercicio.
     * @throws BusinessLogicException Si el libro no se encuentra en la
     * ejercicio
     */
    public ImplementoEntity getImplemento(Long ejerciciosId, Long implementosId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el libro con id = {0} de la ejercicio con id = " + ejerciciosId, implementosId);
        List<ImplementoEntity> implementos = ejercicioPersistence.find(ejerciciosId).getImplementos();
        ImplementoEntity implementoEntity = implementoPersistence.find(implementosId);
        int index = implementos.indexOf(implementoEntity);
        LOGGER.log(Level.INFO, "Termina proceso de consultar el libro con id = {0} de la ejercicio con id = " + ejerciciosId, implementosId);
        if (index >= 0) {
            return implementos.get(index);
        }
        throw new BusinessLogicException("El libro no está asociado a la ejercicio");
    }

    /**
     * Remplazar implementos de una ejercicio
     *
     * @param implementos Lista de libros que serán los de la ejercicio.
     * @param ejerciciosId El id de la ejercicio que se quiere actualizar.
     * @return La lista de libros actualizada.
     */
    public List<ImplementoEntity> replaceImplementos(Long ejerciciosId, List<ImplementoEntity> implementos) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el ejercicio con id = {0}", ejerciciosId);
        EjercicioEntity ejercicioEntity = ejercicioPersistence.find(ejerciciosId);
        List<ImplementoEntity> implementoList = implementoPersistence.findAll();
        
        for (ImplementoEntity implemento : implementoList) {
            if (implementos.contains(implemento)) {
                implemento.setEjercicio(ejercicioEntity);
            } else if (implemento.getEjercicio() != null && implemento.getEjercicio().equals(ejercicioEntity)) {
                implemento.setEjercicio(null);
            }
        }
        LOGGER.log(Level.INFO, "Termina proceso de actualizar la ejercicio con id = {0}", ejerciciosId);
        return implementos;
    }
}
