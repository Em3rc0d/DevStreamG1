package microservice_catalogo.catalogo_application.CursoService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

import microservice_catalogo.catalogo_application.model.Curso;
import microservice_catalogo.catalogo_application.repository.CursoRepository;

@Service
public class CursoService {

    @Autowired
    private CursoRepository cursoRepository;

    public List<Curso> obtenerTodosLosCursos() {
        return cursoRepository.findAll();
    }

    public Optional<Curso> obtenerCursoPorId(Long id) {
        return cursoRepository.findById(id);
    }
    
    public void eliminarCurso(Long id) {
        cursoRepository.deleteById(id);
    }

    public Curso actualizarCurso(Long id, Curso cursoActualizado) {
        Optional<Curso> optionalCurso = cursoRepository.findById(id);
        if (optionalCurso.isPresent()) {
            Curso cursoExistente = optionalCurso.get();
            cursoExistente.setNombre(cursoActualizado.getNombre());
            cursoExistente.setCategoria(cursoActualizado.getCategoria());
            return cursoRepository.save(cursoExistente);
        } else {
            // Manejar el caso en el que el curso no existe
            throw new RuntimeException("Curso no encontrado con ID: " + id);
        }
    }

    public Curso crearCurso(Curso nuevoCurso) {
        return cursoRepository.save(nuevoCurso);
    }

}
