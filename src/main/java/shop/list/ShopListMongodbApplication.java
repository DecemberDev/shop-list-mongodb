package shop.list;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.config.EnableMongoAuditing;

@SpringBootApplication
@EnableMongoAuditing
public class ShopListMongodbApplication {

	public static void main(String[] args) {
		SpringApplication.run(ShopListMongodbApplication.class, args);
	}

}
