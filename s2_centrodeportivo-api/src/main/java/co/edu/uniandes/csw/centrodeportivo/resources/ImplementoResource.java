/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;

import co.edu.uniandes.csw.centrodeportivo.dtos.ImplementoDTO;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author Lina Cardozo
 */
@Path("implementos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ImplementoResource {
    
    @POST
    public ImplementoDTO crearImplemento(ImplementoDTO implemento)
    {
        return null;
    }
    
    @GET
    @Path("{implementosId: \\d+}")
    public ImplementoDTO getImplemento(@PathParam("implementosId") Long implementosId) {
       
        return null;
    }
    
}