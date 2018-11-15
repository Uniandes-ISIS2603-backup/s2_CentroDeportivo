/* 
* To change this license header, choose License Headers in Project Properties. 
* To change this template file, choose Tools | Templates 
* and open the template in the editor. 
*/ 
package co.edu.uniandes.csw.centrodeportivo.resources; 

import co.edu.uniandes.csw.centrodeportivo.dtos.DeportistaDTO;
import co.edu.uniandes.csw.centrodeportivo.dtos.DeportistaDetailDTO;
import co.edu.uniandes.csw.centrodeportivo.ejb.DeportistaLogic;
import co.edu.uniandes.csw.centrodeportivo.entities.DeportistaEntity;
import co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.centrodeportivo.mappers.BusinessLogicExceptionMapper;
import co.edu.uniandes.csw.centrodeportivo.mappers.WebApplicationExceptionMapper;
import java.io.Serializable;
import java.util.ArrayList;
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
* Clase que modela el recurso "deportistas". 
* @author Leidy Romero 
*/ 
@Path("deportistas") 
@Produces("application/json") 
@Consumes("application/json") 
@RequestScoped 
public class DeportistaResource implements Serializable{ 

    private static final Logger LOGGER = Logger.getLogger(DeportistaResource.class.getName());
    @Inject
    DeportistaLogic deportistaLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias. 

    /**
     * Crea un nuevo deportista con la informacion que se recibe en el cuerpo de
     * la petición y se regresa un objeto identico con un id auto-generado por
     * la base de datos.
     *
     * @param deportista {@link DeportistaDTO} - El deportista que se desea
     * guardar.
     * @return JSON {@link DeportistaDTO} - El deportista guardada con el
     * atributo id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando ya existe el deportista.
     */
    @POST
    public DeportistaDTO createDeportista(DeportistaDTO deportista) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "DeportistaResource createDeportista: input: {0}", deportista.toString());
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica. 
        DeportistaEntity deportistaEntity = deportista.toEntity();
        // Invoca la lógica para crear el deportista nuevo
        DeportistaEntity nuevoDeportistaEntity = deportistaLogic.createDeportista(deportistaEntity); 
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo 
        DeportistaDTO nuevoDeportistaDTO = new DeportistaDTO(nuevoDeportistaEntity); 
        LOGGER.log(Level.INFO, "DeportistaResource createDeportista: output: {0}", nuevoDeportistaDTO.toString()); 
        return nuevoDeportistaDTO; 
    }
    
    /**
     * Busca y devuelve todas los deportistas que existen en la aplicacion.
     *
     * @return JSONArray {@link DeportistaDTO} - Los deportistas encontrados en
     * la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<DeportistaDetailDTO> getDeportistas() {
        LOGGER.info("DeportistaResource getDeportistas: input: void");
        List<DeportistaDetailDTO> listaDeportistas = listEntity2DetailDTO(deportistaLogic.getDeportistas()); 
        LOGGER.log(Level.INFO, "DeportistaResource getDeportistas: output: {0}", listaDeportistas.toString()); 
        return listaDeportistas; 
    }
    
     /**
     * Busca el deportista con el id asociado recibido en la URL y la devuelve.
     *
     * @param deportistasId Identificador del deportista que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @return JSON {@link DeportistaDTO} - El deportista buscado
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el deportista.
     */
    @GET
    @Path("{deportistasId: \\d+}")
    public DeportistaDetailDTO getDeportista(@PathParam("deportistasId") Long deportistasId) throws WebApplicationException {
        LOGGER.log(Level.INFO, "DeportistaResource getDeportista: input: {0}", deportistasId);
        DeportistaEntity deportistaEntity = deportistaLogic.getDeportista(deportistasId); 
        if (deportistaEntity == null)  
            throw new WebApplicationException("El recurso /deportistas/" + deportistasId + " no existe.", 404); 
         
        DeportistaDetailDTO detailDTO = new DeportistaDetailDTO(deportistaEntity); 
        LOGGER.log(Level.INFO, "DeportistaResource getDeportista: output: {0}", detailDTO.toString()); 
        return detailDTO; 
    }
       /**
     * Actualiza el deportista con el id recibido en la URL con la informacion
     * que se recibe en el cuerpo de la petición.
     *
     * @param deportistasId Identificador del deportista que se desea
     * actualizar. Este debe ser una cadena de dígitos.
     * @param deportista {@link DeportistaDTO} El deportista que se desea
     * guardar.
     * @return JSON {@link DeportistaDTO} - El deportista guardado.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el deportista a
     * actualizar.
     */
    @PUT
    @Path("{deportistasId: \\d+}")
    public DeportistaDTO updateDeportista(@PathParam("deportistasId") Long deportistasId, DeportistaDTO deportista) throws WebApplicationException {

        LOGGER.log(Level.INFO, "DeportistaResource updateDeportista: input: id:{0} , deportista: {1}", new Object[]{deportistasId, deportista.toString()});
        deportista.setId(deportistasId);
        if (deportistaLogic.getDeportista(deportistasId) == null)  
            throw new WebApplicationException("El recurso /deportistas/" + deportistasId + " no existe.", 404);

        DeportistaDetailDTO detailDTO = new DeportistaDetailDTO(deportistaLogic.updateDeportista(deportistasId, deportista.toEntity())); 
        LOGGER.log(Level.INFO, "DeportistaResource updateDeportista: output: {0}", detailDTO.toString()); 
        return detailDTO; 
    }
    
    /**
     * Convierte una lista de Entity a una lista de DetailDTO.
     *
     * @param entityList Lista de Entity a convertir.
     * @return Lista de DetailDTO convertida.
     */
    private List<DeportistaDetailDTO> listEntity2DetailDTO(List<DeportistaEntity> entityList) {
        List<DeportistaDetailDTO> list = new ArrayList<>();
        for (DeportistaEntity entity : entityList) {
            list.add(new DeportistaDetailDTO(entity));
        }
        return list;
    }
    
     @Path("{deportistasId: \\d+}/objetivos")
    public Class<DeportistaObjetivoResource> getDeportistaObjetivosReosurce(@PathParam("deportistasId") Long deportistasId) {
        if (deportistaLogic.getDeportista(deportistasId) == null) {
            throw new WebApplicationException("El recurso /deportistas/" + deportistasId + " no existe.", 404);
        }
            return DeportistaObjetivoResource.class;
    }
    //ELIMINAR?
    
} 