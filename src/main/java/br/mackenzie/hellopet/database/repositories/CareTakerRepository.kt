package br.mackenzie.hellopet.database.repositories

import br.mackenzie.hellopet.database.model.caretaking.CareTaker
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface CareTakerRepository : JpaRepository<CareTaker, Long>