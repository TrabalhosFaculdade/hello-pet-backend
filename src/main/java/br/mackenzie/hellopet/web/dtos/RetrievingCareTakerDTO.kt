package br.mackenzie.hellopet.web.dtos

import br.mackenzie.hellopet.database.model.caretaking.CareTaker
import io.swagger.annotations.ApiModel
import java.time.LocalDate

@ApiModel("CareTaker")
data class RetrievingCareTakerDTO (private val careTaker: CareTaker) {

    val id: Long = careTaker.id!!
    val name: String = careTaker.name!!
    val cpf: String = careTaker.cpf!!
    val dateBirth: LocalDate = careTaker.dateBirth!!
    val address: AddressDTO = AddressDTO(careTaker.address!!)
    val email: String = careTaker.user!!.email!!
    val phoneNumbers: List<String> = careTaker.phoneNumbers.map { it.phoneNumber!! }
}