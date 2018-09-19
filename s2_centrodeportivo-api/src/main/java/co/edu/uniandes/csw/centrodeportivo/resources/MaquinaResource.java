/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;
import co.edu.uniandes.csw.centrodeportivo.dtos.MaquinaDTO;
import co.edu.uniandes.csw.centrodeportivo.ejb.MaquinaLogic;
import co.edu.uniandes.csw.centrodeportivo.entities.MaquinaEntity;
import java.io.Serializable;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
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
    
    private static final Logger LOGGER = Logger.getLogger(MaquinaResource.class.getName());
    
    @Inject
    private MaquinaLogic maquinaLogic;
    
    @POST
    public MaquinaDTO createMaquina(MaquinaDTO maquina)
    {
        LOGGER.log(Level.INFO, "MaquinaResource createMaquina: input: {0}", maquina.toString());
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        MaquinaEntity maquinaEntity = maquina.toEntity();
        // Invoca la lógica para crear la editorial nueva
        MaquinaEntity nuevaMaquinaEntity = maquinaLogic.createMaquina(maquinaEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        MaquinaDTO nuevaMaquinaDTO = new MaquinaDTO(nuevaMaquinaEntity);
        LOGGER.log(Level.INFO, "MaquinaResource createMaquina: output: {0}", nuevaMaquinaDTO.toString());
        return nuevaMaquinaDTO;
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
    public MaquinaDTO actualizarAtributos(@PathParam("maquinasId") Long maquinasId, MaquinaDTO maquina)
    {
        return null;
    }
    
    @DELETE
    @Path("{maquinasId: \\d+}")
    public void eliminarMaquina(@PathParam("maquinasId") Long maquinasId)
    {
  
    }
}
