/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.upccompany.service.test;

import java.util.List;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pe.com.upccompany.dao.entity.Departamento;
import pe.com.upccompany.service.base.BaseService;
import pe.com.upccompany.service.impl.DepartamentoServiceImpl;

/**
 *
 * @author Jose
 */
@Test(enabled = false)
public class DepartamentoTest {

    public DepartamentoTest() {
    }

    private final BaseService service = DepartamentoServiceImpl.obtenerInstancia();
    private static Departamento departamento;

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @BeforeClass
    public static void setUpClass() throws Exception {
    }

    @AfterClass
    public static void tearDownClass() throws Exception {
    }

    @BeforeMethod
    public void setUpMethod() throws Exception {
    }

    @AfterMethod
    public void tearDownMethod() throws Exception {
    }

    @Test(enabled = false)
    public void insertar() {
        try {
            departamento = new Departamento();
            departamento.setNombre("departamento de prueba");
            service.insertar(departamento);
            Assert.assertTrue(departamento.getIdDepartamento() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = {"insertar"}, enabled = false)
    public void actualizar() {
        try {
            departamento.setNombre("departamento actualizado");
            service.actualizar(departamento);
            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = {"insertar"}, enabled = false)
    public void eliminar() {
        try {
            service.eliminar(departamento.getIdDepartamento());
            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }

    @Test(enabled = false)
    public void listar() {
        try {
            List<Departamento> lista = service.listar();
            for (Departamento dep : lista) {
                System.out.println(dep.getNombre());
            }
            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }
}
