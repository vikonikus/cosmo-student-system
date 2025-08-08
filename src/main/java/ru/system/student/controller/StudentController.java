package ru.system.student.controller;

import ru.system.student.dto.DeleteStudentDTO;
import ru.system.student.dto.GetStudentDTO;
import ru.system.student.dto.SaveStudentDTO;
import ru.system.student.model.Student;
import ru.system.student.service.StudentService;
import ru.system.student.service.impl.StudentServiceImpl;

public class StudentController {

  StudentService studentService = new StudentServiceImpl();

  public String getStudent(GetStudentDTO studentDTO) {
    return studentService.getStudent(studentDTO.getSeria(), studentDTO.getNumber());
  }

  public boolean deleteStudent(DeleteStudentDTO studentDTO) {
    return studentService.deleteStudent(studentDTO.getSeria(), studentDTO.getNumber());
  }

  public boolean saveStudent(SaveStudentDTO saveStudentDTO) {
    return studentService.saveStudent(saveStudentDTO.getName(), saveStudentDTO.getLastName(), saveStudentDTO.getSeria(),
            saveStudentDTO.getNumber(), saveStudentDTO.getBirthDate(), saveStudentDTO.getBirthPlace(),
            saveStudentDTO.getFacultyName(), saveStudentDTO.getPhoneNumber(), saveStudentDTO.getEMail(),
            saveStudentDTO.getAddress());

  }
}
