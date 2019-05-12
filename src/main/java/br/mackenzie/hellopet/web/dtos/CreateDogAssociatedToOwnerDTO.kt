package br.mackenzie.hellopet.web.dtos

import io.swagger.annotations.ApiModel
import javax.validation.Valid
import javax.validation.constraints.NotNull

@ApiModel("CreationDog")
data class CreateDogAssociatedToOwnerDTO(

        @NotNull
        val ownerId: Long,

        @Valid
        val animal: DogDTO
)