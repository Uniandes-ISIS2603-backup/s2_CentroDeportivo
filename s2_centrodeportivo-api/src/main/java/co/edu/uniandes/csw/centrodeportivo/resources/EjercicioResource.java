/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;
import co.edu.uniandes.csw.centrodeportivo.dtos.EjercicioDTO;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;
/**
 *aa
 * @author Daniel Pardo
 */
@Path("ejercicio")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class EjercicioResource {
    
    @POST
    public EjercicioDTO createEjercicio(EjercicioDTO ejercicio)
    {
        return ejercicio;
    }
    
    @GET
    @Path("(ejercicioId:\\d+)")
    public EjercicioDTO getEjercicio()
    {
        return null;
    }

   
    

}
