package com.biblioteca.apibiblioteca.dto.autor
import com.biblioteca.apibiblioteca.model.Autor



data class AutorResponse(
    val id: Long,
    val nome: String
)

fun Autor.toResponse(): AutorResponse = AutorResponse(id = this.id, nome = this.nome)