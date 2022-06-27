package org.ivangrod.domainevents.service

import javax.transaction.Transactional

interface BookSaleService {

    @Transactional
    fun sellBook(bookId: Long)
}
