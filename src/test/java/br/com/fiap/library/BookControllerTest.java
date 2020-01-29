package br.com.fiap.library;

import br.com.fiap.library.service.BookService;
import br.com.fiap.library.service.impl.BookServiceImpl;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BookControllerTest {

    @Test
    public void getAllTest() {
        BookService bookService = new BookServiceImpl();
        assertEquals(bookService.getAll(null).size(), 3);
    }

}
