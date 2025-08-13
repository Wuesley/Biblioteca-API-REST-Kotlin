package com.biblioteca.apibiblioteca.repository
import com.biblioteca.apibiblioteca.model.Autor
import org.springframework.data.jpa.repository.JpaRepository

interface AutorRepository : JpaRepository<Autor, Long>