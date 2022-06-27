package org.ivangrod.domainevents.domain

import java.time.OffsetDateTime
import javax.persistence.*

@Entity
@Table
class BookArchive(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String? = null,
    var description: String? = null,
    var soldBooks: Int? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    var author: org.ivangrod.domainevents.domain.Author? = null,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "book_id")
    var book: Book? = null,
    var dateArchiveCreated: OffsetDateTime? = null,
    var lastDateVersionUpdated: OffsetDateTime? = null
)
