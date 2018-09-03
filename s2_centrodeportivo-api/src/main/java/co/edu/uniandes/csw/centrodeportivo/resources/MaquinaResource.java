/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;
import co.edu.uniandes.csw.centrodeportivo.dtos.MaquinaDTO;
import java.io.Serializable;
import java.util.Collection;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;


/**
 *
 * @author dy.quintero
 */
@Path("maquinas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class MaquinaResource implements Serializable{
    
    @POST
    public MaquinaDTO createCentroDeportivo(MaquinaDTO maquina)
    {
        return maquina;
    }
    
    @GET
    public Collection<MaquinaDTO> getMaquinas()
    {
        return null;
    }
    
    @GET
    @Path("{maquinasId: \\d+}")
    public MaquinaDTO getMaquina(@PathParam("maquinasId") Long maquinasId) {
       
        return null;
    }
    
    @PUT
    @Path("{maquinasId: \\d+}")
    public MaquinaDTO actualizarAtributos(@PathParam("maquinasId") Long maquinasId)
    {
        return null;
    }
    
    @DELETE
    @Path("{maquinasId: \\d+}")
    public void eliminarMaquina(@PathParam("maquinasId") Long maquinasId)
    {
  
    }
}
