package br.mackenzie.hellopet.web.controllers.petowning

import br.mackenzie.hellopet.database.model.petowning.Dog
import br.mackenzie.hellopet.database.model.petowning.Gender
import br.mackenzie.hellopet.database.model.petowning.Size
import br.mackenzie.hellopet.database.model.utils.ConvertibleEnum
import br.mackenzie.hellopet.services.api.PetOwnerService
import br.mackenzie.hellopet.web.dtos.CreateDogAssociatedToOwnerDTO
import br.mackenzie.hellopet.web.dtos.DogDTO
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import java.beans.PropertyEditorSupport

@RestController
@RequestMapping("/pet")
@Api(value = "Pet Endpoints")
class PetController @Autowired constructor(private val petOwnerService: PetOwnerService){

    @ApiOperation(value = "Creates a dog and associate it to a pet owner with informed id",
            notes = "If the informed species is not already registered on " +
                    "database, a new one will be registered")
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "Pet registered and associated to pet owner, no problem occurred"),
        ApiResponse(code = 404, message = "Could not find pet owner with informed id to associated pet to"),
        ApiResponse(code = 500, message = "Unexpected internal server error, contact developers")
    ])
    @PostMapping
    fun create(@RequestBody dog: CreateDogAssociatedToOwnerDTO): ResponseEntity<Any> {

        val petOwner = petOwnerService.findOne(dog.ownerId)
        if (petOwner.isEmpty) {
            return ResponseEntity.notFound().build()
        }

        petOwnerService.addPetToOwner(petOwner.get(), dog.animal.convertEntity())
        return ResponseEntity.ok().build()
    }

    @ApiOperation(value = "Return list of pets associated to pet owner with informed id")
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "Pets successfully retrieved, no problem occurred",
                    response = DogDTO::class, responseContainer = "List"),
        ApiResponse(code = 404, message = "Could not find pet owner with informed id"),
        ApiResponse(code = 500, message = "Unexpected internal server error, contact developers")
    ])
    @GetMapping("/owner/{id}")
    fun getPetsFromOwner(@PathVariable id: Long): ResponseEntity<Any> {
        return try {
            val ownerDogs = petOwnerService.listPets(id, Dog::class.java)
            ResponseEntity.ok(ownerDogs.map { DogDTO(it) })

        } catch (e: IllegalArgumentException) {
            ResponseEntity(hashMapOf("message" to e.message),
                           HttpStatus.NOT_FOUND)
        }
    }

    @InitBinder
    fun sizeBinder(webDataBinder: WebDataBinder) {
        webDataBinder.registerCustomEditor(Size::class.java, SizeConverter())
    }

    @InitBinder
    fun genderBinder(webDataBinder: WebDataBinder) {
        webDataBinder.registerCustomEditor(Gender::class.java, GenderConvert())
    }
}

class SizeConverter : PropertyEditorSupport() {
    @Throws(IllegalArgumentException::class)
    override fun setAsText(text: String) {
        value = ConvertibleEnum.fromValue(Size::class.java, text)
    }
}

class GenderConvert : PropertyEditorSupport() {
    @Throws(IllegalArgumentException::class)
    override fun setAsText(text: String) {
        value = ConvertibleEnum.fromValue(Gender::class.java, text)
    }
}