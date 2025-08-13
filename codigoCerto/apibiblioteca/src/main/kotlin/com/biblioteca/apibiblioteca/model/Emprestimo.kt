package com.biblioteca.apibiblioteca.model
import jakarta.persistence.*

@Entity
@Table(name = "emprestimos")
data class Emprestimo(
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,

    @ManyToOne
    @JoinColumn(name = "usuario_id")
    var usuario: Usuario,

    @ManyToOne
    @JoinColumn(name = "livro_id")
    var livro: Livro,

    var dataEmprestimo: String,
    var dataDevolucao: String? = null
)