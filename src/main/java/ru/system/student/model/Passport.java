package ru.system.student.model;

import lombok.*;

import java.time.LocalDate;

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



}
