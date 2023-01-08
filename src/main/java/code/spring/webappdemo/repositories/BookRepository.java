package code.spring.webappdemo.repositories;

import code.spring.webappdemo.domain.Book;
import org.springframework.data.repository.CrudRepository;

public interface BookRepository extends CrudRepository<Book, Long> {
}
