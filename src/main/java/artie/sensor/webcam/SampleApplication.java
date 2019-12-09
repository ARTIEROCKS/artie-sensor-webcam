package artie.sensor.webcam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SampleApplication {

	public static void main(String[] args) {
		System.setProperty("spring.config.name", "webcam.properties");
		SpringApplication.run(SampleApplication.class, args);
	}

}
