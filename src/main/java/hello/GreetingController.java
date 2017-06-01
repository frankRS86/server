package main.java.hello;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.java.persistence.IUserPersistence;
import main.java.persistence.User;

@RestController
public class GreetingController {

	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	IUserPersistence iUserPersistence;
	
	@RequestMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		
		System.out.println("request accepted");
		
		User u = new User();
		u.setName("first db user");
		
		iUserPersistence.save(u);
		
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
