/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;

import co.edu.uniandes.csw.centrodeportivo.dtos.EspecialistaDTO;

import co.edu.uniandes.csw.centrodeportivo.dtos.EspecialistaDetailDTO;
import co.edu.uniandes.csw.centrodeportivo.ejb.EspecialistaLogic;
import co.edu.uniandes.csw.centrodeportivo.entities.EspecialistaEntity;
import co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException;
import java.util.logging.Level;
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
 * @author estudiante
 */
@Path("especialistas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class EspecialistaResource {
     private static final Logger LOGGER = Logger.getLogger(EspecialistaResource.class.getName());
 @Inject
    EspecialistaLogic especialistaLogic;
    
    @POST
    public EspecialistaDTO createEspecialista(EspecialistaDTO especialista) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "EspecialistaResource createEspecialista: input: {0}", especialista.toString());
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        //EspecialistaEntity especialistaEntity = especialista.toEntity();
        // Invoca la lógica para crear la editorial nueva
        //EspecialistaEntity nuevoEspecialistaEntity = especialistaLogic.createEpecialista(especialistaEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        //EspecialistaDTO nuevoEspecialistaDTO = new EspecialistaDTO(nuevoEspecialistaEntity);
        //LOGGER.log(Level.INFO, "EditorialResource createEditorial: output: {0}", nuevoEditorialDTO.toString());
        return especialista;
    }
/**
     * Busca y devuelve todos los especialistas que existen en la aplicacion.
     *
     * @return JSONArray {@link EspecialistaDetailDTO} - Los especialistas
     * encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    /*@GET
    public List<EspecialistaDetailDTO> getEspecialistas() {
        /*LOGGER.info("EditorialResource getEditorials: input: void");
        List<EspecialistaDetailDTO> listaEspecialistas = listEntity2DetailDTO(especialistaLogic.getEspecialistas());
        LOGGER.log(Level.INFO, "EditorialResource getEditorials: output: {0}", listaEspecialistas.toString());
        return listaEspecialistas;
        return null;
    }*/
    
    /**
     * Busca el especialista con el id asociado recibido en la URL y lo devuelve.
     *
     * @param especialistasId Identificador del especialista que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @return JSON {@link EspecialistaDetailDTO} - El especialista buscado
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el especialista.
     */
    @GET
    @Path("{especialistasId: \\d+}")
    public EspecialistaDetailDTO getEspecialista(@PathParam("especialistasId") Long especialistasId) throws WebApplicationException {
        /*LOGGER.log(Level.INFO, "EspecialistaResource getEspecialista: input: {0}", especialistasId);
        EspecialistaEntity especialistaEntity = especialistaLogic.getEspecialistas(especialistasId);
        if (especialistaEntity == null) {
            throw new WebApplicationException("El recurso /especialista/" + especialistaId + " no existe.", 404);
        }
        EspecialistaDetailDTO detailDTO = new EspecialistaDetailDTO(especialistaEntity);
        LOGGER.log(Level.INFO, "EspecialistaResource getEspecialista: output: {0}", detailDTO.toString());
        return detailDTO;*/
        return null;
    }
    
    /**
     * Actualiza el especialista con el id recibido en la URL con la información
     * que se recibe en el cuerpo de la petición.
     *
     * @param especialistasId Identificador del especialista que se desea
     * actualizar. Este debe ser una cadena de dígitos.
     * @param especialista {@link EspecialistaDetailDTO} El especialista que se desea
     * guardar.
     * @return JSON {@link EspecialistaDetailDTO} - El especialista guardado.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el especialista a
     * actualizar.
     */
    @PUT
    @Path("{especialistasId: \\d+}")
    public EspecialistaDetailDTO updateEspecialista(@PathParam("especialistasId") Long especialistasId, EspecialistaDetailDTO especialista) throws WebApplicationException 
    {
        return null;
    }
    
    /**
     * Borra el especialista con el id asociado recibido en la URL.
     *
     * @param especialistasId Identificador del especialista que se desea borrar.
     * Este debe ser una cadena de dígitos.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se puede eliminar el especialista.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el especialista.
     */
    @DELETE
    @Path("{especialistasId: \\d+}")
    public void deleteEspecialista(@PathParam("especialistasId") Long especialistasId) throws BusinessLogicException {
        
    }
    
    
    
}
