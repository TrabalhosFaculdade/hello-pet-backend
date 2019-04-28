package br.mackenzie.hellopet.database.model.petowning

import br.mackenzie.hellopet.database.model.auth.User
import br.mackenzie.hellopet.database.model.commons.Address
import br.mackenzie.hellopet.database.model.commons.DatabaseEntity
import br.mackenzie.hellopet.database.model.commons.Phone
import java.time.LocalDateTime
import javax.persistence.*

@Entity
class PetOwner (

        @Column(nullable = false)
        val name: String? = null,

        @Column(unique = true, nullable = false)
        private val cpf: String? = null,

        @Column(nullable = false)
        val dataBirth: LocalDateTime? = null,

        @OneToOne(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, orphanRemoval = true)
        val address: Address? = null,

        @OneToMany(cascade = [CascadeType.ALL], fetch = FetchType.EAGER, orphanRemoval = true)
        val phoneNumbers:MutableList<Phone> = mutableListOf(),

        @OneToOne(optional = false, cascade = [CascadeType.ALL], orphanRemoval = true)
        val user: User? = null,

        @OneToMany
        val pets:MutableList<Pet> = mutableListOf()

) : DatabaseEntity<Long>()