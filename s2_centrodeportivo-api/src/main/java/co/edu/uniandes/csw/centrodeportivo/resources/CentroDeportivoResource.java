/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;
import co.edu.uniandes.csw.centrodeportivo.dtos.CentroDeportivoDTO;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.*;


/**
 *
 * @author dy.quintero
 */
@Produces("centroDeportivo/json")
@Consumes("centroDeportivo/json")
@RequestScoped
public class CentroDeportivoResource {
    
    @POST
    public CentroDeportivoDTO createCentroDeportivo(CentroDeportivoDTO centro)
    {
        return centro;
    }
}