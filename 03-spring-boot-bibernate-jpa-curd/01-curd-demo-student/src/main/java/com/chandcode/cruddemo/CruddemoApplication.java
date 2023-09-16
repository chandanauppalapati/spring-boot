package com.chandcode.cruddemo;

import com.chandcode.cruddemo.dao.StudentDAO;
import com.chandcode.cruddemo.entity.Student;
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
			//createStudent(studentDAO);

			createMultipleStudents(studentDAO);

			//readStudent(studentDAO);

			//queryForStudents(studentDAO);

			//queryForStudentsByLastNAme(studentDAO);

			//updateStudent(studentDAO);
			
			//deleteStudent(studentDAO);

			// deleteAllStudents(studentDAO);
		};
	}

	private void deleteAllStudents(StudentDAO studentDAO) {

		System.out.println("Deleting all students");
		int numberRowsDeleted = studentDAO.deleteAll();

		System.out.println("Deleted row count: " + numberRowsDeleted);
	}

	private void deleteStudent(StudentDAO studentDAO) {

		//delete the student
		int studentId = 3 ;

		System.out.println("Deleted student id: "+ studentId);

		studentDAO.delete(studentId);
	}

	private void updateStudent(StudentDAO studentDAO) {

		// retrieve student based on the id: primary key
		int studentId = 1 ;
		System.out.println("Getting student with id: " + studentId);
		Student myStudent = studentDAO.findById(studentId);

		// change first name to "Sai"
		System.out.println("Updating student ...");
		myStudent.setFirstName("Sai");

		// update the student
		studentDAO.update(myStudent);

		// display the updated student
		System.out.println("Updated student: " + myStudent);


	}

	private void queryForStudentsByLastNAme(StudentDAO studentDAO) {

		//get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Y");

		// display list of students
		for (Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {

		// get a list of students
		List<Student> theStudents = studentDAO.findAll();

		//display list of students
		for(Student tempStudent : theStudents) {
			System.out.println(tempStudent);
		}

	}

	private void readStudent(StudentDAO studentDAO) {

		// create student object
		System.out.println("Creating new student object....");
		Student tempStudent = new Student("Tim","H","timh@xyx.com");

		// save the student
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student, Generated Id: "+ theId);

		// retrieve student based on the id: primary key
		System.out.println("Retrieving student with id: "+ theId);
		Student myStudent = studentDAO.findById(theId);

		// display student
		System.out.println("Found the student: "+ myStudent);

	}

	private void createMultipleStudents(StudentDAO studentDAO) {

		// create multiple students
		System.out.println("Creating three student object ...");
		Student tempStudent1 = new Student("Satya","Y", "satya@xyz.com");
		Student tempStudent2 = new Student("Sitara","Y", "sitara@xyz.com");
		Student tempStudent3 = new Student("Vijaya","U", "vijaya@xyz.com");

		// save the students
		System.out.println("Saving the students .....");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);
	}

	private void createStudent(StudentDAO studentDAO) {

		// create the student object
		System.out.println("Creating new student object ...");
		Student tempStudent = new Student("chand","u", "cu@xyz.com");

		//save the student object
		System.out.println("Saving the student .....");
		studentDAO.save(tempStudent);

		//display id of the saved student
		System.out.println("Saved student. Generated Id: " +tempStudent.getId());

	}
}
