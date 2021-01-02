package com.hamidreza.multipleroom.data.local

import androidx.room.*
import com.hamidreza.multipleroom.data.local.entities.College
import com.hamidreza.multipleroom.data.local.entities.Course
import com.hamidreza.multipleroom.data.local.entities.Manager
import com.hamidreza.multipleroom.data.local.entities.Student
import com.hamidreza.multipleroom.data.local.relations.CollegeAndManager
import com.hamidreza.multipleroom.data.local.relations.CollegeWithStudents
import kotlinx.coroutines.flow.Flow

@Dao
interface CollegeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCollege(college: College)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertManager(manager: Manager)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudent(student: Student)


    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCourse(course: Course)

    @Transaction
    @Query("SELECT * FROM College")
    fun getCollegeAndManagers() : Flow<List<CollegeAndManager>>

    @Transaction
    @Query("SELECT * FROM College")
    fun getCollegeWithStudents() : Flow<List<CollegeWithStudents>>



}