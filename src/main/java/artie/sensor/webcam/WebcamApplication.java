package artie.sensor.webcam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;


@SpringBootApplication
@EnableScheduling
@EnableJpaRepositories("artie.sensor")
@EntityScan("artie.sensor")
@ComponentScan(basePackages = "artie.sensor")
public class WebcamApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebcamApplication.class, args);
	}

}
