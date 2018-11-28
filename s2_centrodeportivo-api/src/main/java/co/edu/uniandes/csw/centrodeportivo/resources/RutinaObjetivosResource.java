/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;

import co.edu.uniandes.csw.centrodeportivo.ejb.RutinaObjetivosLogic;
import co.edu.uniandes.csw.centrodeportivo.dtos.ObjetivoDTO;
import co.edu.uniandes.csw.centrodeportivo.dtos.ObjetivoDetailDTO;
import co.edu.uniandes.csw.centrodeportivo.ejb.ObjetivoLogic;

import co.edu.uniandes.csw.centrodeportivo.entities.ObjetivoEntity;
import co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;

/**
 * Clase que implementa el recurso "rutina/{id}/objetivos".
 * 
 * @author Francisco Jose MacAllister
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class RutinaObjetivosResource {
    private static final Logger LOGGER = Logger.getLogger(RutinaObjetivosResource.class.getName());
    
    private static final String NOEXISTE = " no existe.";
    
    @Inject
    private RutinaObjetivosLogic rutinaObjetivosLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    @Inject
    private ObjetivoLogic objetivoLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    /**
     * Guarda un objetivo dentro de una rutina con la información que recibe el
     * la URL. Se devuelve el objetivo que se guarda en la rutina.
     *
     * @param rutinasId Identificador de la rutina que se esta
     * actualizando. Este debe ser una cadena de dígitos.
     * @param objetivosId Identificador del objetivo que se desea guardar. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link ObjetivoDTO} - El objetivo guardado en la rutina.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el objetivo.
     */
    @POST
    @Path("{objetivosId: \\d+}")
    public ObjetivoDTO addObjetivo(@PathParam("rutinasId") Long rutinasId, @PathParam("objetivosId") Long objetivosId) {
        LOGGER.log(Level.INFO, "RutinaObjetivosResource addObjetivo: input: rutinasID: {0} , objetivosId: {1}", new Object[]{rutinasId, objetivosId});
        if (objetivoLogic.getObjetivo(objetivosId) == null) {
            throw new WebApplicationException("El recurso /objetivos/" + objetivosId +  NOEXISTE, 404);
        }
        ObjetivoDTO objetivoDTO = new ObjetivoDTO(rutinaObjetivosLogic.addObjetivo(objetivosId, rutinasId));
        LOGGER.log(Level.INFO, "RutinaObjetivosResource addObjetivo: output: {0}", objetivoDTO );
        return objetivoDTO;
    }

    /**
     * Busca y devuelve todos los objetivos que existen en la rutina.
     *
     * @param rutinasId Identificador de la rutina que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @return JSONArray {@link ObjetivoDetailDTO} - Los objetivos encontrados en la
     * rutina. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<ObjetivoDetailDTO> getObjetivos(@PathParam("rutinasId") Long rutinasId) {
        LOGGER.log(Level.INFO, "RutinaObjetivosResource getObjetivos: input: {0}", rutinasId);
        List<ObjetivoDetailDTO> listaDetailDTOs = objetivosListEntity2DTO(rutinaObjetivosLogic.getObjetivos(rutinasId));
        LOGGER.log(Level.INFO, "RutinaObjetivosResource getObjetivos: output: {0}", listaDetailDTOs );
        return listaDetailDTOs;
    }

    /**
     * Busca el objetivo con el id asociado dentro de la rutina con id asociado.
     *
     * @param rutinasId Identificador de la rutina que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @param objetivosId Identificador del objetivo que se esta buscando. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link ObjetivoDetailDTO} - El objetivo buscado
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el objetivo.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el objetivo en la
     * rutina.
     */
    @GET
    @Path("{objetivosId: \\d+}")
    public ObjetivoDetailDTO getObjetivo(@PathParam("rutinasId") Long rutinasId, @PathParam("objetivosId") Long objetivosId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "RutinaObjetivosResource getObjetivo: input: rutinasID: {0} , objetivosId: {1}", new Object[]{rutinasId, objetivosId});
        if (objetivoLogic.getObjetivo(objetivosId) == null) {
            throw new WebApplicationException("El recurso /rutinas/" + rutinasId + "/objetivos/" + objetivosId +  NOEXISTE, 404);
        }
        ObjetivoDetailDTO objetivoDetailDTO = new ObjetivoDetailDTO(rutinaObjetivosLogic.getObjetivo(rutinasId, objetivosId));
        LOGGER.log(Level.INFO, "RutinaObjetivosResource getObjetivo: output: {0}", objetivoDetailDTO );
        return objetivoDetailDTO;
    }

    /**
     * Remplaza las instancias de Objetivo asociadas a una instancia de Rutina
     *
     * @param rutinasId Identificador de la rutina que se esta
     * remplazando. Este debe ser una cadena de dígitos.
     * @param objetivos JSONArray {@link ObjetivoDTO} El arreglo de objetivos nuevo para la
     * rutina.
     * @return JSON {@link ObjetivoDTO} - El arreglo de objetivos guardado en la
     * rutina.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el objetivo.
     */
    @PUT
    public List<ObjetivoDetailDTO> replaceObjetivos(@PathParam("rutinasId") Long rutinasId, List<ObjetivoDetailDTO> objetivos) {
        LOGGER.log(Level.INFO, "RutinaObjetivosResource replaceObjetivos: input: rutinasId: {0} , objetivos: {1}", new Object[]{rutinasId, objetivos });
        for (ObjetivoDetailDTO objetivo : objetivos) {
            if (objetivoLogic.getObjetivo(objetivo.getId()) == null) {
                throw new WebApplicationException("El recurso /objetivos/" + objetivo.getId() +  NOEXISTE, 404);
            }
        }
        List<ObjetivoDetailDTO> listaDetailDTOs = objetivosListEntity2DTO(rutinaObjetivosLogic.replaceObjetivos(rutinasId, objetivosListDTO2Entity(objetivos)));
        LOGGER.log(Level.INFO, "RutinaObjetivosResource replaceObjetivos: output: {0}", listaDetailDTOs );
        return listaDetailDTOs;
    }

    /**
     * Convierte una lista de ObjetivoEntity a una lista de ObjetivoDetailDTO.
     *
     * @param entityList Lista de ObjetivoEntity a convertir.
     * @return Lista de ObjetivoDTO convertida.
     */
    private List<ObjetivoDetailDTO> objetivosListEntity2DTO(List<ObjetivoEntity> entityList) {
        List<ObjetivoDetailDTO> list = new ArrayList();
        for (ObjetivoEntity entity : entityList) {
            list.add(new ObjetivoDetailDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de ObjetivoDetailDTO a una lista de ObjetivoEntity.
     *
     * @param dtos Lista de ObjetivoDetailDTO a convertir.
     * @return Lista de ObjetivoEntity convertida.
     */
    private List<ObjetivoEntity> objetivosListDTO2Entity(List<ObjetivoDetailDTO> dtos) {
        List<ObjetivoEntity> list = new ArrayList<>();
        for (ObjetivoDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
}
