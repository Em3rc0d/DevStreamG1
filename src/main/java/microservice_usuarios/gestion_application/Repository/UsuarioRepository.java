package microservice_usuarios.gestion_application.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import microservice_usuarios.gestion_application.Entity.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Optional<Usuario> findById(Long id);
    
    List<Usuario> findAll();

    Usuario save(Usuario nuevoUsuario);

    boolean existsById(Long id);

    void deleteById(Long id);
    List<Usuario> findByNombre(String nombre);
    // List<Usuario> findByEdad(int edad);
    List<Usuario> findByNombreAndApellido(String nombre, String apellido);
    // long countByEdad(int edad);
    // List<Usuario> findByEdadGreaterThan(int edad);
    // List<Usuario> findByEdadLessThan(int edad);
}
