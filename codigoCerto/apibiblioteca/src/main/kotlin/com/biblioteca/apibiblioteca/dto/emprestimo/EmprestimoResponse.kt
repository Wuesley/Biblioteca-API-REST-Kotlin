package com.biblioteca.apibiblioteca.dto.emprestimo
import com.biblioteca.apibiblioteca.dto.livro.LivroResponse
import com.biblioteca.apibiblioteca.dto.usuario.UsuarioResponse



data class EmprestimoResponse(
    val id: Long,
    val usuario: UsuarioResponse,
    val livro: LivroResponse,
    val dataEmprestimo: String,
    val dataDevolucao: String?
)