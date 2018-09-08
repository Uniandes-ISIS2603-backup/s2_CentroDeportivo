/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;

import co.edu.uniandes.csw.centrodeportivo.dtos.SeguimientoDTO;
import co.edu.uniandes.csw.centrodeportivo.dtos.SeguimientoDetailDTO;
import co.edu.uniandes.csw.centrodeportivo.dtos.SeguimientoDTO;
import co.edu.uniandes.csw.centrodeportivo.ejb.SeguimientoLogic;
import co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException;
import java.util.List;
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
 * @author Lina Cardozo
 */
@Path("seguimientos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class SeguimientoResource {
    
    private static final Logger LOGGER = Logger.getLogger(SeguimientoResource.class.getName());
    
    @Inject
    private SeguimientoLogic seguimientoLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    
    /**
     * Crea un nuevo seguimiento con la informacion que se recibe en el cuerpo de
     * la petición y se regresa un objeto identico con un id auto-generado por
     * la base de datos.
     *
     * @param seguimiento {@link SeguimientoDTO} - El seguimiento que se desea
     * guardar.
     * @return JSON {@link SeguimientoDTO} - El seguimiento guardado con el atributo
     * id autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando ya existe el seguimiento.
     */
    @POST
    public SeguimientoDTO crearSeguimiento(SeguimientoDTO seguimiento) throws BusinessLogicException
    {
        /*LOGGER.log(Level.INFO, "SeguimientoResource createSeguimiento: input: {0}", seguimiento.toString());
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        SeguimientoEntity seguimientoEntity = seguimiento.toEntity();
        // Invoca la lógica para crear el seguimiento nuevo
        SeguimientoEntity nuevoSeguimientoEntity = SeguimientoLogic.createSeguimiento(seguimientoEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        SeguimientoDTO nuevoSeguimientoDTO = new SeguimientoDTO(nuevoSeguimientoEntity);
        LOGGER.log(Level.INFO, "SeguimientoResource createSeguimiento: output: {0}", nuevoSeguimientoDTO.toString());
        return nuevoSeguimientoDTO;*/
        return seguimiento;
    }
    
    /**
     * Busca y devuelve todos los seguimientos que existen en la aplicacion.
     *
     * @return JSONArray {@link SeguimientoDetailDTO} - Los seguimientos
     * encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<SeguimientoDetailDTO> getSeguimientos() {
        /*LOGGER.info("EditorialResource getEditorials: input: void");
        List<SeguimientoDetailDTO> listaSeguimientos = listEntity2DetailDTO(seguimientoLogic.getSeguimientos());
        LOGGER.log(Level.INFO, "EditorialResource getEditorials: output: {0}", listaSeguimientos.toString());
        return listaSeguimientos;*/
        return null;
    }
    
    /**
     * Busca el seguimiento con el id asociado recibido en la URL y lo devuelve.
     *
     * @param seguimientosId Identificador del seguimiento que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @return JSON {@link SeguimientoDetailDTO} - El seguimiento buscado
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el seguimiento.
     */
    @GET
    @Path("{seguimientosId: \\d+}")
    public SeguimientoDetailDTO getSeguimiento(@PathParam("seguimientosId") Long seguimientosId) throws WebApplicationException {
        /*LOGGER.log(Level.INFO, "SeguimientoResource getSeguimiento: input: {0}", seguimientosId);
        SeguimientoEntity seguimientoEntity = seguimientoLogic.getSeguimiento(seguimientosId);
        if (seguimientoEntity == null) {
            throw new WebApplicationException("El recurso /editorials/" + seguimientosId + " no existe.", 404);
        }
        SeguimientoDetailDTO detailDTO = new SeguimientoDetailDTO(seguimientoEntity);
        LOGGER.log(Level.INFO, "SeguimientoResource getSeguimiento: output: {0}", detailDTO.toString());
        return detailDTO;*/
        return null;
    }
    
    /**
     * Actualiza el seguimiento con el id recibido en la URL con la información
     * que se recibe en el cuerpo de la petición.
     *
     * @param seguimientosId Identificador del seguimiento que se desea
     * actualizar. Este debe ser una cadena de dígitos.
     * @param seguimiento {@link SeguimientoDetailDTO} El seguimiento que se desea
     * guardar.
     * @return JSON {@link SeguimientoDetailDTO} - El seguimiento guardado.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el seguimiento a
     * actualizar.
     */
    @PUT
    @Path("{seguimientosId: \\d+}")
    public SeguimientoDetailDTO updateSeguimiento(@PathParam("seguimientosId") Long seguimientosId, SeguimientoDetailDTO seguimiento) throws WebApplicationException 
    {
        return null;
    }
    
    /**
     * Borra el seguimiento con el id asociado recibido en la URL.
     *
     * @param seguimientosId Identificador del seguimiento que se desea borrar.
     * Este debe ser una cadena de dígitos.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se puede eliminar el seguimiento.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el seguimiento.
     */
    @DELETE
    @Path("{seguimientosId: \\d+}")
    public void deleteSeguimiento(@PathParam("seguimientosId") Long seguimientosId) throws BusinessLogicException {
        
    }
}