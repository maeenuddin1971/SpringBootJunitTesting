package com.example.springBootUnitTesting.entity.book;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/book")
@CrossOrigin("*")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping("/insert")
    public ResponseEntity<?> insert(@RequestBody Book book) {
        Book book1 = this.bookService.insert(book);

        return new ResponseEntity<>(book1, HttpStatus.OK);
    }

    @GetMapping("/get/{id}")
    public ResponseEntity<?> get(@PathVariable(name = "id") Long id) {
        Book book = this.bookService.get(id);
        return new ResponseEntity<>(book, HttpStatus.OK);
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll() {
        List<Book> bookList = this.bookService.getBooks();
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

}
