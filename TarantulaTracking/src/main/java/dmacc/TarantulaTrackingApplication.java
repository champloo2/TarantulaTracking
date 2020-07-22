package dmacc;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;

import com.ulisesbocchio.jasyptspringboot.annotation.EnableEncryptableProperties;

@EnableEncryptableProperties
@SpringBootApplication
public class TarantulaTrackingApplication {

	public static void main(String[] args) {
		SpringApplication.run(TarantulaTrackingApplication.class, args);
	}

}
