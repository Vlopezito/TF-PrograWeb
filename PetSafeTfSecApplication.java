package pe.edu.upc.spring;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
public class PetSafeTfSecApplication implements CommandLineRunner{

	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	public static void main(String[] args) {
		SpringApplication.run(PetSafeTfSecApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		String passAdmin = "ADMIN";
		String passJefe = "JEFE";
		String passUser = "USER";
		String passPet = "PET";
		String passVet = "VET";
		
		for (int i=0;i<2;i++) {
			String bcryptPassword = passwordEncoder.encode(passAdmin);
			System.out.println(bcryptPassword);
		}
		
		for (int i=0;i<2;i++) {
			String bcryptPassword = passwordEncoder.encode(passJefe);
			System.out.println(bcryptPassword);
		}
		for (int i=0;i<2;i++) {
			String bcryptPassword = passwordEncoder.encode(passUser);
			System.out.println(bcryptPassword);
		}
		for (int i=0;i<2;i++) {
			String bcryptPassword = passwordEncoder.encode(passPet);
			System.out.println(bcryptPassword);
		}
		for (int i=0;i<2;i++) {
			String bcryptPassword = passwordEncoder.encode(passVet);
			System.out.println(bcryptPassword);
		}
		
	}

}
