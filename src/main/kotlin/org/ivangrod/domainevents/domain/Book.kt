package org.ivangrod.domainevents.domain

import org.ivangrod.domainevents.domain.events.BookChangedInfo
import org.ivangrod.domainevents.domain.events.BookSold
import org.ivangrod.domainevents.domain.events.BookUpdated
import org.springframework.data.domain.AbstractAggregateRoot
import java.time.OffsetDateTime
import javax.persistence.*

@Entity
@Table
class Book(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var name: String? = null,
    var description: String? = null,
    var dateCreated: OffsetDateTime? = null,
    var lastDateUpdated: OffsetDateTime? = null,
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "author_id")
    var author: Author? = null,
    var price: Int? = null,
    @OneToMany(fetch = FetchType.LAZY, mappedBy = "book", cascade = [CascadeType.ALL])
    var bookSales: MutableList<BookSale> = mutableListOf()
) : AbstractAggregateRoot<Book>() {
    public override fun <T : Any> registerEvent(event: T): T = super.registerEvent(event)
}

fun Book.sell() {
    registerEvent(BookUpdated(this))
    registerEvent(BookSold(this))
}

fun Book.changeInfo(name: String, description: String) {
    registerEvent(BookUpdated(this))
    this.name = name
    this.description = description
    lastDateUpdated = OffsetDateTime.now()
    registerEvent(BookChangedInfo(this))
}

