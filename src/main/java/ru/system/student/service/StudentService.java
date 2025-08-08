package ru.system.student.service;

import ru.system.student.model.Student;

import java.time.LocalDate;

public interface StudentService {
  String getStudent(String seria, String number);
  boolean deleteStudent(String seria, String number);
  boolean saveStudent(String name, String lastName, String seria, String number,
                      LocalDate birthDate, String birthPlace, String facultyName,
                      String phoneNumber, String eMail, String address);

}
