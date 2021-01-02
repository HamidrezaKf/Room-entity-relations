package com.hamidreza.multipleroom.data.local.relations

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.hamidreza.multipleroom.data.local.entities.Course
import com.hamidreza.multipleroom.data.local.entities.Student

data class CourseWithStudents(
    @Embedded val course:Course,
    @Relation(
        parentColumn = "courseName",
        entityColumn = "studentName",
        associateBy = Junction(StudentCourseCrossRef::class)
    )
    val students : List<Student>
)
