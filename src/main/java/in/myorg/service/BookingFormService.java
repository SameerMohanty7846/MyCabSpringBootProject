package in.myorg.service;

import java.util.List;

import in.myorg.entity.BookingForm;

public interface BookingFormService {
	 BookingForm saveBookingFormService(BookingForm bookingForm);
	 List<BookingForm> getAllBookingService();
	 void deleteBooking(Integer id);
}
