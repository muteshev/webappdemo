package code.spring.webappdemo.repositories;

import code.spring.webappdemo.domain.Author;
import org.springframework.data.repository.CrudRepository;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
