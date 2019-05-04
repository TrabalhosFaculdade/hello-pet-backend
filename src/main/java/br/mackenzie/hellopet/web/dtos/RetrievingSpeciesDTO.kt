package br.mackenzie.hellopet.web.dtos

import br.mackenzie.hellopet.database.model.petowning.Species

data class RetrievingSpeciesDTO (val id:Long, val name:String) {

    constructor(species:Species): this(species.id!!, species.name!!)

}