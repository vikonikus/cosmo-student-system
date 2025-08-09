package ru.system.student.util;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class DateUtils {
  public static LocalDate formatStringToDate(String date) {
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
    return LocalDate.parse(date, formatter);
  }
}
