package br.com.unicivcom.testapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@SpringBootApplication
public class TestApiApplication {

	private final MessageRepository messageRepository;

	@Autowired
	public TestApiApplication(MessageRepository messageRepository) {
		this.messageRepository = messageRepository;
	}

	public static void main(String[] args) {
		SpringApplication.run(TestApiApplication.class, args);
	}

	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Message> getAll(){
		return messageRepository.findAll();
	}

	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public void post(@RequestBody Message message){
		message.setId(UUID.randomUUID());
		messageRepository.save(message);
	}
}
