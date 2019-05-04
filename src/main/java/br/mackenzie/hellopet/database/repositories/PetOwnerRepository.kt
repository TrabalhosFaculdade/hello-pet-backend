package br.mackenzie.hellopet.database.repositories

import br.mackenzie.hellopet.database.model.petowning.PetOwner
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface PetOwnerRepository : JpaRepository<PetOwner, Long>