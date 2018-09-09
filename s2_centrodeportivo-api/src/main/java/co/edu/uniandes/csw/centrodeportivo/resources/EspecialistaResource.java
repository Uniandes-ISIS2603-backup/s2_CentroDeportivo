/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;

import co.edu.uniandes.csw.centrodeportivo.dtos.EspecialistaDTO;
import co.edu.uniandes.csw.centrodeportivo.ejb.EspecialistaLogic;
import co.edu.uniandes.csw.centrodeportivo.entities.EspecialistaEntity;
import co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
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
 @Inject
    EspecialistaLogic especialistaLogic;
    
    @POST
    public EspecialistaDTO createEspecialista(EspecialistaDTO especialista) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "EspecialistaResource createEspecialista: input: {0}", especialista.toString());
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        //EspecialistaEntity especialistaEntity = especialista.toEntity();
        // Invoca la lógica para crear la editorial nueva
        //EspecialistaEntity nuevoEspecialistaEntity = especialistaLogic.createEpecialista(especialistaEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        //EspecialistaDTO nuevoEspecialistaDTO = new EspecialistaDTO(nuevoEspecialistaEntity);
        //LOGGER.log(Level.INFO, "EditorialResource createEditorial: output: {0}", nuevoEditorialDTO.toString());
        return null;
    }

    
    
    
}
