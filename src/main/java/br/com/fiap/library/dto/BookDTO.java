package br.com.fiap.library.dto;

import br.com.fiap.library.entity.Book;

import java.lang.reflect.UndeclaredThrowableException;
import java.time.ZoneOffset;
import java.time.ZonedDateTime;
import java.util.Date;

public class BookDTO {

    private Integer id;
    private String titulo;
    private Integer quantidadeDePaginas;
    private String ISBN;
    private ZonedDateTime dataLancamento;
    private AutorDTO autor;
    private ZonedDateTime dataCriacao;
    private ZonedDateTime dataModificacao;

    public BookDTO(){}

    public BookDTO(Integer id, String titulo, Integer quantidadeDePaginas, String ISBN, ZonedDateTime dataLancamento, AutorDTO autor) {
        this.id = id;
        this.titulo = titulo;
        this.quantidadeDePaginas = quantidadeDePaginas;
        this.ISBN = ISBN;
        this.dataLancamento = dataLancamento;
        this.autor = autor;
    }

    public BookDTO(CreateBookDTO createBookDTO, Integer id) {
        this.id = id;
        this.titulo = createBookDTO.getTitulo();
        this.quantidadeDePaginas = createBookDTO.getQuantidadeDePaginas();
        this.ISBN = createBookDTO.getISBN();
        this.dataLancamento = createBookDTO.getDataLancamento();
    }

    public BookDTO(Book book) {
        this.id = book.getId();
        this.titulo = book.getTitulo();
        this.quantidadeDePaginas = book.getQuantidadeDePaginas();
        this.ISBN = book.getISBN();
        this.dataLancamento = book.getDataLancamento();
        this.dataCriacao = ZonedDateTime.ofInstant(book.getCreatedDate().toInstant(), ZoneOffset.UTC);
        this.dataModificacao = ZonedDateTime.ofInstant(book.getModifiedDate().toInstant(), ZoneOffset.UTC);
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Integer getQuantidadeDePaginas() {
        return quantidadeDePaginas;
    }

    public void setQuantidadeDePaginas(Integer quantidadeDePaginas) {
        this.quantidadeDePaginas = quantidadeDePaginas;
    }

    public String getISBN() {
        return ISBN;
    }

    public void setISBN(String ISBN) {
        this.ISBN = ISBN;
    }

    public ZonedDateTime getDataLancamento() {
        return dataLancamento;
    }

    public void setDataLancamento(ZonedDateTime dataLancamento) {
        this.dataLancamento = dataLancamento;
    }

    public AutorDTO getAutor() {
        return autor;
    }

    public void setAutor(AutorDTO autor) {
        this.autor = autor;
    }

    public ZonedDateTime getDataCriacao() {
        return dataCriacao;
    }

    public void setDataCriacao(ZonedDateTime dataCriacao) {
        this.dataCriacao = dataCriacao;
    }

    public ZonedDateTime getDataModificacao() {
        return dataModificacao;
    }

    public void setDataModificacao(ZonedDateTime dataModificacao) {
        this.dataModificacao = dataModificacao;
    }
}
