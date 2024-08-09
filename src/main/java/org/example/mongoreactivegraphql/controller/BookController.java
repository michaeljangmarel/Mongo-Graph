package org.example.mongoreactivegraphql.controller;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.example.mongoreactivegraphql.ds.BookInput;
import org.example.mongoreactivegraphql.entity.Book;
import org.example.mongoreactivegraphql.service.BookService;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Controller
@RequiredArgsConstructor
public class BookController {

    private final BookService bookService;

    @QueryMapping
    public Flux<Book> findAllBooks(){
        return bookService.findAll();
    }

    @QueryMapping
    public Mono<Book>findBookById(@Argument String id){
        return bookService.findById(id);
    }
    @MutationMapping
    public Mono<Boolean>findDeleteId(@Argument String id){
        return bookService.deleteById(id).defaultIfEmpty(false);
    }
    @MutationMapping
    public Mono<Book> createBook(@Argument String title , @Argument int pages, @Argument String author){
        return  bookService.save(new Book(null,title,pages,author));
    }

    @MutationMapping
    public  Mono<Book> addBook(@Argument BookInput book){
        return  bookService.addBook(book);
    }
    @MutationMapping
    public  Mono<Book> updateBook(@Argument String id , @Argument BookInput book){
        return  bookService.updateBook(id,book);
    }



}
