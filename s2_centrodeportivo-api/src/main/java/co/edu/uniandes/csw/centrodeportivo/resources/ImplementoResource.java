/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;

import co.edu.uniandes.csw.centrodeportivo.dtos.ImplementoDTO;
import co.edu.uniandes.csw.centrodeportivo.dtos.ImplementoDetailDTO;
import co.edu.uniandes.csw.centrodeportivo.ejb.ImplementoLogic;
import co.edu.uniandes.csw.centrodeportivo.entities.ImplementoEntity;
import co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author Lina Cardozo
 */
@Path("implementos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ImplementoResource {
    
    private static final Logger LOGGER = Logger.getLogger(ImplementoResource.class.getName());
    
    @Inject
    private ImplementoLogic implementoLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    
    /**
     * Crea un nuevo implemento con la informacion que se recibe en el cuerpo de
     * la petición y se regresa un objeto identico con un id auto-generado por
     * la base de datos.
     *
     * @param implemento {@link ImplementoDTO} - El implemento que se desea
     * guardar.
     * @return JSON {@link ImplementoDTO} - El implemento guardado con el atributo
     * id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando ya existe el implemento.
     */
    @POST
    public ImplementoDTO crearImplemento(ImplementoDTO implemento) throws BusinessLogicException
    {
        /*LOGGER.log(Level.INFO, "ImplementoResource createImplemento: input: {0}", implemento.toString());
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        ImplementoEntity implementoEntity = implemento.toEntity();
        // Invoca la lógica para crear el implemento nuevo
        ImplementoEntity nuevoImplementoEntity = ImplementoLogic.createImplemento(implementoEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        ImplementoDTO nuevoImplementoDTO = new ImplementoDTO(nuevoImplementoEntity);
        LOGGER.log(Level.INFO, "ImplementoResource createImplemento: output: {0}", nuevoImplementoDTO.toString());
        return nuevoImplementoDTO;*/
        return null;
    }
    
    /**
     * Busca y devuelve todos los implementos que existen en la aplicacion.
     *
     * @return JSONArray {@link ImplementoDetailDTO} - Los implementos
     * encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<ImplementoDetailDTO> getImplementos() {
        /*LOGGER.info("EditorialResource getEditorials: input: void");
        List<ImplementoDetailDTO> listaImplementos = listEntity2DetailDTO(implementoLogic.getImplementos());
        LOGGER.log(Level.INFO, "EditorialResource getEditorials: output: {0}", listaImplementos.toString());
        return listaImplementos;*/
        return null;
    }
    
    /**
     * Busca el implemento con el id asociado recibido en la URL y lo devuelve.
     *
     * @param implementosId Identificador del implemento que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @return JSON {@link ImplementoDetailDTO} - El implemento buscado
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el implemento.
     */
    @GET
    @Path("{implementosId: \\d+}")
    public ImplementoDetailDTO getImplemento(@PathParam("implementosId") Long implementosId) throws WebApplicationException {
        /*LOGGER.log(Level.INFO, "ImplementoResource getImplemento: input: {0}", implementosId);
        ImplementoEntity implementoEntity = implementoLogic.getImplemento(implementosId);
        if (implementoEntity == null) {
            throw new WebApplicationException("El recurso /editorials/" + implementosId + " no existe.", 404);
        }
        ImplementoDetailDTO detailDTO = new ImplementoDetailDTO(implementoEntity);
        LOGGER.log(Level.INFO, "ImplementoResource getImplemento: output: {0}", detailDTO.toString());
        return detailDTO;*/
        return null;
    }
    
    /**
     * Actualiza el implemento con el id recibido en la URL con la información
     * que se recibe en el cuerpo de la petición.
     *
     * @param implementosId Identificador del implemento que se desea
     * actualizar. Este debe ser una cadena de dígitos.
     * @param implemento {@link ImplementoDetailDTO} El implemento que se desea
     * guardar.
     * @return JSON {@link ImplementoDetailDTO} - El implemento guardado.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el implemento a
     * actualizar.
     */
    @PUT
    @Path("{implementosId: \\d+}")
    public ImplementoDetailDTO updateImplemento(@PathParam("implementosId") Long implementosId, ImplementoDetailDTO implemento) throws WebApplicationException 
    {
        return null;
    }
}