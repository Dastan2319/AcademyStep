package kz.example.academystep

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class RegistrationActivity:AppCompatActivity() {

    var editTextName:EditText?=null;
    var editTextEmail:EditText?=null;
    var editTextPass:EditText?=null;
    var editTextConfirmPass:EditText?=null;
    var btnRegistration:Button?=null;
    var textViewRegestrationStatus:TextView?=null;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration);
        initView();
        initListener();
    }

    fun initView(){
        editTextName=findViewById(R.id.editTextName);
        editTextEmail=findViewById(R.id.editTextEmail);
        editTextPass=findViewById(R.id.editTextPass);
        editTextConfirmPass=findViewById(R.id.editTextConfirmPass);
        btnRegistration=findViewById(R.id.btnRegistration);
        textViewRegestrationStatus=findViewById(R.id.textViewRegestrationStatus)
    }

    fun initListener(){
        btnRegistration!!.setOnClickListener(View.OnClickListener {
            println(editTextName!!.text.toString())
            println(editTextEmail!!.text.toString())
            println(editTextPass!!.text.toString())
            println(editTextConfirmPass!!.text.toString())

            if(editTextName!!.text.toString()!="" && editTextEmail!!.text.toString()!=""
                && editTextPass!!.text.toString()!="" && editTextConfirmPass!!.text.toString()!=""){
                if(editTextPass!!.text.toString()==editTextConfirmPass!!.text.toString()){
                    if(editTextName!!.text.toString().contains(Regex("[0-9]"))){
                        textViewRegestrationStatus!!.setText("Спасибо за регистрацию")
                    }else{
                        textViewRegestrationStatus!!.setText("Не хватает цифры в имени")
                    }
                }else{
                    textViewRegestrationStatus!!.setText("Пароли не совподают")
                }
            }else{
                textViewRegestrationStatus!!.setText("Одно или несколько полей не заполнены")
            }
        })
    }
}