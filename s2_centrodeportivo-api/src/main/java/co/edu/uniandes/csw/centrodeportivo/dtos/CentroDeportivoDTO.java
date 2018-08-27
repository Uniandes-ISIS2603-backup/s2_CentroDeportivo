/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.dtos;

/**
 *
 * @author dy.quintero
 */
public class CentroDeportivoDTO 
{
     /**
     * ID del centro deportivo
     */
    private Long id;
    /**
     * Nombre del centro deportivo
     */
    private String nombre;
    /**
     * Direccion del centro deportivo
     */
    private String direccion;
    /**
     * Telefono del centro deportivo
     */
    private int telefono;
    
    //METODOS
    
    /**
     * Metodo que retorna el id unico del centro deportivo
     *
     * @return Id unico del centro deportivo
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Metodo que retorna el nombre del centro deportivo
     *
     * @return el nombre del centro deportivo
     */
    public String getNombre(){
        return nombre;
    }
    
     /**
     * Metodo que retorna la direccion del centro deportivo
     *
     * @return la direccion del centro deportivo
     */
    public String getdireccion( ){
        return direccion;
    }
    
     /**
     * Metodo que retorna el telefono del centro deportivo
     *
     * @return el telefono del centro deportivo
     */
    public Integer getTelefono( ){
        return telefono;
    }
    
    /**
     * Actualizalos datos del centro deportivo
     *
     * @param pNombre - Nuevo nombre
     * @param pDireccion -  Nueva direccion 
     * @param pTelefono - Nuevo telefono
     */
    public void actualizarDatos(String pNombre , String pDireccion ,Integer pTelefono ) {
        this.nombre = pNombre;
        this.direccion = pDireccion;
        this.telefono = pTelefono;
    }
}


