package br.cesul.ex03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ProductTest {

    @Test
    @DisplayName("Product object creation")
    void testProductObjectCreation() {
        var product = new Product("Product1", 100.0, 10.0, 5.0, 2);
        assertEquals("Product1", product.getName());
        assertEquals(100.0, product.getPrice());
        assertEquals(10.0, product.getIcms());
        assertEquals(5.0, product.getIpi());
        assertEquals(2, product.getQuantity());
    }

    @Test
    @DisplayName("Final price calculation with positive values")
    void testFinalPriceCalculationWithPositiveValues() {
        var product = new Product("Product1", 100.0, 10.0, 5.0, 2);
        assertEquals(230d, product.getFinalPrice(), 0.001);
    }

    @Test
    @DisplayName("Final price calculation with zero quantity")
    void testFinalPriceCalculationWithZeroQuantity() {
        var product = new Product("Product1", 100.0, 10.0, 5.0, 0);
        assertEquals(0d, product.getFinalPrice(), 0.001);
    }

    @Test
    @DisplayName("Final price calculation with zero price")
    void testFinalPriceCalculationWithZeroPrice() {
        var product = new Product("Product1", 0.0, 10.0, 5.0, 2);
        assertEquals(0d, product.getFinalPrice(), 0.001);
    }

    @Test
    @DisplayName("Final price calculation with zero taxes")
    void testFinalPriceCalculationWithZeroTaxes() {
        var product = new Product("Product1", 100.0, 0.0, 0.0, 2);
        assertEquals(200d, product.getFinalPrice(), 0.001);
    }
}