package org.ivangrod.domainevents.service

import org.springframework.stereotype.Service
import javax.transaction.Transactional

@Service
class EmailServiceImpl : EmailService {

    @Transactional(Transactional.TxType.REQUIRES_NEW)
    override fun send(email: String, message: String) {
        TODO("Not yet implemented")
    }
}
