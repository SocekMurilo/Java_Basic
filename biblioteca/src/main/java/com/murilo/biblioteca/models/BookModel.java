package com.murilo.biblioteca.models;

import java.io.Serializable;
import java.sql.Date;
import java.util.UUID;

import jakarta.persistence.*;

@Entity
@Table(name = "Books")
public class BookModel implements Serializable{
    private static final long serialVersionUID = 1L;

    @Id // Identificador de ID
    @GeneratedValue(strategy=GenerationType.AUTO) // Gerar ID altomaticamente
    private UUID idBook; // Identificador UUID para arquiteturas distribuidas, quando temos base de dados por microservices, eles são universais.
    private String titulo;
    private String autor;
    private String isbn; // string pq não faz sentido armazenar em numero
    private Date publicacao;
    public String getAutor() {
        return autor;
    }
    public void setAutor(String autor) {
        this.autor = autor;
    }
    public String getIsbn() {
        return isbn;
    }
    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }
    public Date getPublicacao() {
        return publicacao;
    }
    public void setPublicacao(Date publicacao) {
        this.publicacao = publicacao;
    }
    public String getTitulo() {
        return titulo;
    }
    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }


    // Gerar Getter e Setter de todos os atributos na mão, c# é melhor
    public UUID getIdBook() {
        return idBook;
    }
    public void setIdBook(UUID idBook) {
        this.idBook = idBook;
    }
    
}
