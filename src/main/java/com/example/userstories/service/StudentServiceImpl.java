package com.example.userstories.service;

import com.example.userstories.entity.Computer;
import com.example.userstories.entity.Student;
import com.example.userstories.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    @Autowired
    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    @Override
    public Student getById(Integer id) {
        Optional<Student> optionalStudent = studentRepository.findById(id);
        return optionalStudent.orElse(null);
    }

    @Override
    public Student create(Student student) {
        return studentRepository.save(student);
    }

    @Override
    public Student update(Integer id, Student student) {
        if (studentRepository.existsById(id)) {
            student.setId(id);
            return studentRepository.save(student);
        }
        return null;
    }

    @Override
    public void delete(Integer id) {
        studentRepository.deleteById(id);
    }


    @Override
    public void appendNote(Integer id, String note) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        student.getNotes().add(note);

        studentRepository.save(student);
    }
    @Override
    public void deleteNote(Integer id, int noteIndex) {
        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));
        try {
            List<String> notes = student.getNotes();
            System.out.println(notes);
            notes.remove(noteIndex);
            System.out.println(notes);
            student.setNotes(notes);

        } catch (Exception e) {
            throw new RuntimeException(e);
        }


        studentRepository.save(student);
    }

}
