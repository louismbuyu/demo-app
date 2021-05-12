package com.example.test2.domains.mentor

import org.springframework.stereotype.Service
import java.util.*

@Service
class MentorService (val mentorRepository: MentorRepository) {

    fun createMentor(mentorRequest: MentorRequest): Mentor {
        return mentorRepository.save(mentorRequest.toEntity()).toModel()
    }

    fun getMentors(): List<Mentor> {
        return mentorRepository.findAll().map { it.toModel() }
    }

    fun getMentor(mentorId: UUID): Mentor {

        var optionalMentorEntity = mentorRepository.findById(mentorId)

        if (optionalMentorEntity.isEmpty) {
            //Throw error
        }

        return optionalMentorEntity.get().toModel()
    }
}