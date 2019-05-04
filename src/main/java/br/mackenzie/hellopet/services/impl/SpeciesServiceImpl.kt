package br.mackenzie.hellopet.services.impl

import br.mackenzie.hellopet.database.model.petowning.Species
import br.mackenzie.hellopet.database.repositories.SpeciesRepository
import br.mackenzie.hellopet.services.api.SpeciesService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import java.lang.IllegalArgumentException
import java.util.*

@Service
class SpeciesServiceImpl
@Autowired constructor(private val speciesRepository: SpeciesRepository) : SpeciesService {

    override fun create(newSpecies: Species): Species {

        if (speciesRepository.existsByName(newSpecies.name!!)) {
            throw IllegalArgumentException("Already exists a species with informed name")
        }

        return speciesRepository.saveAndFlush(newSpecies)
    }

    override fun create(newSpeciesName: String): Species {
        return create(Species(newSpeciesName))
    }

    override fun list(): List<Species> = speciesRepository.findAll()

    override fun findOne(id: Long): Optional<Species> = speciesRepository.findById(id)

    override fun findOne(name: String): Optional<Species> = speciesRepository.findByName(name)

    override fun getForUse(name: String): Species {
        return getForUse(Species(name))
    }

    override fun getForUse(species: Species): Species {
        val fromRepo = findOne(species.name!!)
        return if (fromRepo.isPresent) {
            fromRepo.get()
        } else {
            speciesRepository.saveAndFlush(species)
        }
    }
}