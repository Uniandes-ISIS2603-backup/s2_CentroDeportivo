/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.dtos;

import co.edu.uniandes.csw.centrodeportivo.entities.DeportistaEntity;
import co.edu.uniandes.csw.centrodeportivo.entities.EjercicioEntity;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *aaa
 * @author estudiante
 */
public class EjercicioDTO 
{  
    public static final String TIPO_AEROBICO = "aerobico";
    
    public static final String TIPO_ANAEROBICO = "anaerobico";

    public static final String TIPO_FEXIBILIDAD = "flexibilidad";
    
    public static final String TIPO_EQUILIBRIO = "equilibrio";
    
    public static final String TIPO_RELAJACION = "relajacion";
    
    public static final String TIPO_TONIFICACION = "tonificacion";
    
    
    private Long id;
    
    private String nombre;
    
    private String categoria;
    
    private int duracion;
    
    private int numeroDeSeries;
    
    private String descripcion;
    
    private String explicacion;
    
    public Long getId(){
        return id;
    }
    
    public void setId(Long id)
    {
        this.id = id;
    }
    
    public String getNombre(){
        return nombre;
    }
    
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    public String getCategoria(){
        return categoria;
    }
    
    public void setCategoria(String categoria){
        this.categoria = categoria;
    }
    
    public int getDuracion(){
        return duracion;
    }
    
    public void setDuracion(int duracion){
        this.duracion = duracion;
    }
    
    public int getNumeroDeSeries()
    {
        return numeroDeSeries;
    }
    
    public void setNumeroDeSeries(int numeroDeSeries){
        this.numeroDeSeries = numeroDeSeries;
    }
    
    public String getDescripcion(){
        return descripcion;
    }
    
    public void setDescripcion(String descripcion){
        this.descripcion = descripcion;
    }
    
    public String getExplicacion(){
        return explicacion;
    }
    
    public void setExplicacion(String explicacion){
        this.explicacion = explicacion;
    }
 
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
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }

}
