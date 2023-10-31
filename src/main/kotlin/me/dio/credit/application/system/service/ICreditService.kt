package me.dio.credit.application.system.service

import me.dio.credit.application.system.entity.Credit
import org.springframework.data.jpa.repository.Query
import java.util.*

interface ICreditService {
    fun save(credit: Credit): Credit

    @Query(value = "select * from credit where credit_id = ?1", nativeQuery = true)
    fun findAllByCustomerId(customerId: Long): List<Credit>

    fun findByCreditCode(customerId: Long, creditCode: UUID): Credit?
}