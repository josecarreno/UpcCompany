package pe.com.upccompany.dao.hibernate.base;

import org.apache.log4j.Logger;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.service.ServiceRegistry;

public class ConexionHibernate {

    private static final Logger LOGGER = Logger.getLogger(ConexionHibernate.class);
    private static SessionFactory sessionFactory;
    static {
        try {
            Configuration configuration = new Configuration();
            configuration.configure("hibernate.cfg.xml");
            ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder().applySettings(configuration.getProperties()).build();
            sessionFactory = configuration.buildSessionFactory(serviceRegistry);
        } catch (HibernateException ex) {
            throw new HibernateException(ex);
        }
    }

    //Sirve para obtener una sesion(conexion) a la base de datos
    protected Session obtenerSesion() {
        Session session = sessionFactory.getCurrentSession();
        session.beginTransaction();
        return session;
    }

    protected void cerrar(Session session) {
        try {
            session.close();
        } catch (Exception ex) {
            LOGGER.error(ex);
        }
    }

    protected void rollback(Session session) {
        try {
            session.beginTransaction().rollback();
        } catch (Exception ex) {
            LOGGER.error(ex);
        }
    }

}
