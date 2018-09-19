/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;

import co.edu.uniandes.csw.centrodeportivo.dtos.EjercicioDTO;
import co.edu.uniandes.csw.centrodeportivo.dtos.ZonaCuerpoDTO;
import co.edu.uniandes.csw.centrodeportivo.ejb.EjercicioLogic;
import co.edu.uniandes.csw.centrodeportivo.ejb.ZonaCuerpoEjercicioLogic;
import co.edu.uniandes.csw.centrodeportivo.ejb.ZonaCuerpoLogic;
import co.edu.uniandes.csw.centrodeportivo.mappers.WebApplicationExceptionMapper;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 *
 * @author Daniel Pardo
 */
@Path("zonasCuerpo/{zonasCuerpoId: \\d+}/ejercicio")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class ZonaCuerpoEjercicioResource {
    private static final Logger LOGGER = Logger.getLogger(ZonaCuerpoEjercicioResource.class.getName());

    @Inject
    private ZonaCuerpoLogic zonaCuerpoLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    @Inject
    private ZonaCuerpoEjercicioLogic zonaCuerpoEjercicioLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    @Inject
    private EjercicioLogic ejercicioLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    /**
     * Remplaza la instancia de Ejercicio asociada a un ZonaCuerpo.
     *
     * @param zonasCuerpoId Identificador del libro que se esta actualizando. Este
     * debe ser una cadena de dígitos.
     * @param ejercicio La ejercicio que se será del libro.
     * @return JSON {@link ZonaCuerpoDTO} - El arreglo de libros guardado en la
     * ejercicio.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la ejercicio o el
     * libro.
     */
    @PUT
    public ZonaCuerpoDTO replaceEjercicio(@PathParam("zonasCuerpoId") Long zonasCuerpoId, EjercicioDTO ejercicio) {
        LOGGER.log(Level.INFO, "ZonaCuerpoEjercicioResource replaceEjercicio: input: zonasCuerpoId{0} , Ejercicio:{1}", new Object[]{zonasCuerpoId, ejercicio.toString()});
        if (zonaCuerpoLogic.getZonaCuerpo(zonasCuerpoId) == null) {
            throw new WebApplicationException("El recurso /zonasCuerpo/" + zonasCuerpoId + " no existe.", 404);
        }
        if (ejercicioLogic.getEjercicio(ejercicio.getId()) == null) {
            throw new WebApplicationException("El recurso /ejercicios/" + ejercicio.getId() + " no existe.", 404);
        }
        ZonaCuerpoDTO zonaCuerpoDTO = new ZonaCuerpoDTO(zonaCuerpoEjercicioLogic.replaceEjercicio(zonasCuerpoId, ejercicio.getId()));
        LOGGER.log(Level.INFO, "ZonaCuerpoEjercicioResource replaceEjercicio: output: {0}", zonaCuerpoDTO.toString());
        return zonaCuerpoDTO;
    }
}
