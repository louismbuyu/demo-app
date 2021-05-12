package com.example.test2.domains.student

data class StudentRequest(
    var name: String
) {

    fun toEntity(): StudentEntity {
        return StudentEntity(
            name = name
        )
    }
}