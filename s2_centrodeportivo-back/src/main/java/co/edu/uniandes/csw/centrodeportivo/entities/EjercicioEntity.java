/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.entities;

import java.io.Serializable;

/**
 *
 * @author estudiante
 */
public class EjercicioEntity extends BaseEntity implements Serializable
{
    private Long id;
    
    private String nombre;
    
    private String categoria;
    
    private int duracion;
    
    private int numeroDeSeries;
    
    private String descripcion;
    
    private String explicacion;
   
    
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    
    public String getNombre() {
        return nombre;
    }
    
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     
    public String getategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public int getDuracion() {
        return duracion;
    }
    
     public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
     
    public int getNumeroDeSeries() {
        return numeroDeSeries;
    }
    
    public void setNumeroDeSeries(int numeroDeSeries) {
        this.numeroDeSeries = numeroDeSeries;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getExplicacion() {
        return explicacion;
    }
    
    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }
}
