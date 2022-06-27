package org.ivangrod.domainevents.service.listeners

import org.ivangrod.domainevents.domain.events.BookUpdated
import org.ivangrod.domainevents.repository.BookArchiveRepository
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener


@Component
class BookUpdatedListener(
    val bookArchiveRepository: BookArchiveRepository,
) {
    @TransactionalEventListener(phase = TransactionPhase.BEFORE_COMMIT)
    fun archiveBook(bookUpdated: BookUpdated) {
        bookArchiveRepository.save(bookUpdated.bookArchive)
    }
}
