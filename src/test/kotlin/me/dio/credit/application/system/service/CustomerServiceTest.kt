package me.dio.credit.application.system.service

import io.mockk.every
import io.mockk.impl.annotations.InjectMockKs
import io.mockk.impl.annotations.MockK
import io.mockk.junit5.MockKExtension
import io.mockk.verify
import me.dio.credit.application.system.entity.Address
import me.dio.credit.application.system.entity.Customer
import me.dio.credit.application.system.repository.CreditRepository
import me.dio.credit.application.system.repository.CustomerRepository
import me.dio.credit.application.system.service.impl.CustomerService
import net.bytebuddy.dynamic.loading.ByteArrayClassLoader.ChildFirst
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.test.context.ActiveProfiles
import java.math.BigDecimal

@ActiveProfiles("test")
@ExtendWith(MockKExtension::class)
class CustomerServiceTest {
    @MockK
    lateinit var customerRepository: CustomerRepository
    @InjectMockKs
    lateinit var customerService: CustomerService

    @Test
    fun shouldCreateCustomer () {
        // given
        val fakeCustomer: Customer = buildCustomer()
        every {
            customerService.save(any())
        } returns fakeCustomer
        // when
        val actual: Customer = customerService.save(fakeCustomer)
        // then
        Assertions.assertThat(actual).isNotNull
        Assertions.assertThat(actual).isSameAs(fakeCustomer)
        verify(exactly = 1) { customerService.save(fakeCustomer) }
    }

    private fun buildCustomer(
        firstName: String = "Marco",
        lastName: String = "Molinaro",
        cpf: String = "72068420031",
        email: String = "marco@gmail.com",
        password: String = "2342",
        zipCode: String = "23434550",
        street: String = "Rua Marco",
        income: BigDecimal = BigDecimal.valueOf(1000.0),
        id: Long = 1L
    ) = Customer (
        firstName = firstName,
        lastName = lastName,
        cpf = cpf,
        email = email,
        password = password,
        income = income,
        id = id,
        address = Address(
            zipCode = zipCode,
            street = street,
        )
    )
}