package org.ivangrod.domainevents.service

import javax.transaction.Transactional

interface BookUpdateService {

    @Transactional
    fun updateBook(bookId: Long, name: String, description: String)
}
