package br.mackenzie.hellopet.web.controllers.petowning

import br.mackenzie.hellopet.database.model.petowning.PetOwner
import br.mackenzie.hellopet.database.repositories.PetOwnerRepository
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/pet-owner")
class PetOwnerController @Autowired constructor(private val petOwnerRepository: PetOwnerRepository) {

    @GetMapping
    fun getAll (): MutableList<PetOwner> = petOwnerRepository.findAll()

    @GetMapping("/{id}")
    fun getById (@PathVariable id: Long) : ResponseEntity<PetOwner> {

        return petOwnerRepository.findById(id).map {
            ResponseEntity.ok(it)
        }.orElse(ResponseEntity.notFound().build())
    }

}