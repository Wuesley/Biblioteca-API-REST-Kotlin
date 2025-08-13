package com.biblioteca.apibiblioteca.service
import com.biblioteca.apibiblioteca.dto.autor.AutorRequest
import com.biblioteca.apibiblioteca.dto.autor.AutorResponse
import com.biblioteca.apibiblioteca.model.Autor
import com.biblioteca.apibiblioteca.repository.AutorRepository
import org.springframework.stereotype.Service

@Service
class AutorService(
    val autorRepository: AutorRepository
) {

    fun salvar(request: AutorRequest): AutorResponse {
        val autor = Autor(nome = request.nome)
        val salvo = autorRepository.save(autor)
        return AutorResponse(salvo.id, salvo.nome)
    }

    fun listar(): List<AutorResponse> {
        return autorRepository.findAll().map { AutorResponse(it.id, it.nome) }
    }

    fun buscarPorId(id: Long): AutorResponse? {
        val autor = autorRepository.findById(id)
        return autor.map { AutorResponse(it.id, it.nome) }.orElse(null)
    }

    fun deletarPorId(id: Long) {
        val autor = autorRepository.findById(id)
        if (autor.isPresent) {
            autorRepository.deleteById(id)
        } else {
            throw Exception("Autor não encontrado")
        }
    }

    fun atualizar(id: Long, request: AutorRequest): AutorResponse {
        val autor = autorRepository.findById(id).orElseThrow { Exception("Autor não encontrado") }
        autor.nome = request.nome
        val atualizado = autorRepository.save(autor)
        return AutorResponse(atualizado.id, atualizado.nome)
    }
}