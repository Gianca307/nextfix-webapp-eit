package ar.com.nextfix;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import ar.com.nextfix.domain.Director;
import ar.com.nextfix.service.DirectorService;

import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class DirectorServiceTest extends BaseTest{
	private final DirectorService directorService;
    private Director directorGuardado;

    @BeforeEach
    void setup() {
        Director director = new Director();
        director.setNacionalidad("argentina");
        director.setFechaNacimiento(LocalDate.now());
        director.setEmail("juandiaz@example.com");

        directorGuardado = directorService.guardarDirector(director);
    }

    @Test
    void testGuardarDirector()
    {
        assertNotNull(directorGuardado.getId());
        assertEquals("argentina", directorGuardado.getNacionalidad());
        assertEquals(LocalDate.now(), directorGuardado.getFechaNacimiento());
        assertEquals("juandiaz@example.com", directorGuardado.getEmail());
    }

    @Test
    void testListarDirectores() {
        assertFalse(directorService.listarDirectores().isEmpty());
    }

    @Test
    void testObtenerDirectorPorId() {
        Long idDirector = 1L;
        Director director = directorService.obtenerDirectorPorId(idDirector);

        assertNotNull(director);
        assertEquals(idDirector, director.getId());
    }
}
