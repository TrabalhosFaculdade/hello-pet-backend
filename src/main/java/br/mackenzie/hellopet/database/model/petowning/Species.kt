package br.mackenzie.hellopet.database.model.petowning

import br.mackenzie.hellopet.database.model.commons.DatabaseEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity
class Species : DatabaseEntity<Long>() {

    @Column(nullable = false)
    var name: String? = null

}