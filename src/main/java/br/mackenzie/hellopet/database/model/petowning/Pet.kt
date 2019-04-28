package br.mackenzie.hellopet.database.model.petowning

import br.mackenzie.hellopet.database.model.commons.DatabaseEntity
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Pet (

        @Column(nullable = false)
        val name:String,

        @Column(nullable = true)
        val birth:LocalDateTime,

        @Column(nullable = true)
        val weight:Float,

        @ManyToOne(optional = false)
        val owner: PetOwner,

        @ManyToOne
        val species: Species,

        @Enumerated(EnumType.STRING)
        val gender: Gender

): DatabaseEntity<Long>()

enum class Gender {
    MALE, FEMALE, UNDEFINED
}