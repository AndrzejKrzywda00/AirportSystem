package airport_system;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

@EnableWebMvc
@SpringBootApplication
public class AirportSystemApplication {
	public static void main(String[] args) {
		SpringApplication.run(AirportSystemApplication.class, args);
	}
}
