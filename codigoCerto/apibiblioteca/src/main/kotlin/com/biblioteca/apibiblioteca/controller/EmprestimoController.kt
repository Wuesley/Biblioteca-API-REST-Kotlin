package com.biblioteca.apibiblioteca.controller
import com.biblioteca.apibiblioteca.dto.emprestimo.EmprestimoRequest
import com.biblioteca.apibiblioteca.dto.emprestimo.EmprestimoResponse
import com.biblioteca.apibiblioteca.service.EmprestimoService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/emprestimos")
class EmprestimoController(val emprestimoService: EmprestimoService) {

    @PostMapping
    fun cadastrar(@RequestBody request: EmprestimoRequest): EmprestimoResponse {
        return emprestimoService.salvar(request)
    }

    @GetMapping
    fun listar(): List<EmprestimoResponse> {
        return emprestimoService.listar()
    }

    @GetMapping("/{id}")
    fun buscarPorId(@PathVariable id: Long): EmprestimoResponse? {
        return emprestimoService.buscarPorId(id)
    }

    @PutMapping("/{id}")
    fun atualizar(@PathVariable id: Long, @RequestBody request: EmprestimoRequest): EmprestimoResponse {
        return emprestimoService.atualizar(id, request)
    }

    @DeleteMapping("/{id}")
    fun deletar(@PathVariable id: Long) {
        emprestimoService.deletarPorId(id)
    }
}
