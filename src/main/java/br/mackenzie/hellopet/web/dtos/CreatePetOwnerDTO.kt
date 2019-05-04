package br.mackenzie.hellopet.web.dtos

import br.mackenzie.hellopet.database.model.auth.User
import br.mackenzie.hellopet.database.model.commons.Phone
import br.mackenzie.hellopet.database.model.petowning.PetOwner
import java.time.LocalDateTime
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CreatePetOwnerDTO(

        @NotNull @NotBlank
        val name: String,

        @NotNull @NotBlank
        val cpf: String,

        @NotNull
        val birthDate: LocalDateTime,

        @NotNull @Valid
        val address: AddressDTO,

        @NotNull @NotBlank @Email
        val email: String,

        @NotNull @NotBlank
        val password: String,

        @NotNull @NotBlank
        val initialPhoneNumber: String
) {
    fun createPetOwner(): PetOwner {

        val phone = Phone(initialPhoneNumber, false)
        val user = User(email, password)
        val address = this.address.createAddress()
        return PetOwner(name, cpf, birthDate, address, phone, user)
    }
}