/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.*;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @authorFrancisco Jose MacAllister y Leidy Romero
 */
@Entity
public class EspecialistaEntity extends BaseEntity implements Serializable {
  

    public String nombre;
    public String especialidad;
    public Integer cedula;

    @PodamExclude
    @OneToMany(mappedBy = "especialista", fetch = javax.persistence.FetchType.LAZY)
    private List<DeportistaEntity> deportistas = new ArrayList<DeportistaEntity>();
    private List <ObjetivoEntity> objetivos = new ArrayList<ObjetivoEntity>();
   
    
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEspecialidad() {
        return especialidad;
    }

    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }

    public void setCedula(Integer cedula) {
        this.cedula=cedula;
    }
      public Integer getCedula() {
        return cedula;
    }

     /**
     * Devuelve los deportistas que son asesorados por este deportista
     * @return Collection los deportistas
     */
    public List<DeportistaEntity> getDeportistas()
    {
      return deportistas;  
    }
    public void setDeportistas(List<DeportistaEntity> deportistas)
    {
        deportistas=deportistas;
    }
     public List<ObjetivoEntity> getObjetivos()
    {
      return objetivos;  
    }
    public void setObjetivos(List<ObjetivoEntity> listaObjetivos)
    {
      objetivos=listaObjetivos;  
    }
}
