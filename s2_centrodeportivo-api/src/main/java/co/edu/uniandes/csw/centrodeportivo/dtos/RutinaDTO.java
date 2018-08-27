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

/**
 *
 * @author estudiante
 */
@Path("rutina")
@Produces("aplication/json")
@Consumes("aplication/json")
@RequestScoped
public class RutinaDTO {
    private Long id;
    private String nombre;
    private boolean estadoTerminado;
   
    public RutinaDTO()
    {
        
    }
    @GET
    public boolean getEstado(String pNombre)
    {
        return true;
    }
    
}
