package br.mackenzie.hellopet.services.impl

import br.mackenzie.hellopet.database.model.petowning.Dog
import br.mackenzie.hellopet.database.model.petowning.Pet
import br.mackenzie.hellopet.database.model.petowning.PetOwner
import br.mackenzie.hellopet.database.repositories.PetOwnerRepository
import br.mackenzie.hellopet.database.repositories.PetRepository
import br.mackenzie.hellopet.services.api.PetOwnerService
import br.mackenzie.hellopet.services.api.SpeciesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException
import java.lang.IllegalArgumentException
import java.util.*

@Service
class PetOwnerServiceImpl
@Autowired constructor(private val petOwnerRepository: PetOwnerRepository,
                       private val petRepository: PetRepository,
                       private val speciesService: SpeciesService) : PetOwnerService {

    override fun exists(petOwnerId: Long): Boolean {
       return petOwnerRepository.existsById(petOwnerId)
    }

    override fun create(newOwner: PetOwner): PetOwner {
        return petOwnerRepository.saveAndFlush(newOwner)
    }

    override fun list(): List<PetOwner> = petOwnerRepository.findAll()

    override fun findOne(id: Long): Optional<PetOwner> = petOwnerRepository.findById(id)

    override fun addPetToOwner(owner: PetOwner, pet: Pet): PetOwner {

        //saving species if not existing before continuing
        val species = speciesService.getForUse(pet.species!!)
        pet.species = species

        owner.addPet(pet)

        petRepository.saveAndFlush(pet)
        return petOwnerRepository.saveAndFlush(owner)
    }

    override fun <T : Pet> listPets(petOwnerId: Long, type: Class<T>): List<T> {

        val owner = findOne(petOwnerId)
        if (owner.isEmpty) {
            throw IllegalArgumentException("Could not find owner with informed id")
        }

        return owner.get().pets.filterIsInstance(type)
    }

    override fun listPets(petOwnerId: Long): List<Pet> {

        val owner = findOne(petOwnerId)
        if (owner.isEmpty) {
            throw IllegalArgumentException("Could not find owner with informed id")
        }

        return owner.get().pets
    }

}