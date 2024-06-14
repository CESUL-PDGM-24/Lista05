package br.cesul.ex04;

import br.cesul.ex04.exception.UnfinishedRentalException;
import br.cesul.ex04.utils.DateUtils;

import java.time.temporal.ChronoUnit;

public class UnlimitedCarRental extends CarRental{

    public UnlimitedCarRental(DateUtils dateUtils, String plate, String customer, String license, Double price, boolean insurance) {
        super(dateUtils, plate, customer, license, price, insurance);
    }

    @Override
    public double getRentalTotal() throws UnfinishedRentalException {
        validateFinishedRental();

        var rentalDuration = startDate.until(finishDate, ChronoUnit.DAYS) + 1;
        var rentalTotal = rentalDuration * price;

        return getInsuranceForRental(rentalTotal);
    }
}
