/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.dtos;


import co.edu.uniandes.csw.centrodeportivo.entities.ZonaCuerpoEntity;
import co.edu.uniandes.csw.centrodeportivo.entities.ZonaCuerpoEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author estudiante
 */
public class EjercicioDetailDTO extends EjercicioDTO implements Serializable
{
   /*
    * Esta lista de tipo ZonaCuerpoDTO contiene las implementos que estan asociadas a un rutina
     */
    private List<ZonaCuerpoDTO> zonasCuerpo;
    private List<ImplementoDTO> implementos;

    /**
     * Constructor por defecto
     */
    public EjercicioDetailDTO() 
    {
        
    }

    /**
     * Devuelve la lista de zonasCuerpo del rutina.
     *
     * @return las zonasCuerpo
     */
    public List<ZonaCuerpoDTO> getZonasCuerpo() 
    {
        return zonasCuerpo;
    }

    /**
     * Modifica la lista de implementos del rutina.
     *
     * @param zonasCuerpo las implementos a modificar
     */
    public void setZonasCuerpo(List<ZonaCuerpoDTO> zonasCuerpo) 
    {
        this.zonasCuerpo = zonasCuerpo;
    }

    /**
     * Devuelve la lista de implementos del rutina.
     *
     * @return los implementos
     */
    public List<ImplementoDTO> getImplementos() 
    {
        return implementos;
    }

    /**
     * Modifica la lista de implementos del seguimiento.
     *
     * @param implementos las implementos a modificar
     */
    public void setImplementos(List<ImplementoDTO> implementos) 
    {
        this.implementos = implementos;
    }
    
    @Override
    public String toString() 
    {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
