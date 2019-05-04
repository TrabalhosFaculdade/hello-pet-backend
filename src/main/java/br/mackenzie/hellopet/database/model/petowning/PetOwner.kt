package br.mackenzie.hellopet.database.model.petowning

import br.mackenzie.hellopet.database.model.auth.User
import br.mackenzie.hellopet.database.model.commons.Address
import br.mackenzie.hellopet.database.model.commons.DatabaseEntity
import br.mackenzie.hellopet.database.model.commons.Phone
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class PetOwner : DatabaseEntity<Long> {

    @Column(nullable = false)
    var name: String? = null

    @Column(unique = true, nullable = false)
    var cpf: String? = null

    @Column(nullable = false)
    var dateBirth: LocalDateTime? = null

    @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, orphanRemoval = true)
    var address: Address? = null

    @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, orphanRemoval = true)
    var phoneNumbers: List<Phone> = mutableListOf()

    @OneToOne(optional = false, cascade = [CascadeType.ALL], orphanRemoval = true)
    var user: User? = null

    @OneToMany
    var pets: MutableList<Pet> = mutableListOf()

    constructor() {
        //empty
    }

    constructor(name:String, cpf:String, dateBirth: LocalDateTime, address: Address, phone:Phone, user: User) {
        this.name = name
        this.cpf = cpf
        this.dateBirth = dateBirth
        this.address = address
        this.phoneNumbers = listOf(phone)
        this.user = user
    }

    fun addPet (pet: Pet) {
        pets.add(pet)
        pet.owner = this
    }
}