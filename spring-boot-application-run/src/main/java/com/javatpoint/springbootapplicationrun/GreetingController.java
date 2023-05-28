package com.javatpoint.springbootapplicationrun;
import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();
	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value="name",defaultValue="World")String name) {
		return new Greeting(counter.incrementAndGet(),String.format(template, name));
	}
	@PostMapping("/register")
	public Account registerAccount(@RequestBody Account account) {
		return new Account(account.getAccount_id(),account.getUsername(),account.getPassword());
	}
	
}
