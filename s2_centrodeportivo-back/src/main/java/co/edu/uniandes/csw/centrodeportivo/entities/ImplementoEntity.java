/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author Lina Cardozo
 */
@Entity
public class ImplementoEntity extends BaseEntity implements Serializable {
    
    private static final long serialVersionUID =1L;
    
    private String nombre;
    
    public ImplementoEntity()
    {
        
    }
  
    /**
     * Devuelve el nombre del implemento.
     *
     * @return nombre del implemento
     */
    public String getNombre()
    {
        return nombre;
    }
    
    /**
     * Modifica el nombre del implemento.
     *
     * @param nombre El nombre a modificar
     */
    public void setNombre(String nombre)
    {
        this.nombre = nombre;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
