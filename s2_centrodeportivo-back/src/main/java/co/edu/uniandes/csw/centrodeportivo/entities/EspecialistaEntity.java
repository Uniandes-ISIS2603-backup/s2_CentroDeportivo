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
import javax.persistence.*;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que representa un especialista en la persistencia y permite su
 * serialización
 *
 * @authorFrancisco Jose MacAllister y Leidy Romero
 */
@Entity
public class EspecialistaEntity extends BaseEntity implements Serializable {
    
    private String nombre;
    private String especialidad;
    private Integer cedula;
    private String imagen;
    
    @PodamExclude
    @OneToMany(mappedBy = "especialista", fetch = javax.persistence.FetchType.LAZY)
    private List<DeportistaEntity> deportistas = new ArrayList<>();
    
    @PodamExclude
    @OneToMany(mappedBy = "especialista", fetch = javax.persistence.FetchType.LAZY)
    private List <ObjetivoEntity> objetivos = new ArrayList<>();
    
    /**
     * Devuelve el nombre de la editorial.
     *
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Modifica el nombre de la editorial.
     *
     * @param nombre el nombre nuevo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Devuelve la especialidad del especialista.
     *
     * @return la especialidad
     */
    public String getEspecialidad() {
        return especialidad;
    }
    
    /**
     * Modifica la especialidad del especialista.
     *
     * @param especialidad la especialidad nueva
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
    }
    
    /**
     * Modifica la cédula del especialista.
     *
     * @param cedula la cédula nueva
     */
    public void setCedula(Integer cedula) {
        this.cedula=cedula;
    }
    
    /**
     * Devuelve la cédula del especialista.
     *
     * @return la cédula
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
     * Devuelve la imagen del especialista.
     * @return La imagen del especialista
     */
    public String getImagen() {
        return imagen;
    }
    
    /**
     * Devuelve los deportistas que son asesorados por este Especialista
     * @return colección de los deportistas
     */
    public List<DeportistaEntity> getDeportistas()
    {
        return deportistas;
    }
    
    /**
     * Asigna deportistas a especialista Especialista
     *
     * @param deportistas Los nuevos deportistas.
     */
    public void setDeportistas(List<DeportistaEntity> deportistas)
    {
        this.deportistas=deportistas;
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
     * Asigna objetivos al Especialista
     *
     * @param listaObjetivos Los nuevos objetivos.
     */
    public void setObjetivos(List<ObjetivoEntity> listaObjetivos)
    {
        this.objetivos=listaObjetivos;
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
        final EspecialistaEntity other = (EspecialistaEntity) obj;
        if (!Objects.equals(this.nombre, other.nombre))
        {
            return false;
        }
        if (!Objects.equals(this.cedula, other.cedula))
        {
            return false;
        }
        if (!Objects.equals(this.especialidad, other.especialidad))
        {
            return false;
        }
        if (!Objects.equals(this.imagen, other.imagen))
        {
            return false;
        }
        return Objects.equals(this.deportistas, other.deportistas);
    }

    @Override
    public int hashCode() {
        if (this.getId() != null) {
            return this.getId().hashCode();
        }
        return super.hashCode();
    }
}