package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n03.S05T01N03CastilloCorporanAlberto.config;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;


@Configuration
public class AppConfig {

	@Bean
 RestTemplate restTemplate(RestTemplateBuilder builder) {		 
		return builder.build();	
		
	}
}
