package in.myorg.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import in.myorg.dao.BookingFormRepository;
import in.myorg.entity.BookingForm;

@Service
public class BookingFormServiceImpl implements BookingFormService {

	private BookingFormRepository bookingFormRepository;

	@Autowired
	public void setBookingFormRepository(BookingFormRepository bookingFormRepository) {
		this.bookingFormRepository = bookingFormRepository;
	}

	@Override
	public BookingForm saveBookingFormService(BookingForm bookingForm) {

		return bookingFormRepository.save(bookingForm);
	}

	@Override
	public List<BookingForm> getAllBookingService() {

		return bookingFormRepository.findAll();
	}

	@Override
	public void deleteBooking(Integer id) {
		bookingFormRepository.deleteById(id);

	}

}
