package pl.chmiel.library;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class EndProjectLibraryApplication {

    public static void main(String[] args) {
        SpringApplication.run(EndProjectLibraryApplication.class, args);
    }

    // TODO: fix update book method
    // TODO: limit the number of books a user can borrow at once
    // TODO: show how many borrowed books a given user has

    // Dodano Swagger2, Dokumentacja dostępna pod adresem: http://localhost:8080/swagger-ui.html


}
