package br.mackenzie.hellopet.database.model.commons

import java.io.Serializable
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.MappedSuperclass

@MappedSuperclass
abstract class DatabaseEntity <T:Serializable> {

        @Id @GeneratedValue
        private var id : T? = null

}

