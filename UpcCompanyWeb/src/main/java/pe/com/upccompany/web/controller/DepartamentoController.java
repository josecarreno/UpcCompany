package pe.com.upccompany.web.controller;

import java.io.IOException;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.apache.log4j.Logger;
import pe.com.upccompany.dao.entity.Departamento;
import pe.com.upccompany.service.DepartamentoService;
import pe.com.upccompany.util.SystemException;
import pe.com.upccompany.web.util.WebUtil;

/**
 *
 * @author Jose
 */
@WebServlet(name = "DepartamentoController", urlPatterns = {"/DepartamentoController"})
public class DepartamentoController extends HttpServlet {

    private static final Logger LOGGER = Logger.getLogger(EmpleadoController.class);
    private static final DepartamentoService DEPARTAMENTO_SERVICE = (DepartamentoService) WebUtil.obtenerService("DEPARTAMENTO");

    protected void registrar(HttpServletRequest request) throws SystemException {
        Departamento departamento = new Departamento();
        departamento.setNombre(request.getParameter("txtNombre"));
        DEPARTAMENTO_SERVICE.insertar(departamento);
    }

    protected void actualizar(HttpServletRequest request) throws SystemException {
        Departamento departamento = new Departamento();
        departamento.setIdDepartamento(Integer.parseInt(request.getParameter("txtId")));
        departamento.setNombre(request.getParameter("txtNombre"));
        DEPARTAMENTO_SERVICE.actualizar(departamento);
    }

    protected void eliminar(HttpServletRequest request) throws SystemException {
        DEPARTAMENTO_SERVICE.eliminar(Integer.parseInt(request.getParameter("id")));
    }
    protected List<Departamento> listar(HttpServletRequest request) throws SystemException {
        Integer limit = Integer.parseInt(request.getParameter("limit"));
        Integer offset = Integer.parseInt(request.getParameter("offset"));
        String sort = request.getParameter("sort");
        String order = request.getParameter("order");
        String search = request.getParameter("search");
        return DEPARTAMENTO_SERVICE.listarPaginado(limit, offset, sort, order, search);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        String accion = request.getParameter("txtAction");
        String mensaje = "";
        String pagina = "";
        try {
            if (("REGISTRAR").equalsIgnoreCase(accion)) {
                registrar(request);
                mensaje = "Se registro correctamente el departamento";
                pagina = "/Pages/Departamento/mntDepartamento.jsp?mensaje=";
            } else if (("ACTUALIZAR").equalsIgnoreCase(accion)) {
                actualizar(request);
                mensaje = "Se actualizo correctamente el departamento";
                pagina = "/Pages/Departamento/mntDepartamento.jsp?mensaje=";
            } else if (("ELIMINAR").equalsIgnoreCase(accion)) {
                eliminar(request);
                mensaje = "Se elimino correctamente el departamento";
                pagina = "/Pages/Departamento/mntDepartamento.jsp?mensaje=";
            } else if (("LISTAR").equalsIgnoreCase(accion)) {
                Long count = DEPARTAMENTO_SERVICE.count(request.getParameter("search"));
                String json = WebUtil.generateJSONString(listar(request), count);
                response.setContentType("application/json");
                response.setCharacterEncoding("UTF-8");
                response.getWriter().write(json);
                return;
            }
        } catch (Exception ex) {
            LOGGER.error(ex);
            response.setContentType("text/html");
            mensaje = WebUtil.controlarError(ex);
            pagina = "/error.jsp?mensaje=";
        }
        response.sendRedirect(request.getContextPath() + pagina + mensaje);
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
