package main.java.hello;

import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GreetingController2 {

	private static final String template = "was geht ab, %s!";
	private final AtomicLong counter = new AtomicLong();

	@RequestMapping("/whats")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		
		System.out.println("request number 2 accepted");
		
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
}
