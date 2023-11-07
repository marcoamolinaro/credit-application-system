package me.dio.credit.application.system.dto

import jakarta.validation.constraints.Email
import jakarta.validation.constraints.NotEmpty
import jakarta.validation.constraints.NotNull
import me.dio.credit.application.system.entity.Address
import me.dio.credit.application.system.entity.Customer
import org.hibernate.validator.constraints.br.CPF
import java.math.BigDecimal

data class CustomerDto(
    @field:NotEmpty(message = "Invalid Input")
    val firstName: String,

    @field:NotEmpty(message = "Invalid Input")
    val lastName: String,

    @field:NotEmpty(message = "Invalid Input")
    @field:CPF(message = "This is a Invalid CPF")
    val cpf: String,

    @field:NotEmpty(message = "Invalid Input")
    @field:Email(message = "Invalid Email")
    val email: String,

    @field:NotNull(message = "Invalid Input")
    val income: BigDecimal,

    @field:NotEmpty(message = "Invalid Input")
    val password: String,

    @field:NotEmpty(message = "Invalid Input")
    val zipCode: String,

    @field:NotEmpty(message = "Invalid Input")
    val street: String
) {
    fun toEntity(): Customer = Customer(
        firstName = this.firstName,
        lastName = this.lastName,
        cpf = this.cpf,
        email = this.email,
        income = this.income,
        password = this.password,
        address = Address(
            zipCode = this.zipCode,
            street = this.street
        )
    )
}
