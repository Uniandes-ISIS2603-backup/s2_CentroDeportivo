/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.dtos;

import co.edu.uniandes.csw.centrodeportivo.entities.EjercicioEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Clase qque modela el ejercicio
 * @author Daniel Pardo
 */
public class EjercicioDTO implements Serializable
{  
    /**
     * Constante para el tipo de ejercicio aerobico
     */
    public static final String TIPO_AEROBICO = "aerobico";
    /**
     * Constante para el tipo de ejercicio anaerobico
     */
    public static final String TIPO_ANAEROBICO = "anaerobico";
    /**
     * Constante para el tipo de ejercicio flexibilidad
     */
    public static final String TIPO_FEXIBILIDAD = "flexibilidad";
     /**
     * Constante para el tipo de ejercicio equilibrio
     */
    public static final String TIPO_EQUILIBRIO = "equilibrio";
    /**
     * Constante para el tipo de ejercicio relajacion
     */
    public static final String TIPO_RELAJACION = "relajacion";
    /**
     * Constante para el tipo de ejercicio tonificacion
     */
    public static final String TIPO_TONIFICACION = "tonificacion";
    /**
     * Id del ejercicio
     */
    private Long id;
    /**
     * Nombre del ejercicio
     */
    private String nombre;
    /**
     * Categoria del ejercicio
     */
    private String categoria;
    /**
     * Duracion del ejercicio
     */
    private Integer duracion;
    /**
     * Numero de series del ejercicio
     */
    private Integer numeroDeSeries;
    /**
     * Desscripcion del ejercicio
     */
    private String descripcion;
    /**
     * Explicacion del ejercicio
     */
    private String explicacion;
    /**
     * Constructoor por defecto
     */
    public EjercicioDTO()
    { }
    /** 
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en      
     * la entidad que viene de argumento.      
     *
     * @param ejercicioEntity: Es la entidad que se va a convertir a DTO  
     */
    public EjercicioDTO(EjercicioEntity ejercicioEntity) {

        if (ejercicioEntity != null) {
            this.id = ejercicioEntity.getId();
            this.nombre = ejercicioEntity.getNombre();
            this.categoria = ejercicioEntity.getCategoria();
            this.duracion = ejercicioEntity.getDuracion();
            this.numeroDeSeries = ejercicioEntity.getNumeroDeSeries();
            this.descripcion = ejercicioEntity.getDescripcion();
            this.explicacion = ejercicioEntity.getExplicacion();    
        }
    }
    /**
     * Retorna el id del ejercicio
     * @return id
     */
    public Long getId(){
        return id;
    }
    /**
     * Cambia el id del ejercicio por el recibido por parametro
     * @param id 
     */
    public void setId(Long id)
    {
        this.id = id;
    }
    /**
     * Retorna el nombre del ejercicio
     * @return nombre
     */
    public String getNombre(){
        return nombre;
    }
    /**
     * Cambia el nombre del ejercicio por el recibido por parametro
     * @param nombre 
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    /**
     * Retorna la categoria del ejercicio
     * @return categoria
     */
    public String getCategoria(){
        return categoria;
    }
    /**
     * Cambia la categoria del ejercicio por la recibida por parametro
     * @param categoria 
     */
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    /**
     * Retorna la duracion del ejercicio
     * @return duracion
     */
    public Integer getDuracion(){
        return duracion;
    }
    /**
     * Cambia la duracion del ejercicio por la frecibida por parametro
     * @param duracion nueva
     */
    public void setDuracion(Integer duracion){
        this.duracion = duracion;
    }
    /**
     * Retorna el numero de series del ejercicio
     * @return numero de series
     */
    public Integer getNumeroDeSeries()
    {
        return numeroDeSeries;
    }
    /**
     * Cambia el numero de series del ejercicio por el recibido por parametro
     * @param numeroDeSeries nuevo
     */
    public void setNumeroDeSeries(Integer numeroDeSeries){
        this.numeroDeSeries = numeroDeSeries;
    }
    /**
     * Retorna la descripcion del ejercicio
     * @return descripcion
     */
    public String getDescripcion(){
        return descripcion;
    }
    /**
     * Cambia la descripcfcion del ejercicio por la recibida por parametro
     * @param descripcion nueva
     */
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    /**
     * Retorna la explicacion del ejercicio
     * @return explicacion
     */
    public String getExplicacion(){
        return explicacion;
    }
    /**
     * Cambia la explicacion del ejercicio por la reccibida por parametro
     * @param explicacion nueva
     */
    public void setExplicacion(String explicacion){
        this.explicacion = explicacion;
    }
    /** 
     * Convertir DTO a Entity      
     * @return Un Entity con los valores del DTO 
     */
    public EjercicioEntity toEntity() {
        EjercicioEntity ejercicioEntity = new EjercicioEntity();
        ejercicioEntity.setId(this.id);
        ejercicioEntity.setNombre(this.nombre);
        ejercicioEntity.setCategoria(this.categoria);
        ejercicioEntity.setDuracion(this.duracion);
        ejercicioEntity.setNumeroDeSeries(this.numeroDeSeries);
        ejercicioEntity.setDescripcion(this.descripcion);
        ejercicioEntity.setExplicacion(this.explicacion);
        return ejercicioEntity;
    }
    /**
     * Retorna el string de la clase
     * @return string
     */
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
