package com.biblioteca.apibiblioteca.dto.livro
import com.biblioteca.apibiblioteca.dto.autor.toResponse
import com.biblioteca.apibiblioteca.dto.autor.AutorResponse
import com.biblioteca.apibiblioteca.model.Livro


data class LivroResponse(
    val id: Long,
    val titulo: String,
    val autor: AutorResponse
)
fun Livro.toResponse(): LivroResponse = LivroResponse(
    id = this.id,
    titulo = this.titulo,
    autor = this.autor.toResponse()
)