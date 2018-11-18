/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.uniandes.csw.centrodeportivo.dtos;

import co.edu.uniandes.csw.centrodeportivo.entities.ZonaCuerpoEntity;
import co.edu.uniandes.csw.centrodeportivo.entities.ZonaCuerpoEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * ZonaCuerpoDTO Objeto de transferencia de datos de ZonasCuerpo. Los DTO contienen las
 * representaciones de los JSON que se transfieren entre el cliente y el
 * servidor.
 *
 * @author Daniel Pardo
 */
public class ZonaCuerpoDTO implements Serializable
{
    /**
     * Id de la zona del cuerpo
     */
    private Long id;
    /**
     * Nombre de la zona del cuerpo
     */
    private String nombre;
    
    /**
     * Constructor vacio
     */
    public ZonaCuerpoDTO()
    {
        
    }
    
    /**
     * Crea un objeto ZonaCuerpoDTO a partir de un objeto ZonaCuerpoEntity.
     *
     * @param zonaCuerpoEntity Entidad ZonaCuerpoEntity desde la cual se va a crear el
     * nuevo objeto.
     *
     */
    public ZonaCuerpoDTO(ZonaCuerpoEntity zonaCuerpoEntity) {
        
        if (zonaCuerpoEntity != null) {
            this.id = zonaCuerpoEntity.getId();
            this.nombre = zonaCuerpoEntity.getNombre();
            
        }
    }
    
    
    //Metodos
    
    /**
     * Metodo que retorna el id unico de la zona del cuerpo
     *
     * @return Id unico de la zona del cuerpo
     */
    public Long getId() {
        return id;
    }
    
    /**
     * Modifica el ID de la zona del cuerpo.
     *
     * @param id el Id a modificar
     */
    public void setId(Long id) {
        this.id = id;
    }
    
    /**
     * Metodo que retorna el nombre de la zona del cuerpo
     *
     * @return el nombre de la zona del cuerpo
     */
    public String getNombre( )
    {
        return nombre;
    }
    
    /**
     * Modifica el nombre de la zona del cuerpo.
     *
     * @param nombre el nombre a modificar
     */
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    
    /**
     * Convierte un objeto ZonaCuerpoDTO a ZonaCuerpoEntity.
     *
     * @return Nueva objeto ZonaCuerpoEntity.
     *
     */
    public ZonaCuerpoEntity toEntity()
    {
        ZonaCuerpoEntity zonaCuerpoEntity = new ZonaCuerpoEntity();
        zonaCuerpoEntity.setId(this.id);
        zonaCuerpoEntity.setNombre(this.nombre);
        return zonaCuerpoEntity;
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