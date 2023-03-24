package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.services;

import java.util.List;

import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.domain.FlorEntity;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.dto.FlorDTO;

public interface FlorService {
	FlorEntity guardar(FlorEntity f);

	List<FlorDTO> getAll();

	FlorDTO getOne(Integer id);

	void delete(Integer id);

}
