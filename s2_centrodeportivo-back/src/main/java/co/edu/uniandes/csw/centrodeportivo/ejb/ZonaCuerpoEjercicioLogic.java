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
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author estudiante
 */
@Stateless
public class ZonaCuerpoEjercicioLogic {
    private static final Logger LOGGER = Logger.getLogger(ZonaCuerpoEjercicioLogic.class.getName());

    @Inject
    private EjercicioPersistence ejercicioPersistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    @Inject
    private ZonaCuerpoPersistence zonaCuerpoPersistence; // Variable para acceder a la persistencia de la aplicación. Es una inyección de dependencias.

    /**
     * Agregar un autor a un premio
     *
     * @param zonasCuerpoId El id premio a guardar
     * @param ejerciciosId El id del autor al cual se le va a guardar el premio.
     * @return El premio que fue agregado al autor.
     */
    public EjercicioEntity addEjercicio(Long ejerciciosId, Long zonasCuerpoId) {
        LOGGER.log(Level.INFO, "Inicia proceso de asociar el autor con id = {0} al premio con id = " + zonasCuerpoId, ejerciciosId);
        EjercicioEntity autorEntity = ejercicioPersistence.find(ejerciciosId);
        ZonaCuerpoEntity zonaCuerpoEntity = zonaCuerpoPersistence.find(zonasCuerpoId);
        zonaCuerpoEntity.setEjercicio(autorEntity);
        LOGGER.log(Level.INFO, "Termina proceso de asociar el autor con id = {0} al premio con id = " + zonasCuerpoId, ejerciciosId);
        return ejercicioPersistence.find(ejerciciosId);
    }

    /**
     *
     * Obtener un premio por medio de su id y el de su autor.
     *
     * @param zonasCuerpoId id del premio a ser buscado.
     * @return el autor solicitada por medio de su id.
     */
    public EjercicioEntity getEjercicio(Long zonasCuerpoId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el autor del premio con id = {0}", zonasCuerpoId);
        EjercicioEntity ejercicioEntity = zonaCuerpoPersistence.find(zonasCuerpoId).getEjercicio();
        LOGGER.log(Level.INFO, "Termina proceso de consultar el autor del premio con id = {0}", zonasCuerpoId);
        return ejercicioEntity;
    }

    /**
     * Remplazar autor de un premio
     *
     * @param zonasCuerpoId el id del premio que se quiere actualizar.
     * @param ejerciciosId El id del nuebo autor asociado al premio.
     * @return el nuevo autor asociado.
     */
    public EjercicioEntity replaceEjercicio(Long zonasCuerpoId, Long ejerciciosId) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el autor del premio premio con id = {0}", zonasCuerpoId);
        EjercicioEntity autorEntity = ejercicioPersistence.find(ejerciciosId);
        ZonaCuerpoEntity zonaCuerpoEntity = zonaCuerpoPersistence.find(zonasCuerpoId);
        zonaCuerpoEntity.setEjercicio(autorEntity);
        LOGGER.log(Level.INFO, "Termina proceso de asociar el autor con id = {0} al premio con id = " + zonasCuerpoId, ejerciciosId);
        return ejercicioPersistence.find(ejerciciosId);
    }

    /**
     * Borrar el autor de un premio
     *
     * @param zonasCuerpoId El premio que se desea borrar del autor.
     * @throws BusinessLogicException si el premio no tiene autor
     */
    public void removeEjercicio(Long zonasCuerpoId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el autor del premio con id = {0}", zonasCuerpoId);
        ZonaCuerpoEntity zonaCuerpoEntity = zonaCuerpoPersistence.find(zonasCuerpoId);
        if (zonaCuerpoEntity.getEjercicio() == null) {
            throw new BusinessLogicException("El premio no tiene autor");
        }
        EjercicioEntity ejercicioEntity = ejercicioPersistence.find(zonaCuerpoEntity.getEjercicio().getId());
        zonaCuerpoEntity.setEjercicio(null);
        ejercicioEntity.getZonasCuerpo().remove(zonaCuerpoEntity);
        LOGGER.log(Level.INFO, "Termina proceso de borrar el autor con id = {0} del premio con id = " + zonasCuerpoId, ejercicioEntity.getId());
    }
}
