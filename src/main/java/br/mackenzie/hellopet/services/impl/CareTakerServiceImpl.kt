package br.mackenzie.hellopet.services.impl

import br.mackenzie.hellopet.database.model.caretaking.CareTaker
import br.mackenzie.hellopet.database.repositories.CareTakerRepository
import br.mackenzie.hellopet.services.api.CareTakerService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.util.*

@Service
class CareTakerServiceImpl
@Autowired constructor(private val careTakerRepository: CareTakerRepository) : CareTakerService {

    override fun create(newCareTaker: CareTaker): CareTaker = careTakerRepository.saveAndFlush(newCareTaker)

    override fun list(): List<CareTaker> = careTakerRepository.findAll()

    override fun findOne(id: Long): Optional<CareTaker> = careTakerRepository.findById(id)

    override fun exists(careTakerId: Long) = careTakerRepository.existsById(careTakerId);


}