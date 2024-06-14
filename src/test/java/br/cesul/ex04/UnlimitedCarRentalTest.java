package br.cesul.ex04;

import br.cesul.ex04.exception.UnfinishedRentalException;
import br.cesul.ex04.utils.DateUtils;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class UnlimitedCarRentalTest {

    @Test
    void testCalculateCarRentalWithInsurance() throws UnfinishedRentalException {
        var dateUtils = mock(DateUtils.class);

        var yesterday = LocalDate.now().minusDays(1);
        var finishDate = yesterday.plusDays(5);

        when(dateUtils.getToday())
                .thenReturn(yesterday)
                .thenReturn(finishDate);

        var rental = new UnlimitedCarRental(
                dateUtils,
                "ABC-1234",
                "João da Silva",
                "123456",
                200d,
                true
        );

        rental.finish();

        assertEquals(1380, rental.getRentalTotal(), 0.01);
    }

}
