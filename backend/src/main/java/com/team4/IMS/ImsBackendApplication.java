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
		Brand brand7 = Brand.builder()
				.name("converse")
				.build();
		brandRepository.save(brand7);

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

		Shoe shoe4 = Shoe.builder()
				.brandId(brand6)
				.name("classic leather")
				.brandName("reebok")
				.color("white")
				.size("7")
				.price(2500.00)
				.build();
		shoeRepository.save(shoe4);
		Shoe shoe5 = Shoe.builder()
				.brandId(brand3)
				.name("era")
				.brandName("vans")
				.color("black")
				.size("9")
				.price(1500.00)
				.build();
		shoeRepository.save(shoe5);
		Shoe shoe6 = Shoe.builder()
				.brandId(brand3)
				.name("sk8 hi")
				.brandName("vans")
				.color("black")
				.size("10")
				.price(2000.00)
				.build();
		shoeRepository.save(shoe6);
		Shoe shoe7 = Shoe.builder()
				.brandId(brand7)
				.name("all star chuck taylor")
				.brandName("chuck taylor")
				.color("black")
				.size("10")
				.price(500.00)
				.build();
		shoeRepository.save(shoe7);
		Shoe shoe8 = Shoe.builder()
				.brandId(brand7)
				.name("jack purcell")
				.brandName("chuck taylor")
				.color("black")
				.size("10")
				.price(600.00)
				.build();
		shoeRepository.save(shoe8);
		Shoe shoe9 = Shoe.builder()
				.brandId(brand)
				.name("air jordan 1")
				.brandName("nike")
				.color("blue")
				.size("9")
				.price(9000.00)
				.build();
		shoeRepository.save(shoe9);

		Shoe shoe10 = Shoe.builder()
				.brandId(brand3)
				.name("old skool")
				.brandName("vans")
				.color("black")
				.size("7")
				.price(700.00)
				.build();
		shoeRepository.save(shoe10);

		Shoe shoe11 = Shoe.builder()
				.brandId(brand2)
				.name("nite ball")
				.brandName("adidas")
				.color("white")
				.size("7")
				.price(700.00)
				.build();
		shoeRepository.save(shoe11);
		Shoe shoe12 = Shoe.builder()
				.brandId(brand2)
				.name("nite ball")
				.brandName("adidas")
				.color("white")
				.size("9")
				.price(700.00)
				.build();
		shoeRepository.save(shoe12);



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
