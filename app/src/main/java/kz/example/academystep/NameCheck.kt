package kz.example.academystep

import android.graphics.Color
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import org.intellij.lang.annotations.RegExp

class NameCheck: AppCompatActivity() {

    var buttonActivityAction : Button? =null;
    var textViewStatus: TextView?= null;
    var editTextEditor: EditText?=null;
//    var reg:RegExp?=RegExp("[0-9]")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_name_check);
        initView();
        initListener();
    }

    fun initView(){
        buttonActivityAction = findViewById(R.id.buttonActivityAction);
        textViewStatus = findViewById(R.id.textViewStatus);
        editTextEditor = findViewById(R.id.editTextEditor);
    }

    fun initListener(){
        buttonActivityAction!!.setOnClickListener(View.OnClickListener {
            var reg="[0-9]".toRegex();
            var result= reg.find(editTextEditor!!.text.toString());
            if(result.toString()!="null"){
                textViewStatus!!.setText(R.string.activity_name_check_error);
                textViewStatus!!.setTextColor(Color.RED)
            }else{
                textViewStatus!!.setText(R.string.activity_name_check_success)
                textViewStatus!!.setTextColor(Color.BLUE)
            }
        })
    }
}