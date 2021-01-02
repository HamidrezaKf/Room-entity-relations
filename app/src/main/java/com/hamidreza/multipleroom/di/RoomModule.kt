package com.hamidreza.multipleroom.di

import android.content.Context
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hamidreza.multipleroom.data.local.CollegeDao
import com.hamidreza.multipleroom.data.local.CollegeDataBase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object RoomModule {

    @Provides
    @Singleton
    fun provideCollegeDb(@ApplicationContext context: Context,
    callBack:CollegeDataBase.CallBack):CollegeDataBase{
        return Room.databaseBuilder(context,
        CollegeDataBase::class.java,CollegeDataBase.DB_NAME)
            .fallbackToDestructiveMigration()
            .addCallback(callBack).build()
    }

    @Provides
    @Singleton
    fun provideDao(db:CollegeDataBase):CollegeDao {
        return db.getCollegeDao()
    }
}