package br.mackenzie.hellopet.web.dtos

import br.mackenzie.hellopet.database.model.petowning.PetOwner
import java.time.LocalDateTime

data class RetrievingPetOwnerDTO (private val petOwner: PetOwner) {

    val name: String = petOwner.name!!
    val cpf: String = petOwner.cpf!!
    val dateBirth: LocalDateTime = petOwner.dateBirth!!
    val address: AddressDTO = AddressDTO(petOwner.address!!)
    val email: String = petOwner.user!!.email!!
    val phoneNumbers: List<String> = petOwner.phoneNumbers.map { it.phoneNumber!! }
}