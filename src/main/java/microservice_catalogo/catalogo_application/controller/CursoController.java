package microservice_catalogo.catalogo_application.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
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

    @Autowired
    private CursoService cursoService;

    @GetMapping
    public ResponseEntity<List<Curso>> obtenerListaCursos() {
        List<Curso> cursos = cursoService.obtenerTodosLosCursos();
        return new ResponseEntity<>(cursos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Curso> obtenerCursoPorCategoria(@PathVariable Long id) {
    Optional<Curso> cursoOptional = cursoService.obtenerCursoPorId(id);

    if (cursoOptional.isPresent()) {
        Curso curso = cursoOptional.get();
        return new ResponseEntity<>(curso, HttpStatus.OK);
    } else {
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }
}


    @PostMapping("/crear")
    public ResponseEntity<Curso> crearCurso(@RequestBody Curso nuevoCurso) {
        Curso cursoCreado = cursoService.crearCurso(nuevoCurso);
        return new ResponseEntity<>(cursoCreado, HttpStatus.CREATED);
    }

    @PutMapping("/actualizar/{id}")
    public ResponseEntity<Curso> actualizarCurso(@PathVariable Long id, @RequestBody Curso cursoActualizado) {
        Curso cursoActualizadoResultado = cursoService.actualizarCurso(id, cursoActualizado);
        return new ResponseEntity<>(cursoActualizadoResultado, HttpStatus.OK);
    }


    @DeleteMapping("/eliminar/{id}")
    public ResponseEntity<Void> eliminarCurso(@PathVariable Long id) {
        cursoService.eliminarCurso(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
