/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.upccompany.dao.hibernate.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.com.upccompany.dao.EmpleadoDao;
import pe.com.upccompany.dao.entity.Empleado;
import pe.com.upccompany.dao.hibernate.base.BaseHibernateDao;
import pe.com.upccompany.util.SystemException;

/**
 *
 * @author Jose
 */
public class EmpleadoHibernateDao extends BaseHibernateDao implements EmpleadoDao {

    //Inicio Singleton
    private static final EmpleadoHibernateDao EMPLEADO_HIBERNATE_DAO;

    static {
        EMPLEADO_HIBERNATE_DAO = new EmpleadoHibernateDao();
    }

    private EmpleadoHibernateDao() {

    }

    public static EmpleadoHibernateDao obtenerInstancia() {
        return EMPLEADO_HIBERNATE_DAO;
    }
    //Fin Singleton

    @Override
    public void insertar(Empleado e) throws SystemException {
        Session session = null;
        try {
            session = obtenerSesion();
            e.setEliminado(Boolean.FALSE);
            session.save(e);
            session.getTransaction().commit();
        } finally {
            cerrar(session);
        }
    }

    @Override
    public void actualizar(Empleado e) throws SystemException {
        Session session = null;
        try {
            session = obtenerSesion();
            e.setEliminado(Boolean.FALSE);
            session.update(e);
            session.getTransaction().commit();
        } finally {
            cerrar(session);
        }
    }

    @Override
    public void eliminar(Integer id) throws SystemException {
        Session session = null;
        try {
            session = obtenerSesion();
            Empleado empleado = (Empleado) session.get(Empleado.class, id);
            empleado.setEliminado(Boolean.TRUE);
            session.update(empleado);
            session.getTransaction().commit();
        } finally {
            cerrar(session);
        }
    }

    @Override
    public Empleado obtener(Integer id) throws SystemException {
        Session session = null;
        Empleado empleado = null;
        try {
            session = obtenerSesion();
            empleado = (Empleado) session.get(Empleado.class, id);
        } finally {
            cerrar(session);
        }
        return empleado;
    }

    @Override
    public List<Empleado> listar() throws SystemException {
        Session session = null;
        List<Empleado> lista = null;
        try {
            session = obtenerSesion();
            String hql = "SELECT e FROM Empleado e WHERE e.eliminado = 0";
            Query query = session.createQuery(hql);
            lista = query.list();
        } finally {
            cerrar(session);
        }
        return lista;
    }

    @Override
    public List<Empleado> listarPaginado(
            Integer limit,
            Integer offset,
            String sort,
            String order,
            String search)
            throws SystemException {
        Session session = null;
        List<Empleado> lista = null;
        if (order == null) {
            order = "DESC";
        } else {
            order = order.toUpperCase();
        }
        if (sort == null) {
            sort = "idEmpleado";
        } else if ("departamento".equalsIgnoreCase(sort)) {
            sort = "idDepartamento.nombre";
        }
        try {
            session = obtenerSesion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT e FROM Empleado e WHERE ");
            sb.append("(e.eliminado = 0)");
            sb.append(" AND (:search is null");
            sb.append(" OR ( CONCAT(idEmpleado, dni, ' ', nombre, ' ', apellido, ' ', sexo )"); 
            sb.append(" LIKE '%' || :search || '%')");
            sb.append(")");
            sb.append(" ORDER BY e.");
            sb.append(sort);
            sb.append(" ");
            sb.append(order);
            String hql = sb.toString();
            Query query = session.createQuery(hql)
                    .setFirstResult(offset)
                    .setMaxResults(limit)
                    .setParameter("search", search);
            lista = query.list();
        } finally {
            cerrar(session);
        }
        return lista;
    }

    @Override
    public Long count(String search) throws SystemException {
        Session session = null;
        Long count = null;
        try {
            session = obtenerSesion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT COUNT(e) FROM Empleado e WHERE ");
            sb.append("(e.eliminado = 0)");
            sb.append(" AND (:search is null");
            sb.append(" OR ( CONCAT(idEmpleado, dni, ' ', nombre, ' ', apellido, ' ', sexo )"); 
            sb.append(" LIKE '%' || :search || '%')");
            sb.append(")");
            Query query = session.createQuery(sb.toString())
                    .setParameter("search", search);
            count = (Long) query.uniqueResult();
            return count;
        } finally {
            cerrar(session);
        }
    }

}
