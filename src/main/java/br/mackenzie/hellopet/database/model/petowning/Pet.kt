package br.mackenzie.hellopet.database.model.petowning

import br.mackenzie.hellopet.database.model.commons.DatabaseEntity
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Pet : DatabaseEntity<Long>() {

    @Column(nullable = false)
    var name: String? = null

    @Column(nullable = true)
    var birth: LocalDateTime? = null

    @Column(nullable = true)
    var weight: Float? = null

    @ManyToOne(optional = false)
    var owner: PetOwner? = null

    @ManyToOne
    var species: Species? = null

    @Enumerated(EnumType.STRING)
    var gender: Gender? = null
}

enum class Gender {
    MALE, FEMALE, UNDEFINED
}