package com.example.userstories.controller;

import com.example.userstories.entity.Student;
import com.example.userstories.service.StudentService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
public class StudentControllerTest {

    @Mock
    private StudentService studentService;

    @InjectMocks
    private StudentController studentController;

    @Test
    public void testGetAllStudents() {
        List<Student> students = Arrays.asList(new Student(), new Student());
        when(studentService.getAll()).thenReturn(students);

        ResponseEntity<List<Student>> responseEntity = studentController.getAll();

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(students, responseEntity.getBody());
    }

    @Test
    public void testGetStudentById() {
        int studentId = 1;
        Student student = new Student();
        when(studentService.getById(studentId)).thenReturn(student);

        ResponseEntity<Student> responseEntity = studentController.getById(studentId);

        assertEquals(HttpStatus.OK, responseEntity.getStatusCode());
        assertEquals(student, responseEntity.getBody());
    }

    @Test
    public void testCreateStudent() {
        Student studentToCreate = new Student();
        when(studentService.create(any(Student.class))).thenReturn(studentToCreate);

        ResponseEntity<Student> responseEntity = studentController.create(studentToCreate);

        assertEquals(HttpStatus.CREATED, responseEntity.getStatusCode());
        assertEquals(studentToCreate, responseEntity.getBody());
    }

    @Test
    public void testUpdateStudent() {
        int studentId = 1;
        Student existingStudent = new Student();
        Student updatedStudent = new Student();
        when(studentService.update(eq(studentId), any(Student.class))).thenReturn(updatedStudent);

        ResponseEntity<Student> responseEntity = studentController.update(studentId, updatedStudent);

        assertEquals(HttpStatus.ACCEPTED, responseEntity.getStatusCode());
        assertEquals(updatedStudent, responseEntity.getBody());
    }

    @Test
    public void testDeleteStudent() {
        int studentId = 1;
        ResponseEntity responseEntity = studentController.delete(studentId);
        assertEquals(HttpStatus.NO_CONTENT, responseEntity.getStatusCode());
        verify(studentService, times(1)).delete(studentId);
    }
}
