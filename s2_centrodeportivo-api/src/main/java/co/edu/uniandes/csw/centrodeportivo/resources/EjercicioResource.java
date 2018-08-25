/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;

/**
 *aa
 * @author estudiante
 */
public class EjercicioResource {
    
    public static final String TIPO_AEROBICO = "aerobico";
    
    public static final String TIPO_ANAEROBICO = "anaerobico";

    public static final String TIPO_FEXIBILIDAD = "flexibilidad";
    
    public static final String TIPO_EQUILIBRIO = "equilibrio";
    
    public static final String TIPO_RELAJACION = "relajacion";
    
    public static final String TIPO_TONIFICACION = "tonificacion";
    
    private String nombre;
    
    private String categoria;
    
    private int duracion;
    
    private int numeroDeSeries;
    
    private String descripcion;
    
    private String explicacion;
    
    public EjercicioDTO crearEjercicio(EjercicioDTO ejercicioDTO)
    {
        return null;
    }
}
