/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.upccompany.dao.hibernate.impl;

import java.util.List;
import org.hibernate.Query;
import org.hibernate.Session;
import pe.com.upccompany.dao.IdiomaDao;
import pe.com.upccompany.dao.entity.Idioma;
import pe.com.upccompany.dao.hibernate.base.BaseHibernateDao;
import pe.com.upccompany.util.SystemException;

/**
 *
 * @author Jose
 */
public class IdiomaHibernateDao extends BaseHibernateDao implements IdiomaDao{

    //Inicio Singleton
    private static final IdiomaHibernateDao IDIOMA_HIBERNATE_DAO;

    static {
        IDIOMA_HIBERNATE_DAO = new IdiomaHibernateDao();
    }

    private IdiomaHibernateDao() {

    }

    public static IdiomaHibernateDao obtenerInstancia() {
        return IDIOMA_HIBERNATE_DAO;
    }
    //Fin Singleton
    
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
        Session session = null;
        List<Idioma> lista = null;
        try {
            session = obtenerSesion();
            String hql = "SELECT i FROM Idioma i WHERE i.eliminado = 0";
            Query query = session.createQuery(hql);
            lista = query.list();
        } finally {
            cerrar(session);
        }
        return lista;
    }
    
}
