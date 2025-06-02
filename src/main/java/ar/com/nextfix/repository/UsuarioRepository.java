package ar.com.nextfix.repository;

import java.util.List;

import org.springframework.stereotype.Repository;

import ar.com.nextfix.domain.Director;
import ar.com.nextfix.domain.Usuario;

@Repository
public interface UsuarioRepository {
	Usuario findByUsername(String username);
    Usuario findByDirector(Director director);
    List<Usuario> findByDirectorIsNotNull();
}
