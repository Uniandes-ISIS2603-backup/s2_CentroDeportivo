/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.ejb;

import co.edu.uniandes.csw.centrodeportivo.entities.EjercicioEntity;
import co.edu.uniandes.csw.centrodeportivo.entities.MaquinaEntity;
import co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.centrodeportivo.persistence.EjercicioPersistence;
import co.edu.uniandes.csw.centrodeportivo.persistence.MaquinaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author estudiante
 */
public class EjercicioMaquinasLogic {
     
    
    private static final Logger LOGGER = Logger.getLogger(EjercicioMaquinasLogic.class.getName());

    @Inject
    private MaquinaPersistence maquinaPersistence;

    @Inject
    private EjercicioPersistence ejercicioPersistence;

    /**
     * Agregar un maquina a la ejercicio
     *
     * @param maquinasId El id libro a guardar
     * @param ejerciciosId El id de la ejercicio en la cual se va a guardar el
     * libro.
     * @return El libro creado.
     */
    public MaquinaEntity addMaquina(Long maquinasId, Long ejerciciosId) {
        LOGGER.log(Level.INFO, "Inicia proceso de agregarle un libro a la ejercicio con id = {0}", ejerciciosId);
        EjercicioEntity ejercicioEntity = ejercicioPersistence.find(ejerciciosId);
        MaquinaEntity maquinaEntity = maquinaPersistence.find(maquinasId);
        maquinaEntity.setEjercicio(ejercicioEntity);
        LOGGER.log(Level.INFO, "Termina proceso de agregarle un libro a la ejercicio con id = {0}", ejerciciosId);
        return maquinaEntity;
    }

    /**
     * Retorna todos los maquinas asociados a una ejercicio
     *
     * @param ejerciciosId El ID de la ejercicio buscada
     * @return La lista de libros de la ejercicio
     */
    public List<MaquinaEntity> getMaquinas(Long ejerciciosId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar los libros asociados a la ejercicio con id = {0}", ejerciciosId);
        return ejercicioPersistence.find(ejerciciosId).getMaquinas();
    }

    /**
     * Retorna un maquina asociado a una ejercicio
     *
     * @param ejerciciosId El id de la ejercicio a buscar.
     * @param maquinasId El id del libro a buscar
     * @return El libro encontrado dentro de la ejercicio.
     * @throws BusinessLogicException Si el libro no se encuentra en la
     * ejercicio
     */
    public MaquinaEntity getMaquina(Long ejerciciosId, Long maquinasId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el libro con id = {0} de la ejercicio con id = " + ejerciciosId, maquinasId);
        List<MaquinaEntity> maquinas = ejercicioPersistence.find(ejerciciosId).getMaquinas();
        MaquinaEntity maquinaEntity = maquinaPersistence.find(maquinasId);
        int index = maquinas.indexOf(maquinaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de consultar el libro con id = {0} de la ejercicio con id = " + ejerciciosId, maquinasId);
        if (index >= 0) {
            return maquinas.get(index);
        }
        throw new BusinessLogicException("El libro no está asociado a la ejercicio");
    }

    /**
     * Remplazar maquinas de una ejercicio
     *
     * @param maquinas Lista de libros que serán los de la ejercicio.
     * @param ejerciciosId El id de la ejercicio que se quiere actualizar.
     * @return La lista de libros actualizada.
     */
    public List<MaquinaEntity> replaceMaquinas(Long ejerciciosId, List<MaquinaEntity> maquinas) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el ejercicio con id = {0}", ejerciciosId);
        EjercicioEntity ejercicioEntity = ejercicioPersistence.find(ejerciciosId);
        List<MaquinaEntity> maquinaList = maquinaPersistence.findAll();
        
        for (MaquinaEntity maquina : maquinaList) {
            if (maquinas.contains(maquina)) {
                maquina.setEjercicio(ejercicioEntity);
            } else if (maquina.getEjercicio() != null && maquina.getEjercicio().equals(ejercicioEntity)) {
                maquina.setEjercicio(null);
            }
        }
        LOGGER.log(Level.INFO, "Termina proceso de actualizar la ejercicio con id = {0}", ejerciciosId);
        return maquinas;
    }
}
