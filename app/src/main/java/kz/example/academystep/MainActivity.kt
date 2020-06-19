package kz.example.academystep

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    var btnAction: Button?=null
    var btnHideView: Button?=null
    var textLogin: EditText?=null
    var textPassword: EditText?=null
    var TextViewPress: TextView?=null
    var allCheckBox =ArrayList<CheckBox>()
    var nextPageBtn: Button?=null
    var editTextSendMsg:EditText?=null;
    var btnOpenPicture:Button?=null;
    var btnOpenRegistration:Button?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        init()
        initListener()

    }

    fun init(){
        btnOpenRegistration=findViewById(R.id.btnOpenRegistration);
        nextPageBtn = findViewById(R.id.nextPageBtn);
        btnHideView = findViewById(R.id.hideViewBtn);
        textLogin = findViewById(R.id.editTextFirst);
        textPassword = findViewById(R.id.editTextSecond);
        TextViewPress = findViewById(R.id.TextViewPress)
        btnAction = findViewById(R.id.checkFromConst)
        editTextSendMsg=findViewById(R.id.editTextSendMsg)
        btnOpenPicture=findViewById(R.id.btnOpenPicture)
    }

    fun initListener(){
        btnHideView!!.setOnClickListener(View.OnClickListener {

            if (textLogin!!.visibility!=View.INVISIBLE) {
                textLogin!!.visibility = View.INVISIBLE;
                textPassword!!.visibility = View.INVISIBLE;
                TextViewPress!!.visibility = View.INVISIBLE;
            }else{
                textLogin!!.visibility=View.VISIBLE;
                textPassword!!.visibility=View.VISIBLE;
                TextViewPress!!.visibility=View.VISIBLE;
            }
        })
        btnAction!!.setOnClickListener(View.OnClickListener {
            if(textLogin!!.text.toString()=="icarus" && textPassword!!.text.toString()=="fallen"){
                TextViewPress!!.setText(R.string.activity_main_it_is_so_sad);
            }else{
                TextViewPress!!.setText(R.string.activity_main_error_pass);
            }
        });
        nextPageBtn!!.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,DateActivity::class.java);
            intent.putExtra("item",editTextSendMsg!!.text.toString());
            startActivity(intent);
        })

        btnOpenPicture!!.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,ImageActivity::class.java);
            startActivity(intent);
        })
        btnOpenRegistration!!.setOnClickListener(View.OnClickListener {
            val intent=Intent(this,RegistrationActivity::class.java);
            startActivity(intent);
        })

    }
}