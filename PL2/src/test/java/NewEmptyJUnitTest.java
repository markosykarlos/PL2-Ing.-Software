/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/UnitTests/JUnit5TestClass.java to edit this template
 */

import com.mycompany.pl2.*;
import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.*;

public class NewEmptyJUnitTest {

    @BeforeAll
    public static void setUpClass() {
        System.out.println("Iniciando tests...");
    }

    @AfterAll
    public static void tearDownClass() {
        System.out.println("Tests finalizados.");
    }

    @BeforeEach
    public void setUp() {
        System.out.println("Nuevo test...");
    }

    @AfterEach
    public void tearDown() {
        System.out.println("Test terminado.");
    }

    // =========================
    // TEST CITAS
    // =========================

    @Test
    public void testValidarFechaCorrecta() {
        Citas c = new Citas(LocalDate.now().plusDays(1), LocalTime.of(10, 0), "Madrid", "Juan");
        assertTrue(c.validarFecha(c.getFecha()));
    }

    @Test
    public void testValidarFechaIncorrecta() {
        Citas c = new Citas(LocalDate.now().minusDays(1), LocalTime.of(10, 0), "Madrid", "Juan");
        assertFalse(c.validarFecha(c.getFecha()));
    }

    // =========================
    // TEST CONTACTOS PERSONALES
    // =========================

    @Test
    public void testTelefonoValido() {
        ContactosPersonales c = new ContactosPersonales("Juan", 123456789, "juan@email.com", 28001);
        assertTrue(c.validarTelefono(c.getTelefono()));
    }

    @Test
    public void testCorreoValido() {
        ContactosPersonales c = new ContactosPersonales("Juan", 123456789, "juan@email.com", 28001);
        assertTrue(c.validarCorreo(c.getCorreo_electronico()));
    }

    @Test
    public void testCorreoInvalido() {
        ContactosPersonales c = new ContactosPersonales("Juan", 123456789, "juandominio.com", 28001);
        assertFalse(c.validarCorreo(c.getCorreo_electronico()));
    }

    // =========================
    // TEST TAREAS
    // =========================

    @Test
    public void testPrioridadAltaMayorQueBaja() {
        TareasPendientes t1 = new TareasPendientes("A", "alta", "pendiente");
        TareasPendientes t2 = new TareasPendientes("B", "baja", "pendiente");
        int resultado = t1.compararPorPrioridad(t2);
        assertTrue(resultado < 0); // alta debe ir antes
    }

    // =========================
    // TEST SOLAPAMIENTO CITAS
    // =========================

    @Test
    public void testSolapamientoCitas() {
        CitasDeTrabajo c1 = new CitasDeTrabajo("Reunion", 60, LocalDate.now(), LocalTime.of(10, 0), "Oficina", "Juan");
        CitasDeTrabajo c2 = new CitasDeTrabajo("Otra reunion", 60, LocalDate.now(), LocalTime.of(10, 30), "Oficina", "Pedro");
        assertTrue(c1.seSolapa(c2));
    }

    @Test
    public void testNoSolapamientoCitas() {
        CitasDeTrabajo c1 = new CitasDeTrabajo("Reunion", 60, LocalDate.now(), LocalTime.of(10, 0), "Oficina", "Juan");
        CitasDeTrabajo c2 = new CitasDeTrabajo("Otra reunion", 60, LocalDate.now(), LocalTime.of(12, 0), "Oficina", "Pedro");
        assertFalse(c1.seSolapa(c2));
    }
}