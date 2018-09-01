/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.dtos;

import java.io.Serializable;

/**
 *
 * @author dy.quintero
 */
public class MaquinaDTO implements Serializable{
    
    private Long id;
    private String nombre;
    private double calorias;
    private int tiempo;
    private double velocidad;
    private double velocidadPromedio;
    
    public MaquinaDTO()
    {
        
    }
    
    /**
    *
    * Id unico de una maquina
     * @return 
    */
    public Long getId(){
        return id;
    }
    
    /**
    * Metodo que devuelve las calorias quemadas en la maquina
    * @return calorias quemadas en la maquina
    */
    public double getCalorias(){
        return calorias;
    }
    
    /**
    * Metodo que devuelve el tiempo de uso de la maquina
    * @return tiempo de uso de la maquina
    */
    public int getTiempo(){
        return tiempo;
    }
    
   /**
    * Metodo que devuelve la velocidad alcanzada en la la maquina
    * @return velocidad alcanzada en la maquina
    */
    public double getVelocidad()
    {
        return velocidad;
    }
    
    /**
    * Metodo que devuelve la velocidad promedio
    * @return la velocidad promedio
    */
    public double getVelocidadPromedio(){
        return velocidadPromedio;
    }
    /**
    * Metodo que devuelve el nombre de la maquina
    * @return la velocidad promedio
    */
    public String getNombre() {
        return nombre;
    }

     /**
    *
    * Metodo que cambia el nombre de la maquina
     * @param nombre
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
    *
    * Metodo que cambia la cantidad de calorias
     * @param pCalorias
    */
    public void setCalorias( double pCalorias ){
        this.calorias = pCalorias;
    }
    
    /**
    *
    * Metodo que cambia el tiempo
     * @param pTiempo
    */
    public void setTiempo( int pTiempo ){
        this.tiempo = pTiempo;
    }
    
    /**
    *
    * Metodo que cambia la velocidad
     * @param pVelocidad
    */
    public void setVelocidad( double pVelocidad )
    {
        this.velocidad = pVelocidad;
    }
    
    /**
    *
    * Metodo que cambia la velocidad promedio
     * @param pVelocidadPromedio
    */
    public void setVelocidadPromedio( double pVelocidadPromedio ){
        this.velocidadPromedio = pVelocidadPromedio;
    }        
}   
