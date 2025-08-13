package com.biblioteca.apibiblioteca.repository

import com.biblioteca.apibiblioteca.model.Autor
import com.biblioteca.apibiblioteca.model.Livro
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest

@DataJpaTest // Configura banco de dados em memória (H2)
class LivroRepositoryTest {

    @Autowired
    private lateinit var livroRepository: LivroRepository

    @Autowired
    private lateinit var autorRepository: AutorRepository

    @Test
    fun `deve salvar e buscar um livro`() {
        val autor = autorRepository.save(Autor(nome = "Autor Teste"))
        val livro = Livro(titulo = "Livro Teste", autor = autor)

        val livroSalvo = livroRepository.save(livro)
        val livroEncontrado = livroRepository.findById(livroSalvo.id!!)

        assertTrue(livroEncontrado.isPresent)
        assertEquals("Livro Teste", livroEncontrado.get().titulo)
    }
}