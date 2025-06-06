package ar.com.nextfix.service;

import jakarta.persistence.EntityNotFoundException;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import ar.com.nextfix.domain.Pelicula;
import ar.com.nextfix.domain.Plataforma;
import ar.com.nextfix.repository.PlataformaRepository;

import java.util.List;

@Service
@AllArgsConstructor
public class PlataformaService {
	PlataformaRepository plataformaRepository;

    public Plataforma obtenerPlataformaPorId(Long id) {
        return plataformaRepository.findById(id).orElseThrow(
                () -> new RuntimeException("No se encontró la plataforma con el id: "+id));
    }

    public List<Plataforma> listarPlataformas() {
        return plataformaRepository.findAll();
    }

    public Plataforma guardarPlataforma(Plataforma plataforma) {
        return plataformaRepository.save(plataforma);
    }

    @Transactional
    public void eliminarPlataforma(Long id) {
        Plataforma plataforma = plataformaRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Plataforma no encontrada"));

        // Desvincular la plataforma de las películas
        for (Pelicula pelicula : plataforma.getPeliculas()) {
            pelicula.getPlataformasDisponibles().remove(plataforma);
        }

        // Limpiar la lista de películas asociadas en la plataforma
        plataforma.getPeliculas().clear();

        //Finalmente, eliminamos la plaforma
        plataformaRepository.delete(plataforma);
    }
}
