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
        val name: String,

        @Column(unique = true, nullable = false)
        private val cpf: String,

        @Column(nullable = false)
        val dataBirth: LocalDateTime,

        @OneToOne
        val address: Address,

        @OneToMany
        val phoneNumbers:List<Phone>,

        @OneToOne(optional = false)
        val user: User,

        @OneToMany
        val pets:List<Pet>

) : DatabaseEntity<Long>()