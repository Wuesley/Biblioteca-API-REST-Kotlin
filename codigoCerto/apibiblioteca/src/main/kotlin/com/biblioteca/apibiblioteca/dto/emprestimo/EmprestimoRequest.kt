package com.biblioteca.apibiblioteca.dto.emprestimo

data class EmprestimoRequest(
    val usuarioId: Long,
    val livroId: Long,
    val dataEmprestimo: String
)