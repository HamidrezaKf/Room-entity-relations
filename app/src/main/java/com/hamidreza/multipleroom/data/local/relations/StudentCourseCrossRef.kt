package com.hamidreza.multipleroom.data.local.relations

import androidx.room.Entity

@Entity(primaryKeys = ["studentName","courseName"])
data class StudentCourseCrossRef(
    val studentName:String,
    val courseName:String
)
