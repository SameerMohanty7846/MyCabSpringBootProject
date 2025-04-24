package in.myorg.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import in.myorg.entity.BookingForm;

public interface BookingFormRepository extends JpaRepository<BookingForm, Integer> {

}
