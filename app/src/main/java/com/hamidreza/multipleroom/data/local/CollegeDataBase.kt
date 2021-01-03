package com.hamidreza.multipleroom.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hamidreza.multipleroom.data.local.entities.College
import com.hamidreza.multipleroom.data.local.entities.Course
import com.hamidreza.multipleroom.data.local.entities.Manager
import com.hamidreza.multipleroom.data.local.entities.Student
import com.hamidreza.multipleroom.data.local.relations.StudentCourseCrossRef
import kotlinx.coroutines.*
import javax.inject.Inject
import javax.inject.Provider

@Database(entities = [College::class,Course::class,Manager::class,Student::class,StudentCourseCrossRef::class],version = 1)
abstract class CollegeDataBase : RoomDatabase() {

    abstract fun getCollegeDao() : CollegeDao

    companion object {
        const val DB_NAME = "college_db"
    }

}