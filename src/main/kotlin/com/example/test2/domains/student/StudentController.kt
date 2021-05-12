package com.example.test2.domains.student

import org.springframework.web.bind.annotation.*
import java.util.*

@RestController
@RequestMapping("/student")
class StudentController (val studentService: StudentService) {

    @PostMapping
    fun createStudent(@RequestBody studentRequest: StudentRequest): Student {
        return studentService.createStudent(studentRequest=studentRequest)
    }

    @GetMapping
    fun getStudents(): List<Student> {
        return studentService.getStudents()
    }

    @PutMapping("/assign/{studentId}/mentor/{mentorId}")
    fun assignMentor(@PathVariable studentId: UUID, @PathVariable mentorId: UUID): Student {
        return studentService.assignMentor(studentId=studentId,mentorId=mentorId)
    }
}