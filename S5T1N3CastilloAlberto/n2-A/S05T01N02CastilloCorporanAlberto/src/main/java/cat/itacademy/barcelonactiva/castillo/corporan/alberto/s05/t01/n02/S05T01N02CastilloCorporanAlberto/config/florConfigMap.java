package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.config;

import org.modelmapper.ModelMapper;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.domain.FlorEntity;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.dto.FlorDTO;

@Configuration
@Component
public class florConfigMap {

	public FlorDTO convertToDto(FlorEntity flor, FlorDTO dto) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(flor, dto.getClass());
	}

	public FlorEntity convertToEntity(FlorDTO dto, FlorEntity flor) {
		ModelMapper modelMapper = new ModelMapper();
		return modelMapper.map(dto, flor.getClass());
	}

}
