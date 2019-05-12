package br.mackenzie.hellopet.database.model.petowning

import br.mackenzie.hellopet.database.model.commons.DatabaseEntity
import br.mackenzie.hellopet.database.model.utils.ConvertibleEnum
import java.time.LocalDate
import javax.persistence.*

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class Pet : DatabaseEntity<Long>() {

    @Column(nullable = false)
    var name: String? = null

    @Column(nullable = true)
    var birth: LocalDate? = null

    @Column(nullable = true)
    var weight: Float? = null

    @ManyToOne(optional = false)
    var owner: PetOwner? = null

    @ManyToOne
    var species: Species? = null

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    var gender: Gender? = null
}

enum class Gender(private val stringValue: String) : ConvertibleEnum<Gender, String> {

    MALE("MALE"),
    FEMALE("FEMALE"),
    UNDEFINED("UNDEFINED");

    override fun getValue(): String {
        return stringValue
    }
}