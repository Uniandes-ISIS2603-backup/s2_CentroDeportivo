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
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Francisco Jose MacAllister
 */
@Entity
public class RutinaEntity extends BaseEntity implements Serializable {
    public Integer identificadorRutina;
    public String nombre;
    public Boolean estadoTerminado;

     @PodamExclude
    @OneToMany(mappedBy = "rutina", fetch = javax.persistence.FetchType.LAZY)
    private List<ObjetivoEntity> objetivos = new ArrayList<ObjetivoEntity>();
     
     @PodamExclude
    @OneToMany(mappedBy = "rutina", fetch = javax.persistence.FetchType.LAZY)
    List<EjercicioEntity> ejercicios =new ArrayList<EjercicioEntity>();
     /**
     *pide indentificador unico de rutina por deportista
     * 
     */
    public Integer getIdentificadorRutina() {
        return identificadorRutina;
    }
/**
     * asigna identificado unoco de rutina por deportista
     * 
     */
    public void setIdentificadorRutina(Integer identificadorRutina) {
        this.identificadorRutina = identificadorRutina;
    }
/**
     * pide estado a rutina
     * 
     */
    public Boolean getEstadoTerminado() {
        return estadoTerminado;
    }
/**
     * asigna estado a rutina
     * 
     */
    public void setEstadoTerminado(Boolean estadoTerminado) {
        this.estadoTerminado = estadoTerminado;
    }
    /**
     * pide nombre a rutina
     * 
     */
    public String getNombre() {
        return nombre;
    }
/**
     * asigna nombre a rutina
     * 
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
   
    
    
    /**
     * Devuelve los objetivos de esta rutina
     * @return Collection los deportistas
     */
    public List<ObjetivoEntity> getObjetivos()
    {
      return this.objetivos;  
    }
    /**
     * asigna los objetivos de esta rutina
     * 
     */
    public void setObjetivos(List<ObjetivoEntity> deportistas)
    {
        this.objetivos=deportistas;
    }
    
    
    
    
    
    
    /**
     * Devuelve los deportistas que son asesorados por este deportista
     * @return Collection los deportistas
     */
    public List<EjercicioEntity> getEjercicios()
    {
      return this.ejercicios;  
    }
    public void setEjercicios(List<EjercicioEntity> ejercicios)
    {
        this.ejercicios=ejercicios;
    }
}
