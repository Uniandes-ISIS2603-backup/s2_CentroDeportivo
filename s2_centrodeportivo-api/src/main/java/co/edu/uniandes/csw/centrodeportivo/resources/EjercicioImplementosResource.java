/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;

import co.edu.uniandes.csw.centrodeportivo.dtos.ImplementoDTO;
import co.edu.uniandes.csw.centrodeportivo.ejb.EjercicioImplementosLogic;
import co.edu.uniandes.csw.centrodeportivo.ejb.ImplementoLogic;
import co.edu.uniandes.csw.centrodeportivo.entities.ImplementoEntity;
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
 *
 * @author estudiante
 */
public class EjercicioImplementosResource {
    private static final Logger LOGGER = Logger.getLogger(EjercicioImplementosResource.class.getName());

    @Inject
    private EjercicioImplementosLogic ejercicioImplementosLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    @Inject
    private ImplementoLogic implementoLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    /**
     * Guarda un libro dentro de una ejercicio con la informacion que recibe el
     * la URL. Se devuelve el libro que se guarda en la ejercicio.
     *
     * @param ejerciciosId Identificador de la ejercicio que se esta
     * actualizando. Este debe ser una cadena de dígitos.
     * @param implementosId Identificador del libro que se desea guardar. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link ImplementoDTO} - El libro guardado en la ejercicio.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el libro.
     */
    @POST
    @Path("{implementosId: \\d+}")
    public ImplementoDTO addImplemento(@PathParam("ejerciciosId") Long ejerciciosId, @PathParam("implementosId") Long implementosId) {
        LOGGER.log(Level.INFO, "EjercicioImplementosResource addImplemento: input: ejerciciosID: {0} , implementosId: {1}", new Object[]{ejerciciosId, implementosId});
        if (implementoLogic.getImplemento(implementosId) == null) {
            throw new WebApplicationException("El recurso /implementos/" + implementosId + " no existe.", 404);
        }
        ImplementoDTO implementoDTO = new ImplementoDTO(ejercicioImplementosLogic.addImplemento(implementosId, ejerciciosId));
        LOGGER.log(Level.INFO, "EjercicioImplementosResource addImplemento: output: {0}", implementoDTO.toString());
        return implementoDTO;
    }

    /**
     * Busca y devuelve todos los libros que existen en la ejercicio.
     *
     * @param ejerciciosId Identificador de la ejercicio que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @return JSONArray {@link ImplementoDTO} - Los libros encontrados en la
     * ejercicio. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<ImplementoDTO> getImplementos(@PathParam("ejerciciosId") Long ejerciciosId) {
        LOGGER.log(Level.INFO, "EjercicioImplementosResource getImplementos: input: {0}", ejerciciosId);
        List<ImplementoDTO> listaDetailDTOs = implementosListEntity2DTO(ejercicioImplementosLogic.getImplementos(ejerciciosId));
        LOGGER.log(Level.INFO, "EjercicioImplementosResource getImplementos: output: {0}", listaDetailDTOs.toString());
        return listaDetailDTOs;
    }

    /**
     * Busca el libro con el id asociado dentro de la ejercicio con id asociado.
     *
     * @param ejerciciosId Identificador de la ejercicio que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @param implementosId Identificador del libro que se esta buscando. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link ImplementoDTO} - El libro buscado
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el libro en la
     * ejercicio.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el libro.
     */
    @GET
    @Path("{implementosId: \\d+}")
    public ImplementoDTO getImplemento(@PathParam("ejerciciosId") Long ejerciciosId, @PathParam("implementosId") Long implementosId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "EjercicioImplementosResource getImplemento: input: ejerciciosID: {0} , implementosId: {1}", new Object[]{ejerciciosId, implementosId});
        if (implementoLogic.getImplemento(implementosId) == null) {
            throw new WebApplicationException("El recurso /ejercicios/" + ejerciciosId + "/implementos/" + implementosId + " no existe.", 404);
        }
        ImplementoDTO implementoDTO = new ImplementoDTO(ejercicioImplementosLogic.getImplemento(ejerciciosId, implementosId));
        LOGGER.log(Level.INFO, "EjercicioImplementosResource getImplemento: output: {0}", implementoDTO.toString());
        return implementoDTO;
    }

    /**
     * Remplaza las instancias de Implemento asociadas a una instancia de Ejercicio
     *
     * @param ejerciciosId Identificador de la ejercicio que se esta
     * remplazando. Este debe ser una cadena de dígitos.
     * @param implementos JSONArray {@link ImplementoDTO} El arreglo de libros nuevo para la
     * ejercicio.
     * @return JSON {@link ImplementoDTO} - El arreglo de libros guardado en la
     * ejercicio.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el libro.
     */
    @PUT
    public List<ImplementoDTO> replaceImplementos(@PathParam("ejerciciosId") Long ejerciciosId, List<ImplementoDTO> implementos) {
        LOGGER.log(Level.INFO, "EjercicioImplementosResource replaceImplementos: input: ejerciciosId: {0} , implementos: {1}", new Object[]{ejerciciosId, implementos.toString()});
        for (ImplementoDTO implemento : implementos) {
            if (implementoLogic.getImplemento(implemento.getId()) == null) {
                throw new WebApplicationException("El recurso /implementos/" + implemento.getId() + " no existe.", 404);
            }
        }
        List<ImplementoDTO> listaDetailDTOs = implementosListEntity2DTO(ejercicioImplementosLogic.replaceImplementos(ejerciciosId, implementosListDTO2Entity(implementos)));
        LOGGER.log(Level.INFO, "EjercicioImplementosResource replaceImplementos: output: {0}", listaDetailDTOs.toString());
        return listaDetailDTOs;
    }

    /**
     * Convierte una lista de ImplementoEntity a una lista de ImplementoDTO.
     *
     * @param entityList Lista de ImplementoEntity a convertir.
     * @return Lista de ImplementoDTO convertida.
     */
    private List<ImplementoDTO> implementosListEntity2DTO(List<ImplementoEntity> entityList) {
        List<ImplementoDTO> list = new ArrayList();
        for (ImplementoEntity entity : entityList) {
            list.add(new ImplementoDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de ImplementoDTO a una lista de ImplementoEntity.
     * 
     * @param dtos Lista de ImplementoDTO a convertir.
     * @return Lista de ImplementoEntity convertida.
     */
    private List<ImplementoEntity> implementosListDTO2Entity(List<ImplementoDTO> dtos) {
        List<ImplementoEntity> list = new ArrayList<>();
        for (ImplementoDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
}
