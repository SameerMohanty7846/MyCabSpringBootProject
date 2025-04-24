package in.myorg.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.myorg.entity.BookingForm;
import in.myorg.entity.ContactForm;
import in.myorg.service.BookingFormService;
import in.myorg.service.ContactFormService;
import jakarta.validation.Valid;

@Controller
public class MainController {

	private ContactFormService contactFormService;
	private BookingFormService bookingFormService;

	@Autowired
	public void setContactFormService(ContactFormService contactFormService) {
		this.contactFormService = contactFormService;
	}

	@Autowired
	public void setBookingFormService(BookingFormService bookingFormService) {
		this.bookingFormService = bookingFormService;
	}

	@GetMapping(path = { "/home", "/" })
	public String loadIndex(Model m) {
		m.addAttribute("bookingForm", new BookingForm());
		return "index";
	}

	@PostMapping("/bookingform")
	public String submitBooking(@Valid @ModelAttribute BookingForm bf, BindingResult bindingResult,
			RedirectAttributes redirectAttributes, Model m) {
		System.out.println(bf);
		if (bindingResult.hasErrors()) {
			m.addAttribute("bindingresult", bindingResult);

			return "index";

		}

		if (bf.getAdult() + bf.getChildren() > 4) {
			m.addAttribute("message", "The total number of adult and children can not exceed 4");

			return "index";
		}

		BookingForm saved = bookingFormService.saveBookingFormService(bf);
		if (saved == null) {
			redirectAttributes.addFlashAttribute("message", "PROCESSED");
		} else {
			redirectAttributes.addFlashAttribute("message", "CAN NOT BE PROCESSED");
		}

		redirectAttributes.addFlashAttribute("message", "PROCESSED");
		return "redirect:/home";

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
	public String loadContact(Model m) {
		ContactForm cf = new ContactForm();
		m.addAttribute("contactForm", cf);
		return "contacts";
	}

	@PostMapping("contactform")
	public String submitContact(@Valid @ModelAttribute ContactForm cf, BindingResult bindingResult, Model m,
			RedirectAttributes redirectAttributes) {

		System.out.println(cf);
		if (bindingResult.hasErrors()) {
			m.addAttribute("bindingresult", bindingResult);
			return "contacts";
		}

		ContactForm saved = contactFormService.saveContactForm(cf);
		if (saved != null) {
			redirectAttributes.addFlashAttribute("message", "message sent successfully");
		} else {
			redirectAttributes.addFlashAttribute("message", "message not sent ");

		}
		redirectAttributes.addFlashAttribute("message", " REQUEST SENT");
		return "redirect:/contacts";

	}

	@GetMapping("/services")
	public String loadService() {
		return "services";
	}

	@GetMapping("/login")
	public String loadLoginPage() {
		return "admin_login";
	}

}
