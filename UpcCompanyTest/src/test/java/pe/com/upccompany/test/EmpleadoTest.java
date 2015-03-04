package pe.com.upccompany.test;

import com.thoughtworks.selenium.DefaultSelenium;
import com.thoughtworks.selenium.Selenium;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 *
 * @author Renato
 */
public class EmpleadoTest {

    private Selenium selenium;

    @BeforeClass
    public void inicioClase() {
        selenium = new DefaultSelenium("localhost", 4444, "*firefox C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe", "http://localhost:8080/");
        selenium.start();
    }

    @Test(enabled = false)
    public void insertarEmpleadoValido() {

        try {

            selenium.open("/UpcCompanyWeb/");
            selenium.click("empleados");
            selenium.waitForPageToLoad("30000");
            selenium.click("btnRegEmpleado");
            selenium.waitForPageToLoad("30000");
            selenium.type("txtDNI", "17847225");
            selenium.type("txtNombre", "EmpSeleniumP");
            selenium.type("txtApellido", "ApSeleniumP");
            selenium.click("rbSexoF");
            selenium.select("selDepartamento", "sistemas");
            selenium.click("chk2");
            selenium.click("chk1");
            selenium.click("btnRegEmpleado");
            selenium.waitForPageToLoad("3000");

            Assert.assertTrue(("Se registro correctamente el empleado").equalsIgnoreCase(selenium.getText("pMensaje")));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }

    @Test(enabled = false)
    public void insertarEmpleadoInvalido() {

        try {

            selenium.open("/UpcCompanyWeb/");
            selenium.click("empleados");
            selenium.waitForPageToLoad("30000");
            selenium.click("btnRegEmpleado");
            selenium.waitForPageToLoad("30000");
            selenium.click("btnRegEmpleado");

            Assert.assertTrue(("DNI requerido").equalsIgnoreCase(selenium.getText("txtDNI-error")));
            Assert.assertTrue(("Nombre requerido").equalsIgnoreCase(selenium.getText("txtNombre-error")));
            Assert.assertTrue(("Apellido requerido").equalsIgnoreCase(selenium.getText("txtApellido-error")));
            Assert.assertTrue(("Departamento requerido").equalsIgnoreCase(selenium.getText("selDepartamento-error")));
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }

    @Test(enabled = false)
    public void actualizarEmpleadoValido() {

        try {

            selenium.open("/UpcCompanyWeb/");
            selenium.click("empleados");
            selenium.waitForPageToLoad("30000");
            selenium.click("btnActEmp2");
            selenium.waitForPageToLoad("30000");

            selenium.type("txtDNI", "23232323");
            selenium.type("txtNombre", "NomActSelenium");
            selenium.type("txtApellido", "ApActSelenium");
            selenium.click("rbSexoF");
            selenium.select("selDepartamento", "juanitpo");
            selenium.click("chk2");

            selenium.click("btnActualizar");
            selenium.waitForPageToLoad("3000");

            Assert.assertTrue(("Se actualizo correctamente el empleado").equalsIgnoreCase(selenium.getText("pMensaje")));

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }

    @Test(enabled = false)
    public void actualizarEmpleadoInvalido() {

        try {

            selenium.open("/UpcCompanyWeb/");
            selenium.click("empleados");
            selenium.waitForPageToLoad("30000");
            selenium.click("btnActEmp2");
            selenium.waitForPageToLoad("30000");

            selenium.type("txtDNI", " ");
            selenium.type("txtNombre", " ");
            selenium.type("txtApellido", " ");

            selenium.click("btnActualizar");

            Assert.assertTrue(("DNI requerido").equalsIgnoreCase(selenium.getText("txtDNI-error")));
            Assert.assertTrue(("Nombre requerido").equalsIgnoreCase(selenium.getText("txtNombre-error")));
            Assert.assertTrue(("Apellido requerido").equalsIgnoreCase(selenium.getText("txtApellido-error")));

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }

    @Test(enabled = false)
    public void listarEmpleados() {

        try {

            selenium.open("/UpcCompanyWeb/");
            selenium.click("empleados");
            selenium.waitForPageToLoad("30000");

            Assert.assertTrue(Integer.parseInt((selenium.getText("tabla_info").substring(46, 47))) >= 0);

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }

    @AfterClass
    public void finClase() {
        selenium.stop();
    }

}
