package me.dio.credit.application.system.entity

data class Customer (
    val id: Long? = null,
    var firstName: String = "",
    var lastName: String = "",
    val cpf: String,
    var email: String = "",
    var password: String = "",
    var address: Address = Address(),
    var credit: List<Credit> = mutableListOf()
)