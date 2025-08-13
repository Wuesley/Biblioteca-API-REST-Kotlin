package com.biblioteca.apibiblioteca.service
import com.biblioteca.apibiblioteca.dto.autor.AutorResponse
import com.biblioteca.apibiblioteca.dto.livro.LivroRequest
import com.biblioteca.apibiblioteca.dto.livro.LivroResponse
import com.biblioteca.apibiblioteca.model.Livro
import com.biblioteca.apibiblioteca.repository.AutorRepository
import com.biblioteca.apibiblioteca.repository.LivroRepository
import org.springframework.stereotype.Service

@Service
class LivroService(
    val livroRepository: LivroRepository,
    val autorRepository: AutorRepository
) {

    fun salvar(request: LivroRequest): LivroResponse {
        val autor = autorRepository.findById(request.autorId)
            .orElseThrow { Exception("Autor não encontrado") }

        val livro = Livro(titulo = request.titulo, autor = autor)
        val salvo = livroRepository.save(livro)

        return LivroResponse(salvo.id, salvo.titulo, AutorResponse(salvo.autor.id, salvo.autor.nome))
    }



    fun listar(): List<LivroResponse> {
        return livroRepository.findAll().map {
            LivroResponse(it.id, it.titulo, AutorResponse(it.autor.id, it.autor.nome))
        }
    }

    fun buscarPorId(id: Long): LivroResponse? {
        val livro = livroRepository.findById(id)
        return livro.map { LivroResponse(it.id, it.titulo, AutorResponse(it.autor.id, it.autor.nome)) }.orElse(null)
    }

    fun deletarPorId(id: Long) {
        val livro = livroRepository.findById(id)
        if (livro.isPresent) {
            livroRepository.deleteById(id)
        } else {
            throw Exception("Livro não encontrado")
        }
    }

    fun atualizar(id: Long, request: LivroRequest): LivroResponse {
        val livro = livroRepository.findById(id)
            .orElseThrow { Exception("Livro não encontrado") }

        val autor = autorRepository.findById(request.autorId)
            .orElseThrow { Exception("Autor não encontrado") }

        livro.titulo = request.titulo
        livro.autor = autor

        val atualizado = livroRepository.save(livro)

        return LivroResponse(atualizado.id, atualizado.titulo, AutorResponse(atualizado.autor.id, atualizado.autor.nome))
    }


}