/* 

* To change this license header, choose License Headers in Project Properties. 

* To change this template file, choose Tools | Templates 

* and open the template in the editor. 

 */
package co.edu.uniandes.csw.centrodeportivo.entities;

import java.io.Serializable;
import java.util.Collection;

import java.util.Date;

import javax.persistence.Entity;

/**  *
 *
 *
 * @author Leidy Romero  *
 */
@Entity
public class ObjetivoEntity extends BaseEntity implements Serializable {

    private String descripcion;

    private Boolean cumplio;

    private Date fechaLimite;

     /**
     * Modela la asociacion *...1 entre las clases Objetivo y (hacia) Deportista
     */
    @javax.persistence.ManyToOne()
    DeportistaEntity deportista;
    
     /**
     * Modela la asociacion *...1 entre las clases Objetivo y (hacia) Especialista
     */
    @javax.persistence.ManyToOne()
    EspecialistaEntity especialista;
        
     /**
     * Modela la asociacion 1...* entre las clases Objetivo Y (hacia) Deportista
     * se especifica fetch para especificar que no se deben cargar las
     * dos entidades al  mismo tiempo
     */
    @javax.persistence.OneToMany(mappedBy = "objetivo",
            fetch = javax.persistence.FetchType.LAZY)
    Collection<DeportistaEntity> deportistas;
    /**
     * Devuelve los deportistas que en el historial, han completado este objetivo (casos exitosos)
     * @return Collection los deportistas
     */
    public Collection<DeportistaEntity> getDeportistas()
    {
      return this.deportistas;  
    }
    
    /**      *
     * Devuelve el DESCRIPCION del objetivo.      *
     * @return the id      *
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**      *
     * Modifica la DESCRIPCION del objetivo.      *
     * @param pDescripcion descripcion nueva      *
     */
    public void setDescripcion(String pDescripcion) {
        this.descripcion = pDescripcion;
    }

    /**      *
     * Devuelve el estado del objetivo del objetivo. 
     * @return si o no      *
     */
    public Boolean getCumplio() {
        return cumplio;
    }

    /**
     * Modifica el estado del objetivo.
     */
    public void setCumplio() {
        this.cumplio = !cumplio;
    }

    /**
     * Devuelve la fecha limite del objetivo del objetivo.
     * @return fecha
     */
    public Date getFechaLimite() {
        return fechaLimite;
    }

    /**
     * Modifica la fecha limite del objetivo. 
     * @param pFechaLimite nueva fecha limite 
     */
    public void setFechaLimite(Date pFechaLimite) {
        this.fechaLimite = pFechaLimite;
    }
    
 
    

}
