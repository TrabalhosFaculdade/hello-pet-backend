package br.mackenzie.hellopet.web.controllers.petowning

import br.mackenzie.hellopet.services.api.SpeciesService
import br.mackenzie.hellopet.web.dtos.RetrievingSpeciesDTO
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/species")
@Api(value = "Species Endpoints")
class SpeciesController @Autowired constructor(private val speciesService: SpeciesService) {

    @ApiOperation(value = "List all species",
            response = RetrievingSpeciesDTO::class,
            responseContainer = "List")
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "Species returned, no problem occurred"),
        ApiResponse(code = 500, message = "Unexpected internal server error, contact developers")
    ])
    @GetMapping
    fun list(): ResponseEntity<List<RetrievingSpeciesDTO>> {
        return ResponseEntity.ok(speciesService.list().map { RetrievingSpeciesDTO(it) })
    }
}