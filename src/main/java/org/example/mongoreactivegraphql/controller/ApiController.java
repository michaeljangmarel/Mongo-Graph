package org.example.mongoreactivegraphql.controller;

import lombok.RequiredArgsConstructor;
import org.example.mongoreactivegraphql.entity.Book;
import org.example.mongoreactivegraphql.service.BookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

@RestController
@RequiredArgsConstructor
public class ApiController {
    private final BookService bookService;
    @GetMapping("/mongo")
    public Flux<Book> AllMongo(){
        return bookService.findAll();
    }
}
