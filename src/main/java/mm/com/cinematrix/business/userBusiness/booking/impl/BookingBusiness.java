package mm.com.cinematrix.business.userBusiness.booking.impl;

import lombok.extern.slf4j.Slf4j;
import mm.com.cinematrix.business.userBusiness.booking.IBookingBusiness;
import mm.com.cinematrix.business.dto.SampleBooking;
import mm.com.cinematrix.config.AppConfig;
import mm.com.cinematrix.db.model.Booking;
import mm.com.cinematrix.db.repo.BookingRepo;
import mm.com.cinematrix.util.EncryptionUtil;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class BookingBusiness implements IBookingBusiness {

    private final BookingRepo bookingRepo;

    private final AppConfig appConfig;

    public BookingBusiness(BookingRepo bookingRepo, AppConfig appConfig) {
        this.bookingRepo = bookingRepo;
        this.appConfig = appConfig;
    }

    public SampleBooking sampleBook(Booking booking) {
        bookingRepo.save(booking);
        String qrStr = EncryptionUtil.encrypt(booking.getBookingId(), appConfig.getAppSecret(), "showKey");

        SampleBooking sampleBookingResponse = new SampleBooking();
        sampleBookingResponse.setMovieId(booking.getMovieId());
        sampleBookingResponse.setQrString(qrStr);
        return sampleBookingResponse;
    }
}
