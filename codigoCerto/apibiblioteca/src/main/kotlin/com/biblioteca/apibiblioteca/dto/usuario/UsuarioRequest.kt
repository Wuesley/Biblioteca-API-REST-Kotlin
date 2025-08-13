package com.biblioteca.apibiblioteca.dto.usuario

data class UsuarioRequest(
    val nome: String,
    val email: String,
    val senha: String
)