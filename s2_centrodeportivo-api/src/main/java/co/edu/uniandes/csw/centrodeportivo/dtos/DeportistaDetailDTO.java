/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.uniandes.csw.centrodeportivo.dtos;

import java.io.Serializable;
import co.edu.uniandes.csw.centrodeportivo.entities.*;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Clase que modela el detail del deportista
 * @author Leidy Romero
 */
public class DeportistaDetailDTO extends DeportistaDTO implements Serializable {
    /**
     * Lista de objetivos del deportista
     */
    private List<ObjetivoDTO> objetivos;
    /**
     * Constructor por defecto
     */
    public DeportistaDetailDTO()
    {
        super();
    }
    
    /**      *
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en      *
     * la entidad que viene de argumento.      *
     *
     * @param deportistaEntity: Es la entidad que se va a convertir a DTO      *
     */
    public DeportistaDetailDTO(DeportistaEntity deportistaEntity) {
        super(deportistaEntity);
        if (deportistaEntity != null && deportistaEntity.getObjetivos() != null)
        {
            objetivos = new ArrayList<>();
            for (ObjetivoEntity entityObjetivos : deportistaEntity.getObjetivos()) {
                objetivos.add(new ObjetivoDTO(entityObjetivos));
            }
        }
    }
    /**      *
     * Convertir DTO a Entity
     * @return Un Entity con los valores del DTO      *
     */
    @Override
    public DeportistaEntity toEntity() {
        DeportistaEntity deportista = super.toEntity();
        if (objetivos != null) {
            List<ObjetivoEntity> objetivosEntity = new ArrayList<>();
            for (ObjetivoDTO dtoObjetivo : objetivos) {
                objetivosEntity.add(dtoObjetivo.toEntity());
            }
            deportista.setObjetivos(objetivosEntity);
        }
        return deportista;
        
    }
    /**
     * Obtiene la lista de objetivos del deportista
     * @return los objetivos
     */
    public List<ObjetivoDTO> getObjetivos()
    {
        return objetivos;
    }
    
    /** Modifica la lista de objetivos del deportista
     * @param pObjetivos objetivos nuevos
     */
    public void setObjetivos(List<ObjetivoDTO> pObjetivos)
    {
        this.objetivos = pObjetivos;
    }
    /**
     * Retorna el string de la clase
     * @return el string
     */
    @Override
    public String toString() {
        
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
        
    }
    
}
