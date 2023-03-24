package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n03.S05T01N03CastilloCorporanAlberto.controllers;

import java.util.ArrayList;
import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n03.S05T01N03CastilloCorporanAlberto.domain.FlorEntity;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n03.S05T01N03CastilloCorporanAlberto.dto.FlorDTO;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n03.S05T01N03CastilloCorporanAlberto.services.*;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/")
public class FlorController {

	@Autowired
	private FlorRestTemplateServiceImpl florRestTemplate;

	// inicio
	@GetMapping("/")
	public String welcome() {
		return "inicio";
	}

	// add
	@Operation(summary = "Añade una nueva entidad", description = " llama al metodo .save para  añadir  una nueva  entidad ", tags = {
			"S05T01N03" })

	@PostMapping("/restcliente/flor/add")
	public ResponseEntity<?> add(@RequestBody FlorEntity flor) {
		FlorEntity newFlorEntity = florRestTemplate.add(flor);
		return new ResponseEntity<>(newFlorEntity, HttpStatus.CREATED);
	}

	// getAll
	@Operation(summary = "Lista todas las flores", description = " Lista todas las entidades `FlorEntity` existentes en la base de datos", tags = {
			"S05T01N03" })
	@GetMapping(value = "/restcliente/flor/getAll")
	public ArrayList<FlorDTO> getAll() {
		FlorDTO[] florDTOs = florRestTemplate.getAll();
		return new ArrayList<>(Arrays.asList(florDTOs));
	}

	// getOne
	@Operation(summary = "Busca una entidad ", description = "Busca una entidad por su id si no exite devuelve un error", tags = {
			"S05T01N03" })
	@GetMapping(value = "/restcliente/flor/getOne/{id}")
	public ResponseEntity<?> getOne(@PathVariable("id") Integer id) {
		FlorDTO florDTO = florRestTemplate.getOne(id);
		return new ResponseEntity<>(florDTO, HttpStatus.OK);
	}

	// Update
	@Operation(summary = "Actualiza una entidad ", description = "Busca una entidad por su id para poder actualizar ", tags = {
			"S05T01N03" })
	@PutMapping(value = "/restcliente/flor/update/{id}")
	public ResponseEntity<?> update(@PathVariable Integer id, @RequestBody FlorEntity flor) {

		FlorEntity updatedFlor = florRestTemplate.update(id, flor);

		return new ResponseEntity<>(updatedFlor, HttpStatus.OK);
	}

	// Delete
	@Operation(summary = "Borrar entidad", description = "Elimina una entidad", tags = { "S05T01N03" })
	@DeleteMapping("/restcliente/flor/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) {
		florRestTemplate.delete(id);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}

}
