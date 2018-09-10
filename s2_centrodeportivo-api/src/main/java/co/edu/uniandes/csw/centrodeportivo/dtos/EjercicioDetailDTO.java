/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.dtos;


import co.edu.uniandes.csw.centrodeportivo.entities.EjercicioEntity;
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
    private List<ZonaCuerpoDTO> zonasCuerpo;
    
    public EjercicioDetailDTO(EjercicioEntity ejercicioEntity) {
    super(ejercicioEntity);
        if (ejercicioEntity != null) {
            zonasCuerpo = new ArrayList<ZonaCuerpoDTO>();
            for (ZonaCuerpoEntity entityZonaCuerpos : ejercicioEntity.getZonasCuerpo()) {
                zonasCuerpo.add(new ZonaCuerpoDTO(entityZonaCuerpos));
            }
        }
    }

    /**
     * Convierte un objeto EjercicioDetailDTO a EjercicioEntity incluyendo los
     * atributos de EjercicioDTO
     *
     * @return Nuevo objeto EjercicioEntity
     */
    @Override
    public EjercicioEntity toEntity() {
        EjercicioEntity ejercicio;
         ejercicio = super.toEntity();
        if (zonasCuerpo != null) {
            List<ZonaCuerpoEntity> zonasCuerpoEntity = new ArrayList<ZonaCuerpoEntity>();
            for (ZonaCuerpoDTO dtoZonaCuerpo : zonasCuerpo) {
                zonasCuerpoEntity.add(dtoZonaCuerpo.toEntity());
            }
            ejercicio.setZonasCuerpo(zonasCuerpoEntity);
        }
        return ejercicio;
    }
    
    /**
     * Obtiene la lista de zonasCuerpos del ejercicio
     * @return los zonasCuerpo
     */
    public List<ZonaCuerpoDTO> getZonaCuerpos()
    {
        return zonasCuerpo;
    }
    
     /* Modificala lista de zonasCuerpos del ejercicio
     * @param pZonaCuerpos zonasCuerpos nuevos
     */
    public void setZonaCuerpos(List<ZonaCuerpoDTO> pZonaCuerpos)
    {
        this.zonasCuerpo = pZonaCuerpos;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}
