package main.java;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.java.hello.Greeting;
import main.java.persistence.IUserPersistence;
import main.java.persistence.User;

@RestController
public class Test3 {

	private static final String template = "Hello second package, %s!";
	private final AtomicLong counter = new AtomicLong();

	
	@Autowired
	TestService testService;
	
	@Autowired
	IUserPersistence iUserPersistence;
	
	@RequestMapping("/second")
	public Greeting second(@RequestParam(value = "name", defaultValue = "World") String name) {
		
		String text = testService.getString();
				
		Iterable<User> res = iUserPersistence.findAll();
	    StringBuffer b = new  StringBuffer();
		
		res.forEach(action ->
		{
			b.append(action.getName()+"\n");
		});
		
		return new Greeting(counter.incrementAndGet(), String.format(template,b.toString()));
	}
}