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
    public String imagen;

    @PodamExclude
    @OneToMany(mappedBy = "especialista", fetch = javax.persistence.FetchType.LAZY)
    private List<DeportistaEntity> deportistas = new ArrayList<DeportistaEntity>();
    private List <ObjetivoEntity> objetivos = new ArrayList<ObjetivoEntity>();
   
    
    /**
     * pide nombre de Especialista
     * 
     */
    public String getNombre() {
        return nombre;
    }
/**
     * Asigna nombre a Especialista
     * 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
     * pide especialidad de Especialista
     * 
     */
    public String getEspecialidad() {
        return especialidad;
    }
/**
     * Asigna especialidad a Especialista
     * 
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
/**
     * Asigna cedula a Especialista
     * 
     */
    public void setCedula(Integer cedula) {
        this.cedula=cedula;
    }
    /**
     *pide cedula de especialista Especialista
     * 
     */
      public Integer getCedula() {
        return cedula;
    }
      
    /**
     * Asigna imagen al especialista.
     * @param imagen La nueva imagen del especialista
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
    /**
     * @return La imagen del especialista
     */
    public String getImagen() {
        return imagen;
    }

     /**
     * Devuelve los deportistas que son asesorados por este Especialista
     * @return Collection los deportistas
     */
    public List<DeportistaEntity> getDeportistas()
    {
      return deportistas;  
    }
    /**
     * Asigna deprotistas a especialista Especialista
     * 
     */
    public void setDeportistas(List<DeportistaEntity> deportistas)
    {
        deportistas=deportistas;
    }
    /**
     * Devuelve los objetivos de este Especialista
     * @return Collection los deportistas
     */
     public List<ObjetivoEntity> getObjetivos()
    {
      return objetivos;  
    }
     /**
     * Asigna objetivos a especialista Especialista
     * 
     */
    public void setObjetivos(List<ObjetivoEntity> listaObjetivos)
    {
      objetivos=listaObjetivos;  
    }
}
