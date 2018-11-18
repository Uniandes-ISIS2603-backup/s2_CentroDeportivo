/*
 * To change this license header, choose License Headers in Project Properties.|
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.dtos;

import co.edu.uniandes.csw.centrodeportivo.entities.MaquinaEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Clase que modela la máquina
 * @author Diany Quintero
 */
public class MaquinaDTO implements Serializable{
    /**
     * Id de la maquina
     */
    private Long id;
    /**
     * Nombre de la maquina
     */
    private String nombre;
    /**
     * Referencia de la maquina
     */
    private String referencia;
    /**
     * Ruta dela imagen
     */
    private String imagen;
    /**
     * Constructor por defecto
     */
    public MaquinaDTO()
    {
        
    }
    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param maquinaEntity: Es la entidad que se va a convertir a DTO
     */
    public MaquinaDTO(MaquinaEntity maquinaEntity)
    {
        if(maquinaEntity != null)
        {
            this.id = maquinaEntity.getId();
            this.nombre = maquinaEntity.getNombre();
            this.referencia = maquinaEntity.getReferencia();
            this.imagen = maquinaEntity.getImagen();
        }
    }
    
    /**
    *
    * Retorna el id unico de una maquina
     * @return id
    */
    public Long getId(){
        return id;
    }
    /**
     * Cambia el id de la maquina por el recibido por parametro
     * @param id nuevo
     */
     public void setId(Long id) {
        this.id = id;
    }
    /**
    * Metodo que devuelve el nombre de la maquina
    * @return la velocidad promedio
    */
    public String getNombre() {
        return nombre;
    }
     /**
    *
    * Metodo que cambia el nombre de la maquina
     * @param nombre
    */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }  
    /**
    * Metodo que devuelve la referencia de la maquina
    * @return la velocidad promedio
    */
    public String getReferencia() {
        return referencia;
    }
     /**
    *
    * Metodo que cambia la referencia promedio
     * @param pReferencia
    */
    public void setReferencia(String pReferencia) {
        this.referencia = pReferencia;}
    /**
    * Metodo que devuelve la ruta de la imagen de la maquina
    * @return ruta de la imagen
    */
    public String getImagen() {
        return imagen;
    }
    /**
    *
    * Metodo que cambia la ruta de la imagen
    * @param pImagen
    */
    public void setImagen(String pImagen) {
        this.imagen = pImagen;
    }
    
    /**      *
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO      *
     */
    public MaquinaEntity toEntity() 
    {
        MaquinaEntity maquinaEntity = new MaquinaEntity();
        maquinaEntity.setId(this.id);
        maquinaEntity.setNombre(this.nombre);
        maquinaEntity.setReferencia(this.referencia);
        maquinaEntity.setImagen(this.imagen);
        return maquinaEntity;
    }
     /**
     * Retorna el string del DTO
     * @return string
     */
    @Override
    public String toString() {

        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);

    }
}   
