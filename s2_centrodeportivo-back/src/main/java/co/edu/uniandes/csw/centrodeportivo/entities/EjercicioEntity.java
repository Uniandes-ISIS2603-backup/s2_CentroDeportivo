/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.persistence.Entity;
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
    
    private int duracion;
    
    private int numeroDeSeries;
    
    private String descripcion;
    
    private String explicacion;
    
    
    @PodamExclude
    @javax.persistence.ManyToOne()
    ZonaCuerpoEntity zonaCuerpo;
    
   // @PodamExclude
   //  @javax.persistence.ManyToOne()
   //  MaquinaEntity maquina;
    
    @PodamExclude
    @javax.persistence.OneToMany(mappedBy = "ejercicio")
    List<ZonaCuerpoEntity> zonasCuerpo;
    
    @PodamExclude
    @javax.persistence.OneToMany(mappedBy = "ejercicio")
    List<ImplementoEntity> implementos;
    
   // @PodamExclude
   //@javax.persistence.OneToMany(mappedBy = "ejercicio",
    //        fetch = javax.persistence.FetchType.LAZY)
   // List<MaquinaEntity> maquinas;
    
    //Metodos-------------------------
    
    
    //---------------------------------------------------------------
    
   //  public List<MaquinaEntity> getZonasCuerpo()
   // {
  ////     return this.maquinas;  
   // }
     public List<ImplementoEntity> getImplementos()
     {
      return this.implementos;  
     }

     public List<ZonaCuerpoEntity> getZonasCuerpo()
    {
     return this.zonasCuerpo;  
    }
     public void setZonasCuerpo(List<ZonaCuerpoEntity> pZonasCuerpo)
    {
        this.zonasCuerpo = pZonasCuerpo;
    }
    
    
    //---------------------------------------------------------------
    
//     public void setMaquina(MaquinaEntity pMaquina)
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
