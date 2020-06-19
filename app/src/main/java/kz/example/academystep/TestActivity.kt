package kz.example.academystep

import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import dagger.MapKey

class TestActivity:AppCompatActivity() {
    var textViewActivityText:TextView?=null;
    var gridBtn1:Button?=null;
    var gridBtn2:Button?=null;
    var gridBtn3:Button?=null;
    var gridBtn4:Button?=null;
    var Quension:ArrayList<MutableMap<String,String>>?=null;
    var CorrectAnswerCount=0;
    var questonNum=0;

    var textViewEndGame:TextView?=null;
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test)
        initView()
    }

    fun initView(){
        Quension=ArrayList<MutableMap<String,String>>();

        Quension!!.add(mutableMapOf("Question" to "How are you?","answer" to "Yes","wrong1" to "No","wrong2" to "Yes no","wrong3" to "no Yes"));
        Quension!!.add(mutableMapOf("Question" to "What you think about me?","answer" to "Good","wrong1" to "Bad","wrong2" to "What?","wrong3" to "Why are you?"));

        textViewActivityText=findViewById(R.id.textview_activity_text);
        gridBtn1=findViewById(R.id.grid_btn_1);
        gridBtn2=findViewById(R.id.grid_btn_2);
        gridBtn3=findViewById(R.id.grid_btn_3);
        gridBtn4=findViewById(R.id.grid_btn_4);
        textViewEndGame=findViewById(R.id.textViewEndGame);

        initGame(Quension!![questonNum]);
    }

    fun initGame(question:MutableMap<String,String>){
        textViewActivityText!!.setText( question.getValue("Question").toString());
        var answers= listOf(question.getValue("answer").toString(),
                            question.getValue("wrong1").toString(),
                            question.getValue("wrong2").toString(),
                            question.getValue("wrong3").toString());



        answers=answers.shuffled();

        gridBtn1!!.setText(answers[0])
        gridBtn2!!.setText(answers[1])
        gridBtn3!!.setText(answers[2])
        gridBtn4!!.setText(answers[3])


        gridBtn1!!.setOnClickListener ( View.OnClickListener {
            checkAnswerAndNext(gridBtn1!!.text.toString(),question["answer"].toString());
        })
        gridBtn2!!.setOnClickListener ( View.OnClickListener {
            checkAnswerAndNext(gridBtn2!!.text.toString(),question["answer"].toString());
        })
        gridBtn3!!.setOnClickListener ( View.OnClickListener {
            checkAnswerAndNext(gridBtn3!!.text.toString(),question["answer"].toString());
        })
        gridBtn4!!.setOnClickListener ( View.OnClickListener {
            checkAnswerAndNext(gridBtn4!!.text.toString(),question["answer"].toString());
        })
        questonNum++;
    }

    fun checkAnswerAndNext(text:String,answer:String){
        if(text==answer){
            CorrectAnswerCount++;
        }
        if(Quension!!.count()!=questonNum) {
            initGame(Quension!![questonNum]);
        }
        else{
            textViewActivityText!!.visibility=View.INVISIBLE;
            gridBtn1!!.visibility=View.INVISIBLE;
            gridBtn2!!.visibility=View.INVISIBLE;
            gridBtn3!!.visibility=View.INVISIBLE;
            gridBtn4!!.visibility=View.INVISIBLE;

            textViewEndGame!!.setText("Правильных ответов:"+CorrectAnswerCount.toString());
        }
    }
}