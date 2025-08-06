package ru.system.student.model;

import lombok.*;

import java.time.LocalDate;
import java.util.Objects;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Passport {
  private String name;
  private String lastName;
  private LocalDate birthDate;
  private String birthPlace;
  private String seria;
  private String number;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Passport passport = (Passport) o;
    return Objects.equals(name, passport.name)
            && Objects.equals(lastName, passport.lastName)
            && Objects.equals(birthDate, passport.birthDate)
            && Objects.equals(birthPlace, passport.birthPlace)
            && Objects.equals(seria, passport.seria)
            && Objects.equals(number, passport.number);

  }

  @Override
  public int hashCode() {
    return Objects.hash(name, lastName, birthDate, birthPlace, seria, number);
  }
}
