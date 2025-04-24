package in.myorg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.myorg.dao.ContactFormRepository;
import in.myorg.entity.ContactForm;

@Service
public class ContactFormServiceImpl implements ContactFormService {

	private ContactFormRepository contactFormRepository;

	@Autowired
	public void setContactFormRepository(ContactFormRepository contactFormRepository) {
		this.contactFormRepository = contactFormRepository;
	}

	@Override
	public ContactForm saveContactForm(ContactForm cf) {

		return contactFormRepository.save(cf);
	}

	@Override
	public List<ContactForm> getAllContactService() {

		return contactFormRepository.findAll();
	}

	@Override
	public void deleteById(Integer id) {
		contactFormRepository.deleteById(id);

	}

}
