/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;
import co.edu.uniandes.csw.centrodeportivo.dtos.EjercicioDTO;
import co.edu.uniandes.csw.centrodeportivo.ejb.EjercicioLogic;
import co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;
/**
 *aa
 * @author Daniel Pardo
 */
@Path("ejercicios")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class EjercicioResource {
    private static final Logger LOGGER = Logger.getLogger(DeportistaResource.class.getName());
    @Inject
    EjercicioLogic ejercicioLogic;
    
    @POST
    public EjercicioDTO createEjercicio(EjercicioDTO ejercicio) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "EjercicioResource createEjercicio: input: {0}", ejercicio.toString());
        return ejercicio;
    }

    @GET
    public List<EjercicioDTO> getEjercicios() {
        LOGGER.info("EjercicioResource getEjercicios: input: void"); 
        return null;
    }
    
    @GET
    @Path("{ejerciciosId: \\d+}")
    public EjercicioDTO getEjercicico(@PathParam("ejerciciosId") Long ejerciciosId) throws WebApplicationException
    {
        LOGGER.log(Level.INFO, "EjercicioResource getEjercicio input: {0}", ejerciciosId);

        return null;
    }
   
    @PUT
    @Path("{ejerciciosId: \\d+}")
    public EjercicioDTO updateEjercicio(@PathParam("ejerciciosId") Long ejerciciosId, EjercicioDTO ejercicio) throws WebApplicationException {

        LOGGER.log(Level.INFO, "EjercicioResource updateEjercicio: input: id:{0} , ejercicio: {1}", new Object[]{ejerciciosId, ejercicio.toString()});
        ejercicio.setId(ejerciciosId);

        return null;
    }
    @DELETE
    @Path("{ejerciciosId: \\d+}")
    public void deleteEjercicio(@PathParam("ejerciciosId") Long ejerciciosId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "EjercicioResource deleteEjercicio: input: {0}", ejerciciosId);
    }

}
