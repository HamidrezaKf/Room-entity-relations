package com.hamidreza.multipleroom.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.sqlite.db.SupportSQLiteDatabase
import com.hamidreza.multipleroom.data.local.entities.College
import com.hamidreza.multipleroom.data.local.entities.Course
import com.hamidreza.multipleroom.data.local.entities.Manager
import com.hamidreza.multipleroom.data.local.entities.Student
import com.hamidreza.multipleroom.data.local.relations.StudentCourseCrossRef
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.supervisorScope
import javax.inject.Inject

@Database(entities = [College::class,Course::class,Manager::class,Student::class],version = 1)
abstract class CollegeDataBase : RoomDatabase() {

    abstract fun getCollegeDao() : CollegeDao

    companion object {
        const val DB_NAME = "college_db"
    }

    inner class CallBack @Inject constructor() : RoomDatabase.Callback() {
        override fun onCreate(db: SupportSQLiteDatabase) {
            super.onCreate(db)
            GlobalScope.launch {
                getCollegeDao().insertCollege(College("Tehran Jonoub","Tehran"))
                getCollegeDao().insertCollege(College("Shahid Beheshti","Tehran"))
                getCollegeDao().insertCollege(College("Azad University Of Shiraz","Shiraz"))
                getCollegeDao().insertCollege(College("Azad University Of Tabriz","Tabriz"))
                getCollegeDao().insertCollege(College("Azad University Of Isfahan","Isfahan"))
                getCollegeDao().insertCollege(College("Shiraz Technology","Shiraz"))

                getCollegeDao().insertStudent(Student("Hamid","hamid@gmail.com","Tehran Jonoub"))
                getCollegeDao().insertStudent(Student("Reza","reza@gmail.com","Azad University Of Shiraz"))
                getCollegeDao().insertStudent(Student("Akbar","akbar@gmail.com","Azad University Of Isfahan"))
                getCollegeDao().insertStudent(Student("Hasan","hasan@gmail.com","Tehran Jonoub"))
                getCollegeDao().insertStudent(Student("Nima","nima@gmail.com","Shiraz Technology"))
                getCollegeDao().insertStudent(Student("Ehsan","ehsan@gmail.com","Shiraz Technology"))

                getCollegeDao().insertCourse(Course("Riazi",24))
                getCollegeDao().insertCourse(Course("Shimi",14))
                getCollegeDao().insertCourse(Course("Tafsir",84))
                getCollegeDao().insertCourse(Course("Honar",12))
                getCollegeDao().insertCourse(Course("Varzesh",27))
                getCollegeDao().insertCourse(Course("Adabiat",33))

                getCollegeDao().insertManager(Manager("Jamshidi",35,"Tehran Jonoub"))
                getCollegeDao().insertManager(Manager("Abdollahi",55,"Shiraz Technology"))
                getCollegeDao().insertManager(Manager("Abbasi",37,"Azad University Of Shiraz"))
                getCollegeDao().insertManager(Manager("Naderi",44,"Tehran Jonoub"))
                getCollegeDao().insertManager(Manager("Eskandari",53,"Shiraz Technology"))
                getCollegeDao().insertManager(Manager("Karimi",38,"Azad University Of Tabriz"))
                getCollegeDao().insertManager(Manager("Danaei",38,"Azad University Of Isfahan"))

                getCollegeDao().insertStudentCourse(StudentCourseCrossRef("Hamid","Honar"))
                getCollegeDao().insertStudentCourse(StudentCourseCrossRef("Hamid","Varzesh"))
                getCollegeDao().insertStudentCourse(StudentCourseCrossRef("Hamid","Tafsir"))
                getCollegeDao().insertStudentCourse(StudentCourseCrossRef("Reza","Honar"))
                getCollegeDao().insertStudentCourse(StudentCourseCrossRef("Reza","Shimi"))
                getCollegeDao().insertStudentCourse(StudentCourseCrossRef("Akbar","Honar"))
                getCollegeDao().insertStudentCourse(StudentCourseCrossRef("Hasan","Varzesh"))
                getCollegeDao().insertStudentCourse(StudentCourseCrossRef("Nima","Tafsir"))
                getCollegeDao().insertStudentCourse(StudentCourseCrossRef("Nima","Honar"))
            }
        }
    }
}