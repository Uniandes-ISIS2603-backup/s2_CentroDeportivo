/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;

import co.edu.uniandes.csw.centrodeportivo.dtos.DeportistaDTO;
import co.edu.uniandes.csw.centrodeportivo.dtos.DeportistaDetailDTO;
import co.edu.uniandes.csw.centrodeportivo.ejb.DeportistaLogic;
import co.edu.uniandes.csw.centrodeportivo.ejb.ObjetivoDeportistasLogic;
import co.edu.uniandes.csw.centrodeportivo.entities.DeportistaEntity;
import co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException;
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
 *
 * @author Leidy Romero
 */
public class ObjetivoDeportistasResource {
     private static final Logger LOGGER = Logger.getLogger(ObjetivoDeportistasResource.class.getName());

    @Inject
    private ObjetivoDeportistasLogic objetivoDeportistasLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    @Inject
    private DeportistaLogic deportistaLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    
    /**
     * Guarda un deportista dentro de una objetivo con la informacion que recibe
     * la URL. Se devuelve el deportista que se guarda en la objetivo.
     *
     * @param objetivosId Identificador de la objetivo que se esta
     * actualizando. Este debe ser una cadena de dígitos.
     * @param deportistasId Identificador del deportista que se desea guardar. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link DeportistaDTO} - El deportista guardado en la objetivo.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el deportista.
     */
    @POST
    @Path("{deportistasId: \\d+}")
    public DeportistaDTO addDeportista(@PathParam("objetivosId") Long objetivosId, @PathParam("deportistasId") Long deportistasId) {
        LOGGER.log(Level.INFO, "ObjetivoDeportistasResource addDeportista: input: objetivosId: {0} , deportistasId: {1}", new Object[]{objetivosId, deportistasId});
        if (deportistaLogic.getDeportista(deportistasId) == null) {
            throw new WebApplicationException("El recurso /deportistas/" + deportistasId + " no existe.", 404);
        }
        DeportistaDTO deportistaDTO = new DeportistaDTO(objetivoDeportistasLogic.addDeportista(deportistasId, objetivosId));
        LOGGER.log(Level.INFO, "ObjetivoDeportistasResource addDeportista: output: {0}", deportistaDTO.toString());
        return deportistaDTO;
    }

    /**
     * Busca y devuelve todos los deportistas que existen en la objetivo.
     *
     * @param objetivosId Identificador de la objetivo que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @return JSONArray {@link DeportistaDetailDTO} - Los deportistas encontrados en la
     * objetivo. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<DeportistaDetailDTO> getDeportistas(@PathParam("objetivosId") Long objetivosId) {
        LOGGER.log(Level.INFO, "ObjetivoDeportistasResource getDeportistas: input: {0}", objetivosId);
        List<DeportistaDetailDTO> listaDetailDTOs = deportistasListEntity2DTO(objetivoDeportistasLogic.getDeportistas(objetivosId));
        LOGGER.log(Level.INFO, "ObjetivoDeportistasResource getDeportistas: output: {0}", listaDetailDTOs.toString());
        return listaDetailDTOs;
    }
    
    /**
     * Busca el deportista con el id asociado dentro de la objetivo con id asociado.
     *
     * @param objetivosId Identificador de la objetivos que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @param deportistasId Identificador del libro que se esta buscando. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link DeportistaDetailDTO} - El ejrcicio buscado
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el deportista.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el deportista en la
     * objetivo.
     */
    @GET
    @Path("{deportistasId: \\d+}")
    public DeportistaDetailDTO getDeportista(@PathParam("objetivosId") Long objetivosId, @PathParam("deportistasId") Long deportistasId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "ObjetivoDeportistasResource getDeportista: input: objetivosID: {0} , deportistasId: {1}", new Object[]{objetivosId, deportistasId});
        if (deportistaLogic.getDeportista(deportistasId) == null) {
            throw new WebApplicationException("El recurso /objetivos/" + objetivosId + "/ejericios/" + deportistasId + " no existe.", 404);
        }
        DeportistaDetailDTO deportistaDetailDTO = new DeportistaDetailDTO (objetivoDeportistasLogic.getDeportista(objetivosId, deportistasId));
        LOGGER.log(Level.INFO, "ObjetivoDeportistasResource getDeportista: output: {0}", deportistaDetailDTO.toString());
        return deportistaDetailDTO;
    }
    
    /**
     * Remplaza las instancias de Deportista asociadas a una instancia de Objetivo
     *
     * @param ObjetivosId Identificador de la objetivo que se esta
     * remplazando. Este debe ser una cadena de dígitos.
     * @param deportistas JSONArray {@link DeportistaDTO} El arreglo de deportistas nuevo para la
     * objetivo.
     * @return JSON {@link DeportistaDTO} - El arreglo de deportistas guardado en la
     * objetivo.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el deportista.
     */
    @PUT
    public List<DeportistaDetailDTO> replaceDeportistas(@PathParam("objetivosId") Long objetivosId, List<DeportistaDetailDTO> deportistas) {
        LOGGER.log(Level.INFO, "EditorialDeportistasResource replaceDeportistas: input: objetivosId: {0} , deportistas: {1}", new Object[]{objetivosId, deportistas.toString()});
        for (DeportistaDTO deportista : deportistas) {
            if (deportistaLogic.getDeportista(deportista.getId()) == null) {
                throw new WebApplicationException("El recurso /deportistas/" + deportista.getId() + " no existe.", 404);
            }
        }
        List<DeportistaDetailDTO> listaDetailDTOs = deportistasListEntity2DTO(objetivoDeportistasLogic.replaceDeportistas(objetivosId, deportistasListDTO2Entity(deportistas)));
        LOGGER.log(Level.INFO, "EditorialDeportistasResource replaceDeportistas: output: {0}", listaDetailDTOs.toString());
        return listaDetailDTOs;
    }

    /**
     * Convierte una lista de DeportistaEntity a una lista de EjecicioDetailDTO.
     *
     * @param entityList Lista de DeportistaEntity a convertir.
     * @return Lista de DeportistaDTO convertida.
     */
    private List<DeportistaDetailDTO> deportistasListEntity2DTO(List<DeportistaEntity> entityList) {
        List<DeportistaDetailDTO> list = new ArrayList();
        for (DeportistaEntity entity : entityList) {
            list.add(new DeportistaDetailDTO(entity));
        }
        return list;
    }
    
    /**
     * Convierte una lista de DeportistaDetailDTO a una lista de DeportistaEntity.
     *
     * @param dtos Lista de DeportistaDetailDTO a convertir.
     * @return Lista de DeportistaEntity convertida.
     */
    private List<DeportistaEntity> deportistasListDTO2Entity(List<DeportistaDetailDTO> dtos) {
        List<DeportistaEntity> list = new ArrayList<>();
        for (DeportistaDetailDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
}
