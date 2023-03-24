package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.config.florConfigMap;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.domain.FlorEntity;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.dto.FlorDTO;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n02.S05T01N02CastilloCorporanAlberto.repository.FlorRepository;

@Service()
public class FlorServiceImpl implements FlorService {

	@Autowired
	private FlorRepository florRepository;

	@Autowired
	private florConfigMap mapFlor;

	@Override
	public FlorEntity guardar(FlorEntity f) {
		return florRepository.save(f);

	}

	@Override
	public List<FlorDTO> getAll() {
		FlorDTO fDTO = new FlorDTO();
		List<FlorDTO> fListDTO = new ArrayList<FlorDTO>();
		List<FlorEntity> flores = (List<FlorEntity>) florRepository.findAll();
		for (FlorEntity florEntity : flores) {
			fListDTO.add(mapFlor.convertToDto(florEntity, fDTO));
		}

		return fListDTO;
	}

	@Override
	public FlorDTO getOne(Integer id) {
		FlorEntity florEntity = florRepository.findById(id).orElse(null);
		FlorDTO florDTO = new FlorDTO();
		//florEntity = florRepository.findById(id).orElse(null);
		 
		florDTO= mapFlor.convertToDto(florEntity, florDTO);
		return florDTO;
	}

	@Override
	public void delete(Integer id) {
		florRepository.deleteById(id);

	}

}
