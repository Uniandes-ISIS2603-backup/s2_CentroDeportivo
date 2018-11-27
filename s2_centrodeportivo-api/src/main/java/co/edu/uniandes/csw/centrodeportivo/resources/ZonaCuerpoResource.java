/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.uniandes.csw.centrodeportivo.resources;

import co.edu.uniandes.csw.centrodeportivo.dtos.ZonaCuerpoDTO;
import co.edu.uniandes.csw.centrodeportivo.ejb.ZonaCuerpoLogic;
import co.edu.uniandes.csw.centrodeportivo.entities.ZonaCuerpoEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 * Clase que implementa el recurso "ZonasCuerpo".
 *
 * @zonaCuerpo Daniel Pardo
 */
@Path("zonasCuerpo")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ZonaCuerpoResource
{
    private static final Logger LOGGER = Logger.getLogger(ZonaCuerpoResource.class.getName());
    
    @Inject
    ZonaCuerpoLogic zonaCuerpoLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    
    /**
     * Crea un nuevo zona del cuerpo con la información que se recibe en el cuerpo de la
     * petición y se regresa un objeto idéntico con un id auto-generado por la
     * base de datos.
     *
     * @param zonaCuerpo {@link ZonaCuerpoDTO} - La zona del cuerpo que se desea guardar.
     * @return JSON {@link ZonaCuerpoDTO} - La zona del cuerpo guardada con el atributo id
     * autogenerado.
     */
    @POST
    public ZonaCuerpoDTO createZonaCuerpo(ZonaCuerpoDTO zonaCuerpo)
    {
        LOGGER.log(Level.INFO, "ZonaCuerpoResource createZonaCuerpo: input: {0}", zonaCuerpo.toString());
        ZonaCuerpoDTO nuevoZonaCuerpoDTO = new ZonaCuerpoDTO(zonaCuerpoLogic.createZonaCuerpo(zonaCuerpo.toEntity()));
        LOGGER.log(Level.INFO, "ZonaCuerpoResource createZonaCuerpo: output: {0}", nuevoZonaCuerpoDTO.toString());
        return nuevoZonaCuerpoDTO;
    }
    
    /**
     * Busca y devuelve todos las zonas del cuerpo que existen en la aplicación.
     *
     * @return JSONArray {@link ZonaCuerpoDetailDTO} - Las zonas del cuerpo encontradas en la
     * aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<ZonaCuerpoDTO> getZonasCuerpo() {
        LOGGER.info("ZonaCuerpoResource getZonasCuerpo: input: void");
        List<ZonaCuerpoDTO> listaZonasCuerpo = listEntity2DetailDTO(zonaCuerpoLogic.getZonasCuerpo());
        LOGGER.log(Level.INFO, "ZonaCuerpoResource getZonasCuerpo: output: {0}", listaZonasCuerpo.toString());
        return listaZonasCuerpo;
    }
    
    /**
     * Busca la zona del cuerpo con el id asociado recibido en la URL y la devuelve.
     *
     * @param zonasCuerpoId Identificador de la zona del cuerpo que se esta buscando. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link ZonaCuerpoDTO} - La zona del cuerpo buscada
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la zona del cuerpo.
     */
    @GET
    @Path("{zonasCuerpoId: \\d+}")
    public ZonaCuerpoDTO getZonaCuerpo(@PathParam("zonasCuerpoId") Long zonasCuerpoId) throws WebApplicationException
    {
        LOGGER.log(Level.INFO, "ZonaCuerpoResource getZonaCuerpo: input: {0}", zonasCuerpoId);
        ZonaCuerpoEntity entity = zonaCuerpoLogic.getZonaCuerpo(zonasCuerpoId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /zonasCuerpo/" + zonasCuerpoId + " no existe.", 404);
        }
        ZonaCuerpoDTO zonaCuerpoDTO = new ZonaCuerpoDTO(zonaCuerpoLogic.getZonaCuerpo(zonasCuerpoId));
        LOGGER.log(Level.INFO, "ZonaCuerpoResource getZonaCuerpo: output: {0}", zonaCuerpoDTO.toString());
        return zonaCuerpoDTO;
    }
    
    /**
     * Actualiza la zona del cuerpo con el id recibido en la URL con la información que se
     * recibe en el cuerpo de la petición.
     *
     * @param zonasCuerpoId Identificador de la zona del cuerpo que se desea actualizar. Este
     * debe ser una cadena de dígitos.
     * @param zonaCuerpo {@link ZonaCuerpoDTO} La zona del cuerpo que se desea guardar.
     * @return JSON {@link ZonaCuerpoDTO} - La zona del cuerpo guardado.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la zona del cuerpo a
     * actualizar.
     */
    @PUT
    @Path("{zonasCuerpoId: \\d+}")
    public ZonaCuerpoDTO updateZonaCuerpo(@PathParam("zonasCuerpoId") Long zonasCuerpoId, ZonaCuerpoDTO zonaCuerpo) throws WebApplicationException {
        
        LOGGER.log(Level.INFO, "ZonaCuerpoResource updateZonaCuerpo: input: zonasCuerpoId: {0} , zonaCuerpo: {1}", new Object[]{zonasCuerpoId, zonaCuerpo.toString()});
        zonaCuerpo.setId(zonasCuerpoId);
        ZonaCuerpoEntity entity = zonaCuerpoLogic.getZonaCuerpo(zonasCuerpoId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /zonasCuerpo/" + zonasCuerpoId + " no existe.", 404);
        }
        ZonaCuerpoDTO detailDTO = new ZonaCuerpoDTO(zonaCuerpoLogic.updateZonaCuerpo(zonasCuerpoId, zonaCuerpo.toEntity()));
        LOGGER.log(Level.INFO, "ZonaCuerpoResource updateZonaCuerpo: output: {0}", detailDTO.toString());
        return detailDTO;
    }
    
    /**
     * Borra la zona del cuerpo con el id asociado recibido en la URL.
     *
     * @param zonasCuerpoId Identificador de la zona del cuerpo que se desea borrar. Este debe
     * ser una cadena de dígitos.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper}
     * Error de lógica que se genera cuando no se encuentra la zona del cuerpo a borrar.
     */
    @DELETE
    @Path("{zonasCuerpoId: \\d+}")
    public void deleteZonaCuerpo(@PathParam("zonasCuerpoId") Long zonasCuerpoId) {
        LOGGER.log(Level.INFO, "ZonaCuerpoResource deleteZonaCuerpo: input: {0}", zonasCuerpoId);
        ZonaCuerpoEntity entity = zonaCuerpoLogic.getZonaCuerpo(zonasCuerpoId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /zonasCuerpo/" + zonasCuerpoId + " no existe.", 404);
        }
        
        zonaCuerpoLogic.deleteZonaCuerpo(zonasCuerpoId);
        LOGGER.info("ZonaCuerpoResource deleteZonaCuerpo: output: void");
    }
    
    /**
     * Convierte una lista de ZonaCuerpoEntity a una lista de ZonaCuerpoDTO.
     *
     * @param entityList Lista de ZonaCuerpoEntity a convertir.
     * @return Lista de ZonaCuerpoDTO convertida.
     */
    private List<ZonaCuerpoDTO> listEntity2DetailDTO(List<ZonaCuerpoEntity> entityList) {
        List<ZonaCuerpoDTO> list = new ArrayList();
        for (ZonaCuerpoEntity entity : entityList) {
            list.add(new ZonaCuerpoDTO(entity));
        }
        return list;
    }
    
    /**
     * Conexión con el servicio de ejercicios para una zona del cuerpo.
     * {@link ZonaCuerpoEjercicioResource}
     *
     * Este método conecta la ruta de /zonasCuerpo con las rutas de /ejercicios que
     * dependen de la zona del cuerpo, es una redirección al servicio que maneja el segmento
     * de la URL que se encarga de los ejercicios.
     *
     * @param zonasCuerpoId El ID de la zona del cuerpo con respecto al cual se accede al
     * servicio.
     * @return El servicio de Ejercicios para esa zona del cuerpo en paricular.
     */
    @Path("{zonasCuerpoId: \\d+}/ejercicios")
    public Class<ZonaCuerpoEjercicioResource> getZonaCuerpoEjercicioResource(@PathParam("zonasCuerpoId") Long zonasCuerpoId) {
        if (zonaCuerpoLogic.getZonaCuerpo(zonasCuerpoId) == null) {
            throw new WebApplicationException("El recurso /zonasCuerpo/" + zonasCuerpoId + " no existe.", 404);
        }
        return ZonaCuerpoEjercicioResource.class;
    }
}