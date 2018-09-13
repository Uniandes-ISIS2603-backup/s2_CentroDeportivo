/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.entities;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;

/**
 *
 * @author Daniel Pardo
 */
@Entity
public class ZonaCuerpoEntity  extends BaseEntity implements Serializable
{
    private String nombre;
    
    
    //--------------------------------------
    
    @javax.persistence.ManyToOne()
    EjercicioEntity ejercicio;
    

    
    //----------------------------------------------
    
    
    //-----------------------------------------------

    public void setEjercicio(EjercicioEntity pEjercicio)
    {
        this.ejercicio = pEjercicio;
    }
    public EjercicioEntity getEjercicio()
    {
       return ejercicio;
    }
    //-----------------------------------------------
    public void setNombre(String nombre)
    {
         this.nombre = nombre;
    }
    
    public String getNombre( )
    {
        return nombre;
    }
    
}
