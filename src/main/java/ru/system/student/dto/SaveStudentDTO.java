package ru.system.student.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class SaveStudentDTO {

  private String name;
  private String lastName;
  private String seria;
  private String number;
  private LocalDate birthDate;
  private String birthPlace;
  private String facultyName;
  private String phoneNumber;
  private String eMail;
  private String address;
}
