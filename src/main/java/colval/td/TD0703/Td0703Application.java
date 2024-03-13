package colval.td.TD0703;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "colval.td.TD0703.repository")
@EntityScan("colval.td.TD0703.entity")
public class Td0703Application {

	public static void main(String[] args) {
		SpringApplication.run(Td0703Application.class, args);
	}

}
