/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.uniandes.csw.centrodeportivo.dtos;

import co.edu.uniandes.csw.centrodeportivo.entities.EjercicioEntity;
import co.edu.uniandes.csw.centrodeportivo.entities.ObjetivoEntity;
import co.edu.uniandes.csw.centrodeportivo.entities.RutinaEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * Clase que modela el detalle de la rutina.
 * @author Francisco Jose MacAllister
 */
public class RutinaDetailDTO extends RutinaDTO implements Serializable {
    
    /**
     * Esta lista de tipo EjercicioDTO contiene las ejercicios que estan asociadas a un rutina
     */
    private List<EjercicioDTO> ejercicios;
    /**
     * Lista de tipo ObjetivoDTO que contiene los objetivos asociaciados a la rutina.
     */
    private List<ObjetivoDTO> objetivos;
    /**
     * Constructor por defecto
     */
    public RutinaDetailDTO()
    {
        
    }
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param rutinaEntity La entidad del rutina para transformar a DTO.
     */
    public RutinaDetailDTO(RutinaEntity rutinaEntity) {
        super(rutinaEntity);
        if (rutinaEntity != null) {
            if (rutinaEntity.getEjercicios() != null) {
                ejercicios = new ArrayList<>();
                for (EjercicioEntity entityEjercicio : rutinaEntity.getEjercicios()) {
                    ejercicios.add(new EjercicioDTO(entityEjercicio));
                }
            }
            if (rutinaEntity.getObjetivos() != null) {
                objetivos = new ArrayList<>();
                for (ObjetivoEntity entityObjetivo : rutinaEntity.getObjetivos()) {
                    objetivos.add(new ObjetivoDTO(entityObjetivo));
                }
            }
        }
    }
    /**
     * Devuelve la lista de ejercicios de la rutina.
     *
     * @return los ejercicios
     */
    public List<EjercicioDTO> getEjercicios()
    {
        return ejercicios;
    }
    /**
     * Modifica la lista de ejercicios del rutina.
     *
     * @param ejercicios los ejercicios a modificar
     */
    public void setEjercicios(List<EjercicioDTO> ejercicios)
    {
        this.ejercicios = ejercicios;
    }
    
    /**
     * Devuelve la lista de objetivos de la rutina.
     *
     * @return los objetivos
     */
    public List<ObjetivoDTO> getObjetivos()
    {
        return objetivos;
    }
    /**
     * Modifica la lista de objetivos del seguimiento.
     *
     * @param objetivos los objetivos a modificar
     */
    public void setObjetivos(List<ObjetivoDTO> objetivos)
    {
        this.objetivos = objetivos;
    }
    
    /**
     * Convierte un objeto RutinaDTO a RutinaEntity.
     *
     * @return Nuevo objeto RutinaEntity.
     *
     */
    @Override
    public RutinaEntity toEntity() {
        RutinaEntity rutinaEntity = super.toEntity();
        if (objetivos != null) {
            List<ObjetivoEntity> objetivosEntity = new ArrayList<>();
            for (ObjetivoDTO dtoObjetivo : objetivos) {
                objetivosEntity.add(dtoObjetivo.toEntity());
            }
            rutinaEntity.setObjetivos(objetivosEntity);
        }
        if (ejercicios != null) {
            List<EjercicioEntity> ejerciciosEntity = new ArrayList<>();
            for (EjercicioDTO dtoEjercicio : ejercicios) {
                ejerciciosEntity.add(dtoEjercicio.toEntity());
            }
            rutinaEntity.setEjercicios(ejerciciosEntity);
        }
        return rutinaEntity;
    }
    
    /**
     * Retorna el string del DTO
     * @return string
     */
    @Override
    public String toString()
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}