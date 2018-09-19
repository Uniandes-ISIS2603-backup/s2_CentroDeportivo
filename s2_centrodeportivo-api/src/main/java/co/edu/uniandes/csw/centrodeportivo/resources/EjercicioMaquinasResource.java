/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.resources;

import co.edu.uniandes.csw.centrodeportivo.dtos.MaquinaDTO;
import co.edu.uniandes.csw.centrodeportivo.ejb.EjercicioMaquinasLogic;
import co.edu.uniandes.csw.centrodeportivo.ejb.MaquinaLogic;
import co.edu.uniandes.csw.centrodeportivo.entities.MaquinaEntity;
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
public class EjercicioMaquinasResource {
    private static final Logger LOGGER = Logger.getLogger(EjercicioMaquinasResource.class.getName());

    @Inject
    private EjercicioMaquinasLogic ejercicioMaquinasLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    @Inject
    private MaquinaLogic maquinaLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    /**
     * Guarda un libro dentro de una ejercicio con la informacion que recibe el
     * la URL. Se devuelve el libro que se guarda en la ejercicio.
     *
     * @param ejerciciosId Identificador de la ejercicio que se esta
     * actualizando. Este debe ser una cadena de dígitos.
     * @param maquinasId Identificador del libro que se desea guardar. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link MaquinaDTO} - El libro guardado en la ejercicio.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el libro.
     */
    @POST
    @Path("{maquinasId: \\d+}")
    public MaquinaDTO addMaquina(@PathParam("ejerciciosId") Long ejerciciosId, @PathParam("maquinasId") Long maquinasId) {
        LOGGER.log(Level.INFO, "EjercicioMaquinasResource addMaquina: input: ejerciciosID: {0} , maquinasId: {1}", new Object[]{ejerciciosId, maquinasId});
        if (maquinaLogic.getMaquina(maquinasId) == null) {
            throw new WebApplicationException("El recurso /maquinas/" + maquinasId + " no existe.", 404);
        }
        MaquinaDTO maquinaDTO = new MaquinaDTO(ejercicioMaquinasLogic.addMaquina(maquinasId, ejerciciosId));
        LOGGER.log(Level.INFO, "EjercicioMaquinasResource addMaquina: output: {0}", maquinaDTO.toString());
        return maquinaDTO;
    }

    /**
     * Busca y devuelve todos los libros que existen en la ejercicio.
     *
     * @param ejerciciosId Identificador de la ejercicio que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @return JSONArray {@link MaquinaDTO} - Los libros encontrados en la
     * ejercicio. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<MaquinaDTO> getMaquinas(@PathParam("ejerciciosId") Long ejerciciosId) {
        LOGGER.log(Level.INFO, "EjercicioMaquinasResource getMaquinas: input: {0}", ejerciciosId);
        List<MaquinaDTO> listaDetailDTOs = maquinasListEntity2DTO(ejercicioMaquinasLogic.getMaquinas(ejerciciosId));
        LOGGER.log(Level.INFO, "EjercicioMaquinasResource getMaquinas: output: {0}", listaDetailDTOs.toString());
        return listaDetailDTOs;
    }

    /**
     * Busca el libro con el id asociado dentro de la ejercicio con id asociado.
     *
     * @param ejerciciosId Identificador de la ejercicio que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @param maquinasId Identificador del libro que se esta buscando. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link MaquinaDTO} - El libro buscado
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el libro en la
     * ejercicio.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el libro.
     */
    @GET
    @Path("{maquinasId: \\d+}")
    public MaquinaDTO getMaquina(@PathParam("ejerciciosId") Long ejerciciosId, @PathParam("maquinasId") Long maquinasId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "EjercicioMaquinasResource getMaquina: input: ejerciciosID: {0} , maquinasId: {1}", new Object[]{ejerciciosId, maquinasId});
        if (maquinaLogic.getMaquina(maquinasId) == null) {
            throw new WebApplicationException("El recurso /ejercicios/" + ejerciciosId + "/maquinas/" + maquinasId + " no existe.", 404);
        }
        MaquinaDTO maquinaDTO = new MaquinaDTO(ejercicioMaquinasLogic.getMaquina(ejerciciosId, maquinasId));
        LOGGER.log(Level.INFO, "EjercicioMaquinasResource getMaquina: output: {0}", maquinaDTO.toString());
        return maquinaDTO;
    }

    /**
     * Remplaza las instancias de Maquina asociadas a una instancia de Ejercicio
     *
     * @param ejerciciosId Identificador de la ejercicio que se esta
     * remplazando. Este debe ser una cadena de dígitos.
     * @param maquinas JSONArray {@link MaquinaDTO} El arreglo de libros nuevo para la
     * ejercicio.
     * @return JSON {@link MaquinaDTO} - El arreglo de libros guardado en la
     * ejercicio.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el libro.
     */
    @PUT
    public List<MaquinaDTO> replaceMaquinas(@PathParam("ejerciciosId") Long ejerciciosId, List<MaquinaDTO> maquinas) {
        LOGGER.log(Level.INFO, "EjercicioMaquinasResource replaceMaquinas: input: ejerciciosId: {0} , maquinas: {1}", new Object[]{ejerciciosId, maquinas.toString()});
        for (MaquinaDTO maquina : maquinas) {
            if (maquinaLogic.getMaquina(maquina.getId()) == null) {
                throw new WebApplicationException("El recurso /maquinas/" + maquina.getId() + " no existe.", 404);
            }
        }
        List<MaquinaDTO> listaDetailDTOs = maquinasListEntity2DTO(ejercicioMaquinasLogic.replaceMaquinas(ejerciciosId, maquinasListDTO2Entity(maquinas)));
        LOGGER.log(Level.INFO, "EjercicioMaquinasResource replaceMaquinas: output: {0}", listaDetailDTOs.toString());
        return listaDetailDTOs;
    }

    /**
     * Convierte una lista de MaquinaEntity a una lista de MaquinaDTO.
     *
     * @param entityList Lista de MaquinaEntity a convertir.
     * @return Lista de MaquinaDTO convertida.
     */
    private List<MaquinaDTO> maquinasListEntity2DTO(List<MaquinaEntity> entityList) {
        List<MaquinaDTO> list = new ArrayList();
        for (MaquinaEntity entity : entityList) {
            list.add(new MaquinaDTO(entity));
        }
        return list;
    }

    /**
     * Convierte una lista de MaquinaDTO a una lista de MaquinaEntity.
     * 
     * @param dtos Lista de MaquinaDTO a convertir.
     * @return Lista de MaquinaEntity convertida.
     */
    private List<MaquinaEntity> maquinasListDTO2Entity(List<MaquinaDTO> dtos) {
        List<MaquinaEntity> list = new ArrayList<>();
        for (MaquinaDTO dto : dtos) {
            list.add(dto.toEntity());
        }
        return list;
    }
}
