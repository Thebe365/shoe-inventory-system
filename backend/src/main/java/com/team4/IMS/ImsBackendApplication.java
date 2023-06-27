package com.team4.IMS;

import com.team4.IMS.Models.Brand;
import com.team4.IMS.Models.Inventory;
import com.team4.IMS.Models.Shoe;
import com.team4.IMS.Models.User;
import com.team4.IMS.Repositorys.BrandRepository;
import com.team4.IMS.Repositorys.InventoryRepository;
import com.team4.IMS.Repositorys.ShoeRepository;
import com.team4.IMS.Repositorys.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@Import({com.team4.IMS.Configs.CorsConfig.class})
public class ImsBackendApplication {


	public ImsBackendApplication(UserRepository userRepository, BrandRepository brandRepository, ShoeRepository shoeRepository, PasswordEncoder passwordEncoder, InventoryRepository inventoryRepository) {

		User user =User.builder()
				.email("admin@admin.com")
				.password(passwordEncoder.encode("admin"))
				.build();
		userRepository.save(user);

		Brand brand = Brand.builder()
				.name("Nike")
				.build();
		brandRepository.save(brand);

		Brand brand2 = Brand.builder()
				.name("Adidas")
				.build();
		brandRepository.save(brand2);

		Shoe shoe1 = Shoe.builder()
				.brandId(brand)
				.name("Air Force 1")
				.color("White")
				.size("10")
				.price(100.00)
				.build();
		shoeRepository.save(shoe1);

		Shoe shoe2 = Shoe.builder()
				.brandId(brand)
				.name("Air Max 90")
				.color("White")
				.size("10")
				.price(100.00)
				.build();
		shoeRepository.save(shoe2);

		Shoe shoe3 = Shoe.builder()
				.brandId(brand2)
				.name("Superstar")
				.color("White")
				.size("10")
				.price(100.00)
				.build();
		shoeRepository.save(shoe3);

		Inventory inventory = Inventory.builder()
				.shoe(shoe1)
				.quantity(10)
				.build();
		inventoryRepository.save(inventory);

		Inventory inventory2 = Inventory.builder()
				.shoe(shoe2)
				.quantity(10)
				.build();

		inventoryRepository.save(inventory2);

		Inventory inventory3 = Inventory.builder()
				.shoe(shoe3)
				.quantity(10)
				.build();
		inventoryRepository.save(inventory3);
	}

	public static void main(String[] args) {
		SpringApplication.run(ImsBackendApplication.class, args);
	}



}
