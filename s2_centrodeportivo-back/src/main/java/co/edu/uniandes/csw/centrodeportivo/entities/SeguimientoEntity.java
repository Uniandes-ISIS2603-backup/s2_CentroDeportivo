/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Lina Cardozo
 */
@Entity
public class SeguimientoEntity extends BaseEntity implements Serializable {
    
    private static final long serialVersionUID =1L;
    
    private Integer tiempo;
    private Double calorias;
    private Double velocidadPromedio;
    private Double ritmoCardiacoPromedio;
    
    public SeguimientoEntity()
    {
        
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
