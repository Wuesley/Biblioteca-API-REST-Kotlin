package com.biblioteca.apibiblioteca.controller

import com.biblioteca.apibiblioteca.dto.autor.AutorResponse
import com.biblioteca.apibiblioteca.dto.livro.LivroRequest
import com.biblioteca.apibiblioteca.dto.livro.LivroResponse
import com.biblioteca.apibiblioteca.service.LivroService
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.`when`
import org.mockito.junit.jupiter.MockitoExtension
import kotlin.test.assertEquals

@ExtendWith(MockitoExtension::class) // Habilita o Mockito
class LivroControllerTest {

    @Mock
    private lateinit var livroService: LivroService

    @InjectMocks // Injeta o mock no controller
    private lateinit var livroController: LivroController

    @Test
    fun `deve cadastrar um livro`() {
        // 1. Dados de teste
        val livroRequest = LivroRequest("Livro Teste", 1)
        val livroResponse = LivroResponse(1, "Livro Teste", AutorResponse(1, "Autor Teste"))

        // 2. Configuração do mock
        `when`(livroService.salvar(livroRequest)).thenReturn(livroResponse)

        // 3. Execução do método testado
        val resultado = livroController.cadastrar(livroRequest)

        // 4. Verificação
        assertEquals(livroResponse, resultado)
    }
}