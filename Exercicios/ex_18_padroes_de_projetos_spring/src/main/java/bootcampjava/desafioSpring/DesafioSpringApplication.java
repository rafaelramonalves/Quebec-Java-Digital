package bootcampjava.desafioSpring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@EnableFeignClients
@SpringBootApplication
public class DesafioSpringApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioSpringApplication.class, args);
	}

}
