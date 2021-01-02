package com.hamidreza.multipleroom.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Manager(
    @PrimaryKey(autoGenerate = false)
    val managerName:String,
    val age:Int,
    val collegeName:String
)