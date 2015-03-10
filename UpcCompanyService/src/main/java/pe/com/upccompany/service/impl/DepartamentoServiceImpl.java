/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.upccompany.service.impl;

import java.util.List;
import pe.com.upccompany.dao.DepartamentoDao;
import pe.com.upccompany.dao.entity.Departamento;
import pe.com.upccompany.service.DepartamentoService;
import pe.com.upccompany.service.util.ServiceUtil;
import pe.com.upccompany.util.SystemException;

/**
 *
 * @author Jose
 */
public class DepartamentoServiceImpl implements DepartamentoService{

    //Inicio Singleton
    private static final DepartamentoServiceImpl DEPARTAMENTO_SERVICE_IMPL;
    private DepartamentoDao departamentoDao;
    
    static{
        DEPARTAMENTO_SERVICE_IMPL = new DepartamentoServiceImpl();
    }
    
    private DepartamentoServiceImpl(){
        departamentoDao = (DepartamentoDao)ServiceUtil.obtenerDao("Departamento");
    }
    
    public static DepartamentoServiceImpl obtenerInstancia(){
        return DEPARTAMENTO_SERVICE_IMPL;
    }
    
    @Override
    public void insertar(Departamento e) throws SystemException {
        departamentoDao.insertar(e);
    }

    @Override
    public void actualizar(Departamento e) throws SystemException {
        departamentoDao.actualizar(e);
    }

    @Override
    public void eliminar(Integer id) throws SystemException {
        departamentoDao.eliminar(id);
    }

    @Override
    public Departamento obtener(Integer id) throws SystemException {
        return departamentoDao.obtener(id);
    }

    @Override
    public List<Departamento> listar() throws SystemException {
        return departamentoDao.listar();
    }

    @Override
    public List<Departamento> listarPaginado(Integer limit, Integer offset, String sort, String order, String search) throws SystemException {
        return departamentoDao.listarPaginado(limit, offset, sort, order, search);
    }

    @Override
    public Long count(String search) throws SystemException {
        return departamentoDao.count(search);
    }
    
}
