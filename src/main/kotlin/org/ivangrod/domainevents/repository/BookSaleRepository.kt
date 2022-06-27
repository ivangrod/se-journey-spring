package org.ivangrod.domainevents.repository

import org.ivangrod.domainevents.domain.BookSale
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface BookSaleRepository:  JpaRepository<BookSale, Long>
