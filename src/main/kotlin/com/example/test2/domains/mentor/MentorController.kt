package com.example.test2.domains.mentor

import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/mentor")
class MentorController(val mentorService: MentorService) {

    @PostMapping
    fun createMentor(@RequestBody mentorRequest: MentorRequest): Mentor {
        return mentorService.createMentor(mentorRequest)
    }

    @GetMapping
    fun getMentors(): List<Mentor> {
        return mentorService.getMentors()
    }
}