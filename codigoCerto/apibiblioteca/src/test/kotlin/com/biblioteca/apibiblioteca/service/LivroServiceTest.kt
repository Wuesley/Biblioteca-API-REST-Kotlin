package com.biblioteca.apibiblioteca.service

import com.biblioteca.apibiblioteca.dto.autor.AutorResponse
import com.biblioteca.apibiblioteca.dto.livro.LivroRequest
import com.biblioteca.apibiblioteca.dto.livro.LivroResponse
import com.biblioteca.apibiblioteca.model.Autor
import com.biblioteca.apibiblioteca.model.Livro
import com.biblioteca.apibiblioteca.repository.AutorRepository
import com.biblioteca.apibiblioteca.repository.LivroRepository
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.mockito.InjectMocks
import org.mockito.Mock
import org.mockito.Mockito.*
import org.mockito.junit.jupiter.MockitoExtension
import java.util.*

@ExtendWith(MockitoExtension::class) // Habilita o Mockito no teste
class LivroServiceTest {

    @Mock
    private lateinit var livroRepository: LivroRepository

    @Mock
    private lateinit var autorRepository: AutorRepository

    @InjectMocks // Injeta os mocks no LivroService
    private lateinit var livroService: LivroService

    @Test
    fun `deve salvar um livro`() {
        // 1. Dados de teste
        val autor = Autor(id = 1, nome = "Autor Teste")
        val livroRequest = LivroRequest(titulo = "Livro Teste", autorId = 1)
        val livroSalvo = Livro(id = 1, titulo = "Livro Teste", autor = autor)
        val livroResponseEsperado = LivroResponse(1, "Livro Teste", AutorResponse(1, "Autor Teste"))

        // 2. Configuração dos mocks
        `when`(autorRepository.findById(1)).thenReturn(Optional.of(autor))
        `when`(livroRepository.save(any(Livro::class.java))).thenReturn(livroSalvo)

        // 3. Execução do método testado
        val resultado = livroService.salvar(livroRequest)

        // 4. Verificações
        assertEquals(livroResponseEsperado, resultado)
        verify(autorRepository).findById(1)
        verify(livroRepository).save(any(Livro::class.java))
    }
}