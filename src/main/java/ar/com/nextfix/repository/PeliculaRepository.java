package ar.com.nextfix.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import ar.com.nextfix.domain.Director;
import ar.com.nextfix.domain.Pelicula;

@Repository
public interface PeliculaRepository extends JpaRepository<Pelicula, Long>{
	Optional<Pelicula> findByGenero(String genero);

    @Query("SELECT p FROM Pelicula p ORDER BY LOWER(p.titulo) ASC")
    List<Pelicula> findByAllByOrderByTituloIgnoreCaseAsc();

    void deleteByDirector(Director director);

    void deleteByGenero(String genero);
}
