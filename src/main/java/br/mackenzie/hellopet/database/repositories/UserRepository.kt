package br.mackenzie.hellopet.database.repositories

import br.mackenzie.hellopet.database.model.auth.User
import org.springframework.data.jpa.repository.JpaRepository

interface UserRepository : JpaRepository<User, Long>