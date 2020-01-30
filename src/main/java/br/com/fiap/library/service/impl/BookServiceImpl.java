package br.com.fiap.library.service.impl;

import br.com.fiap.library.dto.AutorDTO;
import br.com.fiap.library.dto.BookDTO;
import br.com.fiap.library.dto.CreateBookDTO;
import br.com.fiap.library.service.BookService;
import org.springframework.stereotype.Service;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    List<BookDTO> bookDTOList = new ArrayList<>();

    public BookServiceImpl(){
        bookDTOList.add(new BookDTO(1,
                "Senhor do Aneis",
                800,
                "67125371213",
                ZonedDateTime.now().minusYears(40),
                new AutorDTO()));
        bookDTOList.add(new BookDTO(2,
                "O Hobbit",
                800,
                "67125371213",
                ZonedDateTime.now().minusYears(40),
                new AutorDTO()));
        bookDTOList.add(new BookDTO(3,
                "Silmarillion",
                800,
                "67125371213",
                ZonedDateTime.now().minusYears(40),
                new AutorDTO()));
    }

    @Override
    public List<BookDTO> findAll(String titulo) {
        return bookDTOList.stream()
                .filter(bookDTO -> titulo == null || bookDTO.getTitulo().startsWith(titulo))
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO findById(Integer id) {
        return null;
    }

    @Override
    public BookDTO update(Integer id, CreateBookDTO createBookDTO) {
        return null;
    }

    @Override
    public BookDTO update(Integer id, AutorDTO autorDTO) {
        return null;
    }

    @Override
    public BookDTO create(CreateBookDTO createBookDTO) {
        return null;
    }

    @Override
    public void delete(Integer id) {

    }
}
