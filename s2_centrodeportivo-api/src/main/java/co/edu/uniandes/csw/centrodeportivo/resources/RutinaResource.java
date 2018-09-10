/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;

import co.edu.uniandes.csw.centrodeportivo.dtos.RutinaDTO;
import co.edu.uniandes.csw.centrodeportivo.ejb.RutinaLogic;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
}
