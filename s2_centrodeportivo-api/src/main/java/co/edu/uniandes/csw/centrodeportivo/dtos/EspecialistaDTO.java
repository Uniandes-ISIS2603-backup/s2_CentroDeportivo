/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.dtos;

import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
    
    public EspecialistaDTO()
    {
        
    }
    public String getNombre(int pIdentificador)
    {
        return null;
    }
    public String getEspecialidad(int pIdentificador)
    {
        return null;
    }
    
    
}
