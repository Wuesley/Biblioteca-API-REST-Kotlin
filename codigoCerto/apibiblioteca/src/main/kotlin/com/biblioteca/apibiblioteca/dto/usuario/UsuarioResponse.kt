package com.biblioteca.apibiblioteca.dto.usuario
import com.biblioteca.apibiblioteca.model.Usuario

data class UsuarioResponse(
    val id: Long,
    val nome: String,
    val email: String
)


fun Usuario.toResponse() = UsuarioResponse(id = this.id, nome = this.nome, email = this.email)