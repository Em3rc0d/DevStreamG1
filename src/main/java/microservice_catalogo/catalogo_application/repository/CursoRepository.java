package microservice_catalogo.catalogo_application.repository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import microservice_catalogo.catalogo_application.model.Curso;

public interface CursoRepository extends JpaRepository<Curso, Long> {
    List<Curso> findByCategoria(String categoria);
}