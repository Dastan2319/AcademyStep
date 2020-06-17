package kz.example.academystep

import android.os.Bundle
import android.os.PersistableBundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class StudentActivity :AppCompatActivity(){
    var btnSortByName: Button?=null
    var btnSortRandom: Button?=null
    var textViewStudentList: TextView?=null
    var studentsList:ArrayList<String> = ArrayList();
    var sort:SortStudentUseCase = SortStudentUseCase();

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_students);
        initialView();
        initialListener();
    }

    fun initialView(){

//        textViewStudentList=findViewById(R.id.textview_activity_students_list)
        btnSortByName =  findViewById(R.id.button_activity_sort_students);
        btnSortRandom =  findViewById(R.id.button_activity_sort_random);
        studentsList.add("First");
        studentsList.add("Second")
        studentsList.add("Three");
        studentsList.add("Four");
        studentsList.add("Five");
        studentsList.add("Six");
//        textViewStudentList?.setText(studentsList.toString());

    }

    fun initialListener(){
        btnSortByName!!.setOnClickListener(View.OnClickListener {
            textViewStudentList?.setText("asddsa");
//            textViewStudentList?.setText(sort.sortByName(studentsList).toString());
        })
//        btnSortRandom!!.setOnClickListener(View.OnClickListener {
//            textViewStudentList?.setText(sort.sortRandom(studentsList).toString());
//        })
    }
}