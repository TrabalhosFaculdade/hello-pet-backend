package br.mackenzie.hellopet.database.model.commons

import javax.persistence.Column
import javax.persistence.Entity

@Entity
class Phone (

        @Column(nullable = false)
        val phoneNumber:String,

        @Column(nullable = false)
        val validated:Boolean

) : DatabaseEntity<Long>()