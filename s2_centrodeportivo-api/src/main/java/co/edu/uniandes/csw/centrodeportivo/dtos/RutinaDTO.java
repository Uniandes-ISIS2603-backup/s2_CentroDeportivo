/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.uniandes.csw.centrodeportivo.dtos;

import co.edu.uniandes.csw.centrodeportivo.entities.RutinaEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;



/**
 * Objeto de transferencia de datos de rutina
 * @author Francisco Jose MacAllister
 */
public class RutinaDTO implements Serializable {
    /**
     * Identificador unico de la rutina
     */
    public Long id;
    /**
     * Identificador de la rutina repetible por deportista
     */
    public Integer identificadorRutina;
    /**
     * Nombre de la rutina
     */
    public String nombre;
    /**
     * Estado de la rutina
     */
    public Boolean estadoTerminado;
    /**
     * Constructor por defecto
     */
    public RutinaDTO()
    {
        
    }
    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param createRutina Es la entidad que se va a convertir a DTO
     */
    public RutinaDTO(RutinaEntity createRutina) {
        if(createRutina!=null)
        {
            this.estadoTerminado=createRutina.getEstadoTerminado();
            this.id=createRutina.getId();
            this.nombre=createRutina.getNombre();
        }
    }
    /**
     * Devuelve el identificador unico  de la rutina asociada al deportista.
     *
     * @return the identificadorRutina
     */
    public int getIdentificadorRutina() {
        return identificadorRutina;
    }
    /**
     * Modifica el identificador unico  de la rutina asociada al deportista.
     *
     * @param identificadorRutina the id to set
     */
    public void setIdentificadorRutina(int identificadorRutina) {
        this.identificadorRutina = identificadorRutina;
    }
    /**
     * Modifica el ID de la rutina.
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }
    /**
     * Devuelve el ID de la rutina.
     *
     * @return the id
     */
    public Long getId()
    {
        return this.id;
    }
    /**
     * Devuelve el nombre de la rutina.
     *
     * @return the name
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * Modifica el nombre de la rutina.
     *
     * @param nombre the name to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * Devuelve el estado de terminacion  de la rutina.
     *
     * @return estadoTerminado
     */
    public boolean getEstadoTerminado() {
        return estadoTerminado;
    }
    /**
     * Modifica el estado de terminación de una rutina.
     *
     * @param estadoTerminado
     */
    public void setEstadoTerminado(boolean estadoTerminado) {
        this.estadoTerminado = estadoTerminado;
    }
    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public RutinaEntity toEntity() {
        RutinaEntity rutinaEntity = new RutinaEntity();
        rutinaEntity.setId(this.id);
        rutinaEntity.setNombre(this.nombre);
        rutinaEntity.setEstadoTerminado(this.estadoTerminado);
        return rutinaEntity;
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
