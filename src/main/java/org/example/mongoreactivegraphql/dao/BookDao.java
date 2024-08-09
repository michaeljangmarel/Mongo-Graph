package org.example.mongoreactivegraphql.dao;

import org.example.mongoreactivegraphql.entity.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface BookDao extends ReactiveMongoRepository<Book, String> {
}
