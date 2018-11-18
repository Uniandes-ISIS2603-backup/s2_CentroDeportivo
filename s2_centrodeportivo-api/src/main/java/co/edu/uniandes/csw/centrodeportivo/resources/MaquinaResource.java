/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/
package co.edu.uniandes.csw.centrodeportivo.resources;
import co.edu.uniandes.csw.centrodeportivo.dtos.MaquinaDTO;
import co.edu.uniandes.csw.centrodeportivo.dtos.MaquinaDetailDTO;
import co.edu.uniandes.csw.centrodeportivo.ejb.MaquinaLogic;
import co.edu.uniandes.csw.centrodeportivo.entities.MaquinaEntity;
import co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;


/**
 * Clase que implementa el recurso "maquinas".
 *
 * @author Diany Quintero
 */
@Path("maquinas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class MaquinaResource implements Serializable {
    
    private static final Logger LOGGER = Logger.getLogger(MaquinaResource.class.getName());
    
    @Inject
    private MaquinaLogic maquinaLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    
    /**
     * Crea una nueva maquina con la informacion que se recibe en el cuerpo de la
     * petición y se regresa un objeto identico con un id auto-generado por la
     * base de datos.
     *
     * @param maquina {@link MaquinaDTO} - La maquina que se desea guardar.
     * @return JSON {@link MaquinaDTO} - La maquina guardada con el atributo id
     * autogenerado.
     */
    @POST
    public MaquinaDTO createMaquina(MaquinaDTO maquina)
    {
        LOGGER.log(Level.INFO, "MaquinaResource createMaquina: input: {0}", maquina.toString());
        // Convierte el DTO (json) en un objeto Entity para ser manejado por la lógica.
        MaquinaEntity maquinaEntity = maquina.toEntity();
        // Invoca la lógica para crear la editorial nueva
        MaquinaEntity nuevaMaquinaEntity = maquinaLogic.createMaquina(maquinaEntity);
        // Como debe retornar un DTO (json) se invoca el constructor del DTO con argumento el entity nuevo
        MaquinaDTO nuevaMaquinaDTO = new MaquinaDTO(nuevaMaquinaEntity);
        LOGGER.log(Level.INFO, "MaquinaResource createMaquina: output: {0}", nuevaMaquinaDTO.toString());
        return nuevaMaquinaDTO;
    }
    
    /**
     * Busca y devuelve todas las maquinas que existen en la aplicacion.
     *
     * @return JSONArray {@link MaquinaDetailDTO} - Las maquinas encontradas en la
     * aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<MaquinaDetailDTO> getMaquinas()
    {
        LOGGER.info("MaquinaReosurce getMaquinas: input: void");
        List<MaquinaDetailDTO> listaMaquinas = listEntity2DetailDTO(maquinaLogic.getMaquinas());
        LOGGER.log(Level.INFO, "MaquinaReosurce getMaquinas: output: {0}", listaMaquinas.toString());
        return listaMaquinas;
    }
    
    /**
     * Busca la maquina con el id asociado recibido en la URL y la devuelve.
     *
     * @param maquinasId Identificador de la maquina que se esta buscando. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link MaquinaDetailDTO} - La maquina buscado
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la maquina.
     */
    @GET
    @Path("{maquinasId: \\d+}")
    public MaquinaDetailDTO getMaquina(@PathParam("maquinasId") Long maquinasId) throws WebApplicationException {
        
        LOGGER.log(Level.INFO, "MaquinaResource getMaquina: input: {0}", maquinasId);
        MaquinaEntity maquinaEntity = maquinaLogic.getMaquina(maquinasId);
        if (maquinaEntity == null) {
            throw new WebApplicationException("El recurso /maquinas/" + maquinasId + " no existe.", 404);
        }
        MaquinaDetailDTO detailDTO = new MaquinaDetailDTO(maquinaEntity);
        LOGGER.log(Level.INFO, "MaquinaResource getMaquina: output: {0}", detailDTO.toString());
        return detailDTO;
    }
    
    /**
     * Actualiza la maquina con el id recibido en la URL con la información que se
     * recibe en el cuerpo de la petición.
     *
     * @param maquinasId Identificador de la maquina que se desea actualizar. Este
     * debe ser una cadena de dígitos.
     * @param maquina {@link MaquinaDetailDTO} La maquina que se desea guardar.
     * @return JSON {@link MaquinaDetailDTO} - La maquina guardado.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la maquina a
     * actualizar.
     */
    @PUT
    @Path("{maquinasId: \\d+}")
    public MaquinaDTO actualizarAtributos(@PathParam("maquinasId") Long maquinasId, MaquinaDTO maquina)
    {
        LOGGER.log(Level.INFO, "MaquinaResource updateMaquina: input: id:{0} , maquina: {1}", new Object[]{maquinasId, maquina.toString()});
        maquina.setId(maquinasId);
        if (maquinaLogic.getMaquina(maquinasId) == null) {
            throw new WebApplicationException("El recurso /maquinas/" + maquinasId + " no existe.", 404);
        }
        MaquinaDetailDTO detailDTO = new MaquinaDetailDTO(maquinaLogic.updateMaquina(maquinasId, maquina.toEntity()));
        LOGGER.log(Level.INFO, "MaquinaResource updateMaquina: output: {0}", detailDTO.toString());
        return detailDTO;
    }
    
    /**
     * Borra la maquina con el id asociado recibido en la URL.
     *
     * @param maquinasId Identificador dela maquina que se desea borrar. Este debe
     * ser una cadena de dígitos.
     * @throws co.edu.uniandes.csw.centrodeportivo.exceptions.BusinessLogicException
     * si la maquina tiene ejercicios asociados
     * @throws WebApplicationException {@link WebApplicationExceptionMapper}
     * Error de lógica que se genera cuando no se encuentra la maquina a borrar.
     */
    @DELETE
    @Path("{maquinasId: \\d+}")
    public void eliminarMaquina(@PathParam("maquinasId") Long maquinasId) throws BusinessLogicException
    {
        LOGGER.log(Level.INFO, "MaquinaResource deleteMaquina: input: {0}", maquinasId);
        if (maquinaLogic.getMaquina(maquinasId) == null) {
            throw new WebApplicationException("El recurso /maquinas/" + maquinasId + " no existe.", 404);
        }
        maquinaLogic.deleteMaquina(maquinasId);
        
        LOGGER.info("MaquinaResource deleteMaquina: output: void");
    }
    
    /**
     * Convierte una lista de MaquinaEntity a una lista de MaquinaDetailDTO.
     *
     * @param entityList Lista de MaquinaEntity a convertir.
     * @return Lista de MaquinaDetailDTO convertida.
     */
    private List<MaquinaDetailDTO> listEntity2DetailDTO(List<MaquinaEntity> entityList) {
        List<MaquinaDetailDTO> list = new ArrayList<>();
        for (MaquinaEntity entity : entityList) {
            list.add(new MaquinaDetailDTO(entity));
        }
        return list;
    }
    
    /**
     * Conexión con el servicio de ejercicios para un maquina.
     * {@link MaquinaEjerciciosResource}
     *
     * Este método conecta la ruta de /maquinas con las rutas de /ejercicios que
     * dependen de la maquina, es una redirección al servicio que maneja el segmento
     * de la URL que se encarga de los ejercicios.
     *
     * @param maquinasId El ID de la maquina con respecto al cual se accede al
     * servicio.
     * @return El servicio de ejercicios para esa maquina en paricular.
     */
    @Path("{maquinasId: \\d+}/ejercicios")
    public Class<MaquinaEjerciciosResource> getMaquinaEjerciciosReosurce(@PathParam("maquinasId") Long maquinasId) {
        if (maquinaLogic.getMaquina(maquinasId) == null) {
            throw new WebApplicationException("El recurso /maquinas/" + maquinasId + " no existe.", 404);
        }
        return MaquinaEjerciciosResource.class;
    }
}