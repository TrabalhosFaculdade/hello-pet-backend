package br.mackenzie.hellopet.web.dtos

import br.mackenzie.hellopet.database.model.auth.User
import br.mackenzie.hellopet.database.model.commons.Address
import br.mackenzie.hellopet.database.model.commons.Phone
import br.mackenzie.hellopet.database.model.petowning.PetOwner
import org.springframework.lang.Nullable
import java.time.LocalDateTime
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class CreatePetOwnerDTO (

        @NotNull @NotBlank
        val name : String,

        @NotNull @NotBlank
        val cpf: String,

        @NotNull
        val birthDate: LocalDateTime,

        @Valid
        val address: AddressDTO,

        @NotNull @NotBlank @Email
        val email : String,

        @NotNull @NotBlank
        val password : String,

        @NotNull @NotBlank
        val initialPhoneNumber : String
)
{
        fun createPetOwner () : PetOwner {

                val phone = Phone(initialPhoneNumber, false)
                val user = User(email, password)
                return PetOwner(
                        name, cpf, birthDate,
                       address.createAddress(),
                       mutableListOf(phone), user, mutableListOf())
        }
}

data class AddressDTO (

        @NotNull @NotBlank
        val street : String,

        @NotNull @NotBlank
        val number : String,

        @NotNull @NotBlank
        val zipCode : String,

        @NotNull @NotBlank
        val city : String,

        @Nullable
        val complement : String
)
{
        fun createAddress () : Address {
                return Address(street, number, zipCode, city, complement);
        }
}