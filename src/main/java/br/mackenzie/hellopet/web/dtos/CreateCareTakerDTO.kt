package br.mackenzie.hellopet.web.dtos

import br.mackenzie.hellopet.database.model.auth.User
import br.mackenzie.hellopet.database.model.caretaking.CareTaker
import br.mackenzie.hellopet.database.model.commons.Phone
import io.swagger.annotations.ApiModel
import java.time.LocalDate
import javax.validation.Valid
import javax.validation.constraints.Email
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

@ApiModel("CreationCareTaker")
data class CreateCareTakerDTO(

        @NotNull @NotBlank
        val name: String,

        @NotNull @NotBlank
        val cpf: String,

        @NotNull
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
    fun createCareTaker(): CareTaker {

        val phone = Phone(initialPhoneNumber, false)
        val user = User(email, password)
        val address = this.address.createAddress()
        return CareTaker(name, cpf, birthDate, address, phone, user)
    }
}