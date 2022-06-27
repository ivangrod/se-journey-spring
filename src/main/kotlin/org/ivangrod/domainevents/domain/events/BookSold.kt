package org.ivangrod.domainevents.domain.events

import org.ivangrod.domainevents.domain.Book
import org.ivangrod.domainevents.domain.BookSale
import java.time.OffsetDateTime

class BookSold(book: Book) {
    val bookSale = BookSale(
        book = book,
        dateSold = OffsetDateTime.now(),
        priceSold = book.price
    )
    val totalSoldBooksCount by lazy { book.bookSales.count() }
    val authorEmail by lazy { book.author?.email }
}
