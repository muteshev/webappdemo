package code.spring.webappdemo.bootstrap;

import code.spring.webappdemo.domain.Author;
import code.spring.webappdemo.domain.Book;
import code.spring.webappdemo.domain.Publisher;
import code.spring.webappdemo.repositories.AuthorRepository;
import code.spring.webappdemo.repositories.BookRepository;
import code.spring.webappdemo.repositories.PublisherRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        Publisher marat = new Publisher("Marat Uteshev", "694 Hamilton Ct", "Brentwood", "CA", "94513");
        publisherRepository.save(marat);

        Author eric = new Author("Eric", "Evans");
        Book ddd = new Book("Domain Driven Design", "123123");

        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        ddd.setPublisher(marat);

        authorRepository.save(eric);
        bookRepository.save(ddd);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "345345");

        eric.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        noEJB.setPublisher(marat);

        authorRepository.save(rod);
        bookRepository.save(noEJB);

        marat.getBooks().add(ddd);
        marat.getBooks().add(noEJB);

        publisherRepository.save(marat);

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Books: " + bookRepository.count());
        System.out.println("Number of Authors: " + authorRepository.count());

        System.out.println("Number of Publishers: " + publisherRepository.count());
        System.out.println("Publisher Number of Books: " + marat.getBooks().size());
    }
}
