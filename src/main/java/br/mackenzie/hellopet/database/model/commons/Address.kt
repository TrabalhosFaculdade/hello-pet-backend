package br.mackenzie.hellopet.database.model.commons

import javax.persistence.Column
import javax.persistence.Entity

@Entity
class Address : DatabaseEntity<Long> {

    @Column(nullable = false)
    var street: String? = null

    @Column(nullable = false)
    var number: String? = null

    @Column(nullable = false)
    var zipCode: String? = null

    @Column(nullable = false)
    var city: String? = null

    @Column(nullable = true)
    var complement: String? = null

    constructor() {
        //empty constructor
    }

    constructor(street: String?, number: String?, zipCode: String?, city: String?, complement: String?) : super() {
        this.street = street
        this.number = number
        this.zipCode = zipCode
        this.city = city
        this.complement = complement
    }

}