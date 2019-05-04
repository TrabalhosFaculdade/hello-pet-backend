package br.mackenzie.hellopet.database.model.petowning

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated

@Entity
class Dog : Pet() {

    @Enumerated(EnumType.STRING)
    @Column(nullable = true)
    var size: Size? = null

    @Column(nullable = true)
    var fur: String? = null /*Should this be something else? */

    @Column(nullable = true)
    var color: String? = null /*Should this be something else? */
}

enum class Size {
    BIG, MEDIUM, SMALL
}