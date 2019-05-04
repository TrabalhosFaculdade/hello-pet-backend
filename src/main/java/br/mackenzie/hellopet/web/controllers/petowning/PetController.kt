package br.mackenzie.hellopet.web.controllers.petowning

import br.mackenzie.hellopet.database.model.petowning.Dog
import br.mackenzie.hellopet.database.model.petowning.Gender
import br.mackenzie.hellopet.database.model.petowning.Size
import br.mackenzie.hellopet.database.model.utils.ConvertibleEnum
import br.mackenzie.hellopet.services.api.PetOwnerService
import br.mackenzie.hellopet.web.dtos.CreateDogAssociatedToOwnerDTO
import br.mackenzie.hellopet.web.dtos.DogDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.WebDataBinder
import org.springframework.web.bind.annotation.*
import java.beans.PropertyEditorSupport

@RestController
@RequestMapping("/pet")
class PetController @Autowired constructor(private val petOwnerService: PetOwnerService){

    @PostMapping
    fun create(@RequestBody dog: CreateDogAssociatedToOwnerDTO): ResponseEntity<Any> {

        val petOwner = petOwnerService.findOne(dog.ownerId)
        if (petOwner.isEmpty) {
            return ResponseEntity.notFound().build()
        }

        petOwnerService.addPetToOwner(petOwner.get(), dog.animal.convertEntity())
        return ResponseEntity.ok().build()
    }

    @GetMapping("/owner/{id}")
    fun getPetsFromOwner(@PathVariable id: Long): ResponseEntity<List<DogDTO>> {
        val ownerDogs = petOwnerService.listPets(id, Dog::class.java)
        return ResponseEntity.ok(ownerDogs.map { DogDTO(it) })
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