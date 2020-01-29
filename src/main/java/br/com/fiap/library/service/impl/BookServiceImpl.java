package br.com.fiap.library.service.impl;

import br.com.fiap.library.dto.AutorDTO;
import br.com.fiap.library.dto.BookDTO;
import br.com.fiap.library.dto.CreateBookDTO;
import br.com.fiap.library.entity.Book;
import br.com.fiap.library.repository.BookRepository;
import br.com.fiap.library.service.BookService;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;
    private ObjectMapper objectMapper;
    private List<BookDTO> bookDTOList = new ArrayList<>();

    @Autowired
    public BookServiceImpl(BookRepository bookRepository, ObjectMapper objectMapper) {
        this.bookRepository = bookRepository;
        this.objectMapper = objectMapper;
    }

    @Override
    public List<BookDTO> getAll(String titulo) {
        return bookRepository.findAll()
                .stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());
    }

    @Override
    public BookDTO findById(Integer id) {
        return bookDTOList.stream()
                .filter(bookDTO -> bookDTO.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public BookDTO create(CreateBookDTO createBookDTO) {
        Book book = objectMapper.convertValue(createBookDTO, Book.class);
        Book savedBook = bookRepository.save(book);
        return new BookDTO(savedBook);
    }

    @Override
    public BookDTO update(Integer id, CreateBookDTO createBookDTO) {
        BookDTO bookDTO = findById(id);
        bookDTO.setDataLancamento(createBookDTO.getDataLancamento());
        bookDTO.setISBN(createBookDTO.getISBN());
        bookDTO.setQuantidadeDePaginas(createBookDTO.getQuantidadeDePaginas());
        bookDTO.setTitulo(createBookDTO.getTitulo());
        return bookDTO;
    }

    @Override
    public BookDTO update(Integer id, AutorDTO autorDTO) {
        BookDTO bookDTO = findById(id);
        bookDTO.setAutor(autorDTO);
        return bookDTO;
    }

    @Override
    public void delete(Integer id) {
        BookDTO bookDTO = findById(id);
        bookDTOList.remove(bookDTO);
    }
}
