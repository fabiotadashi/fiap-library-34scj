package br.com.fiap.library.service;

import br.com.fiap.library.dto.AutorDTO;
import br.com.fiap.library.dto.BookDTO;
import br.com.fiap.library.dto.CreateBookDTO;

import java.util.List;

public interface BookService {

    List<BookDTO> findAll(String titulo);

    BookDTO findById(Integer id);

    BookDTO update(Integer id, CreateBookDTO createBookDTO);

    BookDTO update(Integer id, AutorDTO autorDTO);

    BookDTO create(CreateBookDTO createBookDTO);

    void delete(Integer id);

}
