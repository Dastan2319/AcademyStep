package kz.example.academystep

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DateActivity:AppCompatActivity() {

    var textViewActivityShowText:TextView?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_data);
        textViewActivityShowText=findViewById(R.id.textViewActivityShowText)
        val item=intent.getStringExtra("item");
        textViewActivityShowText!!.setText(item);

    }

}