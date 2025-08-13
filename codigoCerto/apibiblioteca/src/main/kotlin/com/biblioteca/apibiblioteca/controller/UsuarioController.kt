package com.biblioteca.apibiblioteca.controller
import com.biblioteca.apibiblioteca.dto.usuario.UsuarioRequest
import com.biblioteca.apibiblioteca.dto.usuario.UsuarioResponse
import com.biblioteca.apibiblioteca.service.UsuarioService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/usuarios")
class UsuarioController(val usuarioService: UsuarioService) {

    @PostMapping
    fun cadastrar(@RequestBody request: UsuarioRequest): UsuarioResponse {
        return usuarioService.salvar(request)
    }

    @GetMapping
    fun listar(): List<UsuarioResponse> {
        return usuarioService.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): UsuarioResponse? {
        return usuarioService.buscarPorId(id)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody request: UsuarioRequest): UsuarioResponse {
        return usuarioService.atualizar(id, request)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long) {
        usuarioService.deletarPorId(id)
    }
}
