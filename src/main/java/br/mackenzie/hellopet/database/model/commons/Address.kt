package br.mackenzie.hellopet.database.model.commons

import javax.persistence.Column
import javax.persistence.Entity

@Entity
class Address (

        @Column(nullable = false)
        val street:String,

        @Column(nullable = false)
        var number:String,

        @Column(nullable = false)
        val zipCode:String,

        @Column(nullable = false)
        val city:String,

        @Column(nullable = true)
        val complement:String

) : DatabaseEntity<Long>()