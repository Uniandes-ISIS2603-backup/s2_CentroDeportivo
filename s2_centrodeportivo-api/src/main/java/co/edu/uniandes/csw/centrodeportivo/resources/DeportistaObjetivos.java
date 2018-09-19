/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;

import co.edu.uniandes.csw.centrodeportivo.dtos.ObjetivoDTO;
import co.edu.uniandes.csw.centrodeportivo.dtos.ObjetivoDetailDTO;
import co.edu.uniandes.csw.centrodeportivo.ejb.DeportistaObjetivosLogic;
import co.edu.uniandes.csw.centrodeportivo.ejb.ObjetivoLogic;
import co.edu.uniandes.csw.centrodeportivo.entities.ObjetivoEntity;
import co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.centrodeportivo.mappers.BusinessLogicExceptionMapper;
import co.edu.uniandes.csw.centrodeportivo.mappers.WebApplicationExceptionMapper;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.WebApplicationException;

/**
 * Clase que implementa el recurso "deportista/{id}/objetivos".
 * @author Leidy Romero
 */
public class DeportistaObjetivos {
    private static final Logger LOGGER = Logger.getLogger(DeportistaObjetivos.class.getName());

    @Inject
    private DeportistaObjetivosLogic deportistaObjetivosLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    @Inject
    private ObjetivoLogic objetivoLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    
    /**
     * Guarda un objetivo dentro de una deportista con la informacion que recibe
     * la URL. Se devuelve el objetivo que se guarda en la deportista.
     *
     * @param deportistasId Identificador de la deportista que se esta
     * actualizando. Este debe ser una cadena de dígitos.
     * @param objetivosId Identificador del objetivo que se desea guardar. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link ObjetivoDTO} - El objetivo guardado en la deportista.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el objetivo.
     */
    @POST
    @Path("{objetivosId: \\d+}")
    public ObjetivoDTO addObjetivo(@PathParam("deportistasId") Long deportistasId, @PathParam("objetivosId") Long objetivosId) {
        LOGGER.log(Level.INFO, "DeportistaObjetivosResource addObjetivo: input: deportistasId: {0} , booksId: {1}", new Object[]{deportistasId, objetivosId});
        if (objetivoLogic.getObjetivo(objetivosId) == null) {
            throw new WebApplicationException("El recurso /objetivos/" + objetivosId + " no existe.", 404);
        }
        ObjetivoDTO objetivoDTO = new ObjetivoDTO(deportistaObjetivosLogic.addObjetivo(objetivosId, deportistasId));
        LOGGER.log(Level.INFO, "DeportistaObjetivosResource addObjetivo: output: {0}", objetivoDTO.toString());
        return objetivoDTO;
    }

    /**
     * Busca y devuelve todos los objetivos que existen en la deportista.
     *
     * @param deportistasId Identificador de la deportista que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @return JSONArray {@link ObjetivoDetailDTO} - Los objetivos encontrados en la
     * deportista. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<ObjetivoDetailDTO> getObjetivos(@PathParam("deportistasId") Long deportistasId) {
        LOGGER.log(Level.INFO, "DeportistaObjetivosResource getObjetivos: input: {0}", deportistasId);
        List<ObjetivoDetailDTO> listaDetailDTOs = objetivosListEntity2DTO(deportistaObjetivosLogic.getObjetivos(deportistasId));
        LOGGER.log(Level.INFO, "DeportistaObjetivosResource getObjetivos: output: {0}", listaDetailDTOs.toString());
        return listaDetailDTOs;
    }
    
    /**
     * Busca el objetivo con el id asociado dentro de la deportista con id asociado.
     *
     * @param deportistasId Identificador de la deportistas que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @param objetivosId Identificador del libro que se esta buscando. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link ObjetivoDetailDTO} - El ejrcicio buscado
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el objetivo.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el objetivo en la
     * deportista.
     */
    @GET
    @Path("{objetivosId: \\d+}")
    public ObjetivoDetailDTO getObjetivo(@PathParam("deportistasId") Long deportistasId, @PathParam("objetivosId") Long objetivosId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "DeportistaObjetivosResource getObjetivo: input: deportistasID: {0} , booksId: {1}", new Object[]{deportistasId, objetivosId});
        if (objetivoLogic.getObjetivo(objetivosId) == null) {
            throw new WebApplicationException("El recurso /deportistas/" + deportistasId + "/ejericios/" + objetivosId + " no existe.", 404);
        }
        ObjetivoDetailDTO objetivoDetailDTO = new ObjetivoDetailDTO (deportistaObjetivosLogic.getObjetivo(deportistasId, objetivosId));
        LOGGER.log(Level.INFO, "DeportistaObjetivosResource getObjetivo: output: {0}", objetivoDetailDTO.toString());
        return objetivoDetailDTO;
    }
    
    /**
     * Remplaza las instancias de Objetivo asociadas a una instancia de Deportista
     *
     * @param DeportistasId Identificador de la deportista que se esta
     * remplazando. Este debe ser una cadena de dígitos.
     * @param objetivos JSONArray {@link ObjetivoDTO} El arreglo de objetivos nuevo para la
     * deportista.
     * @return JSON {@link ObjetivoDTO} - El arreglo de objetivos guardado en la
     * deportista.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el objetivo.
     */
    @PUT
    public List<ObjetivoDetailDTO> replaceObjetivos(@PathParam("deportistasId") Long deportistasId, List<ObjetivoDetailDTO> objetivos) {
        LOGGER.log(Level.INFO, "DeportistaObjetivosResource replaceObjetivos: input: deportistasId: {0} , books: {1}", new Object[]{deportistasId, objetivos.toString()});
        for (ObjetivoDTO objetivo : objetivos) {
            if (objetivoLogic.getObjetivo(objetivo.getId()) == null) {
                throw new WebApplicationException("El recurso /objetivos/" + objetivo.getId() + " no existe.", 404);
            }
        }
        List<ObjetivoDetailDTO> listaDetailDTOs = objetivosListEntity2DTO(deportistaObjetivosLogic.replaceObjetivos(deportistasId, objetivosListDTO2Entity(objetivos)));
        LOGGER.log(Level.INFO, "DeportistaObjetivosResource replaceObjetivos: output: {0}", listaDetailDTOs.toString());
        return listaDetailDTOs;
    }

    /**
     * Convierte una lista de ObjetivoEntity a una lista de EjecicioDetailDTO.
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
