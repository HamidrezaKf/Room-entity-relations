package com.hamidreza.multipleroom.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Student(
    @PrimaryKey(autoGenerate = false)
    val studentName:String,
    val email:String
)
