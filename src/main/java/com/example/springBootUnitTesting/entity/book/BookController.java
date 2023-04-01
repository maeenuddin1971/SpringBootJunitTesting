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

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable(name = "id") Long id) {
        Boolean isDeleted = this.bookService.delete(id);
        return new ResponseEntity<>(isDeleted, HttpStatus.OK);
    }

    @GetMapping("/getByWriter/{writer}")
    public ResponseEntity<?> getByWriter(@PathVariable(name = "writer") String writer) {
        List<Book> bookList = this.bookService.getBookByWriter(writer);
        return new ResponseEntity<>(bookList, HttpStatus.OK);
    }

}
