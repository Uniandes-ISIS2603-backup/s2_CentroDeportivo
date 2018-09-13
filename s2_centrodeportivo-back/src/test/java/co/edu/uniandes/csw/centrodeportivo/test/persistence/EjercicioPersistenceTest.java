/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.test.persistence;


import co.edu.uniandes.csw.centrodeportivo.entities.EjercicioEntity;
import co.edu.uniandes.csw.centrodeportivo.persistence.EjercicioPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author Daniel Pardo
 */
@RunWith(Arquillian.class)
public class EjercicioPersistenceTest 
{
    @Inject
    private EjercicioPersistence ejercicioPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    private List<EjercicioEntity> data = new ArrayList<>();
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EjercicioEntity.class.getPackage())
                .addPackage(EjercicioEntity.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            inserData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    private void clearData() {
        em.createQuery("delete from EjercicioEntity").executeUpdate();
    }

    private void inserData() {
        PodamFactory factory = new PodamFactoryImpl();
        for(int i = 0; i < 3; i++)
        {
            EjercicioEntity entidad = factory.manufacturePojo(EjercicioEntity.class);
            
            em.persist (entidad);
            data.add (entidad);
        }
    }
    
    @Test
    public void createEjercicioEntity()
    {
        PodamFactory factory =  new PodamFactoryImpl();
        EjercicioEntity nuevoEjercicio = factory.manufacturePojo(EjercicioEntity.class);
        EjercicioEntity resultado = ejercicioPersistence.create(nuevoEjercicio);
        
        Assert.assertNotNull(resultado);
        EjercicioEntity entidad = em.find(EjercicioEntity.class, resultado.getId());
        
        //Assert.assertEquals(nuevoEjercicio.getId(), entidad.getId());
    }
    
    @Test
    public void getEjerciciosTest()
    {
        List<EjercicioEntity> lista = ejercicioPersistence.findAll();
        Assert.assertEquals(data.size(), lista.size());
        for (EjercicioEntity entidad : lista) {
            boolean found = false;
            for (EjercicioEntity entity : data) {
                if (entidad.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getEjercicioTest() {
        EjercicioEntity entity = data.get(0);
        EjercicioEntity nuevaEntity = ejercicioPersistence.find(entity.getId());
        Assert.assertNotNull(nuevaEntity);
        Assert.assertEquals(entity.getNombre(), nuevaEntity.getNombre());
        Assert.assertEquals(entity.getId(), nuevaEntity.getId());
    }
    
    @Test
    public void updateEjercicioTest() {
        EjercicioEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        EjercicioEntity newEntity = factory.manufacturePojo(EjercicioEntity.class);

        newEntity.setId(entity.getId());

        ejercicioPersistence.update(newEntity);

        EjercicioEntity resp = em.find(EjercicioEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getId(), resp.getId());
    }
    
    @Test
    public void deleteEjercicioTest() {
        EjercicioEntity entity = data.get(0);
        ejercicioPersistence.delete(entity.getId());
        EjercicioEntity deleted = em.find(EjercicioEntity.class, entity.getId());
        Assert.assertNull(deleted);
    }
}
