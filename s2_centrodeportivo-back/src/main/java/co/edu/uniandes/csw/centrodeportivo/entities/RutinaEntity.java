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
 * Clase que representa una rutina en la persistencia y permite su serialización
 *
 * @author Francisco Jose MacAllister
 */
@Entity
public class RutinaEntity extends BaseEntity implements Serializable {
    
    @PodamExclude
    @OneToMany(mappedBy = "rutina", fetch = javax.persistence.FetchType.LAZY)
    private List<ObjetivoEntity> objetivos = new ArrayList<ObjetivoEntity>();
    
    @PodamExclude
    @OneToMany(mappedBy = "rutina", fetch = javax.persistence.FetchType.LAZY)
    private List<EjercicioEntity> ejercicios =new ArrayList<EjercicioEntity>();
    
    private Integer identificadorRutina;
    private String nombre;
    private Boolean estadoTerminado;
    
    /**
     * Devuelve el identificador único de la rutina
     *
     * @return Identificador de la rutina
     */
    public Integer getIdentificadorRutina() {
        return identificadorRutina;
    }
    
    /**
     * Asigna identificador único a la rutina
     *
     * @param identificadorRutina Identificador nuevo de la rutina
     */
    public void setIdentificadorRutina(Integer identificadorRutina) {
        this.identificadorRutina = identificadorRutina;
    }
    
    /**
     * Retorna el estado de la rutina
     *
     * @return Estado de la rutina
     */
    public Boolean getEstadoTerminado() {
        return estadoTerminado;
    }
    
    /**
     * Modifica el estado de la rutina
     *
     * @param estadoTerminado Nuevo estado de la rutina
     */
    public void setEstadoTerminado(Boolean estadoTerminado) {
        this.estadoTerminado = estadoTerminado;
    }
    
    /**
     * Devuelve el nombre de la rutina
     *
     * @return Nombre de la rutina
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Modifica el nombre de la rutina
     *
     * @param nombre Nuevo nombre de la rutina
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Devuelve los objetivos de esta rutina
     * @return Lista de objetivos asociados a la rutina
     */
    public List<ObjetivoEntity> getObjetivos()
    {
        return this.objetivos;
    }
    
    /**
     * Modifica los objetivos de esta rutina
     *
     * @param objetivos Los nuevos objetivos
     */
    public void setObjetivos(List<ObjetivoEntity> objetivos)
    {
        this.objetivos=objetivos;
    }
    
    /**
     * Devuelve los ejercicios asociados a la rutina
     *
     * @return Ejercicios asociados a la rutina
     */
    public List<EjercicioEntity> getEjercicios()
    {
        return this.ejercicios;
    }
    
    /**
     * Modifica los ejercicios asociados a la rutina
     *
     * @param ejercicios Los nuevos ejercicios
     */
    public void setEjercicios(List<EjercicioEntity> ejercicios)
    {
        this.ejercicios=ejercicios;
    }
}