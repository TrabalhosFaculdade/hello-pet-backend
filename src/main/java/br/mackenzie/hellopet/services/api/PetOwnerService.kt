package br.mackenzie.hellopet.services.api

import br.mackenzie.hellopet.database.model.petowning.PetOwner
import java.util.*

interface PetOwnerService {

    fun create(newOwner: PetOwner): PetOwner
    fun list(): List<PetOwner>
    fun findOne(id: Long): Optional<PetOwner>

}