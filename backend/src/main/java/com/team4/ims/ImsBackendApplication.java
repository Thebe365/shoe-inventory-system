package com.team4.ims;

import com.team4.ims.Repository.BrandRepository;
import com.team4.ims.Repository.InventoryRepository;
import com.team4.ims.Repository.ShoeRepository;
import com.team4.ims.Repository.UserRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;
import org.springframework.security.crypto.password.PasswordEncoder;

@SpringBootApplication
@Import({com.team4.ims.Configs.CorsConfig.class})
public class ImsBackendApplication {

//	public void createShoe(String name,
//						   Brand brand,
//						   String color,
//						   String size,
//						   int quantity,
//						   double price,
//						   ShoeRepository shoeRepository,
//						   UserRepository userRepository,
//						   BrandRepository brandRepository,
//						   InventoryRepository inventoryRepository
//	) {
//		Shoe shoe = Shoe.builder()
//				.name(name)
//				.brandId(brand)
//				.isAvailable(true)
//				.build();
//		shoeRepository.save(shoe);
//
//		Inventory inventory = Inventory.builder()
//				.shoeId(shoe)
//				.color(color)
//				.size(size)
//				.quantity(quantity)
//				.price(price)
//				.build();
//		inventoryRepository.save(inventory);
//
//	}



	public ImsBackendApplication(UserRepository userRepository, BrandRepository brandRepository, ShoeRepository shoeRepository, PasswordEncoder passwordEncoder, InventoryRepository inventoryRepository) {

//		 Create users (ADMIN and CUSTOMER)
//		User admin =User.builder()
//				.email("admin@admin.com")
//				.password(passwordEncoder.encode("admin"))
//				.role(Roles.ADMIN)
//				.build();
//		userRepository.save(admin);
//
//		System.out.println("admin: " + admin.getPassword());
//
//		User customer =User.builder()
//				.email("user@user.com")
//				.password(passwordEncoder.encode("user"))
//				.role(Roles.CUSTOMER)
//				.build();
//		userRepository.save(customer);
//
//		System.out.println("customer: " + customer.getPassword());
//
//
//		// Create brands (nike, adidas)
//		Brand Nike = Brand.builder()
//				.name("nike")
//				.isAvailable(true)
//				.build();
//		brandRepository.save(Nike);
//
//		Brand Adidas = Brand.builder()
//				.name("adidas")
//				.isAvailable(true)
//				.build();
//		brandRepository.save(Adidas);
//
//		Brand nike = brandRepository.findByName("nike").orElseThrow();
//		Brand adidas = brandRepository.findByName("adidas").orElseThrow();
//
//		System.out.println("nike: " + nike.getId());
//		System.out.println("adidas: " + adidas.getId());

		// Create shoes (nike, adidas)
//		createShoe("air force 1", Nike, "White", "8", 10, 100.00, shoeRepository, userRepository, brandRepository, inventoryRepository);
//		createShoe("superstar", Adidas, "White", "8", 10, 100.00, shoeRepository, userRepository, brandRepository, inventoryRepository);
//		createShoe("air force 1", Nike, "blue", "9", 10, 100.00, shoeRepository, userRepository, brandRepository, inventoryRepository);
//		createShoe("superstar", Adidas, "red", "9", 10, 100.00, shoeRepository, userRepository, brandRepository, inventoryRepository);
//		createShoe("air force 1", Nike, "yellow", "10", 10, 100.00, shoeRepository, userRepository, brandRepository, inventoryRepository);
//		createShoe("superstar", Adidas, "green", "10", 10, 100.00, shoeRepository, userRepository, brandRepository, inventoryRepository);
//		createShoe("jordan 23", Nike, "black", "11", 10, 100.00, shoeRepository, userRepository, brandRepository, inventoryRepository);
//		createShoe("yeezy", Adidas, "black", "11", 10, 100.00, shoeRepository, userRepository, brandRepository, inventoryRepository);
//		createShoe("jordan 23", Nike, "white", "12", 10, 100.00, shoeRepository, userRepository, brandRepository, inventoryRepository);
//		createShoe("yeezy", Adidas, "white", "12", 10, 100.00, shoeRepository, userRepository, brandRepository, inventoryRepository);
//

		//create shoes and inventory

//		Shoe shoe1 = Shoe.builder()
//				.name("air force 1")
//				.brand(nike)
//				.isAvailable(true)
//				.build();
//		shoeRepository.save(shoe1);
//
//		Shoe shoe2 = Shoe.builder()
//				.name("superstar")
//				.brand(adidas)
//				.isAvailable(true)
//				.build();
//		shoeRepository.save(shoe2);
//
//		Shoe shoe3 = Shoe.builder()
//				.name("jordan 23")
//				.brand(nike)
//				.isAvailable(true)
//				.build();
//		shoeRepository.save(shoe3);
//
//		Shoe shoe4 = Shoe.builder()
//				.name("yeezy")
//				.brand(adidas)
//				.isAvailable(true)
//				.build();
//		shoeRepository.save(shoe4);
////
////		//create inventory
////
//		Inventory inventory1 = Inventory.builder()
//				.shoe(shoe1)
//				.color("White")
//				.size("8")
//				.quantity(10)
//				.price(100.00)
//				.build();
//		inventoryRepository.save(inventory1);
////
//		Inventory inventory2 = Inventory.builder()
//				.shoe(shoe2)
//				.color("White")
//				.size("8")
//				.quantity(10)
//				.price(100.00)
//				.build();
//		inventoryRepository.save(inventory2);
//
//		Inventory inventory3 = Inventory.builder()
//				.shoe(shoe1)
//				.color("blue")
//				.size("9")
//				.quantity(10)
//				.price(100.00)
//				.build();
//		inventoryRepository.save(inventory3);
//
//		Inventory inventory4 = Inventory.builder()
//				.shoe(shoe2)
//				.color("red")
//				.size("9")
//				.quantity(10)
//				.price(100.00)
//				.build();
//		inventoryRepository.save(inventory4);
//
//		Inventory inventory5 = Inventory.builder()
//				.shoe(shoe1)
//				.color("yellow")
//				.size("10")
//				.quantity(10)
//				.price(100.00)
//				.build();
//		inventoryRepository.save(inventory5);
//
//		Inventory inventory6 = Inventory.builder()
//				.shoe(shoe2)
//				.color("green")
//				.size("10")
//				.quantity(10)
//				.price(100.00)
//				.build();
//		inventoryRepository.save(inventory6);
//
//		Inventory inventory7 = Inventory.builder()
//				.shoe(shoe3)
//				.color("black")
//				.size("11")
//				.quantity(10)
//				.price(100.00)
//				.build();
//		inventoryRepository.save(inventory7);
//
//		Inventory inventory8 = Inventory.builder()
//				.shoe(shoe4)
//				.color("black")
//				.size("11")
//				.quantity(10)
//				.price(100.00)
//				.build();
//		inventoryRepository.save(inventory8);
//
//		Inventory inventory9 = Inventory.builder()
//				.shoe(shoe3)
//				.color("white")
//				.size("12")
//				.quantity(10)
//				.price(100.00)
//				.build();
//		inventoryRepository.save(inventory9);


//




	}

	public static void main(String[] args) {
		SpringApplication.run(ImsBackendApplication.class, args);
	}

/**
 * User Stories:
 * 1. A user can add new brands to the system (2HRS)
 * 2. A user can add new shoes to the system (3HRS)
 * 3. A user can delist/relist shoes and brands making them unavailable (2HRS) (Discuss with DA)
 * 4. A user can view a list of all available brands and their corresponding shoes(1HR)
 * 1. A user can view graphs and charts or sales data (6HRS)
 * 7.
 *
 *
 * @Frontend
 * 1. Enabling update functionality for updating shoes
 * 2. Enabling the adding shoes functionality
 * 3. Enabling the adding brands functionality
 * 4. Enabling the filter option on the sales data chart
 * 5. Separate services
 * @Backend
 * 1. Connecting to SQL Server DB
 * 2. Fix Query for native queries***DONE***
 * 3. Editing delete so that the shoe is marked as unavailable instead of deleting it ***DONE***
 * 4. Grouping shoe data for each shoe in (Fetch shoe by brand endpoint) **DONE**
 * 5. Create an endpoint for the graph data displayed on overview page
 * 6.
 */

//Sales Endpoint
	/**
	 * 1. Return Sales for a specific month [array of sales information for that month(specified by user)]
	 * 		1.2. Filter by month range
	 * 		1.3. Filter by Shoe
	 * 2. returns most popular brands [based on total highest sales per brand]
	 * 3. returns most popular shoes [based on total highest sales per shoe]
	 * 4. return the total sales for a specific months
	 * 		4.1. Filter by month range
	 */

}
