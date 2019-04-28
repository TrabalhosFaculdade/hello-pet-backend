package br.mackenzie.hellopet.database.model.auth

import br.mackenzie.hellopet.database.model.commons.DatabaseEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity
class User (

        @Column(nullable = false)
        val email:String,

        @Column(nullable = false)
        val password:String

) : DatabaseEntity<Long>()