package me.dio.credit.application.system.entity

import jakarta.persistence.*
import java.math.BigDecimal

@Entity
data class Customer (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(nullable = false)
    var firstName: String = "",

    @Column(nullable = false)
    var lastName: String = "",

    @Column(nullable = false, unique = true)
    val cpf: String,

    @Column(nullable = false)
    val income: BigDecimal = BigDecimal.ZERO,

    @Column(nullable = false, unique = true)
    var email: String = "",

    @Column(nullable = false)
    var password: String = "",

    @Embedded
    @Column(nullable = false)
    var address: Address = Address(),

    @OneToMany(fetch = FetchType.LAZY,
        cascade = [CascadeType.REMOVE, CascadeType.PERSIST],
        mappedBy = "customer")
    @Column(nullable = false)
    var credit: List<Credit> = mutableListOf()
)