/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.dtos;

/**
 *
 * @author estudiante
 */
public class MaquinaDTO {
    
    private Long id;
    private double calorias;
    private int tiempo;
    private double velocidad;
    private double velocidadPromedio;
    
    public Long getId(){
        return id;
    }
    public double getCalorias(){
        return calorias;
    }
    public int getTiempo(){
        return tiempo;
    }
    public double getVelocidad()
    {
        return velocidad;
    }
    public double getVelocidadPromedio(){
        return velocidadPromedio;
    }
    
    public void finalizarSesion(double pCalorias, double pVelocidad,int pTiempo, double pVelocidadPromedio){
        this.calorias = pCalorias;
        this.velocidad = pVelocidad;
        this.tiempo = pTiempo;
        this.velocidadPromedio = pVelocidadPromedio;
    }
            
}   
