package com.biblioteca.apibiblioteca.service
import com.biblioteca.apibiblioteca.dto.livro.toResponse
import com.biblioteca.apibiblioteca.dto.usuario.toResponse
import com.biblioteca.apibiblioteca.dto.emprestimo.EmprestimoRequest
import com.biblioteca.apibiblioteca.dto.emprestimo.EmprestimoResponse
import com.biblioteca.apibiblioteca.model.Emprestimo
import com.biblioteca.apibiblioteca.repository.EmprestimoRepository
import com.biblioteca.apibiblioteca.repository.LivroRepository
import com.biblioteca.apibiblioteca.repository.UsuarioRepository
import org.springframework.stereotype.Service

@Service
class EmprestimoService(
    val emprestimoRepository: EmprestimoRepository,
    val livroRepository: LivroRepository,
    val usuarioRepository: UsuarioRepository
) {

    fun salvar(request: EmprestimoRequest): EmprestimoResponse {
        val livro = livroRepository.findById(request.livroId)
            .orElseThrow { Exception("Livro não encontrado") }
        val usuario = usuarioRepository.findById(request.usuarioId)
            .orElseThrow { Exception("Usuário não encontrado") }
        val emprestimo = Emprestimo(livro = livro, usuario = usuario, dataEmprestimo = request.dataEmprestimo)
        val salvo = emprestimoRepository.save(emprestimo)
        return EmprestimoResponse(salvo.id, usuario.toResponse(),livro.toResponse(), salvo.dataEmprestimo, salvo.dataDevolucao)
    }

    fun listar(): List<EmprestimoResponse> {
        return emprestimoRepository.findAll().map {
            EmprestimoResponse(it.id, it.usuario.toResponse(), it.livro.toResponse(), it.dataEmprestimo, it.dataDevolucao)
        }
    }

    fun buscarPorId(id: Long): EmprestimoResponse? {
        val emprestimo = emprestimoRepository.findById(id)
        return emprestimo.map { EmprestimoResponse(it.id, it.usuario.toResponse(), it.livro.toResponse(), it.dataEmprestimo, it.dataDevolucao) }.orElse(null)
    }

    fun deletarPorId(id: Long) {
        val emprestimo = emprestimoRepository.findById(id)
        if (emprestimo.isPresent) {
            emprestimoRepository.deleteById(id)
        } else {
            throw Exception("Empréstimo não encontrado")
        }
    }

    fun atualizar(id: Long, request: EmprestimoRequest): EmprestimoResponse {
        val emprestimo = emprestimoRepository.findById(id).orElseThrow { Exception("Empréstimo não encontrado") }
        val livro = livroRepository.findById(request.livroId)
            .orElseThrow { Exception("Livro não encontrado") }
        val usuario = usuarioRepository.findById(request.usuarioId)
            .orElseThrow { Exception("Usuário não encontrado") }
        emprestimo.livro = livro
        emprestimo.usuario = usuario
        emprestimo.dataEmprestimo = request.dataEmprestimo
        val atualizado = emprestimoRepository.save(emprestimo)
        return EmprestimoResponse(
            atualizado.id,
            atualizado.usuario.toResponse(),
            atualizado.livro.toResponse(),
            atualizado.dataEmprestimo,
            atualizado.dataDevolucao
        )
    }
}