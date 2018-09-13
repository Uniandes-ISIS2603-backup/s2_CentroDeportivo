/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.ejb;

import co.edu.uniandes.csw.centrodeportivo.entities.EjercicioEntity;
import co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.centrodeportivo.persistence.EjercicioPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author estudiante
 */
public class EjercicioLogic {
    private static final Logger LOGGER = Logger.getLogger(EjercicioLogic.class.getName());
    
    @Inject
    private EjercicioPersistence persistence;
    
     /**
     * Se encarga de crear una ejercicio en la base de datos.
     *
     * @param ejercicioEntity Objeto de tipo EjercicioEntity con los datos nuevos
     * @return Objeto de EjercicioEntity con los datos nuevos y su ID.
     */
    public EjercicioEntity createEjercicio(EjercicioEntity ejercicioEntity) {
        LOGGER.log(Level.INFO, "Inicia proceso de creación de la ejercicio");
        EjercicioEntity newEjercicioEntity = persistence.create(ejercicioEntity);
        LOGGER.log(Level.INFO, "Termina proceso de creación de la ejercicio");
        return newEjercicioEntity;
    }
    
    
     /**
     * Obtiene la lista de las ejercicios.
     *
     * @return Colección de objetos de Ejercicioentity.
     */
    public List<EjercicioEntity> getEjercicios() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las ejercicios");
        List<EjercicioEntity> lista = persistence.findAll();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todas las ejercicios");
        return lista;
    }
    
    /**
     * Obtiene los datos de una instancia de Mquina a partir de su ID.
     *
     * @param ejerciciosId Identificador de la instancia a consultar
     * @return Instancia de EjercicioEntity con los datos del Author consultado.
     */
    public EjercicioEntity getEjercicio(Long ejerciciosId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar la ejercicio con id = {0}", ejerciciosId);
        EjercicioEntity ejercicioEntity = persistence.find(ejerciciosId);
        if (ejercicioEntity == null) {
            LOGGER.log(Level.SEVERE, "la ejercicio con el id = {0} no existe", ejerciciosId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar la ejercicio con id = {0}", ejerciciosId);
        return ejercicioEntity;
    }
    
     /**
     * Actualiza la información de una instancia de Author.
     *
     * @param ejerciciosId Identificador de la instancia a actualizar
     * @param ejercicioEntity Instancia de EjercicioEntity con los nuevos datos.
     * @return Instancia de EjercicioEntity con los datos actualizados.
     */
    public EjercicioEntity updateEjercicio(Long ejerciciosId, EjercicioEntity ejercicioEntity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar la mquina con id = {0}", ejerciciosId);
        EjercicioEntity newEjercicioEntity = persistence.update(ejercicioEntity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar el autor con id = {0}", ejerciciosId);
        return newEjercicioEntity;
    }
    
     /**
     * Elimina una instancia de Ejercicio de la base de datos.
     *
     * @param ejerciciosId Identificador de la instancia a eliminar.
     * @throws BusinessLogicException si la ejercicio a eliminar no existe.
     */
    public void deleteEjercicio(Long ejerciciosId)throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar la ejercicio con id = {0}", ejerciciosId);
        if(getEjercicio(ejerciciosId)== null){
           throw new BusinessLogicException("No se puede borrar la ejercicio con id = "+ejerciciosId+" porque no existe en la base de datos");
        }
        persistence.delete(ejerciciosId);
        LOGGER.log(Level.INFO, "Termina proceso de borrar la ejercicio con id = {0}", ejerciciosId);
    }
}
