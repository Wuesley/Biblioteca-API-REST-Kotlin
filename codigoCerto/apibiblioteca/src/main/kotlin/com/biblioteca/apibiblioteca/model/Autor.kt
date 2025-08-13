package com.biblioteca.apibiblioteca.model
import jakarta.persistence.*

@Entity
@Table(name = "autores")
data class Autor(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    var nome: String
)