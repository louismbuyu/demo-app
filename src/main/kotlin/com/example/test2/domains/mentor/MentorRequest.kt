package com.example.test2.domains.mentor

data class MentorRequest(
    var name: String
) {
    fun toEntity(): MentorEntity {
        return MentorEntity(
            name = name
        )
    }
}