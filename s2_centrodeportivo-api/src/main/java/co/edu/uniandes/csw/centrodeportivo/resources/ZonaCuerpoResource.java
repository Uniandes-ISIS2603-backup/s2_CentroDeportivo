/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;

import co.edu.uniandes.csw.centrodeportivo.dtos.ZonaCuerpoDTO;
import co.edu.uniandes.csw.centrodeportivo.ejb.ZonaCuerpoLogic;
import co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException;
import java.util.List;
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
 * @author Daniel Pardo
 */
@Path("zonasCuerpo")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ZonaCuerpoResource  
{
    private static final Logger LOGGER = Logger.getLogger(DeportistaResource.class.getName());
    @Inject
    ZonaCuerpoLogic ejercicioLogic;
    
    @POST
    public ZonaCuerpoDTO createZonaCuerpo(ZonaCuerpoDTO ejercicio) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "ZonaCuerpoResource createZonaCuerpo: input: {0}", ejercicio.toString());
        return ejercicio;
    }

    @GET
    public List<ZonaCuerpoDTO> getZonasCuerpo() {
        LOGGER.info("ZonaCuerpoResource getZonasCuerpo: input: void"); 
        return null;
    }
    
    @GET
    @Path("{ejerciciosId: \\d+}")
    public ZonaCuerpoDTO getZonaCuerpo(@PathParam("ejerciciosId") Long zonasCuerpoId) throws WebApplicationException
    {
        LOGGER.log(Level.INFO, "ZonaCuerpoesource getZonaCuerpo input: {0}", zonasCuerpoId);

        return null;
    }
   
    @PUT
    @Path("{ejerciciosId: \\d+}")
    public ZonaCuerpoDTO updateZonaCuerpo(@PathParam("zonasCuerpoId") Long zonasCuerpoId, ZonaCuerpoDTO zonaCuerpo) throws WebApplicationException {

        LOGGER.log(Level.INFO, "ZonaCuerpo updateZonaCuerpo: input: id:{0} , objetivo: {1}", new Object[]{zonasCuerpoId, zonaCuerpo.toString()});
        zonaCuerpo.setId(zonasCuerpoId);

        return null;
    }
    @DELETE
    @Path("{zonasCuerpoId: \\d+}")
    public void deleteZonaCuerpo(@PathParam("zonasCuerpoId") Long zonasCuerpoId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "ZonaCuerpoResource deleteZonaCuerpo: input: {0}", zonasCuerpoId);
    }

   
    
}
