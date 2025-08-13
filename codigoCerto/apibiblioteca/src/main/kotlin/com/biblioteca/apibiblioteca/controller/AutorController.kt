package com.biblioteca.apibiblioteca.controller
import com.biblioteca.apibiblioteca.dto.autor.AutorRequest
import com.biblioteca.apibiblioteca.dto.autor.AutorResponse
import com.biblioteca.apibiblioteca.service.AutorService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/autores")
class AutorController(val autorService: AutorService) {

    @PostMapping
    fun cadastrar(@RequestBody request: AutorRequest): AutorResponse {
        return autorService.salvar(request)
    }

    @GetMapping
    fun listar(): List<AutorResponse> {
        return autorService.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): AutorResponse? {
        return autorService.buscarPorId(id)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody request: AutorRequest): AutorResponse {
        return autorService.atualizar(id, request)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long) {
        autorService.deletarPorId(id)
    }
}
