package com.example.test2.domains.mentor

import com.example.test2.domains.student.StudentEntity
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Table(name = "mentor")
@Entity
class MentorEntity (
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id: UUID? = null,

    @Column(nullable = false)
    var name: String,

    @OneToMany(mappedBy = "mentor")
    var students: MutableSet<StudentEntity> = mutableSetOf()
) {
    fun toModel(): Mentor {
        return Mentor(
            id = id,
            name = name,
            students = students.map { it.toModel() }.toMutableSet()
        )
    }
}