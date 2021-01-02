package com.hamidreza.multipleroom.data.local.relations

import androidx.room.Embedded
import androidx.room.Relation
import com.hamidreza.multipleroom.data.local.entities.College
import com.hamidreza.multipleroom.data.local.entities.Student

data class CollegeWithStudents(
    @Embedded val college: College,
    @Relation(
        parentColumn = "collegeName",
        entityColumn = "collegeName"
    )
    val students:List<Student>
)
