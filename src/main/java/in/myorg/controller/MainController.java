package in.myorg.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller

public class MainController {

	@GetMapping("/home")
	public String loadIndex() {

		return "index";
	}

	@GetMapping("/about")

	public String loadAbout() {
		return "about";
	}

	@GetMapping("/cars")

	public String loadCars() {
		return "cars";
	}

	@GetMapping("/contacts")

	public String loadContact() {
		return "contacts";
	}

	@GetMapping("/services")

	public String loadService() {
		return "services";
	}

}
