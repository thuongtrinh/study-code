package net.kzn.shoppingbackend.test;

import static org.junit.Assert.assertEquals;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import net.kzn.shoppingbackend.dao.UserDAO;
import net.kzn.shoppingbackend.dto.Address;
import net.kzn.shoppingbackend.dto.Cart;
import net.kzn.shoppingbackend.dto.User;

public class UserTestCase {

	private static AnnotationConfigApplicationContext context;
	private static UserDAO userDAO;
	private User user = null;
	private Cart cart = null;
	private Address address = null;

	@BeforeClass
	public static void init() {
		context = new AnnotationConfigApplicationContext();
		context.scan("net.kzn.shoppingbackend");
		context.refresh();
		userDAO = (UserDAO) context.getBean("userDAO");
	}
/*
	@Test
	public void testAdd() {
		user = new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setPassword("123456");

		// add the user
		assertEquals("Failed to add user!", true, userDAO.addUser(user));

		address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Jadoo Society, Krissh Nagar");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);

		// link the user with the address using user id
		address.setUserId(user.getId());
		// add the address
		assertEquals("Failed to add address!", true, userDAO.addAddress(address));
		if (user.getRole().equals("USER")) {
			// create a cart for this user
			cart = new Cart();
			cart.setUser(user);
			// add the cart
			assertEquals("Failed to add cart!", true, userDAO.addCart(cart));
			// add a shipping address for this user
			address = new Address();
			address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
			address.setAddressLineTwo("Near Kudrat Store");
			address.setCity("Mumbai");
			address.setState("Maharashtra");
			address.setCountry("India");
			address.setPostalCode("400001");
			// set shipping to true
			address.setShipping(true);
			// link it with the user
			address.setUserId(user.getId());
			// add the shipping address
			assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
		}

		user = new User();
		user.setFirstName("Hrithik");
		user.setLastName("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setPassword("123456");
	}

	@Test
	public void testAdd() {
		user = new User();
		user.setFirstName("Hrithik");
		user.setLast_name("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setPassword("123456");

		if (user.getRole().equals("USER")) {
			// create a cart for this user
			cart = new Cart();
			cart.setUser(user);
			// attach cart with the user
			user.setCart(cart);
		}

		// add the user
		assertEquals("Failed to add user!", true, userDAO.addUser(user));
	}

	@Test
	public void testUpdateCart() {
		// fetch the user by its email
		user = userDAO.getByEmail("hr@gmail.com");
		// get the cart of the user cart =
		user.getCart();
		cart.setGrandTotal(5555);
		cart.setCartLines(2);
		assertEquals("Failed to update the cart!", true, userDAO.updateCart(cart));
	}

	@Test
	public void testAddAddress() {
		user = new User();
		user.setFirstName("Hrithik");
		user.setLast_name("Roshan");
		user.setEmail("hr@gmail.com");
		user.setContactNumber("1234512345");
		user.setRole("USER");
		user.setPassword("123456");
		// add user
		assertEquals("Failed to add user!", true, userDAO.addUser(user));

		// We will going to add the address address = new Address();
		address.setAddressLineOne("101/B Jadoo Society, Krissh Nagar");
		address.setAddressLineTwo("Near Kaabil Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);

		// attached the user to address
		address.setUser(user);
		assertEquals("Failed to add address!", true, userDAO.addAddress(address));

		// add a shipping address for this user
		address = new Address();
		address.setAddressLineOne("201/B Jadoo Society, Kishan Kanhaiya Nagar");
		address.setAddressLineTwo("Near Kudrat Store");
		address.setCity("Mumbai");
		address.setState("Maharashtra");
		address.setCountry("India");
		address.setPostalCode("400001");
		// set shipping to true
		address.setShipping(true);
		// link it with the user
		address.setUser(user);
		assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
	}

	@Test
	public void testAddAddress() {
		user = userDAO.getByEmail("hr@gmail.com");
		// We will going to add the address
		address = new Address();
		address.setAddressLineOne("301/B Jadoo Society, Krissh Kanhaiya Nagar");
		address.setAddressLineTwo("Near Kurat Store");
		address.setCity("Bangalore");
		address.setState("Karnataka");
		address.setCountry("India");
		address.setPostalCode("400001");
		address.setBilling(true);

		// attached the user to address address.setUser(user);
		assertEquals("Failed to add shipping address!", true, userDAO.addAddress(address));
	}
*/
	@Test
	public void testGetAddAddress() {
		user = userDAO.getByEmail("hr@gmail.com");
		assertEquals("Failed to fetch the list of address and size does not match!", 1,
				userDAO.listShippingAddresses(user).size());

		assertEquals("Failed to fetch the billing and size does not match!", "Mumbai",
				userDAO.getBillingAddress(user).getCity());
	}

}
