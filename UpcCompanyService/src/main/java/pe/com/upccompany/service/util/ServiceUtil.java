package pe.com.upccompany.service.util;

import pe.com.upccompany.dao.hibernate.base.EntityDao;
import pe.com.upccompany.dao.hibernate.impl.DepartamentoHibernateDao;
import pe.com.upccompany.dao.hibernate.impl.EmpleadoHibernateDao;
import pe.com.upccompany.dao.hibernate.impl.IdiomaHibernateDao;

public final class ServiceUtil {

    private static final String DEPARTAMENTO = "Departamento";
    private static final String EMPLEADO = "Empleado";
    private static final String IDIOMA = "Idioma";

    private ServiceUtil() {

    }

    public static EntityDao obtenerDao(String tabla) {

        EntityDao entityDao = null;
        String tipoConexion = "HIBERNATE"; //cambiar segun sea necesario

        if (tabla.equalsIgnoreCase(DEPARTAMENTO)) {
            switch (tipoConexion) {
                case "HIBERNATE":
                    entityDao = DepartamentoHibernateDao.obtenerInstancia();
                    break;
                default:
                    entityDao = DepartamentoHibernateDao.obtenerInstancia();
                    break;
            }
        } else if (tabla.equalsIgnoreCase(EMPLEADO)) {
            switch (tipoConexion) {
                case "HIBERNATE":
                    entityDao = EmpleadoHibernateDao.obtenerInstancia();
                    break;
                default:
                    entityDao = EmpleadoHibernateDao.obtenerInstancia();
                    break;
            }
        } else if (tabla.equalsIgnoreCase(IDIOMA)) {
            switch (tipoConexion) {
                case "HIBERNATE":
                    entityDao = IdiomaHibernateDao.obtenerInstancia();
                    break;
                default:
                    entityDao = IdiomaHibernateDao.obtenerInstancia();
                    break;
            }
        }
        return entityDao;
    }
}
