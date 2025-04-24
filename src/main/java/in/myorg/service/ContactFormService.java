package in.myorg.service;

import java.util.List;

import in.myorg.entity.ContactForm;

public interface ContactFormService {
	ContactForm saveContactForm(ContactForm cf);

	List<ContactForm> getAllContactService();

	void deleteById(Integer id);
}
