package br.mackenzie.hellopet.database.model.petowning

import br.mackenzie.hellopet.database.model.commons.DatabaseEntity
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Pet (

        @Column(nullable = false)
        val name:String? = null,

        @Column(nullable = true)
        val birth:LocalDateTime? = null,

        @Column(nullable = true)
        val weight:Float? = null,

        @ManyToOne(optional = false)
        val owner: PetOwner? = null,

        @ManyToOne
        val species: Species? = null,

        @Enumerated(EnumType.STRING)
        val gender: Gender? = null

): DatabaseEntity<Long>()

enum class Gender {
    MALE, FEMALE, UNDEFINED
}