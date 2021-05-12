package com.example.test2.domains.student

import com.example.test2.domains.mentor.MentorEntity
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.*

@Table(name = "student")
@Entity
class StudentEntity (
    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    var id: UUID? = null,

    @Column(nullable = false)
    var name: String,

    @ManyToOne
    @JoinColumn
    var mentor: MentorEntity? = null
) {
    fun toModel(): Student {
        return Student(
            id = id,
            name = name,
            mentor = mentor?.toModel()
        )
    }
}