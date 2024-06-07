package br.cesul.ex03;

public class Service extends SaleItem {

    private final ServiceCategory category;
    private final Double iss;
    private final Double time;

    public Service(String name, Double price, ServiceCategory category, Double iss, Double time) {
        super(name, price);
        this.category = category;
        this.iss = iss;
        this.time = time;
    }

    @Override
    public Double getFinalPrice() {
        var total = price * time * getAdditionalFee();
        total += total * iss / 100;

        return total;
    }

    private double getAdditionalFee() {
        return switch (category) {
            case STANDARD -> 1.03;
            case SUPERIOR -> 1.05;
            default -> 1.1;
        };
    }

    public ServiceCategory getCategory() {
        return category;
    }

    public Double getIss() {
        return iss;
    }

    public Double getTime() {
        return time;
    }
}
