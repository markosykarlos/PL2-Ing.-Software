import com.mycompany.pl2.*;
import java.time.LocalDate;
import java.time.LocalTime;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

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

    // TEST CITAS

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

    @Test
    public void testValidarHoraCorrecta() {
        Citas c = new Citas(LocalDate.now().plusDays(1), LocalTime.of(12, 30), "Madrid", "Juan");
        assertTrue(c.validarHora(c.getHora()));
    }

    @Test
    public void testValidarLugarCorrecto() {
        Citas c = new Citas(LocalDate.now().plusDays(1), LocalTime.of(10, 0), "Oficina", "Juan");
        assertTrue(c.validarLugar(c.getLugar()));
    }

    @Test
    public void testValidarLugarIncorrecto() {
        Citas c = new Citas(LocalDate.now().plusDays(1), LocalTime.of(10, 0), "", "Juan");
        assertFalse(c.validarLugar(c.getLugar()));
    }

    @Test
    public void testValidarPersonasInvolucradasCorrecto() {
        Citas c = new Citas(LocalDate.now().plusDays(1), LocalTime.of(10, 0), "Madrid", "Juan y Pedro");
        assertTrue(c.validarPersonasInvolucradas(c.getPersonas_involucradas()));
    }

    @Test
    public void testValidarPersonasInvolucradasIncorrecto() {
        Citas c = new Citas(LocalDate.now().plusDays(1), LocalTime.of(10, 0), "Madrid", "");
        assertFalse(c.validarPersonasInvolucradas(c.getPersonas_involucradas()));
    }

    // TEST CITAS DE TRABAJO
  
    @Test
    public void testValidarAgendaTemasCorrecta() {
        CitasDeTrabajo c = new CitasDeTrabajo("Reunion", 60, LocalDate.now().plusDays(1),
                LocalTime.of(10, 0), "Oficina", "Juan");
        assertTrue(c.validarAgendaTemas(c.getAgenda_temas()));
    }

    @Test
    public void testValidarAgendaTemasIncorrecta() {
        CitasDeTrabajo c = new CitasDeTrabajo("", 60, LocalDate.now().plusDays(1),
                LocalTime.of(10, 0), "Oficina", "Juan");
        assertFalse(c.validarAgendaTemas(c.getAgenda_temas()));
    }

    @Test
    public void testValidarDuracionEstimadaCorrecta() {
        CitasDeTrabajo c = new CitasDeTrabajo("Reunion", 60, LocalDate.now().plusDays(1),
                LocalTime.of(10, 0), "Oficina", "Juan");
        assertTrue(c.validarDuracionEst(c.getDuracion_est()));
    }

    @Test
    public void testValidarDuracionEstimadaIncorrecta() {
        CitasDeTrabajo c = new CitasDeTrabajo("Reunion", -5, LocalDate.now().plusDays(1),
                LocalTime.of(10, 0), "Oficina", "Juan");
        assertFalse(c.validarDuracionEst(c.getDuracion_est()));
    }

    @Test
    public void testSolapamientoCitas() {
        CitasDeTrabajo c1 = new CitasDeTrabajo("Reunion", 60, LocalDate.now(),
                LocalTime.of(10, 0), "Oficina", "Juan");
        CitasDeTrabajo c2 = new CitasDeTrabajo("Otra reunion", 60, LocalDate.now(),
                LocalTime.of(10, 30), "Oficina", "Pedro");
        assertTrue(c1.seSolapa(c2));
    }

    @Test
    public void testNoSolapamientoCitas() {
        CitasDeTrabajo c1 = new CitasDeTrabajo("Reunion", 60, LocalDate.now(),
                LocalTime.of(10, 0), "Oficina", "Juan");
        CitasDeTrabajo c2 = new CitasDeTrabajo("Otra reunion", 60, LocalDate.now(),
                LocalTime.of(12, 0), "Oficina", "Pedro");
        assertFalse(c1.seSolapa(c2));
    }

    @Test
    public void testNoSolapamientoPorFechaDistinta() {
        CitasDeTrabajo c1 = new CitasDeTrabajo("Reunion", 60, LocalDate.now(),
                LocalTime.of(10, 0), "Oficina", "Juan");
        CitasDeTrabajo c2 = new CitasDeTrabajo("Otra reunion", 60, LocalDate.now().plusDays(1),
                LocalTime.of(10, 30), "Oficina", "Pedro");
        assertFalse(c1.seSolapa(c2));
    }

    // TEST CONTACTOS PERSONALES

    @Test
    public void testNombreValido() {
        ContactosPersonales c = new ContactosPersonales("Juan", 123456789, "juan@email.com", 28001);
        assertTrue(c.validarNombre(c.getNombre()));
    }

    @Test
    public void testNombreInvalido() {
        ContactosPersonales c = new ContactosPersonales("", 123456789, "juan@email.com", 28001);
        assertFalse(c.validarNombre(c.getNombre()));
    }

    @Test
    public void testTelefonoValido() {
        ContactosPersonales c = new ContactosPersonales("Juan", 123456789, "juan@email.com", 28001);
        assertTrue(c.validarTelefono(c.getTelefono()));
    }

    @Test
    public void testTelefonoInvalido() {
        ContactosPersonales c = new ContactosPersonales("Juan", -1, "juan@email.com", 28001);
        assertFalse(c.validarTelefono(c.getTelefono()));
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

    @Test
    public void testDireccionPostalValida() {
        ContactosPersonales c = new ContactosPersonales("Juan", 123456789, "juan@email.com", 28001);
        assertTrue(c.validarDireccionPostal(c.getDireccion_postal()));
    }

    @Test
    public void testDireccionPostalInvalida() {
        ContactosPersonales c = new ContactosPersonales("Juan", 123456789, "juan@email.com", -5);
        assertFalse(c.validarDireccionPostal(c.getDireccion_postal()));
    }

    // TEST CONTACTOS PROFESIONALES

    @Test
    public void testEmpresaValida() {
        ContactosProfesionales c = new ContactosProfesionales("OpenAI", "Ingeniero", "Luis",
                987654321, "luis@openai.com", 28002);
        assertTrue(c.validarEmpresa(c.getEmpresa()));
    }

    @Test
    public void testEmpresaInvalida() {
        ContactosProfesionales c = new ContactosProfesionales("", "Ingeniero", "Luis",
                987654321, "luis@openai.com", 28002);
        assertFalse(c.validarEmpresa(c.getEmpresa()));
    }

    @Test
    public void testCargoValido() {
        ContactosProfesionales c = new ContactosProfesionales("OpenAI", "Ingeniero", "Luis",
                987654321, "luis@openai.com", 28002);
        assertTrue(c.validarCargo(c.getCargo()));
    }

    @Test
    public void testCargoInvalido() {
        ContactosProfesionales c = new ContactosProfesionales("OpenAI", "", "Luis",
                987654321, "luis@openai.com", 28002);
        assertFalse(c.validarCargo(c.getCargo()));
    }

    // TEST TAREAS PENDIENTES

    @Test
    public void testDescripcionValida() {
        TareasPendientes t = new TareasPendientes("Preparar informe", "alta", "pendiente");
        assertTrue(t.validarDescripcion(t.getDescripcion()));
    }

    @Test
    public void testDescripcionInvalida() {
        TareasPendientes t = new TareasPendientes("", "alta", "pendiente");
        assertFalse(t.validarDescripcion(t.getDescripcion()));
    }

    @Test
    public void testPrioridadValida() {
        TareasPendientes t = new TareasPendientes("Preparar informe", "alta", "pendiente");
        assertTrue(t.validarPrioridad(t.getPrioridad()));
    }

    @Test
    public void testEstadoValido() {
        TareasPendientes t = new TareasPendientes("Preparar informe", "alta", "pendiente");
        assertTrue(t.validarEstado(t.getEstado()));
    }

    @Test
    public void testPrioridadAltaMayorQueBaja() {
        TareasPendientes t1 = new TareasPendientes("A", "alta", "pendiente");
        TareasPendientes t2 = new TareasPendientes("B", "baja", "pendiente");
        int resultado = t1.compararPorPrioridad(t2);
        assertTrue(resultado < 0);
    }

    @Test
    public void testPrioridadMediaMayorQueBaja() {
        TareasPendientes t1 = new TareasPendientes("A", "media", "pendiente");
        TareasPendientes t2 = new TareasPendientes("B", "baja", "pendiente");
        int resultado = t1.compararPorPrioridad(t2);
        assertTrue(resultado < 0);
    }

    @Test
    public void testMismaPrioridad() {
        TareasPendientes t1 = new TareasPendientes("A", "alta", "pendiente");
        TareasPendientes t2 = new TareasPendientes("B", "alta", "pendiente");
        int resultado = t1.compararPorPrioridad(t2);
        assertEquals(0, resultado);
    }

    // TEST TAREAS CON SEGUIMIENTO

    @Test
    public void testFechaLimiteValida() {
        TareasConSeguimiento t = new TareasConSeguimiento(LocalDate.now().plusDays(5),
                "Juan", "Memoria", "alta", "pendiente");
        assertTrue(t.validarFechaLimite(t.getFecha_limite()));
    }

    @Test
    public void testFechaLimiteInvalida() {
        TareasConSeguimiento t = new TareasConSeguimiento(LocalDate.now().minusDays(1),
                "Juan", "Memoria", "alta", "pendiente");
        assertFalse(t.validarFechaLimite(t.getFecha_limite()));
    }

    @Test
    public void testResponsablesValidos() {
        TareasConSeguimiento t = new TareasConSeguimiento(LocalDate.now().plusDays(5),
                "Juan y Pedro", "Memoria", "alta", "pendiente");
        assertTrue(t.validarResponsables(t.getResponsables_asig()));
    }

    @Test
    public void testResponsablesInvalidos() {
        TareasConSeguimiento t = new TareasConSeguimiento(LocalDate.now().plusDays(5),
                "", "Memoria", "alta", "pendiente");
        assertFalse(t.validarResponsables(t.getResponsables_asig()));
    }
}