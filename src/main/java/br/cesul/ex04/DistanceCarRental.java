package br.cesul.ex04;

import br.cesul.ex04.exception.UnfinishedRentalException;

public class DistanceCarRental extends CarRental{

    public static final double OVERUSE_FEE = 1.2;
    private final Double hiredDistance;

    private Double usedDistance;

    public DistanceCarRental(String plate, String customer, String license, Double price, boolean insurance, Double hiredDistance) {
        super(plate, customer, license, price, insurance);
        this.hiredDistance = hiredDistance;
    }

    @Override
    public double getRentalTotal() throws UnfinishedRentalException {
        if (getStatus() != RentalStatus.FINISHED) {
            throw new UnfinishedRentalException();
        }

        var total = hiredDistance * price;

        if (usedDistance > hiredDistance) {
            var exceeded = (usedDistance - hiredDistance) * price;
            total += exceeded * OVERUSE_FEE;
        }

        return total;
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
