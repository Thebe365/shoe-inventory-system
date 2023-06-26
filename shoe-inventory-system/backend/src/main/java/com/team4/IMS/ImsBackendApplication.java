package com.team4.IMS;

import com.team4.IMS.Models.User;
import com.team4.IMS.Repositorys.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@RequiredArgsConstructor
@Import({com.team4.IMS.Configs.CorsConfig.class})
public class ImsBackendApplication implements CommandLineRunner {
	private final UserRepository userRepository;

	private  final PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ImsBackendApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		User user =User.builder()
						.email("admin@admin.com")
						.password(passwordEncoder.encode("admin"))
						.build();
		userRepository.save(user);

	}
}
