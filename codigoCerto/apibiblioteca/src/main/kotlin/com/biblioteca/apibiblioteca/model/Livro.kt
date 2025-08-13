package com.biblioteca.apibiblioteca.model
import jakarta.persistence.*

@Entity(name = "livro")
@Table(name = "livros")
data class Livro(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var titulo: String,

    @ManyToOne
    @JoinColumn(name = "autor_id")
    var autor: Autor
)