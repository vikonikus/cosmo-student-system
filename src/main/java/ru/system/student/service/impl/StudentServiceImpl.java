package ru.system.student.service.impl;

import ru.system.student.model.Faculty;
import ru.system.student.model.Passport;
import ru.system.student.model.Student;
import ru.system.student.service.StudentService;

import java.time.LocalDate;

import static ru.system.student.database.Database.FACULTIES;
import static ru.system.student.database.Database.STUDENTS;

public class StudentServiceImpl implements StudentService {

  @Override
  public String getStudent(String seria, String number) {
    Passport passport = STUDENTS.keySet()
            .stream()
            .filter(student -> student.getSeria().equals(seria) && student.getNumber().equals(number))
            .findFirst().orElse(null);
    return STUDENTS.get(passport).toString();
  }

  @Override
  public boolean deleteStudent(String seria, String number) {
    STUDENTS.keySet()
            .stream()
            .filter(student -> student.getSeria().equals(seria) && student.getNumber().equals(number))
            .forEach(STUDENTS::remove);
    return true;
  }

  @Override
  public boolean saveStudent(String name, String lastName, String seria, String number,
                             LocalDate birthDate, String birthPlace, String facultyName,
                             String phoneNumber, String eMail, String address) {
    Passport passport = new Passport(name, lastName, birthDate, birthPlace, seria, number);
    Faculty faculty = FACULTIES
            .stream()
            .filter(facValue -> facValue.getName().equals(facultyName))
            .findFirst()
            .orElse(null);

    Student student = new Student(phoneNumber, eMail, address, faculty);
    STUDENTS.put(passport, student);
    return true;
  }
}
