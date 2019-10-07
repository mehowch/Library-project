package pl.chmiel.library.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.chmiel.library.component.Book;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> {

    @Query("SELECT a FROM Book a WHERE a.title = :param OR a.author = :param OR a.year = :param")
    Iterable<Book> findBook(@Param("param") String param);

}
