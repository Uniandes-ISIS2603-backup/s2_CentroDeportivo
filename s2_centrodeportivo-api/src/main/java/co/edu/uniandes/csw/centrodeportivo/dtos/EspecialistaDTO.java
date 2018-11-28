/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.uniandes.csw.centrodeportivo.dtos;

import co.edu.uniandes.csw.centrodeportivo.entities.EspecialistaEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Clase que modela un especialista.
 * @author Francisco Jose MacAllister
 */
public class EspecialistaDTO implements Serializable {
    
    //El id del especialista
    private Long id;
    //La cédula del especialista
    private Integer cedula;
    //El nombre del especialista
    private String nombre;
    //La especialidad del especialista
    private String especialidad;
    //La imagen del especialista
    private String imagen;
    
    /**
     * Constructor por defecto
     */
    public EspecialistaDTO()
    {
        
    }
    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param nuevoEspecialistaEntity: Es la entidad que se va a convertir a DTO
     */
    public EspecialistaDTO(EspecialistaEntity nuevoEspecialistaEntity) {
        if (nuevoEspecialistaEntity != null) {
            this.id = nuevoEspecialistaEntity.getId();
            this.nombre = nuevoEspecialistaEntity.getNombre();
            this.cedula=nuevoEspecialistaEntity.getCedula();
            this.especialidad=nuevoEspecialistaEntity.getEspecialidad();
            this.imagen = nuevoEspecialistaEntity.getImagen();
        }
    }
    /**
     * Devuelve el ID del especialista.
     *
     * @return El id del especialista
     */
    public Long getId()
    {
        return id;
    }
    /**
     * Modifica el ID del especialista.
     *
     * @param id El nuevo id del especialista
     */
    public void setId(Long id)
    {
        this.id=id;
    }
    /**
     * @return La cédula del especialista
     */
    public Integer getCedula() {
        return cedula;
    }
    /**
     * Asigna cédula al especialista.
     * @param pCedula La cédula nueva a asignar
     */
    public void setCedula(Integer pCedula) {
        this.cedula = pCedula;
    }
    /**
     * Devuelve el nombre del especialista.
     * @return El nombre del especialista
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Modifica el nombre del especialista.
     * @param nombre El nuevo nombre del especialista
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * @return La especialidad del especialista
     */
    public String getEspecialidad() {
        return especialidad;
    }
    
    /**
     * Asigna especialidad al especialista.
     * @param especialidad La nueva especialidad del especialista
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public EspecialistaEntity toEntity() {
        
        EspecialistaEntity especialistaEntity = new EspecialistaEntity();
        especialistaEntity.setId(this.id);
        especialistaEntity.setCedula(this.cedula);
        especialistaEntity.setNombre(this.nombre);
        especialistaEntity.setEspecialidad(this.especialidad);
        especialistaEntity.setImagen(this.imagen);
        return especialistaEntity;
        
    }
    
    /**
     * Retorna el string del DTO
     * @return string
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}