/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.upccompany.dao.hibernate.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.com.upccompany.dao.DepartamentoDao;
import pe.com.upccompany.dao.entity.Departamento;
import pe.com.upccompany.dao.hibernate.base.BaseHibernateDao;
import pe.com.upccompany.util.SystemException;

/**
 *
 * @author José
 */
public class DepartamentoHibernateDao extends BaseHibernateDao implements DepartamentoDao {

    //Inicio Singleton
    private static final DepartamentoHibernateDao DEPARTAMENTO_HIBERNATE_DAO;

    static {
        DEPARTAMENTO_HIBERNATE_DAO = new DepartamentoHibernateDao();
    }

    private DepartamentoHibernateDao() {

    }

    public static DepartamentoHibernateDao obtenerInstancia() {
        return DEPARTAMENTO_HIBERNATE_DAO;
    }
    //Fin Singleton

    @Override
    public void insertar(Departamento e) throws SystemException {
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
    public void actualizar(Departamento e) throws SystemException {
        Session session = null;
        try {
            session = obtenerSesion();
            session.update(e);
            e.setEliminado(Boolean.FALSE);
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
            Departamento departamento = (Departamento) session.get(Departamento.class, id);
            departamento.setEliminado(Boolean.TRUE);
            session.update(departamento);
            session.getTransaction().commit();
        } finally {
            cerrar(session);
        }
    }

    @Override
    public Departamento obtener(Integer id) throws SystemException {
        Session session = null;
        Departamento departamento = null;
        try {
            session = obtenerSesion();
            departamento = (Departamento) session.get(Departamento.class, id);
        } finally {
            cerrar(session);
        }
        return departamento;
    }

    @Override
    public List<Departamento> listar() throws SystemException {
        Session session = null;
        List<Departamento> lista = null;
        try {
            session = obtenerSesion();
            String hql = "SELECT d FROM Departamento d WHERE d.eliminado = 0";
            Query query = session.createQuery(hql);
            lista = query.list();
        } finally {
            cerrar(session);
        }
        return lista;
    }

    @Override
    public List<Departamento> listarPaginado(Integer limit,
            Integer offset,
            String sort,
            String order,
            String search)
            throws SystemException {
        Session session = null;
        List<Departamento> lista = null;
        if (order == null) {
            order = "DESC";
        } else {
            order = order.toUpperCase();
        }
        if (sort == null) {
            sort = "idDepartamento";
        }
        try {
            session = obtenerSesion();
            StringBuilder sb = new StringBuilder();
            sb.append("SELECT d FROM Departamento d WHERE ");
            sb.append("(d.eliminado = 0)");
            sb.append(" AND (:search is null");
            sb.append(" OR ( CONCAT(idDepartamento, ' ', nombre) LIKE '%' || :search || '%')");
            sb.append(")");
            sb.append(" ORDER BY d.");
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
            sb.append("SELECT COUNT(*) FROM Departamento d WHERE ");
            sb.append("(d.eliminado = 0)");
            sb.append(" AND (:search is null");
            sb.append(" OR (CONCAT(idDepartamento, nombre) LIKE '%' || :search || '%')");
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
