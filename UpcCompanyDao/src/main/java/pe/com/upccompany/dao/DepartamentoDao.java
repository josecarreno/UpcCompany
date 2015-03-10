/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.upccompany.dao;

import java.util.List;
import pe.com.upccompany.dao.entity.Departamento;
import pe.com.upccompany.dao.hibernate.base.EntityDao;
import pe.com.upccompany.util.SystemException;

/**
 *
 * @author José
 */
public interface DepartamentoDao extends EntityDao<Departamento, Integer> {
    public List<Departamento> listarPaginado(Integer limit,
            Integer offset,
            String sort,
            String order,
            String search) 
            throws SystemException;
    public Long count(String search) throws SystemException;
}
