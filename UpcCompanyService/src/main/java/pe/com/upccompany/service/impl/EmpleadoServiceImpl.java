/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.upccompany.service.impl;

import java.util.List;
import pe.com.upccompany.dao.EmpleadoDao;
import pe.com.upccompany.dao.entity.Empleado;
import pe.com.upccompany.service.EmpleadoService;
import pe.com.upccompany.service.util.ServiceUtil;
import pe.com.upccompany.util.SystemException;

/**
 *
 * @author Jose
 */
public class EmpleadoServiceImpl implements EmpleadoService {

     //Inicio Singleton
    private static final EmpleadoServiceImpl EMPLEADO_SERVICE_IMPL;
    private EmpleadoDao empleadoDao;
    
    static{
        EMPLEADO_SERVICE_IMPL = new EmpleadoServiceImpl();
    }
    
    private EmpleadoServiceImpl(){
        empleadoDao = (EmpleadoDao)ServiceUtil.obtenerDao("Empleado");
    }
    
    public static EmpleadoServiceImpl obtenerInstancia(){
        return EMPLEADO_SERVICE_IMPL;
    }
    
    @Override
    public void insertar(Empleado e) throws SystemException {
        empleadoDao.insertar(e);
    }

    @Override
    public void actualizar(Empleado e) throws SystemException {
        empleadoDao.actualizar(e);
    }

    @Override
    public void eliminar(Integer id) throws SystemException {
        empleadoDao.eliminar(id);
    }

    @Override
    public Empleado obtener(Integer id) throws SystemException {
        return empleadoDao.obtener(id);
    }

    @Override
    public List<Empleado> listar() throws SystemException {
        return empleadoDao.listar();
    }
}
