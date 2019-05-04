package br.mackenzie.hellopet.database.repositories

import br.mackenzie.hellopet.database.model.petowning.Species
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface SpeciesRepository : JpaRepository<Species, Long> {

    fun findByName(name: String): Optional<Species>
    fun existsByName(name: String) : Boolean

}