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
 *
 * @author Francisco Jose MacAllister
 */

public class EspecialistaDTO implements Serializable {
    public Long id;
    public int cedula;
    public String nombre;
    public String especialidad;
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
     * @param especialistaEntity: Es la entidad que se va a convertir a DTO
     */
    public EspecialistaDTO(EspecialistaEntity nuevoEspecialistaEntity) {
         if (nuevoEspecialistaEntity != null) {
            this.id = nuevoEspecialistaEntity.getId();
            this.nombre = nuevoEspecialistaEntity.getNombre();
            this.cedula=nuevoEspecialistaEntity.getCedula();
            this.especialidad=nuevoEspecialistaEntity.getEspecialidad();
        }
    }
    /**
     * Devuelve el ID de la especialista.
     *
     * @return the id
     */
    public Long getId()
    {
        return id;
    }
    /**
     * Modifica el ID de la especialista.
     *
     * @param id the id to set
     */
    public void setId(Long id)
    {
        this.id=id;
    }
    /**
     * pide cedula al especialista.
     *
     * 
     */
    public int getCedula() {
        return cedula;
    }
/**
     * Asigna cedula al especialista.
     *
     * 
     */
    public void setCedula(int pCedula) {
        this.cedula=pCedula;
    }
/**
     * Devuelve el nombre de la especialista.
     *
     * @return the name
     */
    public String getNombre() {
        return nombre;
    }
/**
     * Modifica el nombre de la especialista.
     *
     * @param name the name to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
/**
     * pide especialidad al especialista.
     *
     * 
     */
    public String getEspecialidad() {
        return especialidad;
    }
/**
     * Asigna especialidad al especialista.
     *
     * 
     */
    public void setEspecialidad(String especialidad) {
        this.especialidad = especialidad;
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
        return especialistaEntity;

    }
   @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
