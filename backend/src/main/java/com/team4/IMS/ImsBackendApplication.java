package com.team4.IMS;

import com.team4.IMS.Models.Brand;
import com.team4.IMS.Models.Inventory;
import com.team4.IMS.Models.Shoe;
import com.team4.IMS.Models.User;
import com.team4.IMS.repository.BrandRepository;
import com.team4.IMS.repository.InventoryRepository;
import com.team4.IMS.repository.ShoeRepository;
import com.team4.IMS.repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@Import({com.team4.IMS.Configs.CorsConfig.class})
public class ImsBackendApplication {


	public ImsBackendApplication(UserRepository userRepository, BrandRepository brandRepository, ShoeRepository shoeRepository, PasswordEncoder passwordEncoder, InventoryRepository inventoryRepository) {

		// Create admin
		User user =User.builder()
				.email("admin@admin.com")
				.password(passwordEncoder.encode("admin"))
				.build();
		userRepository.save(user);

		// Create brands
		Brand brand = Brand.builder()
				.name("nike")
				.build();
		brandRepository.save(brand);

		Brand brand2 = Brand.builder()
				.name("adidas")
				.build();
		brandRepository.save(brand2);

		Brand brand3 = Brand.builder()
				.name("vans")
				.build();
		brandRepository.save(brand3);

		Brand brand4 = Brand.builder()
				.name("puma")
				.build();
		brandRepository.save(brand4);

		Brand brand5 = Brand.builder()
				.name("new balance")
				.build();
		brandRepository.save(brand5);

		Brand brand6 = Brand.builder()
				.name("reebok")
				.build();
		brandRepository.save(brand6);

		Shoe shoe1 = Shoe.builder()
				.brandId(brand)
				.name("air force 1")
				.brandName("nike")
				.color("white")
				.size("10")
				.price(100.00)
				.build();
		shoeRepository.save(shoe1);

		Shoe shoe2 = Shoe.builder()
				.brandId(brand)
				.name("air max 90")
				.brandName("nike")
				.color("white")
				.size("10")
				.price(100.00)
				.build();
		shoeRepository.save(shoe2);

		Shoe shoe3 = Shoe.builder()
				.brandId(brand2)
				.name("superstar")
				.brandName("adidas")
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
