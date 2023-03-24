package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.controllers;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.config.florConfigMap;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.domain.FlorEntity;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.dto.FlorDTO;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.exception.EntityNoEncontradaException;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.services.FlorService;
import io.swagger.v3.oas.annotations.Operation;

@RestController
@RequestMapping("/")
public class FlorController {

	@Autowired
	private FlorService florServiceImpl;

	@Autowired
	private florConfigMap mapFlor;

	@Operation(summary = "Incio", description = "Presenta la pagina de inicio de la aplicación", tags = { "S05T01N02" })

	// inicio
	@GetMapping("/")
	public String welcome() {
		return "inicio";
	}

	// add
	@Operation(summary = "Añade una nueva entidad", description = " llama al metodo .save para  añadir  una nueva  entidad ", tags = {
			"S05T01N02" })
	@PostMapping("/flor/add")
	public FlorEntity addFruta(@RequestBody FlorEntity f) {
		return florServiceImpl.guardar(f);

	}

	// getAll
	@Operation(summary = "Lista todas las flores", description = " Lista todas las entidades `FlorEntity` existentes en la base de datos", tags = {
			"S05T01N02" })
	@GetMapping(value = "/flor/getAll")
	public ResponseEntity<?> getAll() {
		try {
			return new ResponseEntity<>((ArrayList<FlorDTO>) florServiceImpl.getAll(), HttpStatus.OK);
		} catch (DataAccessException e) {
			e.getMessage();
			return new ResponseEntity<Object>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	// getOne
	@Operation(summary = "Busca una entidad ", description = "Busca una entidad por su id si no exite devuelve un error", tags = {
			"S05T01N02" })
	@GetMapping(value = "/flor/getOne/{id}")
	@ResponseBody
	public ResponseEntity<?> getOne(@PathVariable Integer id) throws EntityNoEncontradaException {

		FlorDTO fDTO = florServiceImpl.getOne(id);

		try {
			if (fDTO == null) {
				throw new EntityNoEncontradaException("No se encontró ninguna entidad con el ID " + id);
			}

			return new ResponseEntity<Object>(fDTO, HttpStatus.OK);
		} catch (EntityNoEncontradaException e) {
			return new ResponseEntity<Object>(fDTO, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	// Update
	@Operation(summary = "Actualiza una entidad ", description = "Busca una entidad por su id para poder actualizar ", tags = {
			"S05T01N02" })
	@PutMapping(value="/flor/update/{id}")
	public ResponseEntity<?> update(@RequestBody FlorEntity florEntity, @PathVariable Integer id)
			throws EntityNoEncontradaException {

		FlorDTO fDTO = florServiceImpl.getOne(id);

		try {
			if (fDTO == null) {
				throw new EntityNoEncontradaException("No se encontró ninguna entidad con el ID " + id);
			}
			FlorEntity florUpdate = new FlorEntity();
			FlorEntity florActual =  mapFlor.convertToEntity(fDTO, florEntity);			
			
			florActual.setNomFlor(florEntity.getNomFlor());
			florActual.setPaisFlor(florEntity.getPaisFlor());
			florUpdate=florServiceImpl.guardar(florActual);	
			
			return new ResponseEntity<Object>(florUpdate, HttpStatus.CREATED);

		} catch (EntityNoEncontradaException e) {
			// respuesta.put("Error", e.getMessage());
			return new ResponseEntity<Object>("Error ", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	// Delete
	@Operation(summary = "Borrar entidad", description = "Elimina una entidad", tags = { "S05T01N02" })
	@DeleteMapping("/flor/delete/{id}")
	public ResponseEntity<?> delete(@PathVariable Integer id) throws EntityNoEncontradaException {
		Map<String, Object> respuesta = new HashMap<String, Object>();
		FlorDTO florDTO = florServiceImpl.getOne(id);
		try {
			if (florDTO == null) {
				throw new EntityNoEncontradaException("No se encontró ninguna entidad con el ID " + id);
			}
			respuesta.put("Borrado ", florDTO);			
			florServiceImpl.delete(id);			
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.OK);
		} catch (EntityNoEncontradaException e) {
			respuesta.put(e.getMessage(), null);
			return new ResponseEntity<Map<String, Object>>(respuesta, HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}
}
