package br.mackenzie.hellopet.services.impl

import br.mackenzie.hellopet.database.model.petowning.PetOwner
import br.mackenzie.hellopet.database.repositories.PetOwnerRepository
import br.mackenzie.hellopet.services.api.PetOwnerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class PetOwnerServiceImpl

    @Autowired constructor(private val petOwnerRepository: PetOwnerRepository) : PetOwnerService {

    override fun create(newOwner: PetOwner): PetOwner {

        Objects.requireNonNull(newOwner, "Cannot create a null PetOwner")
        Objects.requireNonNull(newOwner.user, "Cannot create PetOwner without a user")

        return petOwnerRepository.saveAndFlush(newOwner)
    }

    override fun list(): List<PetOwner> = petOwnerRepository.findAll()
    override fun findOne(id: Long): Optional<PetOwner> = petOwnerRepository.findById(id)
    
}