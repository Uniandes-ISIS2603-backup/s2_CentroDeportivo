/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;

/**
 *
 * @authorFrancisco Jose MacAllister y Leidy Romero
 */
@Entity
public class EspecialistaEntity extends BaseEntity implements Serializable {
  

    private String nombre;
    private String especialidad;

    /**
     * Modela la asociacion 1...* entre las clases Especialista y Deportista
     * se especifica fetch para especificar que no se deben cargar las
     * dos entidades al  mismo tiempo
     */
    @javax.persistence.OneToMany(mappedBy = "especialista",
            fetch = javax.persistence.FetchType.LAZY)
    Collection<DeportistaEntity> deportistas;
    /**
     * Devuelve los deportistas que son asesorados por este deportista
     * @return Collection los deportistas
     */
    public Collection<DeportistaEntity> getDeportistas()
    {
      return this.deportistas;  
    }
    
     /**
     * Modela la asociacion 1...* entre las clases Especialista y Objetivo
     * se especifica fetch para especificar que no se deben cargar las
     * dos entidades al  mismo tiempo
     */
    @javax.persistence.OneToMany(mappedBy = "especialista",
            fetch = javax.persistence.FetchType.LAZY)
    Collection<ObjetivoEntity> objetivos;
    /**
     * Devuelve los objetivos
     * @return Collection los objetivos
     */
    public Collection<ObjetivoEntity> getObjetivos()
    {
      return this.objetivos;  
    }
    
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
}
