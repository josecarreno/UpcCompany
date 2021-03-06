/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.upccompany.service;

import java.util.List;
import pe.com.upccompany.dao.entity.Empleado;
import pe.com.upccompany.service.base.BaseService;
import pe.com.upccompany.util.SystemException;

/**
 *
 * @author Jose
 */
public interface EmpleadoService extends BaseService<Empleado, Integer> {
        public List<Empleado> listarPaginado(Integer limit, 
            Integer offset, 
            String sort,
            String order,
            String search) 
            throws SystemException;
    public Long count(String search) throws SystemException;
}
