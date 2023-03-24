package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n03.S05T01N03CastilloCorporanAlberto.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n03.S05T01N03CastilloCorporanAlberto.domain.FlorEntity;
import cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n03.S05T01N03CastilloCorporanAlberto.dto.FlorDTO;
@Service
public class FlorRestTemplateServiceImpl implements FlorRestTemplateService {

	@Autowired
	private  RestTemplate restTemplate;

	

	@Override
	public FlorDTO[] getAll() {
		String url = "http://localhost:9001/flor/getAll";
		ResponseEntity<FlorDTO[]> response = restTemplate.getForEntity(url, FlorDTO[].class);
		return response.getBody();
	}

	@Override
	public FlorDTO getOne(int id) {
		String url = "http://localhost:9001/flor/getOne/" + id;
		ResponseEntity<FlorDTO> response = restTemplate.getForEntity(url, FlorDTO.class);
		return response.getBody();
	}

	@Override
	public FlorEntity add(FlorEntity flor) {
		String url = "http://localhost:9001/flor/add";
		ResponseEntity<FlorEntity> response = restTemplate.postForEntity(url, flor, FlorEntity.class);
		return response.getBody();
	}

	@Override
	public FlorEntity update(int id, FlorEntity flor) {
		String url = "http://localhost:9001/flor/update/" + id;		
		restTemplate.put(url, flor);
		return flor;
	}

	

	@Override
	public void delete(int id) {
		String url = "http://localhost:9001/flor/delete/" + id;
		restTemplate.delete(url);
	}
}
