/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.upccompany.service.base;

import java.util.List;
import pe.com.upccompany.util.SystemException;

/**
 *
 * @author Jose
 * @param <E> clase de objeto
 * @param <J> clase de PK
 */
public interface BaseService<E, J> {

    void insertar(E e) throws SystemException;

    void actualizar(E e) throws SystemException;

    void eliminar(J id) throws SystemException;

    E obtener(J id) throws SystemException;

    List<E> listar() throws SystemException;
}
