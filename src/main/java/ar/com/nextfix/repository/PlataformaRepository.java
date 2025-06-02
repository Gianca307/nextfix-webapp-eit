package ar.com.nextfix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.nextfix.domain.Plataforma;

@Repository
public interface PlataformaRepository extends JpaRepository<Plataforma, Long> {

}
