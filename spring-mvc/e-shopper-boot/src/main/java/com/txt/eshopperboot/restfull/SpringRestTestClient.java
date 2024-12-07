package com.txt.eshopperboot.restfull;

import java.net.URI;
import java.util.LinkedHashMap;
import java.util.List;

import org.springframework.web.client.RestTemplate;

import com.txt.eshopperboot.dto.User;

public class SpringRestTestClient {
/*
	public static final String REST_SERVICE_URI = "http://localhost:8080/EShopper";

	 GET 
	public static void listAllUsers() {
		RestTemplate restTemplate = new RestTemplate();
		List<LinkedHashMap<String, Object>> listUserMap = restTemplate.getForObject(REST_SERVICE_URI + "/users/",
				List.class);
		if (listUserMap != null) {
			for (LinkedHashMap<String, Object> map : listUserMap) {
				System.out.println("User : id=" + map.get("id") + ", Name=" + map.get("displayname") + ", phone="
						+ map.get("mobilePhone"));
			}
		} else {
			System.out.println("No exist User !!!");
		}
	}

	 POST 
	private static void createUser() {
		System.out.println("Testing create User API----------");
		RestTemplate restTemplate = new RestTemplate();
		User user = new User("Sarah", "511349909");
		user.setUsername("User11");
		user.setPassword("123456");
		user.setEnable(true);
		user.setRole("USER");
		user.setEmail("user11@gmail.com");
		URI uri = restTemplate.postForLocation(REST_SERVICE_URI + "/user/", user, User.class);
		System.out.println("Location : " + uri.toASCIIString());
	}

	 PUT 
	private static void updateUser() {
		System.out.println("Testing update User API----------");
		RestTemplate restTemplate = new RestTemplate();
		User user = new User(1, "Tomy", "3370000");
		restTemplate.put(REST_SERVICE_URI + "/user/1", user);
		System.out.println(user);
	}

	 DELETE 
	private static void deleteUser() {
		System.out.println("Testing delete User API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI + "/user/3");
	}

	 DELETE 
	private static void deleteAllUsers() {
		System.out.println("Testing all delete Users API----------");
		RestTemplate restTemplate = new RestTemplate();
		restTemplate.delete(REST_SERVICE_URI + "/user/");
	}

	public static void main(String[] args) {
		listAllUsers();
		createUser();
	}
*/
}
