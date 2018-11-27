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
import javax.persistence.*;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Clase que representa un ejercicio en la persistencia y permite su serialización
 *
 * @author Daniel Pardo
 */
@Entity
public class EjercicioEntity extends BaseEntity implements Serializable
{
    //Atributos---------------
    private String nombre;
    
    private String categoria;
    
    private Integer duracion;
    
    private Integer numeroDeSeries;
    
    private String descripcion;
    
    private String explicacion;
    
    @PodamExclude
    @ManyToOne
    private RutinaEntity rutina;
    
    @PodamExclude
    @OneToOne
    private MaquinaEntity maquina;
    
    @PodamExclude
    @OneToMany(mappedBy = "ejercicio",fetch=FetchType.LAZY)
    private List<ZonaCuerpoEntity> zonasCuerpo = new ArrayList<ZonaCuerpoEntity>();
    
    //@PodamExclude
  //  @OneToMany(mappedBy = "ejercicio",fetch=FetchType.LAZY)
//    private List<MaquinaEntity> maquinas = new ArrayList<MaquinaEntity  >();
    
    @PodamExclude
    @OneToMany(mappedBy = "ejercicio",fetch=FetchType.LAZY)
    private List<ImplementoEntity> implementos = new ArrayList<ImplementoEntity>();
    
    /**
     * Devuelve la rutina a la que pertenece el ejercicio.
     *
     * @return Una entidad de rutina.
     */
    public RutinaEntity getRutina() {
        return rutina;
    }
    
    /**
     * Modifica la rutina a la que pertenece el ejercicio.
     *
     * @param rutina La nueva rutina.
     */
    public void setRutina(RutinaEntity rutina) {
        this.rutina = rutina;
    }
    
    /**
     * Devuelve la máquina a la que pertenece el ejercicio.
     *
     * @return Una entidad de máquina.
     */
    public MaquinaEntity getMaquina() {
        return maquina;
    }
    
    /**
     * Modifica la máquina a la que pertenece el ejercicio.
     *
     * @param maquinaEntity La nueva máquina.
     */
    public void setMaquina(MaquinaEntity maquinaEntity) {
        this.maquina = maquinaEntity;
    }
    
    /**
     * Devuelve las zonas del cuerpo del ejercicio.
     *
     * @return Lista de entidades de tipo ZonaCuerpo
     */
    public List<ZonaCuerpoEntity> getZonasCuerpo()
    {
        return this.zonasCuerpo;
    }
    
    /**
     * Modifica las zonas del cuerpo de un ejercicio.
     *
     * @param pZonasCuerpo Las nuevas zonas del cuerpo.
     */
    public void setZonasCuerpo(List<ZonaCuerpoEntity> pZonasCuerpo)
    {
        this.zonasCuerpo = pZonasCuerpo;
    }
    
    /**
     * Devuelve las máquinas del ejercicio.
     *
     * @return Lista de entidades de tipo Maquina
     */
   // public List<MaquinaEntity> getMaquinas()
    //{
      //  return this.maquinas;
    //}
    
    /**
     * Modifica las máquinas de un ejercicio.
     *
     * @param pMaquinas Las nuevas máquinas.
     */
   // public void setMaquinas(List<MaquinaEntity> pMaquinas)
    //{
      //  this.maquinas = pMaquinas;
    //}
    
    /**
     * Devuelve los implementos de un ejercicio
     *
     * @return Los implementos
     */
    public List<ImplementoEntity> getImplementos() {
        return implementos;
    }
    
    /**
     * Modifica los implementos de un ejercicio
     *
     * @param implementos Los nuevos implementos
     */
    public void setImplementos(List<ImplementoEntity> implementos) {
        this.implementos = implementos;
    }
    
    //---------------------------------------------------------------
    
    /**
     * Devuelve el nombre del ejercicio.
     *
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }
    
    /**
     * Modifica el nombre del ejercicio.
     *
     * @param nombre El nuevo nombre
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    
    /**
     * Devuelve la categoría del ejercicio.
     *
     * @return la categoría
     */
    public String getCategoria() {
        return categoria;
    }
    
    /**
     * Modifica la categoría del ejercicio.
     *
     * @param categoria La nueva categoría
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    /**
     * Devuelve la duración del ejercicio.
     *
     * @return la duración
     */
    public Integer getDuracion() {
        return duracion;
    }
    
    /**
     * Modifica la duración del ejercicio.
     *
     * @param duracion La nueva duración
     */
    public void setDuracion(Integer duracion) {
        this.duracion = duracion;
    }
    
    /**
     * Devuelve el número de series del ejercicio.
     *
     * @return el número de series
     */
    public Integer getNumeroDeSeries() {
        return numeroDeSeries;
    }
    
    /**
     * Modifica el número de series del ejercicio.
     *
     * @param numeroDeSeries El nuevo número de series
     */
    public void setNumeroDeSeries(Integer numeroDeSeries) {
        this.numeroDeSeries = numeroDeSeries;
    }
    
    /**
     * Devuelve la descripción del ejercicio.
     *
     * @return la descripción
     */
    public String getDescripcion() {
        return descripcion;
    }
    
    /**
     * Modifica la descripción del ejercicio.
     *
     * @param descripcion La nueva descripción
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    /**
     * Devuelve la explicación del ejercicio.
     *
     * @return la explicación
     */
    public String getExplicacion() {
        return explicacion;
    }
    
    /**
     * Modifica la explicación del ejercicio.
     *
     * @param explicacion La nueva explicación
     */
    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }
}