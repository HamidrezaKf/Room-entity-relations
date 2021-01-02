package com.hamidreza.multipleroom.data.local

import androidx.room.*
import com.hamidreza.multipleroom.data.local.entities.College
import com.hamidreza.multipleroom.data.local.entities.Manager
import com.hamidreza.multipleroom.data.local.relations.CollegeAndManager
import kotlinx.coroutines.flow.Flow

@Dao
interface CollegeDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertCollege(college: College)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertManager(manager: Manager)

    @Transaction
    @Query("SELECT * FROM College")
    fun getCollegeAndManagers() : Flow<List<CollegeAndManager>>

}