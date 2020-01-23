package br.com.fiap.library;

import br.com.fiap.library.controller.BookController;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookControllerTest {

    @Test
    public void getAllTest() {

        BookController bookController = new BookController();
        assertEquals(bookController.getAll(null).size(), 3);

    }


}
