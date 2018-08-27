/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;
import co.edu.uniandes.csw.centrodeportivo.dtos.MaquinaDTO;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;


/**
 *
 * @author dy.quintero
 */
@Produces("maquina/json")
@Consumes("maquina/json")
@RequestScoped
public class MaquinaResource {
    
    @POST
    public MaquinaDTO createCentroDeportivo(MaquinaDTO maquina)
    {
        return maquina;
    }
}
