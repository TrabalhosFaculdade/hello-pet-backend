package br.mackenzie.hellopet.database.model.petowning

import br.mackenzie.hellopet.database.model.commons.DatabaseEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity
class Species (

        @Column(nullable = false)
        val name:String? = null

): DatabaseEntity<Long>()