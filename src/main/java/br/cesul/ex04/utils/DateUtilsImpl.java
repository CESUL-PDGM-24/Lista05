package br.cesul.ex04.utils;

import java.time.LocalDate;

public class DateUtilsImpl implements DateUtils {

    public LocalDate getToday() {
        return LocalDate.now();
    }
}
