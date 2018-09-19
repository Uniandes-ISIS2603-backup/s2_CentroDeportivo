/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.ejb;

import co.edu.uniandes.csw.centrodeportivo.entities.EjercicioEntity;
import co.edu.uniandes.csw.centrodeportivo.entities.ZonaCuerpoEntity;
import co.edu.uniandes.csw.centrodeportivo.persistence.EjercicioPersistence;
import co.edu.uniandes.csw.centrodeportivo.persistence.ZonaCuerpoPersistence;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 *
 * @author Daniel pardo
 */
@Stateless
public class ZonaCuerpoEjercicioLogic {
    private static final Logger LOGGER = Logger.getLogger(ZonaCuerpoEjercicioLogic.class.getName());

    @Inject
    private ZonaCuerpoPersistence zonaCuerpoPersistence;

    @Inject
    private EjercicioPersistence ejercicioPersistence;

    /**
     * Remplazar la ejercicio de un zonaCuerpo.
     *
     * @param zonasCuerpoId id del libro que se quiere actualizar.
     * @param ejerciciosId El id de la ejercicio que se será del libro.
     * @return el nuevo libro.
     */
    public ZonaCuerpoEntity replaceEjercicio(Long zonasCuerpoId, Long ejerciciosId) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar libro con id = {0}", zonasCuerpoId);
        EjercicioEntity ejercicioEntity = ejercicioPersistence.find(ejerciciosId);
        ZonaCuerpoEntity zonaCuerpoEntity = zonaCuerpoPersistence.find(zonasCuerpoId);
        zonaCuerpoEntity.setEjercicio(ejercicioEntity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar libro con id = {0}", zonaCuerpoEntity.getId());
        return zonaCuerpoEntity;
    }

    /**
     * Borrar un zonaCuerpo de una ejercicio. Este metodo se utiliza para borrar la
     * relacion de un libro.
     *
     * @param zonasCuerpoId El libro que se desea borrar de la ejercicio.
     */
    public void removeEjercicio(Long zonasCuerpoId) {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar la Ejercicio del libro con id = {0}", zonasCuerpoId);
        ZonaCuerpoEntity zonaCuerpoEntity = zonaCuerpoPersistence.find(zonasCuerpoId);
        EjercicioEntity ejercicioEntity = ejercicioPersistence.find(zonaCuerpoEntity.getEjercicio().getId());
        zonaCuerpoEntity.setEjercicio(null);
        ejercicioEntity.getZonasCuerpo().remove(zonaCuerpoEntity);
        LOGGER.log(Level.INFO, "Termina proceso de borrar la Ejercicio del libro con id = {0}", zonaCuerpoEntity.getId());
    }       
}
