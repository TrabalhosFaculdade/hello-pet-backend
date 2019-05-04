package br.mackenzie.hellopet.services.api

import br.mackenzie.hellopet.database.model.petowning.Dog

interface PetService {

    fun list () : List<Dog>

}