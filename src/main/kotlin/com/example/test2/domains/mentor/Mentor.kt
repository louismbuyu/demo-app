package com.example.test2.domains.mentor

import com.example.test2.domains.student.Student
import java.util.*

data class Mentor(
    var id: UUID? = null,
    var name: String,
    var students: MutableSet<Student> = mutableSetOf()
) {

    fun toEntity(): MentorEntity {
        return MentorEntity(
            id = id,
            name = name,
            students = students.map { it.toEntity() }.toMutableSet()
        )
    }
}