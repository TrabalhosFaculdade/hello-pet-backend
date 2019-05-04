package br.mackenzie.hellopet.services.api

import br.mackenzie.hellopet.database.model.petowning.Species
import java.util.*

interface SpeciesService {

    fun create(newSpecies: Species): Species
    fun create (newSpeciesName: String) : Species
    fun list(): List<Species>
    fun findOne(id: Long): Optional<Species>
    fun findOne(name: String): Optional<Species>
    fun getForUse (name: String) : Species
    fun getForUse (species: Species) : Species

}