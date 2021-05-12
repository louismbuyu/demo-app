package com.example.test2.domains.mentor

import org.springframework.data.repository.CrudRepository
import java.util.*

interface MentorRepository: CrudRepository<MentorEntity, UUID> {
}