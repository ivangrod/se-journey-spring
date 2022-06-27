package org.ivangrod.domainevents.domain

import java.time.OffsetDateTime
import javax.persistence.*

@Entity
@Table
class BookSale(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var priceSold: Int? = null,
    var dateSold: OffsetDateTime? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    var book: Book? = null
)

