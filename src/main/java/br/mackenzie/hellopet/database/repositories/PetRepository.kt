package br.mackenzie.hellopet.database.repositories

import br.mackenzie.hellopet.database.model.petowning.Pet
import org.springframework.data.jpa.repository.JpaRepository

interface PetRepository : JpaRepository<Pet, Long>