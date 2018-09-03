/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;

/**
 *
 * @author Lina Cardozo
 */
@Entity
public class ImplementoEntity extends BaseEntity implements Serializable {
    
    private static final long serialVersionUID =1L;
    
    
    private Long id;
    
    private String nombre;
    
    public ImplementoEntity()
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
