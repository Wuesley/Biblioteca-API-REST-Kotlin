package com.biblioteca.apibiblioteca.controller
import com.biblioteca.apibiblioteca.dto.livro.LivroRequest
import com.biblioteca.apibiblioteca.dto.livro.LivroResponse
import com.biblioteca.apibiblioteca.service.LivroService
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/livros")
class LivroController(val livroService: LivroService) {

    @PostMapping
    fun cadastrar(@RequestBody request: LivroRequest): LivroResponse {
        return livroService.salvar(request)
    }

    @GetMapping
    fun listar(): List<LivroResponse> {
        return livroService.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): LivroResponse? {
        return livroService.buscarPorId(id)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody request: LivroRequest): LivroResponse {
        return livroService.atualizar(id, request)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long) {
        livroService.deletarPorId(id)
    }
}
