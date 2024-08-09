package org.example.mongoreactivegraphql.service;

import lombok.RequiredArgsConstructor;
import org.example.mongoreactivegraphql.dao.BookDao;
import org.example.mongoreactivegraphql.ds.BookInput;
import org.example.mongoreactivegraphql.entity.Book;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class BookService {
    private final BookDao bookDao;

    public Flux<Book> findAll() {
        return  bookDao.findAll();
    }
    public Mono<Book> findById( String id) {
        return bookDao.findById(id);
    }

    public Mono<Boolean> deleteById( String id) {
        return bookDao.deleteById(id).then(Mono.just(true));
    }

    public Mono<Book> save(Book book) {
        return bookDao.save(book);
    }

    public  Mono<Book> addBook(BookInput bookInput){
        Book book = new Book(null ,bookInput.title(), bookInput.pages(), bookInput.author());
                return bookDao.save(book);

    }

    public Mono<Book> updateBook(String id , BookInput bookInput){
        Book book = new Book(id ,bookInput.title(), bookInput.pages(), bookInput.author());
        return bookDao.findById(id)
                .flatMap(b->Mono.just(book))
                .doOnNext(bs-> book.setId(id))
                .flatMap(bookDao::save);
    }


}
