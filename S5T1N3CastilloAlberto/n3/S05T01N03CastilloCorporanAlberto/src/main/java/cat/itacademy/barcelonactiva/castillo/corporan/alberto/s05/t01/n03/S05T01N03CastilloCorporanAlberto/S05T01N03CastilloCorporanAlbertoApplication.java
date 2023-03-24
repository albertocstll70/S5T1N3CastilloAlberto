package cat.itacademy.barcelonactiva.castillo.corporan.alberto.s05.t01.n03.S05T01N03CastilloCorporanAlberto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;


@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
//@SpringBootApplication
public class S05T01N03CastilloCorporanAlbertoApplication {

	public static void main(String[] args) {
		SpringApplication.run(S05T01N03CastilloCorporanAlbertoApplication.class, args);
	}

}
