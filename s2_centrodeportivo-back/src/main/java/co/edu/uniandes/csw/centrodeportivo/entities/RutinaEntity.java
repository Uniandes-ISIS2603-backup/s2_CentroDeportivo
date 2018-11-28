/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.uniandes.csw.centrodeportivo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
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
    private List<ObjetivoEntity> objetivos = new ArrayList<>();
    
    @PodamExclude
    @OneToMany(mappedBy = "rutina", fetch = javax.persistence.FetchType.LAZY)
    private List<EjercicioEntity> ejercicios =new ArrayList<>();
    
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
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final RutinaEntity other = (RutinaEntity) obj;
        if (!Objects.equals(this.nombre, other.nombre))
        {
            return false;
        }
        if (!Objects.equals(this.ejercicios, other.ejercicios))
        {
            return false;
        }
        if (!Objects.equals(this.identificadorRutina, other.identificadorRutina))
        {
            return false;
        }
        if (!Objects.equals(this.objetivos, other.objetivos))
        {
            return false;
        }
        return Objects.equals(this.estadoTerminado, other.estadoTerminado);
    }

    @Override
    public int hashCode() {
        if (this.getId() != null) {
            return this.getId().hashCode();
        }
        return super.hashCode();
    }
}