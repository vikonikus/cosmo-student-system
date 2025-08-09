package ru.system.student.controller;

import ru.system.student.dto.DeleteStudentDTO;
import ru.system.student.dto.GetStudentDTO;
import ru.system.student.dto.SaveStudentDTO;
import ru.system.student.model.Faculty;
import ru.system.student.model.Student;
import ru.system.student.service.StudentService;
import ru.system.student.service.impl.StudentServiceImpl;

import static ru.system.student.database.Database.FACULTIES;
import static ru.system.student.validation.StudentValidation.validateSeriaAndNumber;

public class StudentController {

  StudentService studentService = new StudentServiceImpl();

  public String getStudent(GetStudentDTO studentDTO) {
    String validationMessage = validateSeriaAndNumber(studentDTO.getSeria(), studentDTO.getNumber());
    if (validationMessage == null) {
      return studentService.getStudent(studentDTO.getSeria(), studentDTO.getNumber());
    }
    return validationMessage;
  }

  public boolean deleteStudent(DeleteStudentDTO studentDTO) {
    if (studentDTO.getSeria().length() != 4) {
      return false;
    }
    if (studentDTO.getNumber().length() != 6) {
      return false;
    }
    return studentService.deleteStudent(studentDTO.getSeria(), studentDTO.getNumber());
  }

  public boolean saveStudent(SaveStudentDTO saveStudentDTO) {
    Faculty faculty = FACULTIES
            .stream()
            .filter(facValue -> facValue.getName().equals(saveStudentDTO.getFacultyName()))
            .findFirst()
            .orElse(null);
    if (faculty != null) {
      return studentService.saveStudent(saveStudentDTO.getName(), saveStudentDTO.getLastName(), saveStudentDTO.getSeria(),
              saveStudentDTO.getNumber(), saveStudentDTO.getBirthDate(), saveStudentDTO.getBirthPlace(),
              faculty, saveStudentDTO.getPhoneNumber(), saveStudentDTO.getEMail(),
              saveStudentDTO.getAddress());
    } else {
      return false;
    }
  }
}
