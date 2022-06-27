package org.ivangrod.domainevents.repository

import org.ivangrod.domainevents.domain.Book
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookRepository:  JpaRepository<Book, Long>
