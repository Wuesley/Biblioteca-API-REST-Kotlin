package com.biblioteca.apibiblioteca.repository
import com.biblioteca.apibiblioteca.model.Livro
import org.springframework.data.jpa.repository.JpaRepository

interface LivroRepository : JpaRepository<Livro, Long>
