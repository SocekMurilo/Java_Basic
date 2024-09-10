package com.murilo.biblioteca.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import com.murilo.biblioteca.dtos.BookRecordDto;
import com.murilo.biblioteca.models.BookModel;
import com.murilo.biblioteca.repositories.BookRepository;

import jakarta.validation.Valid;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController // Especifico quando vai implementar uma classe rest
public class BookController {

    @Autowired
    BookRepository bookRepository;
    
    @PostMapping("/book") //Publicar um livro
    public ResponseEntity<BookModel> savebook(@RequestBody @Valid BookRecordDto bookRecordDto) {
        var bookModel = new BookModel();
        BeanUtils.copyProperties(bookRecordDto, bookModel);
        return ResponseEntity.status(HttpStatus.CREATED).body(bookRepository.save(bookModel));
    }

    @GetMapping("/book") //Ver todos os Livros
    public ResponseEntity<List<BookModel>> getAllbooks() {
        return ResponseEntity.status(HttpStatus.OK).body(bookRepository.findAll());
    }

    @GetMapping("/book/autor/{autor}") //ver livro por Autor
    public ResponseEntity<Object> getBookByAutor(@PathVariable("autor") String autor) {
        Optional<BookModel> bookOptional = bookRepository.findByAutor(autor);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(bookOptional.get());
    }

    @GetMapping("/book/titulo/{titulo}") //ver livro por Titulo
    public ResponseEntity<Object> getBookByTitulo(@PathVariable("titulo") String titulo) {
        List<BookModel> bookOptional = bookRepository.findByTitulo(titulo);
        if (bookOptional.isEmpty()) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Livro não encontrado");
        }
        return ResponseEntity.status(HttpStatus.OK).body(bookOptional);
    }

    
}
