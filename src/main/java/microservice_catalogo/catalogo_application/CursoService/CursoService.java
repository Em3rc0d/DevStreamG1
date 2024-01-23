package microservice_catalogo.catalogo_application.CursoService;

import org.springframework.stereotype.Service;

import lombok.NonNull;

import java.util.List;
import java.util.Optional;

import microservice_catalogo.catalogo_application.model.Curso;
import microservice_catalogo.catalogo_application.repository.CursoRepository;

@Service
public class CursoService {
 
     private final CursoRepository cursoRepository;

    CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

public List<Curso> getAllCourses() {
    try {
        return cursoRepository.findAll();
    } catch (Exception e) {
        // Log the exception or handle it as appropriate
        throw new RuntimeException("Failed to fetch all courses", e);
    }
}

public Optional<Curso> obtenerCursoPorId(Long id) {
    try {
        return Optional.ofNullable(cursoRepository.findById(id).orElse(null));
    } catch (Exception e) {
        e.printStackTrace();
        return Optional.empty();
    }
}
    
public void deleteCourse(Long id) {
    if (id != null) {
        try {
            cursoRepository.deleteById(id);
        } catch (Exception e) {
            throw new RuntimeException("Failed to delete course with ID: " + id, e);
        }
    } else {
        throw new IllegalArgumentException("Course ID cannot be null");
    }
}

public Curso actualizarCurso(Long id, Curso cursoActualizado) {
    Curso cursoExistente = cursoRepository.findById(id)
        .orElseThrow(() -> new RuntimeException("Curso no encontrado con ID: " + id));
    cursoExistente.setNombre(cursoActualizado.getNombre());
    cursoExistente.setCategoria(cursoActualizado.getCategoria());
    return cursoRepository.save(cursoExistente);
}

public Curso crearCurso(Curso nuevoCurso) {
    try {
        return cursoRepository.save(nuevoCurso);
    } catch (Exception e) {
        return null;
    }
}
}
