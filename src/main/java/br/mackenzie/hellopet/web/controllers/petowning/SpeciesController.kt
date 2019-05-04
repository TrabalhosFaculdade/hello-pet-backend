package br.mackenzie.hellopet.web.controllers.petowning

import br.mackenzie.hellopet.services.api.SpeciesService
import br.mackenzie.hellopet.web.dtos.RetrievingSpeciesDTO
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/species")
class SpeciesController @Autowired constructor(private val speciesService: SpeciesService) {

    @GetMapping
    fun list(): ResponseEntity<List<RetrievingSpeciesDTO>> {
        return ResponseEntity.ok(speciesService.list().map { RetrievingSpeciesDTO(it) })
    }
}