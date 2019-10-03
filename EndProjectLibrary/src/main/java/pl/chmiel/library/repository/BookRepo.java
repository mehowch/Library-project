package pl.chmiel.library.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import pl.chmiel.library.component.Book;

import java.util.List;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> {

    @Query("SELECT a FROM Book a WHERE a.title = :title")
    Book findByTitle(@Param("title") String title);


//    @Query("SELECT a FROM Book a WHERE a.title = ?1")
//    List<Book> findByTitle(String title);

}
