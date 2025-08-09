package ru.system.student.view;

import ru.system.student.controller.StudentController;
import ru.system.student.dto.DeleteStudentDTO;
import ru.system.student.dto.GetStudentDTO;
import ru.system.student.dto.SaveStudentDTO;
import ru.system.student.model.Student;

import java.time.LocalDate;
import java.util.Scanner;

import static ru.system.student.util.DateUtils.formatStringToDate;

public class StudentView {

  private final static StudentController studentController = new StudentController();

  public static void runInterface() {
    System.out.println("-------------------------------");
    System.out.println("1. Найти студента");
    System.out.println("2. Удалить студента");
    System.out.println("3. Добавить студента");

    Scanner scanner = new Scanner(System.in);
    int choice = 0;
    try {
      choice = scanner.nextInt();
    } catch (NumberFormatException exception) {
      System.out.println("Введите корректные данные!");
      runInterface();
    }

    if (choice == 1) {
      try {
        String value = getStudent();
        System.out.println(value);
        runInterface();
      } catch (NullPointerException exception) {
        System.out.println("Студент не найден!");
        runInterface();
      }
    } else if (choice == 2) {
      boolean isDeleted = deleteStudent();
      if (isDeleted) {
        System.out.println("Студен успешно удален");
        runInterface();
      } else {
        System.out.println("Ошибка при удалении студента! Перепроверте данные!");
        runInterface();
      }
    } else if (choice == 3) {
      boolean isSaved = saveStudent();
      if (isSaved) {
        System.out.println("Студен успешно создан");
        runInterface();
      } else {
        System.out.println("Ошибка при создании студента! Перепроверте данные!");
        runInterface();
      }
    } else {
      System.out.println("Введите корректные данные!");
      runInterface();
    }
  }

  private static boolean saveStudent() {
    System.out.println("Введите серию паспорта:");
    Scanner scanner = new Scanner(System.in);
    String seria = scanner.nextLine();
    System.out.println("Введите номер паспорта:");
    scanner = new Scanner(System.in);
    String number = scanner.nextLine();
    System.out.println("Введите адрес:");
    scanner = new Scanner(System.in);
    String address = scanner.nextLine();
    System.out.println("Введите имя:");
    scanner = new Scanner(System.in);
    String name = scanner.nextLine();
    System.out.println("Введите фамилию:");
    scanner = new Scanner(System.in);
    String lastName = scanner.nextLine();
    System.out.println("Введите дату рождения (в формате yyyy-mm-dd):");
    scanner = new Scanner(System.in);
    String birthDate = scanner.nextLine();
    LocalDate birthDateFormatted = formatStringToDate(birthDate);
    System.out.println("Введите место рождения:");
    scanner = new Scanner(System.in);
    String birthPlace = scanner.nextLine();
    System.out.println("Введите факультет:");
    scanner = new Scanner(System.in);
    String faculty = scanner.nextLine();
    System.out.println("Введите номер телефона:");
    scanner = new Scanner(System.in);
    String phoneNumber = scanner.nextLine();
    System.out.println("Введите электронную почту:");
    scanner = new Scanner(System.in);
    String eMail = scanner.nextLine();

    SaveStudentDTO saveStudentDTO = new SaveStudentDTO(name, lastName, seria, number, birthDateFormatted,
            birthPlace, faculty, phoneNumber, eMail, address);
    return studentController.saveStudent(saveStudentDTO);
  }

  private static boolean deleteStudent() {
    System.out.println("Введите серию паспорта:");
    Scanner scanner = new Scanner(System.in);
    String seria = scanner.nextLine();
    System.out.println("Введите номер паспорта:");
    scanner = new Scanner(System.in);
    String number = scanner.nextLine();
    DeleteStudentDTO deleteStudentDTO = new DeleteStudentDTO(seria, number);
    return studentController.deleteStudent(deleteStudentDTO);
  }

  private static String getStudent() {
    System.out.println("Введите серию паспорта:");
    Scanner scanner = new Scanner(System.in);
    String seria = scanner.nextLine();
    System.out.println("Введите номер паспорта:");
    scanner = new Scanner(System.in);
    String number = scanner.nextLine();
    GetStudentDTO studentDTO = new GetStudentDTO(seria, number);
    return studentController.getStudent(studentDTO);
  }
}
