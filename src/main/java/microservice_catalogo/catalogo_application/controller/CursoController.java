package microservice_catalogo.catalogo_application.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import microservice_catalogo.catalogo_application.model.Curso;

import microservice_catalogo.catalogo_application.CursoService.CursoService;

@RestController
@RequestMapping("/cursos")
public class CursoController {

    private final CursoService cursoService;

    CursoController(CursoService cursoService) {
        this.cursoService = cursoService;
    }

    @GetMapping
    public ResponseEntity<List<Curso>> obtenerListaCursos() {
        List<Curso> cursos = cursoService.getAllCourses();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerCursoPorCategoria(@PathVariable Long id) {
        Optional<Curso> cursoOptional = cursoService.obtenerCursoPorId(id);
        if (cursoOptional.isPresent()) {
            return new ResponseEntity<>(cursoOptional.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PostMapping("/crear")
    public ResponseEntity<Curso> crearCurso(@RequestBody Curso nuevoCurso) {
        try {
            Curso cursoCreado = cursoService.crearCurso(nuevoCurso);
            return ResponseEntity
                    .created(URI.create("/cursos/" + cursoCreado.getId()))
                    .body(cursoCreado);
        } catch (Exception e) {
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .build();
        }
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable Long id, @RequestBody Curso cursoActualizado) {
        try {
            Curso cursoActualizadoResultado = cursoService.actualizarCurso(id, cursoActualizado);
            return ResponseEntity.ok(cursoActualizadoResultado);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        try {
            cursoService.deleteCourse(id);
            return ResponseEntity.noContent().build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }
}
