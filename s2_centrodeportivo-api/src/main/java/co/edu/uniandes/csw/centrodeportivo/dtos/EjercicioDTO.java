/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.dtos;

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
    public String getNombre(){
        return nombre;
    }
    public String getCategoria(){
        return categoria;
    }
    public int getDuracion(){
        return duracion;
    }
    public int getNumeroDeSeries()
    {
        return numeroDeSeries;
    }
    public String getDescripcion(){
        return descripcion;
    }
    public String getExplicacion(){
        return explicacion;
    }
    
    public void actualizarDatos(String pNombre , String pCategoria ,Integer pDuracion,Integer pNumeroDeSeries,String pDescripcion,String pExplicacion ) {
        this.nombre = pNombre;
        this.categoria = pCategoria;
        this.duracion = pDuracion;
        this.numeroDeSeries = pNumeroDeSeries;
        this.descripcion = pDescripcion;
        this.explicacion = pExplicacion;
                 
    }
    
}
