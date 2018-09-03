/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.entities;

/**
 *
 * @author estudiante
 */
public class ZonaCuerpoEntity 
{
    private String nombre;
    
    private Long id; 
    
    public void setId (Long id)
    {
         this.id = id;
    }
     
    public Long getId() {
        return id;
    }
    
    public void setNombre(String nombre)
    {
         this.nombre = nombre;
    }
    
    public String getNombre( )
    {
        return nombre;
    }
    
}
