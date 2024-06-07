package br.cesul.ex03;

public class Product extends SaleItem {

    private final Double icms;
    private final Double ipi;
    private final Integer quantity;

    public Product(String name, Double price, Double icms, Double ipi, Integer quantity) {
        super(name, price);
        this.icms = icms;
        this.ipi = ipi;
        this.quantity = quantity;
    }

    @Override
    public Double getFinalPrice() {
        var total = quantity * price;
        return total + (total * icms / 100d) + (total * ipi / 100d);
    }

    public Double getIcms() {
        return icms;
    }

    public Double getIpi() {
        return ipi;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
