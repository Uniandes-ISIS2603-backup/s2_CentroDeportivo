/*

* To change this license header, choose License Headers in Project Properties.

* To change this template file, choose Tools | Templates

* and open the template in the editor.

*/
package co.edu.uniandes.csw.centrodeportivo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que representa un objetivo en la persistencia y permite su serialización
 *
 * @author Leidy Romero
 */
@Entity
public class ObjetivoEntity extends BaseEntity implements Serializable {

    @Override
    public int hashCode() {
        int hash = 5;
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ObjetivoEntity other = (ObjetivoEntity) obj;
        if (!Objects.equals(this.descripcion, other.descripcion)) {
            return false;
        }
        if (!Objects.equals(this.fechaLimite, other.fechaLimite)) {
            return false;
        }
        if (!Objects.equals(this.cumplio, other.cumplio)) {
            return false;
        }
        if (!Objects.equals(this.deportista, other.deportista)) {
            return false;
        }
        if (!Objects.equals(this.rutina, other.rutina)) {
            return false;
        }
        if (!Objects.equals(this.casosExitosos, other.casosExitosos)) {
            return false;
        }
        if (!Objects.equals(this.especialista, other.especialista)) {
            return false;
        }
        return true;
    }
    
    private String descripcion;
    
    private Boolean cumplio;
    private String fechaLimite;
    
    @PodamExclude
    @ManyToOne
    private DeportistaEntity deportista;
    
    @PodamExclude
    @ManyToOne
    private RutinaEntity rutina;
    
    @PodamExclude
    @OneToMany(mappedBy = "objetivo")
    private List<DeportistaEntity> casosExitosos = new ArrayList<>();
    
    @PodamExclude
    @ManyToOne
    private EspecialistaEntity especialista;
    
    /**
     * Obtiene la colección de casos exitosos.
     *
     * @return colección casos exitosos.
     */
    public List<DeportistaEntity> getCasosExitosos()
    {
        return this.casosExitosos;
    }
    
    /**
     * Establece el valor de la colección de casos exitosos.
     *
     * @param pDeportistas nuevo valor de la colección.
     */
    public void setCasosExitosos(List<DeportistaEntity> pDeportistas)
    {
        this.casosExitosos = pDeportistas;
    }
    
    /**
     * Modifica el caso exitoso al que pertenece el objetivo.
     *
     * @param pDeportista El nuevo deportista.
     */
    public void setDeportista(DeportistaEntity pDeportista)
    {
        this.deportista = pDeportista;
    }
    
    /**
     * Devuelve el deportista al que pertenece el objetivo.
     *
     * @return Una entidad de deportista.
     */
    public DeportistaEntity getDeportista()
    {
        return deportista;
    }
    
    /**
     * Modifica el especialista al que pertenece el objetivo.
     *
     * @param pEspecialista El nuevo especialista.
     */
    public void setEspecialista(EspecialistaEntity pEspecialista)
    {
        this.especialista = pEspecialista;
    }
    
    /**
     * Devuelve el especialista al que pertenece el objetivo.
     *
     * @return Una entidad de especialista.
     */
    public EspecialistaEntity getEspecialista()
    {
        return especialista;
    }
    
    /**
     * Modifica la rutina a la que pertenece el objetivo.
     *
     * @param pRutina La nueva rutina.
     */
    public void setRutina(RutinaEntity pRutina)
    {
        this.rutina = pRutina;
    }
    
    /**
     * Devuelve la rutina a la que pertenece el objetivo.
     *
     * @return Una entidad de rutina.
     */
    public RutinaEntity getRutina()
    {
        return rutina;
    }
    
    /**
     * Devuelve el DESCRIPCION del objetivo.
     * @return the id
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * Modifica la DESCRIPCION del objetivo.
     * @param pDescripcion descripcion nueva
     */
    public void setDescripcion(String pDescripcion) {
        this.descripcion = pDescripcion;
    }
    
    /**
     * Devuelve el estado del objetivo del objetivo.
     * @return true si se cumplió el objetivo y false en caso contrario.
     */
    public Boolean getCumplio() {
        return cumplio;
    }
    
    /**
     * Modifica el estado del objetivo.
     * @param pCumplio nuevo estado
     */
    public void setCumplio(Boolean pCumplio) {
        this.cumplio = pCumplio;
    }
    
    /**
     * Devuelve la fecha limite del objetivo del objetivo.
     * @return fecha
     */
    public String getFechaLimite() {
        return fechaLimite;
    }
    
    /**
     * Modifica la fecha limite del objetivo.
     * @param pFechaLimite nueva fecha limite
     */
    public void setFechaLimite(String pFechaLimite) {
        this.fechaLimite = pFechaLimite;
    }
    
}