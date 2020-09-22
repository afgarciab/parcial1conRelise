/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.test.logic;

import co.edu.uniandes.csw.parcial1.ejb.VideoJuegoLogic;
import co.edu.uniandes.csw.parcial1.entities.VideoJuegoEntity;
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
 * @author estudiante
 */
@RunWith(Arquillian.class)
public class VideoJuegoLogicTest {
     private PodamFactory factory = new PodamFactoryImpl();
     @Inject
    private VideoJuegoLogic preguntasComunesLogic;
     
     @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;
    
    private List<VideoJuegoEntity> data = new ArrayList<VideoJuegoEntity>();
}

 @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(VideoJuegoEntity.class.getPackage())
                .addPackage(VideoJuegoLogic.class.getPackage())
                .addPackage(VideoJuegoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Configuración inicial de la prueba.
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            em.joinTransaction();
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
    
    /**
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData() {
        
        em.createQuery("delete from VideoJuegoEntity").executeUpdate();
        
    }
 private void insertData() {
        plantilla=factory.manufacturePojo(PlantillaRespuestaEntity.class);
        em.persist(plantilla);
        conjunto=factory.manufacturePojo(ConjuntoPalabrasEntity.class);
        em.persist(conjunto);
         PodamFactory factory = new PodamFactoryImpl();
    for (int i = 0; i < 3; i++) {
        VideoJuegoEntity entity = factory.manufacturePojo(VideoJuegoEntity.class);
        em.persist(entity);
        data.add(entity);
    }

    @Test
    public void createVideoJuegoTest() throws BusinessLogicException {
        VideoJuegoEntity newEntity = factory.manufacturePojo(VideoJuegoEntity.class);
        VideoJuegoEntity result = preguntasComunesLogic.createVideoJuego(newEntity);
        Assert.assertNotNull(result);
        VideoJuegoEntity entity = em.find(VideoJuegoEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getTitulo(), entity.getTitulo);
     Assert.assertEquals(newEntity.getConsola(), entity.getConsola());
         Assert.assertEquals(newEntity.getCalificacionNumeroEstrellas(), entity.getCalificacionNumeroEstrellas());
    }
    
        }