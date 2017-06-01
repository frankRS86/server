package main.java.web;

import java.util.concurrent.atomic.AtomicLong;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import main.java.hello.Greeting;

	@RestController
	public class DeviceAuthenticationResource {

		private static final String template = "Hello, %s!";
		private final AtomicLong counter = new AtomicLong();

		@RequestMapping("/login")
		public String login()
		{
			return "you need to login";
		}
	}
