package org.ivangrod.domainevents

import org.ivangrod.domainevents.domain.Book
import org.ivangrod.domainevents.repository.BookRepository
import org.ivangrod.domainevents.service.BookSaleService
import org.springframework.boot.CommandLineRunner
import org.springframework.stereotype.Component

@Component
class Runner(bookSaleService: BookSaleService, bookRepository: BookRepository) : CommandLineRunner {
    private val bookSaleService: BookSaleService
    private val bookRepository: BookRepository

    init {
        this.bookSaleService = bookSaleService
        this.bookRepository = bookRepository
    }

    @Throws(Exception::class)
    override fun run(vararg args: String) {
        val book = bookRepository.save(Book(name = "Sapiens", description = "Sapiens", price = 40))
        book.id?.let { bookSaleService.sellBook(it) }
    }
}
