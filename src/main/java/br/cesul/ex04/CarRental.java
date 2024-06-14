package br.cesul.ex04;

import br.cesul.ex04.exception.UnfinishedRentalException;
import br.cesul.ex04.utils.DateUtils;

import java.time.LocalDate;

public abstract class CarRental {

    protected static final double INSURANCE_FEE = 1.15;

    private final String plate;
    private final String customer;
    private final String license;
    protected final Double price;
    protected final boolean insurance;

    private RentalStatus status;

    protected LocalDate startDate;
    protected LocalDate finishDate;

    protected DateUtils dateUtils;

    public CarRental(DateUtils dateUtils, String plate, String customer, String license, Double price, boolean insurance) {
        this.dateUtils = dateUtils;

        this.plate = plate;
        this.customer = customer;
        this.license = license;
        this.price = price;
        this.insurance = insurance;

        this.status = RentalStatus.IN_PROGRESS;
        this.startDate = dateUtils.getToday();
    }

    public abstract double getRentalTotal() throws UnfinishedRentalException;

    protected void finish() {
        this.status = RentalStatus.FINISHED;
        this.finishDate = dateUtils.getToday();
    }

    protected void validateFinishedRental() throws UnfinishedRentalException{
        if (status != RentalStatus.FINISHED) {
            throw new UnfinishedRentalException();
        }
    }

    protected double getInsuranceForRental(double rentalValue) {
        return insurance ? rentalValue * INSURANCE_FEE : rentalValue;
    }

    public String getPlate() {
        return plate;
    }

    public String getCustomer() {
        return customer;
    }

    public String getLicense() {
        return license;
    }

    public Double getPrice() {
        return price;
    }

    public boolean isInsurance() {
        return insurance;
    }

    public RentalStatus getStatus() {
        return status;
    }

    public LocalDate getFinishDate() {
        return finishDate;
    }
}
