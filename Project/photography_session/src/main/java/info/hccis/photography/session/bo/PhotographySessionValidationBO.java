package info.hccis.photography.session.bo;

import info.hccis.photography.session.jpa.entity.PhotographySession;

import java.time.LocalDate;
import java.util.ArrayList;

public class PhotographySessionValidationBO {
    /**
     * Validate the date of booking. If you enter the date before the current date, it will show validation
     * @param photographySession
     * @return the cost
     * @since 20241207
     * @author Vy Phan
     */
    public ArrayList<String> validateBookingDate(PhotographySession photographySession) {

        ArrayList<String> errors = new ArrayList<>();

        String date = photographySession.getDate();
        if (date.length() != 10) {
            errors.add("Booking date must be 10 length");
        }

        if (errors.isEmpty()) {
            try {
                LocalDate localDateBookingDate = LocalDate.parse(date);

                LocalDate currentDate = LocalDate.now();
//                LocalDate oneDayBefore = currentDate.minusDays(1);

                if (localDateBookingDate.isBefore(currentDate)) {
                    errors.add("Booking date cannot before the current date");
                }
            } catch (Exception e) {
                errors.add("Could not parse start date");
            }
        }
        //TODO Add validation to ensure start date is not > 1 month in the future.

        return errors;
    }

}


