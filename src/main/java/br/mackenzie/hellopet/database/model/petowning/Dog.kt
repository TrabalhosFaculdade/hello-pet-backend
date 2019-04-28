package br.mackenzie.hellopet.database.model.petowning

import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Entity
class Dog (

        name:String,
        birth:LocalDateTime,
        weight: Float,
        owner: PetOwner,
        species: Species,
        gender:Gender,

        @Enumerated(EnumType.STRING)
        @Column(nullable = true)
        val size: Size,

        @Column(nullable = true)
        val fur:String, /*Should this be something else? */

        @Column(nullable = true)
        val color: String /*Should this be something else? */

): Pet(name, birth, weight, owner, species, gender)

enum class Size {
    BIG, MEDIUM, SMALL
}