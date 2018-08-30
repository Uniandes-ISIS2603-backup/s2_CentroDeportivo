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
    *
    * Metodo que cambia la cantidad de calorias
    */
    public void setCalorias( double pCalorias ){
        this.calorias = pCalorias;
    }
    
    /**
    *
    * Metodo que cambia el tiempo
    */
    public void setTiempo( int pTiempo ){
        this.tiempo = pTiempo;
    }
    
    /**
    *
    * Metodo que cambia la velocidad
    */
    public void setVelocidad( double pVelocidad )
    {
        this.velocidad = pVelocidad;
    }
    
    /**
    *
    * Metodo que cambia la velocidad promedio
    */
    public void setVelocidadPromedio( double pVelocidadPromedio ){
        this.velocidadPromedio = pVelocidadPromedio;
    }        
}   
