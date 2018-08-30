/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;

import co.edu.uniandes.csw.centrodeportivo.dtos.SeguimientoDTO;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author estudiante
 */
@Path("seguimientos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class SeguimientoResource {
    
    @POST
    public SeguimientoDTO crearSeguimiento(SeguimientoDTO seguimiento)
    {
        return null;
    }
    
}