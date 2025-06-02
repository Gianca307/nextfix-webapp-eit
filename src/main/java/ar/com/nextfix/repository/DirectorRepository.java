package ar.com.nextfix.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.nextfix.domain.Director;

@Repository
public interface DirectorRepository extends JpaRepository<Director, Long> {

}
