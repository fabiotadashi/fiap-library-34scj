package br.com.fiap.library.dto;

import br.com.fiap.library.entity.Autor;

public class AutorDTO {

    private Integer id;
    private String nome;

    public AutorDTO(Autor autor) {
        this.id= autor.getId();
        this.nome = autor.getName();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
