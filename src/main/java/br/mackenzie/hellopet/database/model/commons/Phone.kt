package br.mackenzie.hellopet.database.model.commons

import javax.persistence.Column
import javax.persistence.Entity

@Entity
class Phone : DatabaseEntity<Long> {

    @Column(nullable = false)
    var phoneNumber: String? = null

    @Column(nullable = false)
    var validated: Boolean? = null

    constructor() {
        //empty
    }

    constructor(phoneNumber: String, validated: Boolean) {
        this.phoneNumber = phoneNumber
        this.validated = validated
    }

}