package com.example.test2.domains.student

import com.example.test2.domains.mentor.MentorService
import org.springframework.stereotype.Service
import java.util.*

@Service
class StudentService(val studentRepository: StudentRepository, val mentorService: MentorService) {

    fun createStudent(studentRequest: StudentRequest): Student {
        return studentRepository.save(studentRequest.toEntity()).toModel()
    }

    fun getStudents(): List<Student> {
        return studentRepository.findAll().map { it.toModel() }
    }

    fun assignMentor(studentId: UUID, mentorId: UUID): Student {

        var optionalStudentEntity = studentRepository.findById(studentId)

        if (optionalStudentEntity.isEmpty){
            //Throw error
        }

        var updatedStudentEntity = optionalStudentEntity.get().apply {
            mentor = mentorService.getMentor(mentorId).toEntity()
        }

        return studentRepository.save(updatedStudentEntity).toModel()
    }
}