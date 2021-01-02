package com.hamidreza.multipleroom.data.local.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.hamidreza.multipleroom.data.local.entities.Course
import com.hamidreza.multipleroom.data.local.entities.Student

data class StudentWithCourses(
    @Embedded val student: Student,
    @Relation(
        parentColumn = "studentName",
        entityColumn =  "courseName",
        associateBy = Junction(StudentCourseCrossRef::class)
    )
    val courses : List<Course>
)
