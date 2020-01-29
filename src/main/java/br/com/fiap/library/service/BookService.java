package br.com.fiap.library.service;

import br.com.fiap.library.dto.AutorDTO;
import br.com.fiap.library.dto.BookDTO;
import br.com.fiap.library.dto.CreateBookDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> getAll(String titulo);
    BookDTO findById(Integer id);
    BookDTO create(CreateBookDTO createBookDTO);
    BookDTO update(Integer id, CreateBookDTO createBookDTO);
    BookDTO update(Integer id, AutorDTO autorDTO);
    void delete(Integer id);

}
