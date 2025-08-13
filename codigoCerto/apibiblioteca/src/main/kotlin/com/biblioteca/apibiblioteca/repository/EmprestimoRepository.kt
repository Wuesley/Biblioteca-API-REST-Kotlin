package com.biblioteca.apibiblioteca.repository
import com.biblioteca.apibiblioteca.model.Emprestimo
import org.springframework.data.jpa.repository.JpaRepository

interface EmprestimoRepository : JpaRepository<Emprestimo, Long>