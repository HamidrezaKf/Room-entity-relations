package com.hamidreza.multipleroom.data.local.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class College(
    @PrimaryKey(autoGenerate = false)
    val collegeName:String,
    val address:String
)
