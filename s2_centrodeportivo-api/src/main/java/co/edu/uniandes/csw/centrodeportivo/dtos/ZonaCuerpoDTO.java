/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.dtos;

import java.io.Serializable;

/**
 *aa
 * @author Daniel Pardo
 */
public class ZonaCuerpoDTO implements Serializable 
{
    /**
     * Id de la zona del cuerpo
     */
    private Long id;
    /**
     * Nombre de la zona del cuerpo
     */
    private String nombre;
    
    
    //Metodos
    
    /**
     * Metodo que retorna el id unico de la zona del cuerpo
     *
     * @return Id unico de la zona del cuerpo
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Metodo que retorna el nombre de la zona del cuerpo
     *
     * @return el nombre de la zona del cuerpo
     */
    public String getNombre( )
    {
        return nombre;
    }
    
    /**
     * Actualizalos datos de la zona del cuerpo
     *
     * @param pNombre - Nuevo nombre
     */
    public void actualizarZonaCuerpo(String pNombre ) {
        this.nombre = pNombre;
        
    }
    
    
}
