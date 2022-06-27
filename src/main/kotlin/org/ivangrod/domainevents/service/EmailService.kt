package org.ivangrod.domainevents.service

interface EmailService {
    fun send(email: String, message: String)
}
