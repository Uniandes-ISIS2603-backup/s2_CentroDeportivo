/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;

import co.edu.uniandes.csw.centrodeportivo.dtos.EspecialistaDTO;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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

    
     @POST
    public EspecialistaDTO createCentroDeportivo(EspecialistaDTO especialista)
    {
        return especialista;
    }
}
