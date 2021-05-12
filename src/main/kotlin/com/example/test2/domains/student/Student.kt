package com.example.test2.domains.student

import com.example.test2.domains.mentor.Mentor
import com.fasterxml.jackson.annotation.JsonInclude
import java.util.*

@JsonInclude(JsonInclude.Include.NON_NULL)
data class Student(
    var id: UUID? = null,
    var name: String,
    var mentor: Mentor? = null
) {

    fun toEntity(): StudentEntity {
        return StudentEntity(
            id = id,
            name = name,
            mentor = mentor?.toEntity()
        )
    }
}
