package br.cesul.ex04;

import br.cesul.ex04.exception.UnfinishedRentalException;
import br.cesul.ex04.utils.DateUtils;
import br.cesul.ex04.utils.DateUtilsImpl;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class DistanceCarRentalTest {

    private final DateUtils dateUtils = new DateUtilsImpl();

    @Test
    @DisplayName("Tries to calculate total for unfinished rental")
    void testTryCalculateUnfinishedRental() {
        var carRental = new DistanceCarRental(
                dateUtils,
                "ABC-1234",
                "João da Silva",
                "123456",
                2d,
                true,
                1000d);

        assertThrows(UnfinishedRentalException.class, () -> carRental.getRentalTotal());
    }

    @Test
    @DisplayName("Tries to finish rental without used distance")
    void testTryFinishRentalWithoutUsedDistance() {
        var carRental = new DistanceCarRental(
                dateUtils,
                "ABC-1234",
                "João da Silva",
                "123456",
                2d,
                true,
                1000d);

        assertThrows(IllegalStateException.class, () -> carRental.finish());
    }
}
