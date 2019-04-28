package br.mackenzie.hellopet.database.model.commons

import javax.persistence.Column
import javax.persistence.Entity

@Entity
class Address (

        @Column(nullable = false)
        val street:String? = null,

        @Column(nullable = false)
        var number:String? = null,

        @Column(nullable = false)
        val zipCode:String? = null,

        @Column(nullable = false)
        val city:String? = null,

        @Column(nullable = true)
        val complement:String? = null

) : DatabaseEntity<Long>()