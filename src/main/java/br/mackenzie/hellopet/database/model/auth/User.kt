package br.mackenzie.hellopet.database.model.auth

import br.mackenzie.hellopet.database.model.commons.DatabaseEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity
class User : DatabaseEntity<Long> {

    @Column(nullable = false)
    var email: String? = null

    @Column(nullable = false)
    var password: String? = null

    constructor() {
        //empty
    }

    constructor(email: String, password: String) {
        this.email = email
        this.password = password
    }
}