package microservice_usuarios.gestion_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
public class GestionApplication {

	public static void main(String[] args) {
		SpringApplication.run(GestionApplication.class, args);
	}

	// @GetMapping
	// public String index(){
	// 	return "index";
	// }
}
