package br.mackenzie.hellopet.database.model.commons

import javax.persistence.Column
import javax.persistence.Entity

@Entity
class Phone (

        @Column(nullable = false)
        val phoneNumber:String? = null,

        @Column(nullable = false)
        val validated:Boolean? = null

) : DatabaseEntity<Long>()