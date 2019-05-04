package br.mackenzie.hellopet.database.model.petowning

import br.mackenzie.hellopet.database.model.commons.DatabaseEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity
class Species : DatabaseEntity<Long> {

    @Column(nullable = false, unique = true)
    var name: String? = null

    constructor() {
        //empty constructor
    }

    constructor(name: String) {
        this.name = name
    }

}