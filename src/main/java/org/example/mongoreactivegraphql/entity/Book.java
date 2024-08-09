package org.example.mongoreactivegraphql.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Document
@Getter
@Setter
@ToString
@NoArgsConstructor
 public class Book {
    @Id
    private String id;
    private String title;
    private  int pages;
    private String author;
    private List<Review> reviews= new ArrayList<Review>();

    public Book(String id, String title, int pages, String author) {
        this.id = id;
        this.title = title;
        this.pages = pages;
        this.author = author;
    }

    public void addReview(Review review) {
        this.reviews.add(review);
    }
}
