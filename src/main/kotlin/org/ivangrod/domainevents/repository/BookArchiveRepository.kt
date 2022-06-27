package org.ivangrod.domainevents.repository

import org.ivangrod.domainevents.domain.BookArchive
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookArchiveRepository:  JpaRepository<BookArchive, Long>
