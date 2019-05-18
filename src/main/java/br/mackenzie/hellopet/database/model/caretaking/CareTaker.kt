package br.mackenzie.hellopet.database.model.caretaking

import br.mackenzie.hellopet.database.model.auth.User
import br.mackenzie.hellopet.database.model.commons.Address
import br.mackenzie.hellopet.database.model.commons.DatabaseEntity
import br.mackenzie.hellopet.database.model.commons.Phone
import java.time.LocalDate
import javax.persistence.*

@Entity
class CareTaker : DatabaseEntity<Long> {

    @Column(nullable = false)
    var name: String? = null

    @Column(unique = true, nullable = false)
    var cpf: String? = null

    @Column(nullable = false)
    var dateBirth: LocalDate? = null

    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, orphanRemoval = true)
    var address: Address? = null

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, orphanRemoval = true)
    var phoneNumbers: List<Phone> = mutableListOf()

    @OneToOne(optional = false, cascade = [CascadeType.ALL], orphanRemoval = true)
    var user: User? = null

    constructor() {
        //empty
    }

    constructor(name: String, cpf: String, dateBirth: LocalDate, address: Address, phone: Phone, user: User) {
        this.name = name
        this.cpf = cpf
        this.dateBirth = dateBirth
        this.address = address
        this.phoneNumbers = listOf(phone)
        this.user = user
    }

}