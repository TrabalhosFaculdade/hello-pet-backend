package br.mackenzie.hellopet.web.controllers.petowning

import br.mackenzie.hellopet.services.api.PetOwnerService
import br.mackenzie.hellopet.web.dtos.CreatePetOwnerDTO
import br.mackenzie.hellopet.web.dtos.RetrievingPetOwnerDTO
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/pet-owner")
@Api(value = "Pet Owner Endpoints")
class PetOwnerController @Autowired constructor(private val petOwnerService: PetOwnerService) {

    @ApiOperation(value = "Register a new pet owner with informed values", notes = "Date format: yyyy-MM-dd")
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "Pet owner registered, no problem occurred"),
        ApiResponse(code = 500, message = "Errors related to constraints on fields values, like duplicated cpf or email")
    ])
    @PostMapping
    fun create(@RequestBody @Valid owner: CreatePetOwnerDTO): ResponseEntity<Any> {
        petOwnerService.create(owner.createPetOwner())
        return ResponseEntity.ok().build()
    }

    @ApiOperation(value = "List all pet owner registered",
            response = RetrievingPetOwnerDTO::class,
            responseContainer = "List",
            notes = "Date format: yyyy-MM-dd")
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "Pet owners returned, no problem occurred"),
        ApiResponse(code = 500, message = "Unexpected internal server error, contact developers")
    ])
    @GetMapping
    fun getAll(): ResponseEntity<List<RetrievingPetOwnerDTO>> {
        return ResponseEntity.ok(petOwnerService.list().map { RetrievingPetOwnerDTO(it) })
    }

    @ApiOperation(value = "Return information about pet owner with informed id, if existing")
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "Pet owners successfully retrieved, no problem occurred",
                    response = RetrievingPetOwnerDTO::class,
                    responseContainer = "List"),
        ApiResponse(code = 404, message = "Could not find pet owner with informed id"),
        ApiResponse(code = 500, message = "Unexpected internal server error, contact developers")
    ])
    @GetMapping("/{id}")
    fun getOne(@PathVariable id: Long): ResponseEntity<Any> {

        val petOwner = petOwnerService.findOne(id)
        return if (petOwner.isPresent) {
            ResponseEntity.ok(RetrievingPetOwnerDTO(petOwner.get()))
        } else {
            ResponseEntity.notFound().build()
        }
    }
}