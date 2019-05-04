package br.mackenzie.hellopet.web.dtos

import javax.validation.Valid
import javax.validation.constraints.NotNull

data class CreateDogAssociatedToOwnerDTO(

        @NotNull
        val ownerId: Long,

        @Valid
        val animal: DogDTO
)