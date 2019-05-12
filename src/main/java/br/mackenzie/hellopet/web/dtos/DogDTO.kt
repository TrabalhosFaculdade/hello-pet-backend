package br.mackenzie.hellopet.web.dtos

import br.mackenzie.hellopet.database.model.petowning.Dog
import br.mackenzie.hellopet.database.model.petowning.Gender
import br.mackenzie.hellopet.database.model.petowning.Size
import br.mackenzie.hellopet.database.model.petowning.Species
import io.swagger.annotations.ApiModel
import java.time.LocalDate
import javax.validation.constraints.NotEmpty
import javax.validation.constraints.NotNull

@ApiModel("Dog")
data class DogDTO(

        @NotNull @NotEmpty
        val name: String,

        @NotNull @NotEmpty
        val species: String,

        val fur: String?,
        val color: String?,
        val birth: LocalDate?,
        val weight: Float?,
        val gender: Gender?,
        val size: Size?
) {
    constructor(dog: Dog) : this(dog.name!!, dog.species!!.name!!,
                                 dog.fur, dog.color, dog.birth,
                                 dog.weight, dog.gender, dog.size)

    fun convertEntity () : Dog {

        var dog = Dog()

        dog.color = color
        dog.fur = fur
        dog.size = size
        dog.birth = birth
        dog.weight = weight
        dog.species = Species(species)
        dog.gender = gender
        dog.name = name

        return dog
    }
}