package com.cmmprod.spring5webapp.bootstrap;

import com.cmmprod.spring5webapp.domain.Author;
import com.cmmprod.spring5webapp.domain.Book;
import com.cmmprod.spring5webapp.domain.Publisher;

import com.cmmprod.spring5webapp.repositories.AuthorRepository;
import com.cmmprod.spring5webapp.repositories.BookRepository;
import com.cmmprod.spring5webapp.repositories.PublisherRepository;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class BootStrapData implements CommandLineRunner{
    
    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final PublisherRepository publisherRepository;

    public BootStrapData(AuthorRepository authorRepository, BookRepository bookRepository, PublisherRepository publisherRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.publisherRepository = publisherRepository;
    }
    
    @Override
    public void run(String... args) throws Exception{
        Publisher publisher = new Publisher("Taylor Barr", "2933 Autumn Applause dr", "lewis center", "OH", "43035");
        publisherRepository.save(publisher);
        
        
        Author eric = new Author("eric","evans");
        Book ddd = new Book("Domain Driven Design", "123123");
        eric.getBooks().add(ddd);
        ddd.getAuthors().add(eric);
        publisher.getBooks().add(ddd);
        ddd.setPublisher(publisher);
              
        authorRepository.save(eric);
        bookRepository.save(ddd);
        publisherRepository.save(publisher);

        Author rod = new Author("Rod", "Johnson");
        Book noEJB = new Book("J2EE Development without EJB", "3939459459");
        rod.getBooks().add(noEJB);
        noEJB.getAuthors().add(rod);
        publisher.getBooks().add(noEJB);
        noEJB.setPublisher(publisher);

        authorRepository.save(rod);
        bookRepository.save(noEJB);
        publisherRepository.save(publisher);

        Author isones = new Author("Isabel", "Barr");
        Book htc = new Book("How To Pick Out a Cookware Set For Your Registry", "000000000");
        isones.getBooks().add(htc);
        htc.getAuthors().add(isones);
        publisher.getBooks().add(htc);
        htc.setPublisher(publisher);

        authorRepository.save(isones);
        bookRepository.save(htc);
        publisherRepository.save(publisher);
        
        System.out.println("Started In Bootstrap");
        System.out.println("Number of books: " + bookRepository.count());
        System.out.println("Number of publishers: " + publisherRepository.count());
        System.out.println("Number of books for taylor: " + publisher.getBooks().size() );

    }
}
