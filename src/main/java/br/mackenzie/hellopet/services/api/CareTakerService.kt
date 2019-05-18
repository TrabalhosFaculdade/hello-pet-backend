package br.mackenzie.hellopet.services.api

import br.mackenzie.hellopet.database.model.caretaking.CareTaker
import java.util.*

interface CareTakerService {

    fun exists (careTakerId: Long): Boolean
    fun create(newCareTaker: CareTaker): CareTaker
    fun list(): List<CareTaker>
    fun findOne(id: Long): Optional<CareTaker>

}