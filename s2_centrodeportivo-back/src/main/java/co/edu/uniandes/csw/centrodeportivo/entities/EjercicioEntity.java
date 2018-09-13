/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.entities;

import com.gs.collections.impl.list.fixed.ArrayAdapter;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import uk.co.jemos.podam.common.PodamExclude;

/**
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
    @ManyToOne
    private MaquinaEntity maquina;
    
    @PodamExclude
    @OneToMany(mappedBy = "ejercicio")
    private List<ZonaCuerpoEntity> zonasCuerpo = new ArrayList<ZonaCuerpoEntity>();
    
    @PodamExclude
    @OneToMany(mappedBy = "ejercicio")
    private List<ImplementoEntity> implementos = new ArrayList<ImplementoEntity>();

    public RutinaEntity getRutina() {
        return rutina;
    }

    public void setRutina(RutinaEntity rutina) {
        this.rutina = rutina;
    }

    public MaquinaEntity getMaquina() {
        return maquina;
    }

    public void setMaquina(MaquinaEntity maquinaEntity) {
        this.maquina = maquinaEntity;
    }

    public List<ZonaCuerpoEntity> getZonasCuerpo() {
        return zonasCuerpo;
    }

    public void setZonasCuerpo(List<ZonaCuerpoEntity> zonasCuerpo) {
        this.zonasCuerpo = zonasCuerpo;
    }

    public List<ImplementoEntity> getImplementos() {
        return implementos;
    }

    public void setImplementos(List<ImplementoEntity> implementos) {
        this.implementos = implementos;
    }
    
    
    
    //---------------------------------------------------------------
    
    public String getNombre() {
        return nombre;
    }
   
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
     
    public String getCategoria() {
        return categoria;
    }
    
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    
    public int getDuracion() {
        return duracion;
    }
    
     public void setDuracion(int duracion) {
        this.duracion = duracion;
    }
     
    public int getNumeroDeSeries() {
        return numeroDeSeries;
    }
    
    public void setNumeroDeSeries(int numeroDeSeries) {
        this.numeroDeSeries = numeroDeSeries;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public String getExplicacion() {
        return explicacion;
    }
    
    public void setExplicacion(String explicacion) {
        this.explicacion = explicacion;
    }
}
