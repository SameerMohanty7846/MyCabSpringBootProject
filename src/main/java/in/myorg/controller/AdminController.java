package in.myorg.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import in.myorg.entity.BookingForm;
import in.myorg.entity.ContactForm;
import in.myorg.service.AdminCredentialsService;
import in.myorg.service.BookingFormService;
import in.myorg.service.ContactFormService;

@Controller
@RequestMapping("/admin")
public class AdminController {
	@Autowired
	private ContactFormService contactFormService;

	@Autowired
	private BookingFormService bookingFormService;

	@Autowired
	private AdminCredentialsService adminCredentialsService;

	@GetMapping("/dashboard")
	public String adminDashboard() {
		return "admin/dashboard";
	}

	@GetMapping("/readallcontacts")
	public String getAllContacts(Model m) {
		List<ContactForm> li = contactFormService.getAllContactService();
		m.addAttribute("allcontacts", li);
		return "admin/readallcontacts";
	}

	@GetMapping("/deleteContact/{id}")
	public String deleteContact(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		contactFormService.deleteById(id);

		redirectAttributes.addFlashAttribute("message", "CONTACT DELETED SUCCESSFULLY");
		return "redirect:/admin/readallcontacts";
	}

	@GetMapping("/readallbookings")
	public String getAllBookings(Model m) {
		List<BookingForm> li = bookingFormService.getAllBookingService();
		m.addAttribute("allbookings", li);
		return "admin/readallbookings";
	}

	@GetMapping("/deleteBooking/{id}")
	public String deleteBooking(@PathVariable Integer id, RedirectAttributes redirectAttributes) {
		bookingFormService.deleteBooking(id);

		redirectAttributes.addFlashAttribute("message", "BOOKING DELETED SUCCESSFULLY");
		return "redirect:/admin/readallbookings";
	}

	@GetMapping("/changecredentials")
	public String changeCredentialsView() {

		return "admin/changecredentials";
	}

	@PostMapping("/changecredentials")
	public String changeCredentials(

			@RequestParam("oldusername") String oldusername, @RequestParam("oldpassword") String oldpassword,
			@RequestParam("newusername") String newusername, @RequestParam("newpassword") String newpassword,
			RedirectAttributes redirectAttributes

	) {
		String result = adminCredentialsService.checkAdminCredentials(oldusername, oldpassword);
		System.out.println(result);
		// Here we will learn how to match the encrypted password with raw password

		if (result.equals("SUCCESS")) {
			String result2 = adminCredentialsService.updateAdminCredentials(newusername, newpassword, oldusername);

			redirectAttributes.addFlashAttribute("message", result2);

		} else {
			redirectAttributes.addFlashAttribute("message", "WRONG CREDENTIALS");
			return "redirect:/admin/changecredentials";
			
		}

		return "redirect:/admin/dashboard";
	}

}
