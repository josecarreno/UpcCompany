/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.upccompany.service.impl;

import java.util.List;
import pe.com.upccompany.dao.IdiomaDao;
import pe.com.upccompany.dao.entity.Idioma;
import pe.com.upccompany.service.IdiomaService;
import pe.com.upccompany.service.util.ServiceUtil;
import pe.com.upccompany.util.SystemException;

/**
 *
 * @author Jose
 */
public class IdiomaServiceImpl implements IdiomaService{
     //Inicio Singleton
    private static final IdiomaServiceImpl IDIOMA_SERVICE_IMPL;
    private IdiomaDao idiomaDao;
    
    static{
        IDIOMA_SERVICE_IMPL = new IdiomaServiceImpl();
    }
    
    private IdiomaServiceImpl(){
        idiomaDao = (IdiomaDao)ServiceUtil.obtenerDao("Idioma");
    }
    
    public static IdiomaServiceImpl obtenerInstancia(){
        return IDIOMA_SERVICE_IMPL;
    }

    @Override
    public void insertar(Idioma e) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Idioma e) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Integer id) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Idioma obtener(Integer id) throws SystemException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Idioma> listar() throws SystemException {
        return idiomaDao.listar();
    }
}
