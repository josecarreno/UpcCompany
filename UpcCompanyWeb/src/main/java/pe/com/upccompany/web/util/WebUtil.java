/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.upccompany.web.util;

import java.text.MessageFormat;
import java.util.Date;
import java.util.List;
import pe.com.upccompany.dao.entity.Departamento;
import pe.com.upccompany.dao.entity.Idioma;
import pe.com.upccompany.service.base.BaseService;
import pe.com.upccompany.service.impl.DepartamentoServiceImpl;
import pe.com.upccompany.service.impl.EmpleadoServiceImpl;
import pe.com.upccompany.service.impl.IdiomaServiceImpl;
import pe.com.upccompany.util.SystemException;
import pe.com.upccompany.util.SystemUtil;

/**
 *
 * @author Jose
 */
public class WebUtil {

    private WebUtil() {

    }

    public static String controlarError(Exception excepcion) {
        StringBuilder sb = new StringBuilder();
        String idError = SystemUtil.convertirDate(new Date(), "ddMMyyyyhhmmss");
        sb.append(MessageFormat.format("Código de error: {0} \n", idError));
        sb.append(MessageFormat.format("Mensaje del error: {0} \n",
                excepcion.getMessage()));
        return sb.toString();
    }

    public static String encadenaIdiomas(List<Idioma> idiomas) {
        StringBuilder sb = new StringBuilder();
        Integer i = 0;
        for (Idioma idioma : idiomas) {
            if (i != 0) {
                sb.append(", ");
            } 
            sb.append(idioma.getNombre());
            i++;
        }
        return sb.toString();
    }

    public static BaseService obtenerService(String clase) {
        BaseService baseService = null;
        if (("DEPARTAMENTO").equalsIgnoreCase(clase)) {
            baseService = DepartamentoServiceImpl.obtenerInstancia();
        } else if (("EMPLEADO").equalsIgnoreCase(clase)) {
            baseService = EmpleadoServiceImpl.obtenerInstancia();
        } else if (("IDIOMA").equalsIgnoreCase(clase)) {
            baseService = IdiomaServiceImpl.obtenerInstancia();
        }
        return baseService;
    }
    
    private static String generateUpdateBtnString(Departamento d, String page) {
        Integer id = d.getIdDepartamento();
        StringBuilder sb = new StringBuilder();
        sb.append("<a id='btnActDep");
        sb.append(id.toString());
        sb.append("' href='");
        sb.append(page);
        sb.append("?id=");
        sb.append(id.toString());
        sb.append("' class='btn btn-primary btn-xs'>Modificar</a>");
        return sb.toString();
    }

    private static String generateDeleteBtnString(Departamento d, String page) {
        Integer id = d.getIdDepartamento();
        StringBuilder sb = new StringBuilder();
        sb.append("<a id='btnEliDep");
        sb.append(id.toString());
        sb.append("' href='");
        sb.append(page);
        sb.append("?id=");
        sb.append(id.toString());
        sb.append("&txtAction=ELIMINAR");
        sb.append("' class='btn btn-danger btn-xs'>Eliminar</a>");
        return sb.toString();
    }

    public static String generateJSONString(List<Departamento> lstDepartamento, Long count) throws SystemException {

        StringBuilder sb = new StringBuilder();
        Integer i = 0; //flag
        sb.append("{\"total\": ");
        sb.append(count);
        sb.append(",\"rows\":");
        sb.append("[");
        for (Departamento d : lstDepartamento) {
            sb.append("{\"idDepartamento\":\"");
            sb.append(d.getIdDepartamento().toString());
            sb.append("\",\"nombre\":\"");
            sb.append(d.getNombre());
            sb.append("\",\"actualizar\":\"");
            sb.append(generateUpdateBtnString(d, "/UpcCompanyWeb/Pages/Departamento/actDepartamento.jsp"));
            sb.append("\",\"eliminar\":\"");
            sb.append(generateDeleteBtnString(d, "/UpcCompanyWeb/DepartamentoController"));
            sb.append("\"}");
            if (i < lstDepartamento.size() - 1) {
                sb.append(",");
            }
            i++;
        }
        sb.append("]}");
        return sb.toString();
    }
}
