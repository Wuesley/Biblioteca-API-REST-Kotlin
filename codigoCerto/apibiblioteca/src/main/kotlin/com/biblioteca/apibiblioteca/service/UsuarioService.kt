package com.biblioteca.apibiblioteca.service

import com.biblioteca.apibiblioteca.dto.usuario.UsuarioRequest
import com.biblioteca.apibiblioteca.dto.usuario.UsuarioResponse
import com.biblioteca.apibiblioteca.model.Usuario
import com.biblioteca.apibiblioteca.repository.UsuarioRepository
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UsuarioService(
    val usuarioRepository: UsuarioRepository,
    val passwordEncoder: PasswordEncoder // Injetado para criptografar senhas
) {

    fun salvar(request: UsuarioRequest): UsuarioResponse {
        val usuario = Usuario(
            nome = request.nome,
            email = request.email, // Adicionado
            senha = passwordEncoder.encode(request.senha) // Senha criptografada
        )
        val salvo = usuarioRepository.save(usuario)
        return UsuarioResponse(salvo.id, salvo.nome, salvo.email) // Atualizado para retornar email
    }

    fun listar(): List<UsuarioResponse> {
        return usuarioRepository.findAll().map { UsuarioResponse(it.id, it.nome, it.email) }
    }

    fun buscarPorId(id: Long): UsuarioResponse? {
        val usuario = usuarioRepository.findById(id)
        return usuario.map { UsuarioResponse(it.id, it.nome, it.email) }.orElse(null)
    }

    fun deletarPorId(id: Long) {
        if (usuarioRepository.existsById(id)) {
            usuarioRepository.deleteById(id)
        } else {
            throw Exception("Usuário não encontrado")
        }
    }

    fun atualizar(id: Long, request: UsuarioRequest): UsuarioResponse {
        val usuario = usuarioRepository.findById(id).orElseThrow { Exception("Usuário não encontrado") }
        usuario.nome = request.nome
        usuario.email = request.email // Atualiza email
        // Obs: Atualização de senha deveria ser em endpoint específico
        val atualizado = usuarioRepository.save(usuario)
        return UsuarioResponse(atualizado.id, atualizado.nome, atualizado.email)
    }
}