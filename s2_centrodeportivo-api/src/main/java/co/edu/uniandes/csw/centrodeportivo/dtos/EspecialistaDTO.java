/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.dtos;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author Francisco Jose MacAllister
 */
@Path("especialista")
@Produces("aplication/json")
@Consumes("aplication/json")
@RequestScoped
public class EspecialistaDTO {
    private Long identificador;
    private int id;
    private String nombre;
    private String especialidad;
    @POST
    public EspecialistaDTO()
    {
        
    }
    @GET
    @Path("(especialistaId: \\d+")
    public EspecialistaDTO getEspecialista(@PathParam("especialistaId") Long especialistaId) throws WebApplicationException{
        return null;
    }
    {
        
    }
    @GET
    public String getNombre(int pIdentificador)
    {
        return null;
    }
    @GET
    public String getEspecialidad(int pIdentificador)
    {
        return null;
    }
    
    
}
