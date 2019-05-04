package br.mackenzie.hellopet.web.dtos

import br.mackenzie.hellopet.database.model.commons.Address
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class AddressDTO(

        @NotNull @NotBlank
        val street: String,

        @NotNull @NotBlank
        val number: String,

        @NotNull @NotBlank
        val zipCode: String,

        @NotNull @NotBlank
        val city: String,

        val complement: String? = null
) {
    constructor(address: Address) :

            this(address.street!!,
                 address.number!!,
                 address.zipCode!!,
                 address.city!!,
                 address.complement)

    fun createAddress(): Address {
        return Address(street, number, zipCode, city, complement)
    }
}