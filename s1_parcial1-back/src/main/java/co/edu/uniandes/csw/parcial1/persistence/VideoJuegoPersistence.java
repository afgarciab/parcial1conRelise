/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.persistence;

import co.edu.uniandes.csw.parcial1.entities.VideoJuegoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author af.garciab
 */
@Stateless
public class VideoJuegoPersistence {
    private static final Logger LOGGER = Logger.getLogger(VideoJuegoPersistence.class.getName());
    @PersistenceContext(unitName = "parcial1PU")
    protected EntityManager em;
    
     public VideoJuegoEntity create(VideoJuegoEntity videoJuego) {
        LOGGER.log(Level.INFO, "Creando una plantillaRespuesta nueva");
        /* Note que hacemos uso de un método propio de EntityManager para persistir la plantillaRespuesta en la base de datos.
        Es similar a "INSERT INTO table_name (column1, column2, column3, ...) VALUES (value1, value2, value3, ...);" en SQL.
         */
        em.persist(videoJuego);
        LOGGER.log(Level.INFO, "Saliendo de crear una plantillaRespuesta nueva");
        return videoJuego;
    }
      public List<VideoJuegoEntity> findAll() {
        LOGGER.log(Level.INFO, "Consultando todas las VideoJuegos");
        // Se crea un query para buscar todas las plantillaRespuestaes en la base de datos.
        TypedQuery query = em.createQuery("select u from VideoJuegoEntity u", VideoJuegoEntity.class);
        // Note que en el query se hace uso del método getResultList() que obtiene una lista de plantillaRespuestaes.
        return query.getResultList();
    }
      public VideoJuegoEntity find(Long videoJuegosId) {
        LOGGER.log(Level.INFO, "Consultando plantillaRespuesta con id={0}", videoJuegosId);
        /* Note que se hace uso del metodo "find" propio del EntityManager, el cual recibe como argumento 
        el tipo de la clase y el objeto que nos hara el filtro en la base de datos en este caso el "id"
        Suponga que es algo similar a "select * from VideoJuegoEntity where id=id;" - "SELECT * FROM table_name WHERE condition;" en SQL.
         */
        return em.find(VideoJuegoEntity.class, videoJuegosId);
    }
       public VideoJuegoEntity update(VideoJuegoEntity plantillaRespuestaEntity) {
        LOGGER.log(Level.INFO, "Actualizando plantillaRespuesta con id = {0}", plantillaRespuestaEntity.getId());
        /* Note que hacemos uso de un método propio del EntityManager llamado merge() que recibe como argumento
        la plantillaRespuesta con los cambios, esto es similar a 
        "UPDATE table_name SET column1 = value1, column2 = value2, ... WHERE condition;" en SQL.
         */
        LOGGER.log(Level.INFO, "Saliendo de actualizar la plantillaRespuesta con id = {0}", plantillaRespuestaEntity.getId());
        return em.merge(plantillaRespuestaEntity);
    }
       public void delete(Long videoJuegosId) 
    {
        LOGGER.log(Level.INFO, "Borrando plantillaRespuesta con id = {0}", videoJuegosId);
        // Se hace uso de mismo método que esta explicado en public VideoJuegoEntity find(Long id) para obtener la plantillaRespuesta a borrar.
        VideoJuegoEntity entity = em.find(VideoJuegoEntity.class, videoJuegosId);
        /* Note que una vez obtenido el objeto desde la base de datos llamado "entity", volvemos hacer uso de un método propio del
         EntityManager para eliminar de la base de datos el objeto que encontramos y queremos borrar.
         Es similar a "delete from VideoJuegoEntity where id=id;" - "DELETE FROM table_name WHERE condition;" en SQL.*/
        em.remove(entity);
        LOGGER.log(Level.INFO, "Saliendo de borrar la plantillaRespuesta con id = {0}", videoJuegosId);
    }
       public VideoJuegoEntity findByLlavePrimaria(Long llavePrimaria) {
        LOGGER.log(Level.INFO, "Consultando titulo frecuente por titulo ", llavePrimaria);
        // Se crea un query para buscar usuarios con el nombre que recibe el método como argumento. ":nombre" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From VideoJuegoEntity e where e.llavePrimaria = :llavePrimaria", VideoJuegoEntity.class);
        // Se remplaza el placeholder ":nombre" con el valor del argumento 
        query = query.setParameter("llavePrimaria", llavePrimaria);
        // Se invoca el query se obtiene la lista resultado
        List<VideoJuegoEntity> sameVideoJuegos = query.getResultList();
        VideoJuegoEntity result;
        if (sameVideoJuegos == null) {
            result = null;
        } else if (sameVideoJuegos.isEmpty()) {
            result = null;
        } else {
            result = sameVideoJuegos.get(0);
        }
        LOGGER.log(Level.INFO, "Saliendo de consultar VideoJuego por titulo ", llavePrimaria);
        return result;
    }
        
     public VideoJuegoEntity findByTitulo(String titulo) {
        LOGGER.log(Level.INFO, "Consultando titulo frecuente por titulo ", titulo);
        // Se crea un query para buscar usuarios con el nombre que recibe el método como argumento. ":nombre" es un placeholder que debe ser remplazado
        TypedQuery query = em.createQuery("Select e From VideoJuegoEntity e where e.titulo = :titulo", VideoJuegoEntity.class);
        // Se remplaza el placeholder ":nombre" con el valor del argumento 
        query = query.setParameter("titulo", titulo);
        // Se invoca el query se obtiene la lista resultado
        List<VideoJuegoEntity> samePreguntas = query.getResultList();
        VideoJuegoEntity result;
        if (samePreguntas == null) {
            result = null;
        } else if (samePreguntas.isEmpty()) {
            result = null;
        } else {
            result = samePreguntas.get(0);
        }
        LOGGER.log(Level.INFO, "Saliendo de consultar VideoJuego por titulo ", titulo);
        return result;
    }
     
    
}
