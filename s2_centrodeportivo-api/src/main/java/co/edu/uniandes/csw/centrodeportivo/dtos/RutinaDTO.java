/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.dtos;

import co.edu.uniandes.csw.centrodeportivo.entities.RutinaEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;



/**
 *
 * @author Francisco Jose MacAllister
 */
public class RutinaDTO implements Serializable {
    
    public Long id;
    public Integer identificadorRutina;
    public String nombre;
    public Boolean estadoTerminado;
   
    public RutinaDTO()
    {
        
    }

    public RutinaDTO(RutinaEntity createRutina) {
        if(createRutina!=null)
        {
            this.estadoTerminado=createRutina.getEstadoTerminado();
            this.id=createRutina.getId();
            this.nombre=createRutina.getNombre();
        }
    }

    public int getIdentificadorRutina() {
        return identificadorRutina;
    }

    public void setIdentificadorRutina(int identificadorRutina) {
        this.identificadorRutina = identificadorRutina;
    }
      public void setId(Long id) {
        this.id = id;
    }
      public long getID()
      {
          return this.id;
      }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public boolean getEstadoTerminado() {
        return estadoTerminado;
    }

    public void setEstadoTerminado(boolean estadoTerminado) {
        this.estadoTerminado = estadoTerminado;
    }
     public RutinaEntity toEntity() {
        RutinaEntity rutinaEntity = new RutinaEntity();      
        rutinaEntity.setId(this.id);
        rutinaEntity.setNombre(this.nombre);
        rutinaEntity.setEstadoTerminado(this.estadoTerminado);
        return rutinaEntity;
    }
      @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
