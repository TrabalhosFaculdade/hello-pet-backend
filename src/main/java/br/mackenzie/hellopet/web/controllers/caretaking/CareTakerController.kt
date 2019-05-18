package br.mackenzie.hellopet.web.controllers.caretaking

import br.mackenzie.hellopet.services.api.CareTakerService
import br.mackenzie.hellopet.web.dtos.CreateCareTakerDTO
import br.mackenzie.hellopet.web.dtos.RetrievingCareTakerDTO
import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import io.swagger.annotations.ApiResponse
import io.swagger.annotations.ApiResponses
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RestController
@RequestMapping("/care-taker")
@Api(value = "Care Taker Endpoints")
class CareTakerController
@Autowired constructor(private val careTakerService: CareTakerService) {

    @ApiOperation(value = "Register a new care taker with informed values", notes = "Date format: yyyy-MM-dd")
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "Care taker registered, no problem occurred"),
        ApiResponse(code = 500, message = "Errors related to constraints on fields values, like duplicated cpf or email")
    ])
    @PostMapping
    fun create(@RequestBody @Valid careTaker: CreateCareTakerDTO): ResponseEntity<Any> {
        careTakerService.create(careTaker.createCareTaker())
        return ResponseEntity.ok().build()
    }

    @ApiOperation(value = "List all care taker registered",
            response = RetrievingCareTakerDTO::class,
            responseContainer = "List",
            notes = "Date format: yyyy-MM-dd")
    @ApiResponses(value = [
        ApiResponse(code = 200, message = "Care takers returned, no problem occurred"),
        ApiResponse(code = 500, message = "Unexpected internal server error, contact developers")
    ])
    @GetMapping
    fun getAll(): ResponseEntity<List<RetrievingCareTakerDTO>> {
        return ResponseEntity.ok(careTakerService.list().map { RetrievingCareTakerDTO(it) })
    }

    @ApiOperation(value = "Return information about care taker with informed id, if existing")
    @ApiResponses(value = [
        ApiResponse(
                code = 200, message = "Care taker successfully retrieved, no problem occurred",
                response = RetrievingCareTakerDTO::class,
                responseContainer = "List"),
        ApiResponse(code = 404, message = "Could not find care taker with informed id"),
        ApiResponse(code = 500, message = "Unexpected internal server error, contact developers")
    ])
    @GetMapping("/{id}")
    fun getOne(@PathVariable id: Long): ResponseEntity<Any> {

        val careTaker = careTakerService.findOne(id)
        return if (careTaker.isPresent) {
            ResponseEntity.ok(RetrievingCareTakerDTO(careTaker.get()))
        } else {
            ResponseEntity.notFound().build()
        }
    }

}