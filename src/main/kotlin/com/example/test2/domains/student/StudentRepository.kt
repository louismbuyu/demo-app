package com.example.test2.domains.student

import org.springframework.data.repository.CrudRepository
import java.util.*

interface StudentRepository: CrudRepository<StudentEntity, UUID> {
}