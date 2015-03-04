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
public class DepartamentoTest {

    private Selenium selenium;

    @BeforeClass
    public void inicioClase() {
        selenium = new DefaultSelenium("localhost", 4444, "*firefox C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe", "http://localhost:8080/");
        selenium.start();
    }

    @Test(enabled = false)
    public void insertarDepartamentoValido() {

        try {
            selenium.open("/UpcCompanyWeb/");
            selenium.click("departamentos");
            selenium.waitForPageToLoad("30000");
            selenium.click("btnRegDep");
            selenium.waitForPageToLoad("30000");
            selenium.type("txtNombre", "Prueba Selenium");
            selenium.click("btnRegDepartamento");
            selenium.waitForPageToLoad("3000");

            Assert.assertTrue(("Se registro correctamente el departamento").equalsIgnoreCase(selenium.getText("pMensaje")));

        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail("Error: " + ex.getMessage());

        }
    }

    @Test(enabled = false)
    public void insertarDepartamentoInvalido() {

        try {

            selenium.open("/UpcCompanyWeb/");
            selenium.click("departamentos");
            selenium.waitForPageToLoad("30000");
            selenium.click("btnRegDep");
            selenium.waitForPageToLoad("30000");
            selenium.click("btnRegDepartamento");

            Assert.assertTrue(("Nombre de departamento requerido").equalsIgnoreCase(selenium.getText("txtNombre-error")));

        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail("Error: " + ex.getMessage());

        }
    }

    @Test(enabled = false)
    public void eliminarDepartamento() {

        try {

            selenium.open("/UpcCompanyWeb/");
            selenium.click("departamentos");
            selenium.waitForPageToLoad("30000");
            //PONER UN BOTON QUE EXISTA
            selenium.click("btnEliDep20");
            selenium.waitForPageToLoad("30000");
            Assert.assertTrue(("Se elimino correctamente el departamento").equalsIgnoreCase(selenium.getText("pMensaje")));

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }

    @Test(enabled = false)
    public void actualizarDepartamentoValido() {

        try {

            selenium.open("/UpcCompanyWeb/");
            selenium.click("departamentos");
            selenium.waitForPageToLoad("30000");
            //PONER UN BOTON QUE EXISTA
            selenium.click("btnActDep21");
            selenium.waitForPageToLoad("30000");
            selenium.type("txtNombre", "Prueba Selenium Actualizada");
            selenium.click("btnActualizar");
            selenium.waitForPageToLoad("3000");

            Assert.assertTrue(("Se actualizo correctamente el departamento").equalsIgnoreCase(selenium.getText("pMensaje")));

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }

    @Test(enabled = false)
    public void actualizarDepartamentoInvalido() {

        try {

            selenium.open("/UpcCompanyWeb/");
            selenium.click("departamentos");
            selenium.waitForPageToLoad("30000");
            //PONER UN BOTON QUE EXISTA
            selenium.click("btnActDep21");
            selenium.waitForPageToLoad("30000");
            selenium.type("txtNombre", " ");
            selenium.click("btnActualizar");

            Assert.assertTrue(("Nombre de departamento requerido").equalsIgnoreCase(selenium.getText("txtNombre-error")));

        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }

    @Test(enabled = false)
    public void listarDepartamentos() {

        try {

            selenium.open("/UpcCompanyWeb/");
            selenium.click("departamentos");
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
