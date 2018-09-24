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
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author estudiante
 */
@Stateless
public class ImplementoEjercicioLogic {
    private static final Logger LOGGER = Logger.getLogger(ImplementoEjercicioLogic.class.getName());

    @Inject
    private EjercicioPersistence ejercicioPersistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    @Inject
    private ImplementoPersistence implementoPersistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     * Agregar un autor a un premio
     *
     * @param implementosId El id premio a guardar
     * @param ejerciciosId El id del autor al cual se le va a guardar el premio.
     * @return El premio que fue agregado al autor.
     */
    public EjercicioEntity addEjercicio(Long ejerciciosId, Long implementosId) {
        LOGGER.log(Level.INFO, "Inicia proceso de asociar el autor con id = {0} al premio con id = " + implementosId, ejerciciosId);
        EjercicioEntity autorEntity = ejercicioPersistence.find(ejerciciosId);
        ImplementoEntity implementoEntity = implementoPersistence.find(implementosId);
        implementoEntity.setEjercicio(autorEntity);
        LOGGER.log(Level.INFO, "Termina proceso de asociar el autor con id = {0} al premio con id = " + implementosId, ejerciciosId);
        return ejercicioPersistence.find(ejerciciosId);
    }

    /**
     *
     * Obtener un premio por medio de su id y el de su autor.
     *
     * @param implementosId id del premio a ser buscado.
     * @return el autor solicitada por medio de su id.
     */
    public EjercicioEntity getEjercicio(Long implementosId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el autor del premio con id = {0}", implementosId);
        EjercicioEntity ejercicioEntity = implementoPersistence.find(implementosId).getEjercicio();
        LOGGER.log(Level.INFO, "Termina proceso de consultar el autor del premio con id = {0}", implementosId);
        return ejercicioEntity;
    }

    /**
     * Remplazar autor de un premio
     *
     * @param implementosId el id del premio que se quiere actualizar.
     * @param ejerciciosId El id del nuebo autor asociado al premio.
     * @return el nuevo autor asociado.
     */
    public EjercicioEntity replaceEjercicio(Long implementosId, Long ejerciciosId) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el autor del premio premio con id = {0}", implementosId);
        EjercicioEntity autorEntity = ejercicioPersistence.find(ejerciciosId);
        ImplementoEntity implementoEntity = implementoPersistence.find(implementosId);
        implementoEntity.setEjercicio(autorEntity);
        LOGGER.log(Level.INFO, "Termina proceso de asociar el autor con id = {0} al premio con id = " + implementosId, ejerciciosId);
        return ejercicioPersistence.find(ejerciciosId);
    }

    /**
     * Borrar el autor de un premio
     *
     * @param implementosId El premio que se desea borrar del autor.
     * @throws BusinessLogicException si el premio no tiene autor
     */
    public void removeEjercicio(Long implementosId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el autor del premio con id = {0}", implementosId);
        ImplementoEntity implementoEntity = implementoPersistence.find(implementosId);
        if (implementoEntity.getEjercicio() == null) {
            throw new BusinessLogicException("El premio no tiene autor");
        }
        EjercicioEntity ejercicioEntity = ejercicioPersistence.find(implementoEntity.getEjercicio().getId());
        implementoEntity.setEjercicio(null);
        ejercicioEntity.getImplementos().remove(implementoEntity);
        LOGGER.log(Level.INFO, "Termina proceso de borrar el autor con id = {0} del premio con id = " + implementosId, ejercicioEntity.getId());
    }
}
