package br.mackenzie.hellopet.database.repositories

import br.mackenzie.hellopet.database.model.petowning.Dog
import org.springframework.data.jpa.repository.JpaRepository

interface DogRepository : JpaRepository<Dog,Long> 