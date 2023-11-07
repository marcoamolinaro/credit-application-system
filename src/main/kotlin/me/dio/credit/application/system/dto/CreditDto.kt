package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Future
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Credit
import me.dio.credit.application.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

data class CreditDto(
    @field:NotNull(message = "Invalid Input")
    val creditValue: BigDecimal,

    @field:Future(message = "Invalid input")
    val dayFirstOfInstallment: LocalDate,

    @field:NotNull(message = "Invalid Input")
    val numberOfInstalments: Int,

    @field:NotNull(message = "Invalid Input")
    val customerId: Long
) {

    fun toEntity(): Credit = Credit(
        creditValue = this.creditValue,
        dayFirstInstallment = this.dayFirstOfInstallment,
        numberOfInstallments = this.numberOfInstalments,
        customer = Customer(id = this.customerId)
    )
}

