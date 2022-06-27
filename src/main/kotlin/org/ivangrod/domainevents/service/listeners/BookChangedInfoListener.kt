package org.ivangrod.domainevents.service.listeners

import org.ivangrod.domainevents.domain.events.BookChangedInfo
import org.ivangrod.domainevents.service.EmailService
import org.springframework.stereotype.Component
import org.springframework.transaction.event.TransactionPhase
import org.springframework.transaction.event.TransactionalEventListener

@Component
class BookChangedInfoListener(
    val emailService: EmailService
) {
    @TransactionalEventListener(phase = TransactionPhase.AFTER_COMMIT)
    fun notifyAuthorByEmail(bookChangedInfo: BookChangedInfo) {
        bookChangedInfo.authorEmail?.let {
            emailService.send(it, "Your book's info has been changed")
        }
    }
}
