package org.ivangrod.domainevents.domain.events

import org.ivangrod.domainevents.domain.Book
import org.ivangrod.domainevents.domain.BookArchive
import java.time.OffsetDateTime

class BookUpdated(book: Book) {
    val bookArchive = BookArchive(
        book = book,
        name = book.name,
        description = book.description,
        dateArchiveCreated = OffsetDateTime.now(),
        lastDateVersionUpdated = book.lastDateUpdated ?: book.dateCreated,
        soldBooks = book.bookSales.size
    )
}
