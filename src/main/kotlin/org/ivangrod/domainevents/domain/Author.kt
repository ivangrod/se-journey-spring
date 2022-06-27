package org.ivangrod.domainevents.domain

import javax.persistence.*

@Entity
@Table
class Author(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,
    var email: String? = null
)
