package com.hamidreza.multipleroom.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Course(
    @PrimaryKey(autoGenerate = false)
    val courseName:String,
    val courseCode:Int
)
