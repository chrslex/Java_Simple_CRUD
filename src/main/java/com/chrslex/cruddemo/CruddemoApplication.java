package com.chrslex.cruddemo;

import com.chrslex.cruddemo.dao.StudentDAO;
import com.chrslex.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

    public static void main(String[] args) {
        SpringApplication.run(CruddemoApplication.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
        return runner -> {
            updateStudent(studentDAO);
        };
    }

    private void createStudent(StudentDAO studentDAO) {
        // create the student object
        System.out.println("Creating new student object...");
        Student tempStudent = new Student("Name3", "Name3", "c_name@gmail.com");

        // save the student object
        System.out.println("Saving the student...");
        studentDAO.save(tempStudent);

        // display id of the saved student
        System.out.println("Saved student generated id: " + tempStudent.getId());
    }

    private void readStudent(StudentDAO studentDAO) {
        Student student = studentDAO.findById(1);
        System.out.println(student.getFirstName() +  " " + student.getLastName());
    }

    private void queryForStudents(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findALll();

        for(Student s : theStudents) {
            System.out.println(s);
        }
    }
    private void queryForStudentsByLastName(StudentDAO studentDAO) {
        List<Student> theStudents = studentDAO.findByLastName("Name3");

        for(Student s : theStudents) {
            System.out.println(s);
        }
    }

    private void updateStudent(StudentDAO studentDAO) {
        Student std = studentDAO.findById(3);
        std.setFirstName("Name1Updated");

        studentDAO.update(std);

        System.out.println("Updated student " + std);
    }

    private void deleteStudent(StudentDAO studentDAO) {

    }
}
