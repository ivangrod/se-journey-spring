package org.ivangrod.domainevents.domain.events

import org.ivangrod.domainevents.domain.Book

class BookChangedInfo(book: Book) {
    val authorEmail by lazy { book.author?.email }
}
