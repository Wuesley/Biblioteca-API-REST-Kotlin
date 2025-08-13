package com.biblioteca.apibiblioteca.auth

import com.biblioteca.apibiblioteca.dto.auth.LoginRequest
import com.biblioteca.apibiblioteca.dto.auth.LoginResponse
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(val service: AuthService) {

    @PostMapping("/login")
    fun login(@RequestBody request: LoginRequest): LoginResponse {
        return service.login(request.email, request.senha)
    }
}

