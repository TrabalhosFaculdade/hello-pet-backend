package br.mackenzie.hellopet.web.controllers.petowning

import br.mackenzie.hellopet.services.api.PetOwnerService
import br.mackenzie.hellopet.web.dtos.CreatePetOwnerDTO
import br.mackenzie.hellopet.web.dtos.RetrievingPetOwnerDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/pet-owner")
class PetOwnerController @Autowired constructor(private val petOwnerService: PetOwnerService) {

    @PostMapping
    fun create(@RequestBody @Valid owner: CreatePetOwnerDTO): ResponseEntity<Any> {
        petOwnerService.create(owner.createPetOwner())
        return ResponseEntity.ok().build()
    }

    @GetMapping
    fun list(): ResponseEntity<List<RetrievingPetOwnerDTO>> {
        return ResponseEntity.ok(petOwnerService.list().map { RetrievingPetOwnerDTO(it) })
    }
}