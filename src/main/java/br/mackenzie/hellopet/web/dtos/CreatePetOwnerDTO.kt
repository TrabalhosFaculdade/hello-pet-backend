package br.mackenzie.hellopet.web.dtos

import br.mackenzie.hellopet.database.model.auth.User
import br.mackenzie.hellopet.database.model.commons.Phone
import br.mackenzie.hellopet.database.model.petowning.PetOwner
import com.fasterxml.jackson.annotation.JsonFormat
import io.swagger.annotations.ApiModel
import org.springframework.format.annotation.DateTimeFormat
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@ApiModel("CreationPetOwner")
data class CreatePetOwnerDTO(

        @NotNull @NotBlank
        val name: String,

        @NotNull @NotBlank
        val cpf: String,

        @NotNull
//        @JsonFormat(pattern = "dd/MM/yyyy")
//        @DateTimeFormat(pattern = "dd/MM/yyyy")
        val birthDate: LocalDate,

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