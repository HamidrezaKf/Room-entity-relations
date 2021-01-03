package com.hamidreza.multipleroom.ui

import android.util.Log
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.viewModelScope
import com.hamidreza.multipleroom.data.local.CollegeDao
import com.hamidreza.multipleroom.data.local.entities.College
import com.hamidreza.multipleroom.data.local.entities.Course
import com.hamidreza.multipleroom.data.local.entities.Manager
import com.hamidreza.multipleroom.data.local.entities.Student
import com.hamidreza.multipleroom.data.local.relations.StudentCourseCrossRef
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach
import kotlinx.coroutines.launch

class MainViewModel @ViewModelInject constructor(val dao:CollegeDao) : ViewModel() {

    fun result() {
        viewModelScope.launch {
            dao.insertCollege(College("Tehran Jonoub","Tehran"))
            dao.insertCollege(College("Shahid Beheshti","Tehran"))
            dao.insertCollege(College("Azad University Of Shiraz","Shiraz"))
            dao.insertCollege(College("Azad University Of Tabriz","Tabriz"))
            dao.insertCollege(College("Azad University Of Isfahan","Isfahan"))
            dao.insertCollege(College("Shiraz Technology","Shiraz"))

            dao.insertStudent(Student("Hamid","hamid@gmail.com","Tehran Jonoub"))
            dao.insertStudent(Student("Reza","reza@gmail.com","Azad University Of Shiraz"))
            dao.insertStudent(Student("Akbar","akbar@gmail.com","Azad University Of Isfahan"))
            dao.insertStudent(Student("Hasan","hasan@gmail.com","Tehran Jonoub"))
            dao.insertStudent(Student("Nima","nima@gmail.com","Shiraz Technology"))
            dao.insertStudent(Student("Ehsan","ehsan@gmail.com","Shiraz Technology"))

            dao.insertCourse(Course("Riazi",24))
            dao.insertCourse(Course("Shimi",14))
            dao.insertCourse(Course("Tafsir",84))
            dao.insertCourse(Course("Honar",12))
            dao.insertCourse(Course("Varzesh",27))
            dao.insertCourse(Course("Adabiat",33))

            dao.insertManager(Manager("Jamshidi",35,"Tehran Jonoub"))
            dao.insertManager(Manager("Abdollahi",55,"Shahid Beheshti"))
            dao.insertManager(Manager("Abbasi",37,"Azad University Of Shiraz"))
            dao.insertManager(Manager("Eskandari",53,"Shiraz Technology"))
            dao.insertManager(Manager("Karimi",38,"Azad University Of Tabriz"))
            dao.insertManager(Manager("Danaei",38,"Azad University Of Isfahan"))

            dao.insertStudentCourse(StudentCourseCrossRef("Hamid","Honar"))
            dao.insertStudentCourse(StudentCourseCrossRef("Hamid","Varzesh"))
            dao.insertStudentCourse(StudentCourseCrossRef("Hamid","Tafsir"))
            dao.insertStudentCourse(StudentCourseCrossRef("Reza","Honar"))
            dao.insertStudentCourse(StudentCourseCrossRef("Reza","Shimi"))
            dao.insertStudentCourse(StudentCourseCrossRef("Akbar","Honar"))
            dao.insertStudentCourse(StudentCourseCrossRef("Hasan","Varzesh"))
            dao.insertStudentCourse(StudentCourseCrossRef("Nima","Tafsir"))
            dao.insertStudentCourse(StudentCourseCrossRef("Nima","Honar"))

            dao.getCollegeAndManagers().onEach {
                Log.i("CollegeDataBase", "CollegeDataBase:${it} ")
            }.launchIn(viewModelScope)
        }
    }
}