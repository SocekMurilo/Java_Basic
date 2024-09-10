package com.murilo.biblioteca.repositories;

import com.murilo.biblioteca.models.BookModel;

import java.util.Optional;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;


@Repository
public interface BookRepository extends JpaRepository<BookModel, UUID>{
    Optional<BookModel> findByAutor(String autor);
    List<BookModel> findByTitulo(String titulo);
}