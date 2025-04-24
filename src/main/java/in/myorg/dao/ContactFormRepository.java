package in.myorg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.myorg.entity.ContactForm;

public interface ContactFormRepository extends JpaRepository<ContactForm, Integer> {

}
