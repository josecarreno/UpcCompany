/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pe.com.upccompany.dao.hibernate.test;

import java.util.ArrayList;
import java.util.List;
import org.testng.Assert;
import static org.testng.Assert.*;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pe.com.upccompany.dao.entity.Departamento;
import pe.com.upccompany.dao.entity.Empleado;
import pe.com.upccompany.dao.entity.Idioma;
import pe.com.upccompany.dao.hibernate.base.EntityDao;
import pe.com.upccompany.dao.hibernate.impl.EmpleadoHibernateDao;

/**
 *
 * @author Jose
 */
@Test(enabled = false)
public class EmpleadoTest {

    public EmpleadoTest() {
    }

    private final EmpleadoHibernateDao entity = EmpleadoHibernateDao.obtenerInstancia();
    private static Empleado empleado;

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
            empleado = new Empleado();
            empleado.setNombre("empleado de prueba");

            Idioma idioma = new Idioma();
            idioma.setIdIdioma(1);
            List<Idioma> idiomas = new ArrayList<Idioma>();
            idiomas.add(idioma);
            empleado.setIdiomaList(idiomas);

            Departamento departamento = new Departamento();
            departamento.setIdDepartamento(1);
            empleado.setIdDepartamento(departamento);

            entity.insertar(empleado);
            Assert.assertTrue(empleado.getIdEmpleado() > 0);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = {"insertar"}, enabled = false)
    public void actualizar() {
        try {
            empleado.setNombre("empleado actualizado");

            Idioma idioma = new Idioma();
            idioma.setIdIdioma(2);
            List<Idioma> idiomas = new ArrayList<Idioma>();
            idiomas.add(idioma);
            empleado.setIdiomaList(idiomas);

            Departamento departamento = new Departamento();
            departamento.setIdDepartamento(2);
            empleado.setIdDepartamento(departamento);

            entity.actualizar(empleado);
            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }

    @Test(dependsOnMethods = {"insertar"}, enabled = false)
    public void eliminar() {
        try {
            entity.eliminar(empleado.getIdEmpleado());
            Assert.assertTrue(true);
        } catch (Exception ex) {
            ex.printStackTrace();
            Assert.fail("Error: " + ex.getMessage());
        }
    }

    @Test(enabled = false)
    public void listar() {
        try {
            List<Empleado> lista = entity.listar();
            for (Empleado emp : lista) {
                System.out.println("Nombre:" + emp.getNombre());
                List<Idioma> idiomas = emp.getIdiomaList();
                System.out.println("Idiomas:");
                for (Idioma idioma : idiomas) {
                    System.out.println(idioma.getNombre());
                }
            }
            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }

    @Test(enabled = false)
    public void listarPaginado() {
        try {
            List<Empleado> lista = entity.listarPaginado(100, 0, "nombre", "asc", null);
            for (Empleado emp : lista) {
                System.out.println(emp.getIdDepartamento());
                System.out.println(emp.getDni());
                System.out.println(emp.getNombre());
                System.out.println(emp.getApellido());
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
            System.out.println(count.toString());
            Assert.assertTrue(true);
        } catch (Exception e) {
            e.printStackTrace();
            Assert.fail("Error: " + e.getMessage());
        }
    }
}
