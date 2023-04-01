package com.example.springBootUnitTesting;

import com.example.springBootUnitTesting.entity.book.Book;
import com.example.springBootUnitTesting.entity.book.BookRepo;
import com.example.springBootUnitTesting.entity.book.BookService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@SpringBootTest
class SpringBootUnitTestingApplicationTests {

    @Autowired
    private BookService bookService;

    @MockBean
    private BookRepo bookRepo;

    @Test
    public void getBooksTest() {
        when(bookRepo.findAll()).thenReturn(
                Stream.of(new Book(1L, "Chader Pahar", "Maeen", 120.0),
                        new Book(120L, "Java Book", "Pavel", 130.0)).collect(Collectors.toList()));

        assertEquals(2, bookService.getBooks().size());
    }

}
