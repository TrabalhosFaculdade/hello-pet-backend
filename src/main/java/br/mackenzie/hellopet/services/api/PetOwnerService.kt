package br.mackenzie.hellopet.services.api

import br.mackenzie.hellopet.database.model.petowning.Pet
import br.mackenzie.hellopet.database.model.petowning.PetOwner
import java.util.*

interface PetOwnerService {

    fun exists (petOwnerId: Long): Boolean
    fun create(newOwner: PetOwner): PetOwner
    fun list(): List<PetOwner>
    fun findOne(id: Long): Optional<PetOwner>
    fun addPetToOwner (owner: PetOwner, pet: Pet): PetOwner
    fun listPets (petOwnerId: Long) : List<Pet>
    fun <T:Pet> listPets (petOwnerId: Long, type: Class<T>): List<T>

}