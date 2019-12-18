package artie.sensor.webcam;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableScheduling;

@SpringBootApplication
@EnableScheduling
public class WebcamApplication {

	public static void main(String[] args) {
		SpringApplication.run(WebcamApplication.class, args);
	}

}
