package com.hamidreza.multipleroom.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Professor(
    @PrimaryKey(autoGenerate = false)
    val professorName:String,
    val age:Int,
)