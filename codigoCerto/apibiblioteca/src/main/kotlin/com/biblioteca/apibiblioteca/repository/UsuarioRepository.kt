package com.biblioteca.apibiblioteca.repository

import com.biblioteca.apibiblioteca.model.Usuario
import org.springframework.data.jpa.repository.JpaRepository

interface UsuarioRepository : JpaRepository<Usuario, Long> {
    fun findByEmail(email: String): Usuario?
}