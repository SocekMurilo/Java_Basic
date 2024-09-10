package com.murilo.biblioteca.dtos;

import java.sql.Date;

import jakarta.validation.constraints.NotBlank;

public record BookRecordDto(@NotBlank String titulo, @NotBlank String autor, @NotBlank String isbn, Date publicacao) {}
