package com.biblioteca.apibiblioteca.config

import io.jsonwebtoken.Jwts
import jakarta.servlet.FilterChain
import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.context.SecurityContextHolder

@Component
class JwtAuthFilter : OncePerRequestFilter() {

    override fun doFilterInternal(
        request: HttpServletRequest,
        response: HttpServletResponse,
        filterChain: FilterChain
    ) {
        val authHeader = request.getHeader("Authorization")

        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            filterChain.doFilter(request, response)
            return
        }

        val token = authHeader.substring(7)

        try {
            val claims = Jwts.parserBuilder()
                .setSigningKey("sua-chave-secreta-aqui-pelo-menos-32-caracteres".toByteArray())
                .build()
                .parseClaimsJws(token)
                .body

            val username = claims.subject
            val authToken = UsernamePasswordAuthenticationToken(
                username,
                null,
                emptyList() // Adicione roles se necessário
            )
            SecurityContextHolder.getContext().authentication = authToken
        } catch (e: Exception) {
            response.sendError(HttpServletResponse.SC_UNAUTHORIZED, "Token inválido: ${e.message}")
            return
        }

        filterChain.doFilter(request, response)
    }
}