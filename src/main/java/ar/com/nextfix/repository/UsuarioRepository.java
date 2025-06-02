package ar.com.nextfix.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.nextfix.domain.Director;
import ar.com.nextfix.domain.Usuario;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long>{
	Usuario findByUsername(String username);
    Usuario findByDirector(Director director);
    List<Usuario> findByDirectorIsNotNull();
}
