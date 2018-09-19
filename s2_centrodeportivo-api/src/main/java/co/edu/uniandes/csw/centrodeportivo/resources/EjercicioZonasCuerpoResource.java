/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;

import co.edu.uniandes.csw.centrodeportivo.dtos.ZonaCuerpoDTO;
import co.edu.uniandes.csw.centrodeportivo.ejb.EjercicioZonasCuerpoLogic;
import co.edu.uniandes.csw.centrodeportivo.ejb.ZonaCuerpoLogic;
import co.edu.uniandes.csw.centrodeportivo.entities.ZonaCuerpoEntity;
import co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.centrodeportivo.mappers.BusinessLogicExceptionMapper;
import co.edu.uniandes.csw.centrodeportivo.mappers.WebApplicationExceptionMapper;
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
 *
 * @author Daniel Pardo
 */
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
class EjercicioZonasCuerpoResource 
{
    private static final Logger LOGGER = Logger.getLogger(EjercicioZonasCuerpoResource.class.getName());

    @Inject
    private EjercicioZonasCuerpoLogic ejercicioZonasCuerpoLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    @Inject
    private ZonaCuerpoLogic zonaCuerpoLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    /**
     * Guarda un libro dentro de una ejercicio con la informacion que recibe el
     * la URL. Se devuelve el libro que se guarda en la ejercicio.
     *
     * @param ejerciciosId Identificador de la ejercicio que se esta
     * actualizando. Este debe ser una cadena de dígitos.
     * @param zonasCuerpoId Identificador del libro que se desea guardar. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link ZonaCuerpoDTO} - El libro guardado en la ejercicio.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el libro.
     */
    @POST
    @Path("{zonasCuerpoId: \\d+}")
    public ZonaCuerpoDTO addZonaCuerpo(@PathParam("ejerciciosId") Long ejerciciosId, @PathParam("zonasCuerpoId") Long zonasCuerpoId) {
        LOGGER.log(Level.INFO, "EjercicioZonasCuerpoResource addZonaCuerpo: input: ejerciciosID: {0} , zonasCuerpoId: {1}", new Object[]{ejerciciosId, zonasCuerpoId});
        if (zonaCuerpoLogic.getZonaCuerpo(zonasCuerpoId) == null) {
            throw new WebApplicationException("El recurso /zonasCuerpo/" + zonasCuerpoId + " no existe.", 404);
        }
        ZonaCuerpoDTO zonaCuerpoDTO = new ZonaCuerpoDTO(ejercicioZonasCuerpoLogic.addZonaCuerpo(zonasCuerpoId, ejerciciosId));
        LOGGER.log(Level.INFO, "EjercicioZonasCuerpoResource addZonaCuerpo: output: {0}", zonaCuerpoDTO.toString());
        return zonaCuerpoDTO;
    }

    /**
     * Busca y devuelve todos los libros que existen en la ejercicio.
     *
     * @param ejerciciosId Identificador de la ejercicio que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @return JSONArray {@link ZonaCuerpoDTO} - Los libros encontrados en la
     * ejercicio. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<ZonaCuerpoDTO> getZonasCuerpo(@PathParam("ejerciciosId") Long ejerciciosId) {
        LOGGER.log(Level.INFO, "EjercicioZonasCuerpoResource getZonasCuerpo: input: {0}", ejerciciosId);
        List<ZonaCuerpoDTO> listaDetailDTOs = zonasCuerpoListEntity2DTO(ejercicioZonasCuerpoLogic.getZonasCuerpo(ejerciciosId));
        LOGGER.log(Level.INFO, "EjercicioZonasCuerpoResource getZonasCuerpo: output: {0}", listaDetailDTOs.toString());
        return listaDetailDTOs;
    }

    /**
     * Busca el libro con el id asociado dentro de la ejercicio con id asociado.
     *
     * @param ejerciciosId Identificador de la ejercicio que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @param zonasCuerpoId Identificador del libro que se esta buscando. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link ZonaCuerpoDTO} - El libro buscado
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el libro en la
     * ejercicio.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el libro.
     */
    @GET
    @Path("{zonasCuerpoId: \\d+}")
    public ZonaCuerpoDTO getZonaCuerpo(@PathParam("ejerciciosId") Long ejerciciosId, @PathParam("zonasCuerpoId") Long zonasCuerpoId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "EjercicioZonasCuerpoResource getZonaCuerpo: input: ejerciciosID: {0} , zonasCuerpoId: {1}", new Object[]{ejerciciosId, zonasCuerpoId});
        if (zonaCuerpoLogic.getZonaCuerpo(zonasCuerpoId) == null) {
            throw new WebApplicationException("El recurso /ejercicios/" + ejerciciosId + "/zonasCuerpo/" + zonasCuerpoId + " no existe.", 404);
        }
        ZonaCuerpoDTO zonaCuerpoDTO = new ZonaCuerpoDTO(ejercicioZonasCuerpoLogic.getZonaCuerpo(ejerciciosId, zonasCuerpoId));
        LOGGER.log(Level.INFO, "EjercicioZonasCuerpoResource getZonaCuerpo: output: {0}", zonaCuerpoDTO.toString());
        return zonaCuerpoDTO;
    }

    /**
     * Remplaza las instancias de ZonaCuerpo asociadas a una instancia de Ejercicio
     *
     * @param ejerciciosId Identificador de la ejercicio que se esta
     * remplazando. Este debe ser una cadena de dígitos.
     * @param zonasCuerpo JSONArray {@link ZonaCuerpoDTO} El arreglo de libros nuevo para la
     * ejercicio.
     * @return JSON {@link ZonaCuerpoDTO} - El arreglo de libros guardado en la
     * ejercicio.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el libro.
     */
    @PUT
    public List<ZonaCuerpoDTO> replaceZonasCuerpo(@PathParam("ejerciciosId") Long ejerciciosId, List<ZonaCuerpoDTO> zonasCuerpo) {
        LOGGER.log(Level.INFO, "EjercicioZonasCuerpoResource replaceZonasCuerpo: input: ejerciciosId: {0} , zonasCuerpo: {1}", new Object[]{ejerciciosId, zonasCuerpo.toString()});
        for (ZonaCuerpoDTO zonaCuerpo : zonasCuerpo) {
            if (zonaCuerpoLogic.getZonaCuerpo(zonaCuerpo.getId()) == null) {
                throw new WebApplicationException("El recurso /zonasCuerpo/" + zonaCuerpo.getId() + " no existe.", 404);
            }
        }
        List<ZonaCuerpoDTO> listaDetailDTOs = zonasCuerpoListEntity2DTO(ejercicioZonasCuerpoLogic.replaceZonasCuerpo(ejerciciosId, zonasCuerpoListDTO2Entity(zonasCuerpo)));
        LOGGER.log(Level.INFO, "EjercicioZonasCuerpoResource replaceZonasCuerpo: output: {0}", listaDetailDTOs.toString());
        return listaDetailDTOs;
    }

    /**
     * Convierte una lista de ZonaCuerpoEntity a una lista de ZonaCuerpoDTO.
     *
     * @param entityList Lista de ZonaCuerpoEntity a convertir.
     * @return Lista de ZonaCuerpoDTO convertida.
     */
    private List<ZonaCuerpoDTO> zonasCuerpoListEntity2DTO(List<ZonaCuerpoEntity> entityList) {
        List<ZonaCuerpoDTO> list = new ArrayList();
        for (ZonaCuerpoEntity entity : entityList) {
            list.add(new ZonaCuerpoDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de ZonaCuerpoDTO a una lista de ZonaCuerpoEntity.
     * 
     * @param dtos Lista de ZonaCuerpoDTO a convertir.
     * @return Lista de ZonaCuerpoEntity convertida.
     */
    private List<ZonaCuerpoEntity> zonasCuerpoListDTO2Entity(List<ZonaCuerpoDTO> dtos) {
        List<ZonaCuerpoEntity> list = new ArrayList<>();
        for (ZonaCuerpoDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
}
