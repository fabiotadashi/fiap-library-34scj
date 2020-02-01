package br.com.fiap.library.service.impl;

import br.com.fiap.library.repository.BookRepository;
import br.com.fiap.library.dto.AutorDTO;
import br.com.fiap.library.dto.BookDTO;
import br.com.fiap.library.dto.CreateBookDTO;
import br.com.fiap.library.entity.Book;
import br.com.fiap.library.service.BookService;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookServiceImpl implements BookService {

    private BookRepository bookRepository;

    public BookServiceImpl(BookRepository bookRepository){
        this.bookRepository = bookRepository;
    }

    @Override
    public List<BookDTO> findAll(String titulo) {
        List<Book> bookList;
        if(titulo == null){
            bookList = bookRepository.findAll();
        }else{
            bookList = bookRepository.findAllByTituloStartsWith(titulo);
        }
        return bookList
                .stream()
                .map(BookDTO::new)
                .collect(Collectors.toList());

    }

    @Override
    public BookDTO findById(Integer id) {
        Book book = getBookById(id);
        return new BookDTO(book);
    }

    @Override
    public BookDTO update(Integer id, CreateBookDTO createBookDTO) {
        Book book = getBookById(id);
        book.setTitulo(createBookDTO.getTitulo());
        book.setDataLancamento(createBookDTO.getDataLancamento());
        book.setISBN(createBookDTO.getISBN());
        book.setQuantidadeDePaginas(createBookDTO.getQuantidadeDePaginas());

        Book updatedBook = bookRepository.save(book);
        return new BookDTO(updatedBook);
    }

    @Override
    public BookDTO update(Integer id, AutorDTO autorDTO) {
        return null;
    }

    @Override
    public BookDTO create(CreateBookDTO createBookDTO) {
        Book book = new Book(createBookDTO);
        Book savedBook = bookRepository.save(book);
        return new BookDTO(savedBook);
    }

    @Override
    public void delete(Integer id) {
        bookRepository.deleteById(id);
    }

    private Book getBookById(Integer id) {
        return bookRepository.findById(id)
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }
}
