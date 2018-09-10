/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.centrodeportivo.test.persistence;
import co.edu.uniandes.csw.centrodeportivo.entities.ZonaCuerpoEntity;
import co.edu.uniandes.csw.centrodeportivo.persistence.ZonaCuerpoPersistence;
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
public class ZonaCuerpoPersistenceTest 
{
    @Inject
    private ZonaCuerpoPersistence zonaCuerpoPersistence;
    
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    UserTransaction utx;
    
    private List<ZonaCuerpoEntity> data = new ArrayList<>();
    
    @Deployment
    public static JavaArchive createDeployment(){
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(ZonaCuerpoEntity.class.getPackage())
                .addPackage(ZonaCuerpoEntity.class.getPackage())
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
        em.createQuery("delete from ZonaCuerpoEntity").executeUpdate();
    }

    private void inserData() {
        PodamFactory factory = new PodamFactoryImpl();
        for(int i = 0; i<10 ; i++)
        {
            ZonaCuerpoEntity entidad = factory.manufacturePojo(ZonaCuerpoEntity.class);
            
            em.persist (entidad);
            data.add (entidad);
        }
    }
    
    @Test
    public void createEjercicioEntity()
    {
        PodamFactory factory =  new PodamFactoryImpl();
        ZonaCuerpoEntity nuevaZonaCuerpo = factory.manufacturePojo(ZonaCuerpoEntity.class);
        ZonaCuerpoEntity resultado = zonaCuerpoPersistence.create(nuevaZonaCuerpo);
        
        Assert.assertNotNull(resultado);
        ZonaCuerpoEntity entidad = em.find(ZonaCuerpoEntity.class, resultado.getId());
        
        Assert.assertEquals(nuevaZonaCuerpo.getId(), entidad.getId());
    }
    
    @Test
    public void getEjerciciosTest()
    {
        List<ZonaCuerpoEntity> lista = zonaCuerpoPersistence.findAll();
        Assert.assertEquals(data.size(), lista.size());
        for (ZonaCuerpoEntity entidad : lista) {
            boolean found = false;
            for (ZonaCuerpoEntity entity : data) {
                if (entidad.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }
    
    @Test
    public void getEjercicioTest() {
        ZonaCuerpoEntity entity = data.get(0);
        ZonaCuerpoEntity nuevaEntity = zonaCuerpoPersistence.find(entity.getId());
        Assert.assertNotNull(nuevaEntity);
        Assert.assertEquals(entity.getNombre(), nuevaEntity.getNombre());
        Assert.assertEquals(entity.getId(), nuevaEntity.getId());
    }
    
    @Test
    public void updateEjercicioTest() {
        ZonaCuerpoEntity entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        ZonaCuerpoEntity newEntity = factory.manufacturePojo(ZonaCuerpoEntity.class);

        newEntity.setId(entity.getId());

        zonaCuerpoPersistence.update(newEntity);

        ZonaCuerpoEntity resp = em.find(ZonaCuerpoEntity.class, entity.getId());

        Assert.assertEquals(newEntity.getNombre(), resp.getNombre());
    }
    
    @Test
    public void deleteEjercicioTest() {
        ZonaCuerpoEntity entity = data.get(0);
        zonaCuerpoPersistence.delete(entity.getId());
        ZonaCuerpoEntity deleted = em.find(ZonaCuerpoEntity.class, entity.getId());
        Assert.assertNull(deleted);
    } 
}
