package com.team4.IMS;

<<<<<<< HEAD
import com.team4.IMS.Models.Brand;
import com.team4.IMS.Models.Inventory;
import com.team4.IMS.Models.Shoe;
import com.team4.IMS.Models.User;
import com.team4.IMS.repository.BrandRepository;
import com.team4.IMS.repository.InventoryRepository;
import com.team4.IMS.repository.ShoeRepository;
import com.team4.IMS.repository.UserRepository;
=======
import com.team4.ims.Models.*;
import com.team4.ims.Repository.BrandRepository;
import com.team4.ims.Repository.InventoryRepository;
import com.team4.ims.Repository.ShoeRepository;
import com.team4.ims.Repository.UserRepository;
>>>>>>> e5b8465 (fixing add shoe functionality)
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

<<<<<<< HEAD
		Inventory inventory = Inventory.builder()
				.shoe(shoe1)
=======
		Shoe shoe4 = Shoe.builder()
				.name("yeezy")
				.brandId(adidas)
				.isAvailable(true)
				.build();
		shoeRepository.save(shoe4);
//
//		//create inventory
//
		Inventory inventory1 = Inventory.builder()
				.shoe(shoe1)
				.color("White")
				.size("8")
>>>>>>> e5b8465 (fixing add shoe functionality)
				.quantity(10)
				.build();
		inventoryRepository.save(inventory);

		Inventory inventory2 = Inventory.builder()
				.shoe(shoe2)
<<<<<<< HEAD
=======
				.color("White")
				.size("8")
>>>>>>> e5b8465 (fixing add shoe functionality)
				.quantity(10)
				.build();

		inventoryRepository.save(inventory2);

		Inventory inventory3 = Inventory.builder()
<<<<<<< HEAD
				.shoe(shoe3)
=======
				.shoe(shoe1)
				.color("blue")
				.size("9")
>>>>>>> e5b8465 (fixing add shoe functionality)
				.quantity(10)
				.build();
		inventoryRepository.save(inventory3);
<<<<<<< HEAD
=======

		Inventory inventory4 = Inventory.builder()
				.shoe(shoe2)
				.color("red")
				.size("9")
				.quantity(10)
				.price(100.00)
				.build();
		inventoryRepository.save(inventory4);

		Inventory inventory5 = Inventory.builder()
				.shoe(shoe1)
				.color("yellow")
				.size("10")
				.quantity(10)
				.price(100.00)
				.build();
		inventoryRepository.save(inventory5);

		Inventory inventory6 = Inventory.builder()
				.shoe(shoe2)
				.color("green")
				.size("10")
				.quantity(10)
				.price(100.00)
				.build();
		inventoryRepository.save(inventory6);

		Inventory inventory7 = Inventory.builder()
				.shoe(shoe3)
				.color("black")
				.size("11")
				.quantity(10)
				.price(100.00)
				.build();
		inventoryRepository.save(inventory7);

		Inventory inventory8 = Inventory.builder()
				.shoe(shoe4)
				.color("black")
				.size("11")
				.quantity(10)
				.price(100.00)
				.build();
		inventoryRepository.save(inventory8);

		Inventory inventory9 = Inventory.builder()
				.shoe(shoe3)
				.color("white")
				.size("12")
				.quantity(10)
				.price(100.00)
				.build();
		inventoryRepository.save(inventory9);


//




>>>>>>> e5b8465 (fixing add shoe functionality)
	}

	public static void main(String[] args) {
		SpringApplication.run(ImsBackendApplication.class, args);
	}
}
