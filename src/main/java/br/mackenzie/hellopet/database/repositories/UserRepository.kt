package br.mackenzie.hellopet.database.repositories

import br.mackenzie.hellopet.database.model.auth.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface UserRepository : JpaRepository<User, Long>