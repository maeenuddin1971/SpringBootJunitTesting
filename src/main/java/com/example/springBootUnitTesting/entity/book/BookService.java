package com.example.springBootUnitTesting.entity.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepo bookRepo;

    public Book insert(Book book) {
        return this.bookRepo.save(book);
    }

    public Book get(Long id) {
        Book book = this.bookRepo.findById(id).orElse(null);
        return book;
    }

    public List<Book> getBooks() {
        return this.bookRepo.findAll();
    }

    public Boolean delete(Long id) {
        this.bookRepo.deleteById(id);
        return this.bookRepo.existsById(id);
    }

    public List<Book> getBookByWriter(String writer) {
         return this.bookRepo.findAllByWriter(writer);
    }

}
