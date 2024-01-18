package microservice_catalogo.catalogo_application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.GetMapping;

@SpringBootApplication
@ComponentScan("microservice_catalogo.catalogo_application")
public class CatalogoCursosApplication {
    
    public static void main(String[] args) {
        SpringApplication.run(CatalogoCursosApplication.class, args);
    }

    @GetMapping
    public String index() {
        return "index";
    }
}
