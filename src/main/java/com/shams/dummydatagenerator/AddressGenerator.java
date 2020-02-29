package com.shams.dummydatagenerator;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.javafaker.Faker;

@RestController
@RequestMapping("/randomizer")
public class AddressGenerator {
	
	
	
	
	@GetMapping("/address")
	public static Address generate() {
		Address generatedAddress = new Address();
		
		
		Map<String,String> countries = new HashMap<>();
		countries.put("USA","United States");
		countries.put("CAN","Canada");
		countries.put("MEX","Mexico");
		countries.put("NLD","Netherlands");
		
		
		Object[] keys = countries.keySet().toArray();
		String key = (String) keys[new Random().nextInt(keys.length)];
 
		
		
		
		
		Faker faker = new Faker();
		
		generatedAddress.setHouse(faker.numerify("###"));
		generatedAddress.setStreet(faker.address().streetName());
		generatedAddress.setCity(faker.address().city());
		generatedAddress.setCounty(faker.address().city());
		generatedAddress.setPostalCode(faker.address().zipCode());
		
		if(key.equals("USA") || key.equals("CAN"))
			generatedAddress.setState(faker.address().state());
		
		generatedAddress.setCounty(key);
		generatedAddress.setCountryCode(countries.get(key));
		
		
		return generatedAddress;
		
		
	}
	
	

	
	
	

}
