package br.cesul.ex03;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ServiceTest {

    @Test
    @DisplayName("Service object creation")
    void testServiceObjectCreation() {
        var service = new Service("Service1", 100.0, ServiceCategory.STANDARD, 5.0, 2.0);
        assertEquals("Service1", service.getName());
        assertEquals(100.0, service.getPrice());
        assertEquals(ServiceCategory.STANDARD, service.getCategory());
        assertEquals(5.0, service.getIss());
        assertEquals(2.0, service.getTime());
    }

    @Test
    @DisplayName("Final price calculation for standard service")
    void testFinalPriceCalculationForStandardService() {
        var service = new Service("Service1", 100.0, ServiceCategory.STANDARD, 5.0, 2.0);
        assertEquals(216.3, service.getFinalPrice(), 0.001);
    }

    @Test
    @DisplayName("Final price calculation for superior service")
    void testFinalPriceCalculationForSuperiorService() {
        var service = new Service("Service1", 100.0, ServiceCategory.SUPERIOR, 5.0, 2.0);
        assertEquals(220.5, service.getFinalPrice(), 0.001);
    }

    @Test
    @DisplayName("Final price calculation for premium service")
    void testFinalPriceCalculationForMasterService() {
        var service = new Service("Service1", 100.0, ServiceCategory.MASTER, 5.0, 2.0);
        assertEquals(231d, service.getFinalPrice(), 0.001);
    }

    @Test
    @DisplayName("Final price calculation with zero time")
    void testFinalPriceCalculationWithZeroTime() {
        var service = new Service("Service1", 100.0, ServiceCategory.STANDARD, 5.0, 0.0);
        assertEquals(0d, service.getFinalPrice(), 0.001);
    }

    @Test
    @DisplayName("Final price calculation with zero price")
    void testFinalPriceCalculationWithZeroPrice() {
        var service = new Service("Service1", 0.0, ServiceCategory.STANDARD, 5.0, 2.0);
        assertEquals(0d, service.getFinalPrice(), 0.001);
    }

    @Test
    @DisplayName("Final price calculation with zero iss")
    void testFinalPriceCalculationWithZeroIss() {
        var service = new Service("Service1", 100.0, ServiceCategory.STANDARD, 0.0, 2.0);
        assertEquals(206d, service.getFinalPrice(), 0.001);
    }
}