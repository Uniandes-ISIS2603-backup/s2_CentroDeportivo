/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.dtos;

import java.io.Serializable;

/**
 *
 * @author estudiante
 */
public class SeguimientoDTO implements Serializable {
    
    private Long id;
    private Integer tiempo;
    private Double calorias;
    private Double velocidadPromedio;
    private Double ritmoCardiacoPromedio;
    
    public SeguimientoDTO()
    {
        
    }

    public Long getId() 
    {
        return id;
    }
    
    public Integer getTiempo()
    {
        return tiempo;
    }
    
    public Double returnCalorias()
    {
        return calorias;
    }
    
    public Double getVelocidadPromedio()
    {
        return velocidadPromedio;
    }
    
    public Double getRitmoCardiacoPromedio()
    {
        return ritmoCardiacoPromedio;
    }

    public void setTiempo(Integer tiempo) {
        this.tiempo = tiempo;
    }

    public void setCalorias(Double calorias) {
        this.calorias = calorias;
    }

    public void setVelocidadPromedio(Double velocidadPromedio) {
        this.velocidadPromedio = velocidadPromedio;
    }

    public void setRitmoCardiacoPromedio(Double ritmoCardiacoPromedio) {
        this.ritmoCardiacoPromedio = ritmoCardiacoPromedio;
    }
    
}