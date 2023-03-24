package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n03.S05T01N03CastilloCorporanAlberto.services;

import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n03.S05T01N03CastilloCorporanAlberto.domain.FlorEntity;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n03.S05T01N03CastilloCorporanAlberto.dto.FlorDTO;

public interface FlorRestTemplateService {
	//FlorEntity guardar(FlorEntity f);

	FlorDTO[] getAll();

	FlorDTO getOne(int id);

	FlorEntity add(FlorEntity flor);

	
	FlorEntity update(int id, FlorEntity florEntity);

	void delete(int id);

}
