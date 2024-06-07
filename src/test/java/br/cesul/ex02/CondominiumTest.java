package br.cesul.ex02;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.Month;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class CondominiumTest {

    @Test
    public void testCondominiumOnDueDate() {
        var condominium = new Condominium(
                1000D,
                3000D,
                1500D,
                500D,
                15,
                LocalDate.now());

        assertEquals(400D, condominium.getFee());
    }

    @Test
    public void testCondominiumOverdue() {
        var dueDate = LocalDate.of(2024, Month.JUNE, 1);

        var condominium = new Condominium(
                1000D,
                3000D,
                1500D,
                500D,
                15,
                dueDate);

        assertEquals(440D, condominium.getFee());
    }

}
