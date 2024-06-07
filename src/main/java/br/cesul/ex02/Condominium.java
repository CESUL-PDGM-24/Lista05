package br.cesul.ex02;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

public class Condominium {

    private Double waterBill;

    private Double maintenanceFee;

    private Double reserveFund;

    private Double otherFees;

    private Integer numberOfApartments;

    private LocalDate dueDate;

    public Condominium(Double waterBill, Double maintenanceFee, Double reserveFund, Double otherFees, Integer numberOfApartments, LocalDate dueDate) {
        this.waterBill = waterBill;
        this.maintenanceFee = maintenanceFee;
        this.reserveFund = reserveFund;
        this.otherFees = otherFees;
        this.numberOfApartments = numberOfApartments;
        this.dueDate = dueDate;
    }

    public Double getFee() {
        var today = LocalDate.now();
        var diff = dueDate.until(today, ChronoUnit.DAYS);

        if (diff > 0) {
            return calculateFee(diff);
        }

        return calculateFee();
    }

    private Double calculateFee() {
        return (waterBill + maintenanceFee + reserveFund + otherFees) / numberOfApartments;
    }

    private Double calculateFee(long daysOfDelay) {
        var baseFee = calculateFee();
        return baseFee + (baseFee * 0.05) + (baseFee * 0.01 * daysOfDelay);
    }

    public Double getWaterBill() {
        return waterBill;
    }

    public void setWaterBill(Double waterBill) {
        this.waterBill = waterBill;
    }

    public Double getMaintenanceFee() {
        return maintenanceFee;
    }

    public void setMaintenanceFee(Double maintenanceFee) {
        this.maintenanceFee = maintenanceFee;
    }

    public Double getReserveFund() {
        return reserveFund;
    }

    public void setReserveFund(Double reserveFund) {
        this.reserveFund = reserveFund;
    }

    public Double getOtherFees() {
        return otherFees;
    }

    public void setOtherFees(Double otherFees) {
        this.otherFees = otherFees;
    }

    public Integer getNumberOfApartments() {
        return numberOfApartments;
    }

    public void setNumberOfApartments(Integer numberOfApartments) {
        this.numberOfApartments = numberOfApartments;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }
}
