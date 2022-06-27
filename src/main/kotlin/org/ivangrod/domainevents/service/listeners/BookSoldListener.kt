package org.ivangrod.domainevents.service.listeners

import org.ivangrod.domainevents.domain.events.BookSold
import org.ivangrod.domainevents.repository.BookSaleRepository
import org.ivangrod.domainevents.service.EmailService
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class BookSoldListener(
    val emailService: EmailService,
    val bookSaleRepository: BookSaleRepository
) {
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    fun saveSales(bookSold: BookSold) {
        bookSaleRepository.save(bookSold.bookSale)
    }

    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    fun notifyAuthorIfNeeded(bookSold: BookSold) {
        throw RuntimeException()
        bookSold.authorEmail?.let { email ->
            val totalSoldBooks = bookSold.totalSoldBooksCount
            if (totalSoldBooks % 100 == 0) {
                emailService.send(email, "Another 100 books of your have been sold!")
            }
        }
    }
}
