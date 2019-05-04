package br.mackenzie.hellopet.database.model.commons

import java.io.Serializable
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class DatabaseEntity<T : Serializable> {

    @Id
    @GeneratedValue
    var id: T? = null

    constructor() {
        //empty
    }

    constructor(id: T) {
        this.id = id
    }
}

