/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.upccompany.dao.hibernate.test;

import java.util.List;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pe.com.upccompany.dao.entity.Departamento;
import pe.com.upccompany.dao.hibernate.impl.DepartamentoHibernateDao;

/**
 *
 * @author Jose
 */
public class DepartamentoTest {

    public DepartamentoTest() {
    }

    private final DepartamentoHibernateDao entity = DepartamentoHibernateDao.obtenerInstancia();
    private static Departamento departamento;

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
            entity.insertar(departamento);
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
            entity.actualizar(departamento);
            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = {"insertar"}, enabled = false)
    public void eliminar() {
        try {
            entity.eliminar(departamento.getIdDepartamento());
            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }

    @Test(enabled = false)
    public void listar() {
        try {
            List<Departamento> lista = entity.listar();
            for (Departamento dep : lista) {
                System.out.println(dep.getNombre());
            }
            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }
    @Test(enabled = true)
    public void listarPaginado() {
        try {
            List<Departamento> lista = entity.listarPaginado(100, 0, "nombre", "asc", "14 prueba modificada");
            for (Departamento dep : lista) {
                System.out.print(dep.getIdDepartamento()+ " ");
                System.out.println(dep.getNombre());
            }
            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }
    @Test(enabled = true)
    public void count() {
        try {
            Long count = entity.count(null);
            System.out.println("Filas: " + count.toString());
            Assert.assertTrue(count >= 0);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }
    
}
