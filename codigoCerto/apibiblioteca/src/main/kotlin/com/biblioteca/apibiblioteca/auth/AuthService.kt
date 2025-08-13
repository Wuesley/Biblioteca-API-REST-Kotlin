package com.biblioteca.apibiblioteca.auth

import com.biblioteca.apibiblioteca.dto.auth.LoginResponse
import com.biblioteca.apibiblioteca.repository.UsuarioRepository
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import io.jsonwebtoken.security.Keys
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import java.util.*

@Service
class AuthService(
    private val userRepository: UsuarioRepository,
    private val passwordEncoder: PasswordEncoder
) {
    private val secretKey = "sua-chave-secreta-aqui-pelo-menos-32-caracteres"
    private val jwtIssuer = "biblioteca-api"

    fun login(email: String, senha: String): LoginResponse {
        val user = userRepository.findByEmail(email)
            ?.takeIf { passwordEncoder.matches(senha, it.senha) }
            ?: throw Exception("Credenciais inválidas")

        val token = Jwts.builder()
            .setSubject(user.id.toString())
            .setIssuer(jwtIssuer)
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + 86400000)) // 24 horas
            .signWith(
                Keys.hmacShaKeyFor(secretKey.toByteArray()),
                SignatureAlgorithm.HS256
            )
            .compact()

        return LoginResponse(token)
    }
}