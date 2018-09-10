/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;

import co.edu.uniandes.csw.centrodeportivo.dtos.RutinaDetailDTO;
import co.edu.uniandes.csw.centrodeportivo.dtos.RutinaDTO;
import co.edu.uniandes.csw.centrodeportivo.ejb.RutinaLogic;
import co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author Francisco Jose MacAllister
 */
@Path("rutinas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class RutinaResource {
     private static final Logger LOGGER = Logger.getLogger(RutinaResource.class.getName());
      
    @Inject
    RutinaLogic rutinaLogic;
      @POST
    public RutinaDTO createCentroDeportivo(RutinaDTO rutina)
    {
        return rutina;
    }
    /**
     * Busca y devuelve todos los rutinas que existen en la aplicacion.
     *
     * @return JSONArray {@link RutinaDetailDTO} - Los rutinas
     * encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    /*@GET
    public List<RutinaDetailDTO> getRutinas() {
        /*LOGGER.info("EditorialResource getEditorials: input: void");
        List<RutinaDetailDTO> listaRutinas = listEntity2DetailDTO(rutinaLogic.getRutinas());
        LOGGER.log(Level.INFO, "EditorialResource getEditorials: output: {0}", listaRutinas.toString());
        return listaRutinas;
        return null;
    }*/
    
    /**
     * Busca el rutina con el id asociado recibido en la URL y lo devuelve.
     *
     * @param rutinasId Identificador del rutina que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @return JSON {@link RutinaDetailDTO} - El rutina buscado
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el rutina.
     */
    @GET
    @Path("{rutinasId: \\d+}")
    public RutinaDetailDTO getRutina(@PathParam("rutinasId") Long rutinasId) throws WebApplicationException {
        /*LOGGER.log(Level.INFO, "RutinaResource getRutina: input: {0}", rutinasId);
        RutinaEntity rutinaEntity = rutinaLogic.getRutinas(rutinasId);
        if (rutinaEntity == null) {
            throw new WebApplicationException("El recurso /rutina/" + rutinaId + " no existe.", 404);
        }
        RutinaDetailDTO detailDTO = new RutinaDetailDTO(rutinaEntity);
        LOGGER.log(Level.INFO, "RutinaResource getRutina: output: {0}", detailDTO.toString());
        return detailDTO;*/
        return null;
    }
    
    /**
     * Actualiza el rutina con el id recibido en la URL con la información
     * que se recibe en el cuerpo de la petición.
     *
     * @param rutinasId Identificador del rutina que se desea
     * actualizar. Este debe ser una cadena de dígitos.
     * @param rutina {@link RutinaDetailDTO} El rutina que se desea
     * guardar.
     * @return JSON {@link RutinaDetailDTO} - El rutina guardado.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el rutina a
     * actualizar.
     */
    @PUT
    @Path("{rutinasId: \\d+}")
    public RutinaDetailDTO updateRutina(@PathParam("rutinasId") Long rutinasId, RutinaDetailDTO rutina) throws WebApplicationException 
    {
        return null;
    }
    
    /**
     * Borra el rutina con el id asociado recibido en la URL.
     *
     * @param rutinasId Identificador del rutina que se desea borrar.
     * Este debe ser una cadena de dígitos.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se puede eliminar el rutina.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el rutina.
     */
    @DELETE
    @Path("{rutinasId: \\d+}")
    public void deleteRutina(@PathParam("rutinasId") Long rutinasId) throws BusinessLogicException {
        
    }
    
}
