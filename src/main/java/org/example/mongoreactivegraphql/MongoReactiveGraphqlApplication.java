package org.example.mongoreactivegraphql;

import lombok.RequiredArgsConstructor;
import org.example.mongoreactivegraphql.dao.BookDao;
import org.example.mongoreactivegraphql.entity.Book;
import org.example.mongoreactivegraphql.entity.Review;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
@RequiredArgsConstructor
public class MongoReactiveGraphqlApplication {

    private final BookDao bookDao;
    @Bean
    @Profile("dev")
    public ApplicationRunner runner(){
        return args -> {
             Book book = new Book( null ,"the catcher in the rye" ,500 ,"No more" );
            Book book1 = new Book( null ,"the more than peace" ,400 ,"No more" );

            book.addReview(new Review("the character" ,"the acting feel so bad and the book was amazing"));
            book1.addReview(new Review("the support" , "the good nice"));

            bookDao.save(book).subscribe();
            bookDao.save(book1).subscribe();
        };

    }

    public static void main(String[] args) {
        SpringApplication.run(MongoReactiveGraphqlApplication.class, args);
    }

}
