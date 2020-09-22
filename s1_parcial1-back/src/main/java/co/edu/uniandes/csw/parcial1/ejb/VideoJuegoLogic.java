/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.parcial1.ejb;




import co.edu.uniandes.csw.parcial1.entities.VideoJuegoEntity;
import co.edu.uniandes.csw.parcial1.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.parcial1.persistence.VideoJuegoPersistence;

import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author af.garciab
 */
@Stateless
public class VideoJuegoLogic {
    private static final Logger LOGGER = Logger.getLogger(VideoJuegoLogic.class.getName());

    @Inject
    private VideoJuegoPersistence persistence;
    
    public VideoJuegoEntity createVideoJuego(VideoJuegoEntity videoJuego)throws BusinessLogicException{
        
        if ( videoJuego.getConsola()!="PlayStation" ||videoJuego.getConsola()!="Xbox"||videoJuego.getConsola()!="Nintendo Switch"||videoJuego.getConsola()!="Nintendo 3DS"||videoJuego.getConsola()!="PSVita") {
            throw new BusinessLogicException("la videoJuego tiene una consola invalida \"" + videoJuego.toString() + "\"");
        }
        VideoJuegoEntity tituloComparar=  persistence.findByTitulo(videoJuego.getTitulo());
        if (persistence.findByTitulo(videoJuego.getTitulo()) != null ) 
        {
            if(persistence.findByTitulo(videoJuego.getTitulo()) != null && videoJuego.getEmpresa() == persistence.findByTitulo(videoJuego.getTitulo()).getEmpresa()  )
            throw new BusinessLogicException("Ya existe un videoJuego \""  + "\"");
        }
        
        videoJuego= persistence.create(videoJuego);
        return videoJuego;
    }
    
     
    
}
