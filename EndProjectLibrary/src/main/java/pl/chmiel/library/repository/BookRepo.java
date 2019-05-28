package pl.chmiel.library.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.chmiel.library.component.Book;

import java.util.List;

@Repository
public interface BookRepo extends CrudRepository<Book, Long> {

  @Query("SELECT a FROM Book a WHERE a.title=:str or a.author=:str")
  List<Book> findByTitleOrAuthor(String str);

}
