/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;

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
    
    private int duracion;
    
    private int numeroDeSeries;
    
    private String descripcion;
    
    private String explicacion;
    
    
    
  //   @javax.persistence.ManyToOne()
  //   RutinaEntity rutina;
    
    @javax.persistence.ManyToOne()
    ZonaCuerpoEntity zonaCuerpo;
    
  //   @javax.persistence.ManyToOne()
  //   MaquinaEntity maquina;
    
    @javax.persistence.OneToMany(mappedBy = "ejercicio",
            fetch = javax.persistence.FetchType.LAZY)
    Collection<ZonaCuerpoEntity> zonasCuerpo;
   
  //   @javax.persistence.OneToMany(mappedBy = "ejercicio",
  //           fetch = javax.persistence.FetchType.LAZY)
   //  Collection<ImplementoEntity> implementos;
    
  //   @javax.persistence.OneToMany(mappedBy = "ejercicio",
  //           fetch = javax.persistence.FetchType.LAZY)
  //   Collection<MaquinaEntity> maquinas;
    
    //Metodos-------------------------
    
    
    //---------------------------------------------------------------
    
   //  public Collection<MaquinaEntity> getObjetivos()
   //  {
   //    return this.maquinas;  
   //  }
   //  public Collection<ImplementoEntity> getImplementos()
   //  {
    //   return this.implementos;  
   //  }

   //  public Collection<ZonaCuerpoEntity> getZonasCuerpo()
   //  {
   //    return this.zonasCuerpo;  
   //  }
    
    
    //---------------------------------------------------------------
    
   //  public void setMaquina(MaquinaEntity pMaquina)
   //  {
   //      this.maquina = pMaquina;
  //   }
   //  public MaquinaEntity getMaquina()
  //   {
  //      return maquina;
  //   }
    
    public void setZonaCuerpo(ZonaCuerpoEntity pZonaCuerpo)
    {
        this.zonaCuerpo = pZonaCuerpo;
    }
    public ZonaCuerpoEntity getZonaCuerpo()
    {
       return zonaCuerpo;
    }
    
  //   public void setRutina(RutinaEntity pRutina)
   //  {
  //       this.rutina = pRutina;
  //   }
 //    public RutinaEntity getRutina()
  //   {
  //      return rutina;
  //   }
    
    
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
