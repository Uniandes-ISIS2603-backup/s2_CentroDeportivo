/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.dtos;

import java.io.Serializable;

/**
 *
 * @author estudiante
 */
public class ImplementoDTO implements Serializable {
    
    public Long id;
    public String nombre;
    
    public ImplementoDTO()
    {
        
    }
    
    public Long getId()
    {
        return id;
    }
    
    public String getNombre()
    {
        return nombre;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
}