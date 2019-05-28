package pl.chmiel.library.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import pl.chmiel.library.component.User;

@Repository
public interface UserRepo extends CrudRepository<User, Long> {
  User findByUserName(String username);
}
