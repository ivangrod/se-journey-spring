package org.ivangrod.domainevents.service

import org.ivangrod.domainevents.domain.sell
import org.ivangrod.domainevents.repository.BookRepository
import org.springframework.stereotype.Service
import javax.transaction.Transactional


@Service
class BookSaleServiceImpl(
    private val bookRepository: BookRepository
) : BookSaleService {

    @Transactional
    override fun sellBook(bookId: Long) {
        val book = bookRepository.findById(bookId)
            .orElseThrow {
                NoSuchElementException("Book is not found")
            }
        book.sell()
        bookRepository.save(book)
    }
}
