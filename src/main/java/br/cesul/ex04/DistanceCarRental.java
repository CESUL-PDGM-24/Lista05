package br.cesul.ex04;

import br.cesul.ex04.exception.UnfinishedRentalException;
import br.cesul.ex04.utils.DateUtils;

public class DistanceCarRental extends CarRental{

    public static final double OVERUSE_FEE = 1.2;
    private final Double hiredDistance;

    private Double usedDistance;

    public DistanceCarRental(DateUtils dateUtils, String plate, String customer, String license, Double price, boolean insurance, Double hiredDistance) {
        super(dateUtils, plate, customer, license, price, insurance);
        this.hiredDistance = hiredDistance;
    }

    @Override
    public double getRentalTotal() throws UnfinishedRentalException {
        validateFinishedRental();

        var total = hiredDistance * price;

        if (usedDistance > hiredDistance) {
            var exceeded = (usedDistance - hiredDistance) * price;
            total += exceeded * OVERUSE_FEE;
        }

        return getInsuranceForRental(total);
    }

    @Override
    protected void finish() {
        throw new IllegalStateException();
    }

    public void finish(double usedDistance) {
        super.finish();
        this.usedDistance = usedDistance;
    }

    public Double getHiredDistance() {
        return hiredDistance;
    }

    public Double getUsedDistance() {
        return usedDistance;
    }
}
