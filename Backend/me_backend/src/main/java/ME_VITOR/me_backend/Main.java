package ME_VITOR.me_backend;

import ME_VITOR.me_backend.Users.UserModel;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@SpringBootApplication
public class Main {

	public static void main(String[] args) {
		UserModel user = new UserModel();


		SpringApplication.run(Main.class, args);
	}

}
