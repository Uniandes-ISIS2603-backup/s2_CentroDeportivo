/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.uniandes.csw.centrodeportivo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que representa una máquina en la persistencia y permite su serialización
 *
 * @author Diany Quintero
 */
@Entity
public class MaquinaEntity extends BaseEntity implements Serializable {
    
    private String nombre;
    private String referencia;
    private String imagen;
    
    @PodamExclude
    @OneToMany(mappedBy = "maquina")
    private List<EjercicioEntity> ejercicios = new ArrayList<EjercicioEntity>();
    
    @PodamExclude
    @ManyToOne
    private SeguimientoEntity seguimiento;
    
    /**
     * Devuelve los ejercicios de la máquina.
     *
     * @return Lista de entidades de Ejercicio.
     */
    public List<EjercicioEntity> getEjercicios()
    {
        return this.ejercicios;
    }
    
    /**
     * Modifica los ejercicios de la máquina.
     *
     * @param pEjercicios Los nuevos ejercicios.
     */
    public void setEjercicios(List<EjercicioEntity> pEjercicios)
    {
        this.ejercicios = pEjercicios;
    }
    
    /**
     * Devuelve el seguimiento de la máquina.
     *
     * @return el seguimiento
     */
    public SeguimientoEntity getSeguimiento() {
        return seguimiento;
    }
    
    /**
     * Modifica el seguimiento de la máquina.
     *
     * @param seguimiento el seguimiento nuevo
     */
    public void setSeguimiento(SeguimientoEntity seguimiento) {
        this.seguimiento = seguimiento;
    }
    
    /**
     * Devuelve el nombre de la máquina.
     *
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Modifica el nombre de la máquina.
     *
     * @param nombre el nombre nuevo
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Devuelve la referencia de la máquina.
     *
     * @return la referencia
     */
    public String getReferencia() {
        return referencia;
    }
    
    /**
     * Modifica la referencia de la máquina.
     *
     * @param referencia la referencia nueva
     */
    public void setReferencia(String referencia) {
        this.referencia = referencia;
    }
    
    /**
     * Devuelve la imagen de la máquina.
     *
     * @return la imagen
     */
    public String getImagen() {
        return imagen;
    }
    
    /**
     * Modifica la imagen de la máquina.
     *
     * @param imagen la imagen nueva
     */
    public void setImagen(String imagen) {
        this.imagen = imagen;
    }
    
}